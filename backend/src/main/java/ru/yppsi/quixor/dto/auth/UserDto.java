package ru.yppsi.quixor.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.yppsi.quixor.entity.Role;
import ru.yppsi.quixor.entity.User;

import java.util.Collection;
import java.util.UUID;

/**
 * Dto for {@link User} entity.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;

    private String login;

    private String encryptedPassword;

    private Collection<Role> roles;
}
