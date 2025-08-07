package org.example.spring.b.model;

import lombok.Builder;
import lombok.Getter;

public class BDto {
    @Getter
    @Builder
    public static class BRes {
        private Integer idx;
        private String a01;
        private String a02;

        public static BDto.BRes from(B entity) {
            BDto.BRes dto  = BDto.BRes.builder()
                    .idx(entity.getIdx())
                    .a01(entity.getB01())
                    .a02(entity.getB02())
                    .build();

            return dto;
        }
    }
}
