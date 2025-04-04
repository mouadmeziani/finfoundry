package com.finfoundry.backend.port;

import com.finfoundry.backend.model.User;
import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    User save(User user);
}