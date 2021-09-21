package br.com.devmedia.teste;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.devmedia.modelo.Alocacao;
import br.com.devmedia.modelo.Funcionario;
import br.com.devmedia.modelo.Projeto;
import br.com.devmedia.modelo.Setor;
import br.com.devmedia.util.JpaUtil;

public class TesteInserirProjeto {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Setor setor = em.find(Setor.class, 1L);
		Funcionario funcionario = em.find(Funcionario.class, 1L);
		
		Projeto projeto = new Projeto();
		projeto.setNome("Sistema de Projetos");
		projeto.setDescricao("Sistema de Gestão de Projetos de Software");
		projeto.setInicio(LocalDate.now());
		projeto.setFim(LocalDate.of(2021, 12, 30));
		projeto.setAtivo(true);
		projeto.setSetor(setor);
		
		Alocacao alocacao = new Alocacao();
		alocacao.setCargaHoraria(100);
		alocacao.setGestor(true);
		alocacao.setInicioParticipacao(LocalDate.now());
		alocacao.setFimParticipacao(LocalDate.of(2021, 11, 15));
		alocacao.setFuncionario(funcionario);
		alocacao.setProjeto(projeto);
		
		projeto.adicionarFuncionario(alocacao);
		
		em.getTransaction().begin();
		
		em.persist(projeto);
		
		em.getTransaction().commit();
	}
}
