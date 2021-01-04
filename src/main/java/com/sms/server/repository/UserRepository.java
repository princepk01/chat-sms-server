package com.sms.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.server.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserUniqueId(String userUniqueId);

}
