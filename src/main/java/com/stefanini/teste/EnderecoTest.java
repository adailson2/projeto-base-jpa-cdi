package com.stefanini.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.stefanini.model.Endereco;

public class EnderecoTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("post");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Endereco endereco = new Endereco("Quadra", "Casa", "Taguatinga", "Brasília", "DF", "72000000");
		em.persist(endereco);
		em.getTransaction().commit();
		em.close();
		emf.close();
		System.out.println(endereco);

	}

}