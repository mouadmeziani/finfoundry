package com.finfoundry.backend.port;

import com.finfoundry.backend.model.Tag;
import java.util.List;
import java.util.Optional;

public interface TagRepositoryPort {
    Tag save(Tag tag);
    Optional<Tag> findByName(String name);
    List<Tag> findAll();

    Optional<Tag> findById(Long id);
}