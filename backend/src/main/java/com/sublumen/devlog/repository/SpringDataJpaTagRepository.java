package com.sublumen.devlog.repository;

import com.sublumen.devlog.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaTagRepository extends JpaRepository<Tag, Long> {
    public Optional<Tag> getTagByName(String name);
}
