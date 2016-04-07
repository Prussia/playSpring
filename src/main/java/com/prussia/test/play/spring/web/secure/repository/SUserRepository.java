package com.prussia.test.play.spring.web.secure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prussia.test.play.spring.web.secure.bean.SUser;

public interface SUserRepository extends JpaRepository<SUser, Integer> {
	@Query("select u from SUser u where u.email=?1 and u.password=?2")
	SUser login(String email, String password);

	SUser findByEmailAndPassword(String email, String password);

	SUser findUserByEmail(String email);
}
