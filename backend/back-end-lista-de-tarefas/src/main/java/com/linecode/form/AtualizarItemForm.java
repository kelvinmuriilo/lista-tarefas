package com.linecode.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.linecode.modelo.StatusItem;

public class AtualizarItemForm {
	
	//@NotNull @NotBlank(message = "O status deve ser informado.")
	private StatusItem status;

	public StatusItem getStatus() {
		return status;
	}

	public void setStatus(StatusItem status) {
		this.status = status;
	}
}
