package com.sublumen.devlog.repository;

import com.sublumen.devlog.domain.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataJpaPostRepository extends JpaRepository<Post, Integer> {
    public List<Post> getPosts(Pageable pageable);
    public Optional<Post> getPostById(Long id);
}
