package com.product.user_service.service;

import com.product.user_service.dto.UserRequestDto;
import com.product.user_service.dto.UserResponseDto;

import java.util.List;
public interface UserService {

    UserResponseDto createUser(UserRequestDto dto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(Long id);

    UserResponseDto updateUser(Long id, UserRequestDto dto);

    void deleteUser(Long id);
}
