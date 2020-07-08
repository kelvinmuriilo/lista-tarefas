package com.linecode.dto;

import com.linecode.modelo.Item;
import com.linecode.modelo.StatusItem;

public class ItemDto {
	
	private Long id;
	private String descricao;
	private StatusItem status;
	private Long idListaTarefa; 
	
	public ItemDto(Item item) {
		this.id = item.getId();
		this.descricao = item.getDescricao();
		this.status = item.getStatus();
		this.idListaTarefa = item.getListaTarefa().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusItem getStatus() {
		return status;
	}

	public void setStatus(StatusItem status) {
		this.status = status;
	}

	public Long getIdListaTarefa() {
		return idListaTarefa;
	}

	public void setIdListaTarefa(Long idListaTarefa) {
		this.idListaTarefa = idListaTarefa;
	}
	


}
