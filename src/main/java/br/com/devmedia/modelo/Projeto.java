package br.com.devmedia.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "projetos")
public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O nome deve ser informado")
	@Size(max = 50, message = "O nome não deve ultrapassar {max} caracteres")
	private String nome;

	@Column(columnDefinition = "TEXT")
	@NotEmpty(message = "A descrição deve ser informada")
	private String descricao;
	
	@NotEmpty(message = "A data de início deve ser informada")
	private LocalDate inicio;
	
	private LocalDate fim;
	
	@NotNull(message = "O status do projeto deve ser informado")
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	@NotNull(message = "O setor deve ser informado")
	private Setor setor;
	
	@OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Alocacao> funcionarios = new ArrayList<>(); 

	public Projeto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	public List<Alocacao> getFuncionarios() {
		return funcionarios;
	}
	
	public void adicionarFuncionario(Alocacao alocacao) {
		alocacao.setProjeto(this);
		this.funcionarios.add(alocacao);
	}
	
	public void removerFuncionario(Alocacao alocacao) {
		if(this.funcionarios.contains(alocacao)) {
			this.funcionarios.remove(alocacao);
		}
	}
	
	public void removerTodosFuncionarios() {
		this.funcionarios.clear();
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
		Projeto other = (Projeto) obj;
		return Objects.equals(id, other.id);
	}
}
