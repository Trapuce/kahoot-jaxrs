package com.tp.mappers;

import com.tp.dto.KahootDTO;
import com.tp.model.Kahoot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface KahootMapper {
    KahootMapper INSTANCE = Mappers.getMapper(KahootMapper.class);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "gameSessionIds", expression = "java(mapGameSessionIds(kahoot))")
    @Mapping(target = "questionIds", expression = "java(mapQuestionIds(kahoot))")
    KahootDTO kahootToKahootDTO(Kahoot kahoot);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "gameSessions", ignore = true)
    @Mapping(target = "questions", ignore = true)
    Kahoot kahootDTOToKahoot(KahootDTO kahootDTO);

    default List<Long> mapGameSessionIds(Kahoot kahoot) {
        return kahoot.getGameSessions().stream()
                .map(gameSession -> gameSession.getId())
                .collect(Collectors.toList());
    }

    default List<Long> mapQuestionIds(Kahoot kahoot) {
        return kahoot.getQuestions().stream()
                .map(question -> question.getId())
                .collect(Collectors.toList());
    }
}
