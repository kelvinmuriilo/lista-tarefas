package com.linecode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.linecode.modelo.ListaTarefa;


public interface ListaTarefaRepositoy extends JpaRepository<ListaTarefa, Long>{
	
	@Transactional
	public default void deleteAll() {

	    for (ListaTarefa element : findAll()) {
	        delete(element);
	    }
	}
}
