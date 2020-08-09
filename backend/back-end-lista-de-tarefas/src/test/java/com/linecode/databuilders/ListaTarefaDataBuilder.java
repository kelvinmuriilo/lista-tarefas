package com.linecode.databuilders;

import com.linecode.form.ListaTarefaForm;

public class ListaTarefaDataBuilder {

	private ListaTarefaForm listaTarefaForm;
	
	public ListaTarefaDataBuilder titulo(String titulo) {
		this.listaTarefaForm = new ListaTarefaForm(titulo);
		return this;
	}
	
	public ListaTarefaForm constroi() {
		return listaTarefaForm;
	}

}
