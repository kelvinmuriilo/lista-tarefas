package com.linecode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linecode.modelo.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {
	
}
