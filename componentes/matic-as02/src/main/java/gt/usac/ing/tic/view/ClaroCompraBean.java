package gt.usac.ing.tic.view;

import gt.usac.ing.tic.modelo.dto.TicCuentaDto;
import gt.usac.ing.tic.modelo.dto.TicUserDto;
import gt.usac.ing.tic.srv.GeneralSrv;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "claroCompraBean")
@ViewScoped
public class ClaroCompraBean  implements Serializable{

	@PostConstruct
    public void init() {
		
    }
	private String txtUsuario=null;
	private String txtPassword=null;
	TicUserDto beanUser=null;
	private ArrayList<SelectItem> cbxCuentas=new ArrayList<SelectItem>();
	
	@ManagedProperty("#{generalSrvImpl}")
    protected GeneralSrv generalSrvImpl;    
    
    
    public GeneralSrv getGeneralSrvImpl() {
		return generalSrvImpl;
	}
	public void setGeneralSrvImpl(GeneralSrv generalSrvImpl) {
		this.generalSrvImpl = generalSrvImpl;
	}
	
	public void pagoServicio(ActionEvent actionEvent) {
		 Redirect("resultado.xhtml");
	}
	
	 public void loginClose(ActionEvent actionEvent) {
		 Redirect("../index.xhtml");
	}
	
	 public void iniciarSession(ComponentSystemEvent event){
		 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		 txtUsuario = (String) session.getAttribute("usuarioSession");
		 txtPassword 	= (String) session.getAttribute("passwordSession");
		 
		 if (txtUsuario != null && !txtUsuario.isEmpty()) {
			 beanUser=generalSrvImpl.findUsuarioPassword(txtUsuario,txtPassword);
			 if(beanUser!=null){
				 Iterator<TicCuentaDto> itCuenta=beanUser.getListaCuentas().iterator();
				 while(itCuenta.hasNext()){
					 TicCuentaDto ocuenta=itCuenta.next();
					 cbxCuentas.add(new SelectItem(ocuenta.getNo_Cuenta(), ocuenta.getTipo_Cuenta()+"-"+ocuenta.getNo_Cuenta()+"  "+ocuenta.getNombre_cuenta()));		 
				 }
			 }else{
				 Redirect("../index.xhtml");
			 }
		 }else{
			 Redirect("../index.xhtml");
		 }
	 }
	
	private String Redirect(String path){
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
	public ArrayList<SelectItem> getCbxCuentas() {
		return cbxCuentas;
	}
	public void setCbxCuentas(ArrayList<SelectItem> cbxCuentas) {
		this.cbxCuentas = cbxCuentas;
	}

}
