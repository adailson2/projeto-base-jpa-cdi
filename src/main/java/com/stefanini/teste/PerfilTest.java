package com.stefanini.teste;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.stefanini.model.Perfil;

public class PerfilTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("post");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Perfil perfil = new Perfil("ROLE_ADMIN", "Perfil de administrador", LocalDateTime.now(), LocalDateTime.now());
		em.persist(perfil);
		em.getTransaction().commit();
		em.close();
		emf.close();
		System.out.println(perfil);

	}

}