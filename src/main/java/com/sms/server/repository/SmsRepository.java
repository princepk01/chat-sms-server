package com.sms.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.server.entity.Sms;

public interface SmsRepository extends JpaRepository<Sms, Integer>{

	List<Sms> findByUserUniqueId(String userUniqueId);

}
