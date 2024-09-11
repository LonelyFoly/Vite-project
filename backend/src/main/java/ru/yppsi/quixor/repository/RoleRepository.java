package ru.yppsi.quixor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yppsi.quixor.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}
