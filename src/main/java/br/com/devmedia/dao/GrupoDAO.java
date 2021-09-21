package br.com.devmedia.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.devmedia.modelo.Grupo;
import br.com.devmedia.util.ErrorUtil;
import br.com.devmedia.util.JpaUtil;
import br.com.devmedia.util.MessageUtil;

public class GrupoDAO {

	private EntityManager em;

	public GrupoDAO() {
		em = JpaUtil.getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> listarTodos() {
		return em.createQuery("FROM Grupo ORDER BY nome").getResultList();
	}

	public boolean salvar(Grupo grupo) {
		try {
			em.getTransaction().begin();
			
			if (grupo.getId() == null) {
				em.persist(grupo);
			} else {
				em.merge(grupo);
			}
			
			em.getTransaction().commit();
			
			MessageUtil.mensagemInformacao("Grupo salvo com sucesso");
			
			return true;
		} catch (Exception e) {
			if(em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}

			em.getTransaction().rollback();
			
			MessageUtil.mensagemErro("Erro ao salvar o grupo: " + ErrorUtil.getMensagemErro(e));
			
			return false;
		}
	}
	
	public boolean excluir(Grupo grupo) {
		try {
			em.getTransaction().begin();

			em.remove(grupo);
			
			em.getTransaction().commit();
			
			MessageUtil.mensagemInformacao("Grupo excluído com sucesso");
			
			return true;
		} catch (Exception e) {
			if(em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}

			em.getTransaction().rollback();
			
			MessageUtil.mensagemErro("Erro ao excluir o grupo: " + ErrorUtil.getMensagemErro(e));
			
			return false;
		}
	}
	
	public Grupo buscarPorId(Long id) {
		return em.find(Grupo.class, id);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
