package com.product.user_service.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;
}
