package com.prussia.test.play.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prussia.test.play.spring.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
