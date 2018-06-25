package br.auth.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.auth.controles.LoginDAO;
import br.auth.utils.SessionUtils;

@ManagedBean
@SessionScoped
public class PrivadoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	//Instancia um objeto ManageBean que é um Session para validar a conexao do usuario
	private LoginBean login = new LoginBean(); 
	
	
	//Metodo que leva a uma página privada para apenas usuarios logadoss
	public String paginaPrivada() {
		//checa se o bean Login tem uma sessão ativa e retorna uma página privada se sim, 
		// caso não tenha retorna uma página de erro, ou poderia retornar pra página de login 
		
		if(login.isValid())
			return "privado";
		else
			return "erro";
	}

}
