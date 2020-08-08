package com.linecode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.linecode.controller.ItemController;
import com.linecode.form.ItemForm;
import com.linecode.servico.AplicacaoServico;

@WebMvcTest(controllers = ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private ItemController itemController;
	
	@MockBean
	private AplicacaoServico aplicacaoServico;
	
	@Autowired
	private MockMvc mockMvc;
	
	private ItemForm itemForm;
	
	private Gson gson;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.itemController);
		this.itemForm = new ItemForm();
		
		this.gson = new Gson();
	}
	
	@Test
	public void deveRetornarSucessoAoCadastrarItem() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/item/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.gson.toJson(this.itemForm)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void deveRetornarSucessoAoAtualizarItem() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.put("/item/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.gson.toJson(this.itemForm)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void deveRetornarSucessoAoDeletarItem() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/item/1"))
		.andExpect(status().isOk());
	}

}
