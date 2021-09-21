package br.com.devmedia.teste;

import javax.persistence.EntityManager;

import br.com.devmedia.modelo.Grupo;
import br.com.devmedia.util.JpaUtil;

public class TesteInserirGrupo {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		Grupo grupo = new Grupo();
		grupo.setNome("Gestores");
		
		em.getTransaction().begin();
		em.persist(grupo);
		em.getTransaction().commit();
	}
}
