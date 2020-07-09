package com.linecode.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemForm {
	@NotNull @NotBlank(message = "Informe a descrição do item.")
	private String descricao;
	private Long idListaTarefa;
	
	
	public ItemForm(String descricao, Long idListaTarefa) {
		this.descricao = descricao;
		this.idListaTarefa = idListaTarefa;
	}
	
	public ItemForm() {}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdListaTarefa() {
		return idListaTarefa;
	}

	public void setIdListaTarefa(Long idListaTarefa) {
		this.idListaTarefa = idListaTarefa;
	}
	
}
