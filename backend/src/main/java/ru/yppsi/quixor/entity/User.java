package ru.yppsi.quixor.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.UUID;

/**
 * Class for "T_USER" table.
 */
@Entity
@Table(name = "T_USER", schema = "BASE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private UUID id;

    @JsonIgnore
    private String login;

    @JsonIgnore
    private String encryptedPassword;

    private String email;

    @ManyToMany
    @JoinTable(
            name = "t_users_roles",
            schema = "BASE",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;
}
