package com.sublumen.devlog.web.controller;

import com.sublumen.devlog.common.ApiResponse;
import com.sublumen.devlog.domain.Post;
import com.sublumen.devlog.service.PostService;
import com.sublumen.devlog.web.dto.PostRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Post>>> getPosts(
            Pageable pageable) {
        List<Post> res = postService.getPosts(pageable);
        return ResponseEntity.ok(ApiResponse.of("조회에 성공했습니다.", res));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Post>> getPost(
            @PathVariable Long id) {
        Post res = postService.getPost(id);
        return ResponseEntity.ok(ApiResponse.of("조회에 성공했습니다.", res));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Post>> createPost(
            @RequestBody PostRequest request) {
        Post res = postService.createPost(request);
        URI location = URI.create("/api/posts/" + res.getId());
        return ResponseEntity.created(location)
                .body(ApiResponse.of("성공적으로 생성했습니다.", res));
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<Post>> updatePost(
            @RequestBody PostRequest request
    ) {

    }

}
