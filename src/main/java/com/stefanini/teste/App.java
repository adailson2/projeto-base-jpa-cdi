package com.stefanini.teste;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

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
		Pessoa pessoa = new Pessoa("João", "joaom.dev@hotmail.com1", LocalDate.of(1995, 8, 25), Boolean.TRUE);
		Endereco end1 = new Endereco("Quadra", "Casa", "Taguatinga", "Brasília", "DF", "72000000");
		Endereco end2 = new Endereco("Rua", "Apartamento", "Bairro das Graças", "Rio de Janeiro", "RJ", "75462130");
		
		Perfil perfilAdmin = new Perfil("ROLE_ADMIN", "Perfil de administrador", LocalDateTime.now(), LocalDateTime.now());
		Perfil perfilUser = new Perfil("ROLE_USER", "Perfil de usário", LocalDateTime.now(), LocalDateTime.now());
		
		pessoa.setEnderecos(Arrays.asList(end1, end2));
		
		perfilServico.salvar(perfilAdmin);
		perfilServico.salvar(perfilUser);
		
		enderecoServico.salvar(end1);
		enderecoServico.salvar(end2);
		
		pessoaServico.salvar(pessoa);
		
		PessoaPerfil pessoaAdmin = new PessoaPerfil(pessoa, perfilAdmin);
		PessoaPerfil pessoaUser = new PessoaPerfil(pessoa, perfilUser);
		
		pessoa.setPessoaPerfil(Arrays.asList(pessoaAdmin, pessoaUser));
		
		pessoaPerfilServico.salvar(pessoaAdmin);
		pessoaPerfilServico.salvar(pessoaUser);
	}
}
