package ru.yppsi.quixor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yppsi.quixor.entity.User;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for {@link User} entity.
 */
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByLogin(String login);
}
