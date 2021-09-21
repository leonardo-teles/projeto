package br.com.devmedia.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "funcionarios")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O nome não pode ser nulo")
	@Size(max = 50, message = "O nome não pode ultrapassar {max} caracteres")
	private String nome;
	
	@CPF(message = "Informe um CPF válido")
	@NotEmpty(message = "O CPF deve ser informado")
	@Column(unique = true, length = 14, nullable = false)
	private String cpf;
	
	@Column(unique = true)
	@Email(message = "Informe um email válido")
	@NotEmpty(message = "O e-Mail deve ser informado")
	@Size(max = 40, message = "O e-Mail não pode ultrapassar {max} caracteres")
	private String email;
	
	@Column(columnDefinition = "numeric(10,2)")
	@NotEmpty(message = "O salário deve ser informado")
	private BigDecimal salario;
	
	@NotEmpty(message = "A data de nascimento deve ser informado")
	@Past(message = "A data de nascimento não pode estar no futuro")
	private LocalDate nascimento;
	
	@NotNull(message = "O campo ativo deve ser informado")
	private Boolean ativo;
	
	@Lob
	private byte[] foto;
	
	@NotEmpty(message = "O login deve ser informado")
	@Size(max = 20, message = "O login não pode ultrapassar {max} caracteres")
	private String login;
	
	@NotEmpty(message = "A senha deve ser informada")
	@Size(max = 10, message = "A senha não pode ultrapassar {max} caracteres")
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	@NotNull(message = "O grupo deve ser informado")
	private Grupo grupo;
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	@NotNull(message = "O setor deve ser informado")
	private Setor setor;

	public Funcionario() {}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}
}
