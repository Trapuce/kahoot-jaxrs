package com.tp.mappers;


import com.tp.dto.PlayerDTO;
import com.tp.model.Player;
import com.tp.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PlayerMapper {
   PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
    @Mapping(source = "gameSession.id", target = "gameSessionId")
    @Mapping(source = "answers", target = "answerIds", qualifiedByName = "answersToIds")
    PlayerDTO toDto(Player player);

    @Mapping(target = "gameSession", ignore = true)
    @Mapping(target = "answers", ignore = true)
    Player toEntity(PlayerDTO playerDTO);

    @Named("answersToIds")
    default List<Long> answersToIds(List<Answer> answers) {
        if (answers == null) {
            return null;
        }
        return answers.stream()
                .map(Answer::getId)
                .collect(Collectors.toList());
    }
}