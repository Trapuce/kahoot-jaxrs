package com.tp.mappers;

import com.tp.dto.UserDTO;
import com.tp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "gameSessionIds", expression = "java(mapGameSessionIds(user))")
    @Mapping(target = "kahootIds", expression = "java(mapKahootIds(user))")
    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    default List<Long> mapGameSessionIds(User user) {
        return user.getGameSessions().stream()
                .map(gameSession -> gameSession.getId())
                .collect(Collectors.toList());
    }

    default List<Long> mapKahootIds(User user) {
        return user.getKahoots().stream()
                .map(kahoot -> kahoot.getId())
                .collect(Collectors.toList());
    }
}