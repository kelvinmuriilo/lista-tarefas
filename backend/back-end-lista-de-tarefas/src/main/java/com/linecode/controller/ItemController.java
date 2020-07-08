package com.linecode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linecode.form.AtualizarItemForm;
import com.linecode.form.ItemForm;
import com.linecode.servico.AplicacaoServico;

@RestController
@RequestMapping("item")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
	
	@Autowired
	private AplicacaoServico aplicacaoServico;

	@PostMapping
	@Transactional
	public ResponseEntity<String> cadastrarItem(@RequestBody ItemForm itemForm){
		aplicacaoServico.cadastrarItem(itemForm);
		return ResponseEntity.ok("Item cadastrado com sucesso!");
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<String> atualizarItem(@PathVariable Long id, @RequestBody AtualizarItemForm atualizarItemForm){
		aplicacaoServico.atualizarTarefa(id, atualizarItemForm);
		return ResponseEntity.ok("Item atualizado com sucesso!");
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<String> removerItem(@PathVariable Long id){
		aplicacaoServico.removerItem(id);
		return ResponseEntity.ok("Item removido com sucesso!");
	}
}
