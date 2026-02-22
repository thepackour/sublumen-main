package com.sublumen.devlog.service;

import com.sublumen.devlog.domain.Post;
import com.sublumen.devlog.domain.PostTag;
import com.sublumen.devlog.domain.Tag;
import com.sublumen.devlog.repository.SpringDataJpaPostRepository;
import com.sublumen.devlog.repository.SpringDataJpaPostTagRepository;
import com.sublumen.devlog.repository.SpringDataJpaTagRepository;
import com.sublumen.devlog.web.dto.PostRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAllByDeletedAtIsNull(pageable);
    }

    public Post getPost(Integer id) {
        return postRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("존재하지 않는 데이터입니다.")
        );
    }

    public Post createPost(PostRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        Post res = postRepository.save(post);
        addTags(request, res);
        return post;
    }

    public Post updatePost(Integer id, PostRequest request) {
        Post post = postRepository.findById(id).orElseThrow( () ->
                new NoSuchElementException("존재하지 않는 데이터입니다.") );
        post.updateTitle(request.getTitle());
        post.updateContent(request.getContent());
        postTagRepository.deletePostTagByPostId(post.getId());
        addTags(request, post);
        return post;
    }

    public void deletePost(Integer id) {
        Post post = postRepository.findById(id).orElseThrow( () ->
                new NoSuchElementException("존재하지 않는 데이터입니다.") );
        post.setDeletedAt(LocalDateTime.now());
    }


    private void addTags(PostRequest request, Post post) {
        List<Tag> tags = new ArrayList<>();
        if (request.getTags() == null) request.setTags(new ArrayList<>());

        for (String tagStr : request.getTags()) {
            Optional<Tag> opTag = tagRepository.getTagByName(tagStr);
            if (opTag.isPresent()) {
                tags.add(opTag.get());
            } else {
                tags.add(tagRepository.save(new Tag(tagStr)));
            }
        }
        for (Tag tag : tags) {
            PostTag postTag = new PostTag(post, tag);
            postTagRepository.save(postTag);
        }
    }
}
