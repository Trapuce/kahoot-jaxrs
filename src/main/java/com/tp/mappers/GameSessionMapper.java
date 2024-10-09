package com.tp.mappers;


import com.tp.dto.GameSessionDTO;
import com.tp.model.GameSession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface GameSessionMapper {
    GameSessionMapper INSTANCE = Mappers.getMapper(GameSessionMapper.class);

    @Mapping(target = "playerIds", expression = "java(mapPlayerIds(gameSession))")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "kahootId", source = "kahoot.id")
    GameSessionDTO gameSessionToGameSessionDTO(GameSession gameSession);

    @Mapping(target = "players", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "kahoot", ignore = true)
    GameSession gameSessionDTOToGameSession(GameSessionDTO gameSessionDTO);

    default List<Long> mapPlayerIds(GameSession gameSession) {
        return gameSession.getPlayers().stream()
                .map(player -> player.getId())
                .collect(Collectors.toList());
    }
}
