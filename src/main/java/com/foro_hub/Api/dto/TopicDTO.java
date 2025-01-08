package com.foro_hub.Api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDTO {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private String status;
    private String author;
    private String course;
}
