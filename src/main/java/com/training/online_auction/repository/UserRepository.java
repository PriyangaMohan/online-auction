package com.training.online_auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.online_auction.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
