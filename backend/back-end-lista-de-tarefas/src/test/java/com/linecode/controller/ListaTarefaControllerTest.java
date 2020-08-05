package com.linecode.controller;


import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.linecode.form.ListaTarefaForm;
import com.linecode.servico.AplicacaoServico;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest(controllers = ListaTarefaController.class)
public class ListaTarefaControllerTest {

	@Autowired
	private ListaTarefaController listaTarefaController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AplicacaoServico aplicacaoServico;
	
	Gson g = new Gson();

	
	@BeforeEach
	private void setup() {
		standaloneSetup(this.listaTarefaController);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarListaTarefa() {
		
		when(this.aplicacaoServico.getListaTarefa()).thenReturn(new ArrayList<>());
		
		given()
			.accept("application/json")	
		.when()
			.get("/lista-tarefa")
		.then()
			.statusCode(HttpStatus.SC_OK);
		

	}
	
	@Test
	public void deveRetornarExcecao_QuandoBuscarListaTarefa() {
	}
	
	@Test
	public void deveAcessarServicoCadastrarListaTarefa_QuandoCadastrarListaTarefa() throws Exception {
		ListaTarefaForm listaTarefaForm = new ListaTarefaForm();
		listaTarefaForm.setTitulo("Titulo");
				
		mockMvc.perform(MockMvcRequestBuilders.post("/lista-tarefa")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(g.toJson(listaTarefaForm)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void naoDevePermitirCadastrarListaSemTitulo_QuandoCadastrarListaTarefa() throws Exception {
		ListaTarefaForm listaTarefaForm = new ListaTarefaForm();
		

		mockMvc.perform(MockMvcRequestBuilders.post("/lista-tarefa")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(g.toJson(listaTarefaForm)))
				.andExpect(status().isInternalServerError());
		
			
	}
}
