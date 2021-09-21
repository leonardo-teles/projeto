package br.com.devmedia.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.devmedia.dao.GrupoDAO;
import br.com.devmedia.modelo.Grupo;

@Named
@SessionScoped
public class GrupoMB implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Inject
	private GrupoDAO dao;
	
	private Grupo grupo;
	
	public GrupoMB() {
		dao = new GrupoDAO();
	}

	public String listar() {
		return "/privado/grupo/lista?faces-redirect=true";
	}
	
	public String novo() {
		grupo = new Grupo();
		
		return "cadastro";
	}
	
	public String cancelar() {
		return listar();
	}
	
	public String salvar() {
		if(dao.salvar(grupo)) {
			return "lista";
		} else {
			return "cadastro";
		}
	}
	
	public String editar(Grupo objeto) {
		grupo = objeto;
		
		return "cadastro";
	}
	
	public String excluir(Grupo grupo) {
		dao.excluir(grupo);
		
		return "lista";
	}
	
	public GrupoDAO getDao() {
		return dao;
	}
	
	public void setDao(GrupoDAO dao) {
		this.dao = dao;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
}
