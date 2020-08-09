package com.linecode.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.linecode.databuilders.ListaTarefaDataBuilder;
import com.linecode.exception.ExcecaoAplicacao;
import com.linecode.form.ListaTarefaForm;
import com.linecode.servico.AplicacaoServico;

@SpringBootTest
public class AplicacaoServicoTest {
	
	private static final String MSG_TITULO_LISTA_TAREFA_PREENCHIDO = "O campo título precisa ser preenchido.";

	@Autowired
	AplicacaoServico aplicacaoServico;	
	
	@MockBean
	private AplicacaoServicoDataBuilder aplicacaoServicoDataBuilder;
	
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
	
}
