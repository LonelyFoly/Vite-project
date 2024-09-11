package ru.yppsi.quixor.mapper.user;

import org.mapstruct.Mapper;
import ru.yppsi.quixor.dto.auth.UserDto;
import ru.yppsi.quixor.entity.User;
import ru.yppsi.quixor.mapper.EntityMapper;

/**
 * Mapper for {@link User} and {@link UserDto}.
 */
@Mapper()
public interface UserMapper extends EntityMapper<UserDto, User> {
}
