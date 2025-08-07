package org.example.spring.book.model;


import com.example.demo.b.model.BDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class BookDto {

    @Getter
    public static class Register {
        private String title;
        private String content;
        private List<ReviewDto.Register> review;

        public Book toEntity() {
            Book entity = Book.builder()
                    .title(title)
                    .content(content)
                    .build();
            return entity;
        }
    }
    @Getter
    @Builder
    public static class BookRes {
        private Integer idx;
        private String title;
        private String content;
        private List<ReviewDto.ReviewRes> reviewResList;

        public static BookRes from(Book entity) {
            BookRes dto = BookRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .reviewResList(entity.getReview().stream().map(ReviewDto.ReviewRes::from).toList())
                    .build();


            return dto;
        }
    }

}
