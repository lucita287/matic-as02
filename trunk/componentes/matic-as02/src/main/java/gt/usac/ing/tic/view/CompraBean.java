package gt.usac.ing.tic.view;

import gt.usac.ing.tic.modelo.dto.TicUserDto;
import gt.usac.ing.tic.srv.GeneralSrv;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "compraBean")
@ViewScoped
public class CompraBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	private TicUserDto loginUser=null;
	
	private String txtUsuario;
	private String txtPassword;
	/**
     * <p>Servicio gestionado por Spring, contiene la logica del negocio </p>
     */
    @ManagedProperty("#{generalSrvImpl}")
    protected GeneralSrv generalSrvImpl;    
    
    
    public GeneralSrv getGeneralSrvImpl() {
		return generalSrvImpl;
	}
	public void setGeneralSrvImpl(GeneralSrv generalSrvImpl) {
		this.generalSrvImpl = generalSrvImpl;
	}
    
	@PostConstruct
    public void init() {

    }
	 
	 
	 public void loginUser(ActionEvent actionEvent) {
		 String resultado = generalSrvImpl.loginIniciarSession(txtUsuario,txtPassword);
		 if(resultado.equalsIgnoreCase("ok")){
			 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			 session.setAttribute("usuarioSession", txtUsuario);
             session.setAttribute("passwordSession", txtPassword);
			 Redirect("pagosOnline.xhtml");
		 }else{
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", resultado));
		 }
		 
		 
	}
	 
	
	 
	 
	public TicUserDto getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(TicUserDto loginUser) {
		this.loginUser = loginUser;
	}
	
	public String Redirect(String path){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(path);
           
        } catch (IOException ex) {
             
        }
          return "";
    }
	public String getTxtUsuario() {
		return txtUsuario;
	}
	public void setTxtUsuario(String txtUsuario) {
		this.txtUsuario = txtUsuario;
	}
	public String getTxtPassword() {
		return txtPassword;
	}
	public void setTxtPassword(String txtPassword) {
		this.txtPassword = txtPassword;
	}
	 
}
