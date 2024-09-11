package ru.yppsi.quixor.mapper.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import ru.yppsi.quixor.dto.auth.UserDto;
import ru.yppsi.quixor.entity.Role;
import ru.yppsi.quixor.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-28T06:57:06+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( dto.getId() );
        user.login( dto.getLogin() );
        user.encryptedPassword( dto.getEncryptedPassword() );
        Collection<Role> collection = dto.getRoles();
        if ( collection != null ) {
            user.roles( new ArrayList<Role>( collection ) );
        }

        return user.build();
    }

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( entity.getId() );
        userDto.login( entity.getLogin() );
        userDto.encryptedPassword( entity.getEncryptedPassword() );
        Collection<Role> collection = entity.getRoles();
        if ( collection != null ) {
            userDto.roles( new ArrayList<Role>( collection ) );
        }

        return userDto.build();
    }

    @Override
    public List<User> toEntities(List<UserDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UserDto userDto : dtoList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    @Override
    public List<UserDto> toDtos(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
        }

        return list;
    }
}
