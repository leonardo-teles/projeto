package br.com.devmedia.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.devmedia.modelo.Funcionario;
import br.com.devmedia.modelo.Grupo;
import br.com.devmedia.modelo.Setor;
import br.com.devmedia.util.JpaUtil;

public class TesteInserirFuncionario {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Grupo grupo = em.find(Grupo.class, 1L);
		Setor setor = em.find(Setor.class, 1L);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Leonardo Teles de Almeida");
		funcionario.setCpf("299.717.060-59");
		funcionario.setEmail("leonardo.teles.almeida@gmail.com");
		funcionario.setSalario(new BigDecimal(2500.0));
		funcionario.setNascimento(LocalDate.of(1978, 02, 16));
		funcionario.setAtivo(true);
		funcionario.setLogin("leonardo");
		funcionario.setSenha("senha");
		funcionario.setGrupo(grupo);
		funcionario.setSetor(setor);
		
		em.getTransaction().begin();
		
		em.persist(funcionario);
		
		em.getTransaction().commit();
	}
}
