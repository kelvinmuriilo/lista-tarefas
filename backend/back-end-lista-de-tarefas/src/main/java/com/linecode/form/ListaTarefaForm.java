package com.linecode.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ListaTarefaForm {
	
	@NotBlank(message = "O campo título não pode ser vazio.") 
	@NotNull
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
