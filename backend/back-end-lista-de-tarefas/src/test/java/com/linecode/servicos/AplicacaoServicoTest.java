package com.linecode.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.linecode.dao.ItemRepository;
import com.linecode.dao.ListaTarefaRepositoy;
import com.linecode.databuilders.ItemDataBuilder;
import com.linecode.databuilders.ListaTarefaDataBuilder;
import com.linecode.exception.ExcecaoAplicacao;
import com.linecode.form.ItemForm;
import com.linecode.form.ListaTarefaForm;
import com.linecode.modelo.ListaTarefa;
import com.linecode.servico.AplicacaoServico;

@SpringBootTest
public class AplicacaoServicoTest {
	
	private static final String MSG_TITULO_LISTA_TAREFA_PREENCHIDO = "O campo título precisa ser preenchido.";
	private static final String MSG_LISTA_NAO_ENCONTRADA = "Lista não encontrada!";
	private static final String MSG_INFORME_DESCRICAO = "Informe a descrição do item.";
	private static final String MSG_INFORME_LISTA_PARA_CADASTRAR_ITEM = "Informe a lista que deseja cadastrar o item.";
	
	private ListaTarefa listaTarefa;

	@Autowired
	private AplicacaoServico aplicacaoServico;	
	
	@Autowired
	private ListaTarefaRepositoy listaTarefaRepositoy;
	
	@BeforeEach
	public void salvaListaTarefa() {
		listaTarefa = new ListaTarefa(1L, "TESTE");
		listaTarefaRepositoy.save(listaTarefa);
	}
	
	@AfterEach
	public void esvaziaBancoDeDados() {
		listaTarefaRepositoy.deleteAll();
	}
	
	@Test
	public void deveLancarExcecaoAoCadastrarListaComTituloVazio() {
		try {
			ListaTarefaForm listaTituloVazio = new ListaTarefaDataBuilder()
						.titulo("")
						.constroi();
			aplicacaoServico.cadastrarListaTarefa(listaTituloVazio);
			fail();
		} catch (ExcecaoAplicacao e) {
			assertEquals(MSG_TITULO_LISTA_TAREFA_PREENCHIDO, e.getMessage());

		}
	}
	
	@Test
	public void deveLancarExcecaoAoCadastrarListaComTituloNulo() {
		try {
			ListaTarefaForm listaTarefaTituloNulo = new ListaTarefaDataBuilder()
					.titulo(null)
					.constroi();
			aplicacaoServico.cadastrarListaTarefa(listaTarefaTituloNulo);
			fail();
		} catch (ExcecaoAplicacao e) {
			assertEquals(MSG_TITULO_LISTA_TAREFA_PREENCHIDO, e.getMessage());
		}
	}
	
	@Test
	@Transactional
	public void deveLancarExcecaoAoCadastrarItemComDescricaoVazia() {
	
		try {
			ItemForm itemFormDescricaoVazia = new ItemDataBuilder()
					.descricao("")
					.idListaTarefa(1L)
					.constroi();
			aplicacaoServico.cadastrarItem(itemFormDescricaoVazia);
			fail();
		} catch (ExcecaoAplicacao e) {
			assertEquals(MSG_INFORME_DESCRICAO, e.getMessage());
		}
	}
	
	@Test
	public void deveLancarExececaoAoCadastrarItemComIdListaTarefaInexistente() {

		try {
			ItemForm itemFormListaTarefaInexistente = new ItemDataBuilder()
					.descricao("Teste")
					.idListaTarefa(2L)
					.constroi();
			aplicacaoServico.cadastrarItem(itemFormListaTarefaInexistente);
			fail();
		} catch (ExcecaoAplicacao e) {
			assertEquals(MSG_LISTA_NAO_ENCONTRADA, e.getMessage());
		}
	
	}
	
}
