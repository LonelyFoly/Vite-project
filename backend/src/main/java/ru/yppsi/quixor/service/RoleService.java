package ru.yppsi.quixor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yppsi.quixor.entity.Role;
import ru.yppsi.quixor.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findById("ROLE_USER").orElseGet(
                () -> roleRepository.save(Role.builder().id("ROLE_USER").build()));
    }
}
