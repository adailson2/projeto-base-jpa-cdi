package com.stefanini.teste;

import java.time.LocalDate;
import java.util.Arrays;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.EnderecoServico;
import com.stefanini.servico.PessoaServico;


public class App {

	@Inject
	private PessoaServico pessoaServico;
	
	@Inject
	private EnderecoServico enderecoServico;
	
	public static void main(String[] args) {
		//CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.executar();
		}
	}

	public void executar() {
		Pessoa pessoa = new Pessoa("João", "joaom.dev@hotmail.com1", LocalDate.of(1995, 8, 25), Boolean.TRUE);
		Endereco end1 = new Endereco("Quadra", "Casa", "Taguatinga", "Brasília", "DF", "72000000");
		Endereco end2 = new Endereco("Rua", "Apartamento", "Bairro das Graças", "Rio de Janeiro", "RJ", "75462130");
		
		
		pessoa.setEnderecos(Arrays.asList(end1, end2));
		
		enderecoServico.salvar(end1);
		enderecoServico.salvar(end2);
		
		pessoaServico.salvar(pessoa);
	}
}
