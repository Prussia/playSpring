package com.prussia.test.play.spring.service;

import java.util.List;

import com.prussia.test.play.spring.domain.po.Item;

public interface ItemService {

	public List<Item> findAll();

	public Item saveAndFlush(Item item);

	public void delete(Integer id);
}
