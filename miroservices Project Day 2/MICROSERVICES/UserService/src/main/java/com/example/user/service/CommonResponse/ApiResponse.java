package com.example.user.service.CommonResponse;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ApiResponse {

        private String message;
        private boolean success;
        private HttpStatus status;
}
