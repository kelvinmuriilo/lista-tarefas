package com.linecode.servico;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.linecode.dao.ItemResitory;
import com.linecode.dao.ListaTarefaRepositoy;
import com.linecode.dto.ListaTarefaDto;
import com.linecode.exception.ExcecaoAplicacao;
import com.linecode.form.AtualizarItemForm;
import com.linecode.form.ItemForm;
import com.linecode.form.ListaTarefaForm;
import com.linecode.modelo.Item;
import com.linecode.modelo.ListaTarefa;
import com.linecode.modelo.StatusItem;

@Service
public class AplicacaoServico {

	@Autowired
	private ListaTarefaRepositoy listaTarefaRepository;
	
	@Autowired	
	private ItemResitory itemRepository;

	public List<ListaTarefaDto> getListaTarefa(){
		List<ListaTarefa> listaTarefa = listaTarefaRepository.findAll();
		return ListaTarefaDto.converterToList(listaTarefa);
	}
	
	@Transactional
	public void cadastrarListaTarefa(ListaTarefaForm listaTarefaForm) {
		ListaTarefa listaTarefa = new ListaTarefa(listaTarefaForm.getTitulo());
		listaTarefaRepository.save(listaTarefa);
	}
	
	@Transactional
	public void cadastrarItem(ItemForm itemForm) {
		ListaTarefa listaTarefa = listaTarefaRepository.findById(itemForm.getIdListaTarefa()).get();
		if(listaTarefa != null) {
			Item item = new Item(itemForm.getDescricao(), listaTarefa);
			itemRepository.save(item);
		} else {
			throw new ExcecaoAplicacao("Lista não encontrada!");
		}
	}
	
	@Transactional
	public void atualizarTarefa(Long id ,AtualizarItemForm form) {
		Item item = itemRepository.findById(id).get();
		if(item != null) {
			item.setStatus(StatusItem.CONCLUIDO);
			itemRepository.save(item);
		}
	}
	
	@Transactional
	public void removerItem(Long id) {
		Optional<Item> item = itemRepository.findById(id);
		if(item.isPresent()) {
			itemRepository.deleteById(id);
		} else {
			throw new ExcecaoAplicacao("Erro ao remover. Item não encontrado");
		}
	}
}

