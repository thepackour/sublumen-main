package com.sublumen.devlog.web.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    String title;
    String content;
    List<String> tags;
}
