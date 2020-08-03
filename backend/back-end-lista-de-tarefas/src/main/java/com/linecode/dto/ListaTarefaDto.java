package com.linecode.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.linecode.modelo.ListaTarefa;

public class ListaTarefaDto {
	private Long id;
	private String titulo;
	private List<ItemDto> listaItens;
	
	public ListaTarefaDto(ListaTarefa listaTarefa) {
		this.id = listaTarefa.getId();
		this.titulo = listaTarefa.getTitulo();
		this.listaItens = listaTarefa.getListaItens().stream().map(ItemDto::new).collect(Collectors.toList());
	}
	
	public ListaTarefaDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<ItemDto> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<ItemDto> listaItens) {
		this.listaItens = listaItens;
	}
	
	public static List<ListaTarefaDto> converterToList(List<ListaTarefa> listaTarefa) {
		return  listaTarefa.stream()
				.map(ListaTarefaDto::new)
				.collect(Collectors.toList());
	}
	
}
