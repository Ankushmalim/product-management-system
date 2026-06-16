package com.product.user_service.mapper;

import com.product.user_service.dto.UserRequestDto;
import com.product.user_service.dto.UserResponseDto;
import com.product.user_service.entity.User;

public class UserMapper {
    public static User toEntity(UserRequestDto dto) {

        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .password(dto.getPassword())
                .build();
    }

    public static UserResponseDto toResponse(User user) {

        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }
}
