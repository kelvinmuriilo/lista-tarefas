package com.linecode.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ListaTarefaForm {
	
	@NotNull(message = "O campo t�tulo precisa ser preenchido.")
	@NotBlank(message = "O campo t�tulo precisa ser preenchido.") 
	private String titulo;

	public ListaTarefaForm(String titulo) {
		this.titulo = titulo;
	}
	
	public ListaTarefaForm() {}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
