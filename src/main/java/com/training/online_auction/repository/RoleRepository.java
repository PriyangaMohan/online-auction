package com.training.online_auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.online_auction.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
