package com.stefanini.teste;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import com.stefanini.servico.PessoaServico;


public class App {

	@Inject
	private PessoaServico pessoaServico;
	
	public static void main(String[] args) {
		//CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.executar();
		}
	}

	public void executar() {
		buscarPorId();
	}
	
	public void buscarPorId() {
		System.out.println(pessoaServico.encontrar(1L));
	}

}
