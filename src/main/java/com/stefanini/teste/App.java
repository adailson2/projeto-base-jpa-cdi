package com.stefanini.teste;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.model.PessoaPerfil;
import com.stefanini.servico.EnderecoServico;
import com.stefanini.servico.PerfilServico;
import com.stefanini.servico.PessoaPerfilServico;
import com.stefanini.servico.PessoaServico;


public class App {

	@Inject
	private PessoaServico pessoaServico;
	
	@Inject
	private EnderecoServico enderecoServico;
	
	@Inject
	private PerfilServico perfilServico;
	
	@Inject
	private PessoaPerfilServico pessoaPerfilServico;
	
	public static void main(String[] args) {
		//CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.executar();
		}
	}

	public void executar() {
//		buscarPessoas();
//		encontrarPessoaPorId(5L);
		salvarPessoa();
//		removerPessoa();
	}

	private void remover() {
		System.out.println(pessoaServico.encontrar(1L));
		pessoaServico.remover(5L);
	}

	private void encontrarPessoaPorId(Long id) {
		Optional<Pessoa> pessoa = pessoaServico.encontrar(id);
		if (pessoa.isPresent()) {
			System.out.println("Pessoa encontrada");
			System.out.println(pessoa.get());
		} else {
			System.out.println("Pessoa não encontrada");
		}
	}

	private void buscarPessoas() {
		pessoaServico.getList().ifPresent(i -> {
			i.forEach(b -> {
				System.out.println(b.getEnderecos());
				System.out.println(b);
			});
		});
	}

	public void salvarPessoa() {
		Pessoa pessoa = new Pessoa("ADAILSON", "adailson2@gmail.com", LocalDate.of(1993, 1, 26), true);
		System.out.println(pessoa);
		pessoaServico.salvar(pessoa);
	}
}
