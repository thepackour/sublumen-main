package com.sublumen.devlog.service;

import com.sublumen.devlog.domain.Post;
import com.sublumen.devlog.domain.PostTag;
import com.sublumen.devlog.domain.Tag;
import com.sublumen.devlog.repository.SpringDataJpaPostRepository;
import com.sublumen.devlog.repository.SpringDataJpaPostTagRepository;
import com.sublumen.devlog.repository.SpringDataJpaTagRepository;
import com.sublumen.devlog.web.dto.PostRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PostService {

    private final SpringDataJpaPostRepository postRepository;
    private final SpringDataJpaTagRepository tagRepository;
    private final SpringDataJpaPostTagRepository postTagRepository;

    public PostService(
            SpringDataJpaPostRepository postRepository,
            SpringDataJpaTagRepository tagRepository,
            SpringDataJpaPostTagRepository postTagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
        this.postTagRepository = postTagRepository;
    }

    public List<Post> getPosts(Pageable pageable) {
        return postRepository.getPosts(pageable);
    }

    public Post getPost(Long id) {
        return postRepository.getPostById(id).orElseThrow(
                () -> new NoSuchElementException("존재하지 않는 데이터입니다.")
        );
    }

    public Post createPost(PostRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        postRepository.save(post);

        List<Tag> tags = new ArrayList<>();
        for (String tagStr : request.getTags()) {
            Optional<Tag> opTag = tagRepository.getTagByName(tagStr);
            if (opTag.isPresent()) {
                tags.add(opTag.get());
            }
            else {
                tags.add(tagRepository.save(new Tag(tagStr)));
            }
        }
        for (Tag tag : tags) {
            PostTag postTag = new PostTag(post, tag);
            postTagRepository.save(postTag);
        }

        return post;
    }
}
