package com.linecode.databuilders;

import com.linecode.form.ItemForm;

public class ItemDataBuilder {
	
	private ItemForm itemForm = new ItemForm();
	
	public ItemDataBuilder descricao(String descricao) {
		this.itemForm.setDescricao(descricao);
		return this;
	}
	
	public ItemDataBuilder idListaTarefa(Long idListaTarefa) {
		this.itemForm.setIdListaTarefa(idListaTarefa);
		return this;
	}
	
	public ItemForm constroi() {
		return this.itemForm;
	}

}
