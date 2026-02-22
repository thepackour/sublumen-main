package com.sublumen.devlog.domain;

import com.sublumen.devlog.web.dto.PostRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String title;

    private String content;

    private Long views = 0L;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostTag> postTags;

    @CurrentTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Setter
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


    public Long increaseViews() {
        return ++(this.views);
    }

    public void updateTitle(PostRequest request) {
        this.title = request.getTitle();
    }
    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(PostRequest request) {
        this.content = request.getContent();
    }
    public void updateContent(String content) {
        this.content = content;
    }
}
