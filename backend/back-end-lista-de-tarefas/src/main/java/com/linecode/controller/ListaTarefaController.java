package com.linecode.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.linecode.dao.ListaTarefaRepositoy;
import com.linecode.dto.ListaTarefaDto;
import com.linecode.form.ListaTarefaForm;
import com.linecode.modelo.ListaTarefa;
import com.linecode.servico.AplicacaoServico;

@RestController
@RequestMapping("/lista-tarefa")
@CrossOrigin(origins = "http://localhost:4200")
public class ListaTarefaController {
	
	@Autowired
	private AplicacaoServico aplicacaoServico;
	
	@Autowired
	private ListaTarefaRepositoy ListaTarefaRepositoy;
	
	@GetMapping
	public List<ListaTarefaDto> getListaTarefa(){
		return aplicacaoServico.getListaTarefa();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<String> cadastrarListaTarefa(@RequestBody ListaTarefaForm listaTarefaForm ){
		aplicacaoServico.cadastrarListaTarefa(listaTarefaForm);
		return ResponseEntity.ok("Lista cadastrada com sucesso!");
	}
}
