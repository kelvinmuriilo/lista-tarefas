package com.linecode.controller;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.linecode.dto.ListaTarefaDto;
import com.linecode.form.ListaTarefaForm;
import com.linecode.servico.AplicacaoServico;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class ListaTarefaControllerTest {

	@Autowired
	private ListaTarefaController listaTarefaController;
	
	@MockBean
	private AplicacaoServico aplicacaoServico;
	
	@BeforeEach
	private void setup() {
		standaloneSetup(this.listaTarefaController);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarListaTarefa() {
		
		when(this.aplicacaoServico.getListaTarefa()).thenReturn(new ArrayList<>());
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/lista-tarefa")
		.then()
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void deveRetornarExcecao_QuandoBuscarListaTarefa() {
	}
	
	@Test
	public void deveAcessarServicoCadastrarListaTarefa_QuandoCadastrarListaTarefa() {
		ListaTarefaForm listaTarefaForm = new ListaTarefaForm();
		listaTarefaForm.setTitulo("Titulo");
		
		given()
			.accept(ContentType.ANY)
			.body(listaTarefaForm)
		.when()
			.post("/lista-tarefa")
		.then()
			.statusCode(HttpStatus.SC_OK); 
		
		//verify(this.aplicacaoServico, times(1)).cadastrarListaTarefa(listaTarefaForm);
	}
}
