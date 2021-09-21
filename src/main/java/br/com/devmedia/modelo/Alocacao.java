package br.com.devmedia.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "alocacoes")
public class Alocacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "carga_horaria")
	@NotNull(message = "A carga horária deve ser informada")
	private Integer cargaHoraria;
	
	private Boolean gestor;
	
	@Column(name = "inicio_participacao")
	private LocalDate inicioParticipacao;
	
	@Column(name = "fim_participacao")
	private LocalDate fimParticipacao;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	@NotNull(message = "O funcionário deve ser informado")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "projeto_id")
	@NotNull(message = "O projeto deve ser informado")
	private Projeto projeto;

	public Alocacao() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Boolean getGestor() {
		return gestor;
	}

	public void setGestor(Boolean gestor) {
		this.gestor = gestor;
	}

	public LocalDate getInicioParticipacao() {
		return inicioParticipacao;
	}

	public void setInicioParticipacao(LocalDate inicioParticipacao) {
		this.inicioParticipacao = inicioParticipacao;
	}

	public LocalDate getFimParticipacao() {
		return fimParticipacao;
	}

	public void setFimParticipacao(LocalDate fimParticipacao) {
		this.fimParticipacao = fimParticipacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alocacao other = (Alocacao) obj;
		return Objects.equals(id, other.id);
	}
}
