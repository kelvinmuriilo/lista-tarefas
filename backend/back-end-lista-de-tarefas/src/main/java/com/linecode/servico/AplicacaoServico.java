package com.linecode.servico;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.linecode.dao.ItemRepository;
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
	private Validator validator;

	@Autowired
	private ListaTarefaRepositoy listaTarefaRepository;
	
	@Autowired	
	private ItemRepository itemRepository;

	public List<ListaTarefaDto> getListaTarefa(){
		List<ListaTarefa> listaTarefa = listaTarefaRepository.findAll();
		return ListaTarefaDto.converterToList(listaTarefa);
	}
	
	 /**
     * Realiza o cadastro de uma lista de tarefas.
     * 
     * @param Objeto com parâmetros para cadastro da lista de tarefa {@link ListaTarefaForm}
     */
	
	@Transactional
	public void cadastrarListaTarefa(ListaTarefaForm listaTarefaForm) {
		
		Assert.notNull(listaTarefaForm, "Informe os dados");
		
		Set<ConstraintViolation<ListaTarefaForm>> violacoes = validator.validate(listaTarefaForm);
		
		if(violacoes.isEmpty()) {
			ListaTarefa listaTarefa = new ListaTarefa(listaTarefaForm.getTitulo());
			listaTarefaRepository.save(listaTarefa);
		} else {
			throw new ExcecaoAplicacao(violacoes.stream().findFirst().get().getMessage());
		}	
		
	}
	
	
	/**
     * Realiza o cadastro de um item a uma lista de tarefas.
     * 
     * @param Objeto com parâmetros para cadastro do de tarefa {@link ItemForm}
     */
	
	@Transactional
	public void cadastrarItem(ItemForm itemForm) {
		
		Assert.notNull(itemForm, "Informe os dados");
		
		Set<ConstraintViolation<ItemForm>> violacoes = validator.validate(itemForm);
		
		if(violacoes.isEmpty()) {
			ListaTarefa listaTarefa = listaTarefaRepository.findById(itemForm.getIdListaTarefa()).get();
			if(listaTarefa != null) {
				Item item = new Item(itemForm.getDescricao(), listaTarefa);
				itemRepository.save(item);
			} else {
				throw new ExcecaoAplicacao("Lista não encontrada!");
			}
		} else {
			throw new ExcecaoAplicacao(violacoes.stream().findFirst().get().getMessage());
		}	
	}
	
	
	/**
     * Atualiza o status do item para concluído ou pendente.
     * 
     * @param Id para localizar o item a ser atualizado {@link Long}
     * @param Objeto com parâmetros para cadastro da lista de tarefa {@link AtualizarItemForm}
     */
	
	@Transactional
	public void atualizarItem(Long id) {
		

		Item item = itemRepository.findById(id).get();
		if(item != null) {
			if(item.getStatus() == StatusItem.CONCLUIDO) {
				item.setStatus(StatusItem.PENDENTE);
			}else {
				item.setStatus(StatusItem.CONCLUIDO);
			}
			
			itemRepository.save(item);
		} else {
			throw new ExcecaoAplicacao("Lista não encontrada!");
		}
	
				
	}
	
	
	/**
     * Realiza a exclusão de um item da lista de tarefas.
     * 
     * @param Id para localizar o item a ser deletado {@link Long}
     */
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

