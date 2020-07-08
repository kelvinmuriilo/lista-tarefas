package com.linecode.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ItemForm {
	@NotNull @NotEmpty(message = "Informe a descrição da tarefa.")
	private String descricao;
	@NotNull @NotEmpty(message = "Informe a lista da tarefa.")
	private Long idListaTarefa;
	
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
