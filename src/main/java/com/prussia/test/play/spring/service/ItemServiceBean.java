package com.prussia.test.play.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prussia.test.play.spring.domain.po.Item;
import com.prussia.test.play.spring.repository.ItemRepository;
/**
 * to conert po to vo then introduce dozer
 * @author N551JM
 *
 */
public class ItemServiceBean implements ItemService {
	@Autowired
	private ItemRepository repo;

	@Override
	public List<Item> findAll() {
		return repo.findAll();
	}

	@Override
	public Item saveAndFlush(Item item) {
		return repo.saveAndFlush(item);
	}

	@Override
	public void delete(Integer id) {
		repo.delete(id);
	}
}
