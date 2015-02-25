package gt.usac.ing.tic.view;

import gt.usac.ing.tic.modelo.dto.TicUserDto;
import gt.usac.ing.tic.srv.GeneralSrv;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "compraBean")
@ViewScoped
public class CompraBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	private TicUserDto loginUser=null;
	
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
	 public void iniciarSession(ComponentSystemEvent event){
		 
		  	
	 }
	 
	 public void loginUser(ActionEvent actionEvent) {
		 
		 
		 Redirect("pagosOnline.xhtml");
	}
	 
	 public void loginClose(ActionEvent actionEvent) {
		 Redirect("../index.xhtml");
	}
	 
	 
	 public void pagoServicio(ActionEvent actionEvent) {
		 Redirect("resultado.xhtml");
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
	 
}
