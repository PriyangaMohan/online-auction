package com.training.online_auction.service;

import com.training.online_auction.dto.UserDto;
import com.training.online_auction.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}