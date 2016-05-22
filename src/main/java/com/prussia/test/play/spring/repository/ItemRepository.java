package com.prussia.test.play.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prussia.test.play.spring.domain.po.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
