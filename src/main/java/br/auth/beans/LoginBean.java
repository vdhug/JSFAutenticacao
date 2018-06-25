package br.auth.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.auth.controles.LoginDAO;
import br.auth.utils.SessionUtils;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uname;
	private String pwd;
	private String msg;
	private boolean valid = false;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	// Retorna se o usuario possui uma conexao ativa
	public boolean isValid() {
		return valid;
	}
	
	// Método que valida usuário e senha de usuário e cria uma sessão
	public String validateUsernamePassword() {
		valid = LoginDAO.validate(uname, pwd);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", uname);
			return "success";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Nome de usuário ou senha incorretos", "Por favor digite seu nome de usuário e senha"));
			return "login";
		}
	}

	// Metodo que se desconecta, encerra sessão e seta o login para falso
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		valid = false;
		return "login";
	}
	
	

}
