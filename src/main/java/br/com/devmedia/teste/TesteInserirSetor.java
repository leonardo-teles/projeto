package br.com.devmedia.teste;

import javax.persistence.EntityManager;

import br.com.devmedia.modelo.Setor;
import br.com.devmedia.util.JpaUtil;

public class TesteInserirSetor {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Setor setor = new Setor();
		setor.setNome("Administrativo");
		
		em.getTransaction().begin();
		
		em.persist(setor);
		
		em.getTransaction().commit();
	}
}
