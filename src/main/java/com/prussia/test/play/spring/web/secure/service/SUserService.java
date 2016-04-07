package com.prussia.test.play.spring.web.secure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prussia.test.play.spring.web.secure.bean.SUser;
import com.prussia.test.play.spring.web.secure.repository.SUserRepository;

public class SUserService {
	@Autowired
	private SUserRepository suserRepository;// code10

	public List<SUser> findAll() {
		return suserRepository.findAll();

	}

	public SUser create(SUser user) {
		return suserRepository.save(user);
	}

	public SUser findUserById(int id) {
		return suserRepository.findOne(id);
	}

	public SUser login(String email, String password) {
		return suserRepository.findByEmailAndPassword(email, password);
	}

	public SUser update(SUser user) {
		return suserRepository.save(user);
	}

	public void deleteUser(int id) {
		suserRepository.delete(id);
	}

	public SUser findUserByEmail(String email) {
		return suserRepository.findUserByEmail(email);
	}
}
