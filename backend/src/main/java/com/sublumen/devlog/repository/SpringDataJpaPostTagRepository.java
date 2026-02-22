package com.sublumen.devlog.repository;

import com.sublumen.devlog.domain.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaPostTagRepository extends JpaRepository<PostTag, Long> {
    public void deletePostTagByPostId(Integer id);
}
