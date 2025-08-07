package org.example.spring.review;

import lombok.Builder;
import lombok.Getter;

public class ReviewDto {

    @Getter
    @Builder
    public class reviewRes{
        private Integer idx;
        private String  content1;
        private Integer reviewScore1;

        public static ReviewDto.reviewRes from(Review entity) {
            ReviewDto.reviewRes dto  = reviewRes.builder()
                    .idx(entity.getIdx())
                    .content1(entity.getContent())
                    .reviewScore1(entity.getReviewScore())
                    .build();

            return dto;
        }

    }
}
