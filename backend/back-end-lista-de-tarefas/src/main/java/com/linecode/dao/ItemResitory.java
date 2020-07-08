package com.linecode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linecode.modelo.Item;


public interface ItemResitory extends JpaRepository<Item, Long> {
	
}
