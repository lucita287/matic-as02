package gt.usac.ing.tic.view;

import gt.usac.ing.tic.modelo.dto.TicCuentaDto;
import gt.usac.ing.tic.modelo.dto.TicUserDto;
import gt.usac.ing.tic.srv.GeneralSrv;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@ManagedBean(name = "resultadoBean")
@ViewScoped
public class ResultadoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
    public void init() {

    }
	private String txtUsuario=null;
	private String txtPassword=null;
	TicUserDto beanUser=null;
	private String txt_no_cuenta=null;
	private String txt_no_factura=null;
	private String txt_saldo=null;
	private String txt_nombre=null;
	private String txt_resultado=null;
	private Boolean bol_resultado=false;
	@ManagedProperty("#{generalSrvImpl}")
    protected GeneralSrv generalSrvImpl;    
    
    
    public GeneralSrv getGeneralSrvImpl() {
		return generalSrvImpl;
	}
	public void setGeneralSrvImpl(GeneralSrv generalSrvImpl) {
		this.generalSrvImpl = generalSrvImpl;
	}
	
	public void iniciarSession(ComponentSystemEvent event){
		 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		 txtUsuario = (String) session.getAttribute("usuarioSession");
		 txtPassword 	= (String) session.getAttribute("passwordSession");
		 txt_no_cuenta = (String) session.getAttribute("cuentaSession");
		 txt_no_factura  = (String)( session.getAttribute("passwordSession")).toString();
		 txt_saldo = (String)( session.getAttribute("saldoSession")).toString();
		 if (txtUsuario != null && !txtUsuario.isEmpty()) {
			 beanUser=generalSrvImpl.findUsuarioPassword(txtUsuario,txtPassword);
			 if(beanUser==null){
				 Redirect("../index.xhtml");
			 }else{
				 txt_nombre=beanUser.getNombre()+" "+beanUser.getNombre();
				 txt_resultado="Tu pago ha sido aplicada exitosamente.";
				 bol_resultado=true;
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
	
	 public void loginClose(ActionEvent actionEvent) {
		 Redirect("../index.xhtml");
		 HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                 .getExternalContext().getSession(false);
		 session.removeAttribute("usuarioSession");
         session.removeAttribute("passwordSession");
         session.removeAttribute("cuentaSession");
         session.removeAttribute("saldoSession");
         session.removeAttribute("facturaSession");
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
	public String getTxt_no_cuenta() {
		return txt_no_cuenta;
	}
	public void setTxt_no_cuenta(String txt_no_cuenta) {
		this.txt_no_cuenta = txt_no_cuenta;
	}
	public String getTxt_no_factura() {
		return txt_no_factura;
	}
	public void setTxt_no_factura(String txt_no_factura) {
		this.txt_no_factura = txt_no_factura;
	}
	public String getTxt_saldo() {
		return txt_saldo;
	}
	public void setTxt_saldo(String txt_saldo) {
		this.txt_saldo = txt_saldo;
	}
	public String getTxt_nombre() {
		return txt_nombre;
	}
	public void setTxt_nombre(String txt_nombre) {
		this.txt_nombre = txt_nombre;
	}
	public String getTxt_resultado() {
		return txt_resultado;
	}
	public void setTxt_resultado(String txt_resultado) {
		this.txt_resultado = txt_resultado;
	}
	public Boolean getBol_resultado() {
		return bol_resultado;
	}
	public void setBol_resultado(Boolean bol_resultado) {
		this.bol_resultado = bol_resultado;
	}
	
}
