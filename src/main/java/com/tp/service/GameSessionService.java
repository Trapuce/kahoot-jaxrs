package com.tp.service;

import com.tp.dto.GameSessionDTO;
import com.tp.mappers.GameSessionMapper;
import com.tp.model.GameSession;
import com.tp.model.Kahoot;
import com.tp.model.Player;
import com.tp.model.User;
import com.tp.repository.impl.JpaGameSessionRepository;
import com.tp.repository.impl.JpaKahootRepository;
import com.tp.repository.impl.JpaPlayerRepository;
import com.tp.repository.impl.JpaUserRepository;

import java.util.Date;
import java.util.Random;

public class GameSessionService {

    private final JpaGameSessionRepository jpaGameSessionRepository;
    private final JpaPlayerRepository jpaPlayerRepository;
    private GameSessionMapper gameSessionMapper;
    private final JpaKahootRepository jpaKahootRepository;
    private final JpaUserRepository jpaUserRepository;

    public GameSessionService(){
        this.jpaGameSessionRepository = new JpaGameSessionRepository();
        this.jpaPlayerRepository = new JpaPlayerRepository();
        this.jpaKahootRepository = new JpaKahootRepository();
        this.jpaUserRepository = new JpaUserRepository();
        this.gameSessionMapper = GameSessionMapper.INSTANCE;
    }

    public GameSessionDTO createGameSession(Long kahootId) {
        Kahoot kahoot = this.jpaKahootRepository.findOne(kahootId);
        User user = this.jpaUserRepository.findOne(kahoot.getUser().getId());

        if (kahoot == null || user == null) {
            throw new IllegalArgumentException("Kahoot not found");
        }

        GameSession gameSession = new GameSession();
        gameSession.setCreatedAt(new Date());
        gameSession.setEndAt(new Date(System.currentTimeMillis() + 3600000));
        gameSession.setUrl("http://example.com/gamesession/" + gameSession.getGamePin());
        gameSession.setGamePin(generateRandomPin());
        user.addGameSession(gameSession);
        Player player = new Player();
        player.setNickname("jarhill");
        gameSession.addPlayer(player);
        kahoot.addGameSession(gameSession);

        this.jpaGameSessionRepository.save(gameSession);
        this.jpaPlayerRepository.save(player);

        return this.gameSessionMapper.gameSessionToGameSessionDTO(gameSession);
    }

    private String generateRandomPin() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }
}