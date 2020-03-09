package com.stefanini.dao.util;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Configuracao do CDI
 * Responsavel pela configuração da injeção do EntityManager
 */
public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jpa");

    public JPAUtil() {
    }

    /**
     * Retorna o EntityManager para injecao do contexto
     * @return
     */
    @Produces
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Fechar o EntityManager após uma transacao
     * @param em
     */
    public void close(@Disposes EntityManager em) {
        em.close();
    }
}
