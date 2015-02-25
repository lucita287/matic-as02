package gt.usac.ing.tic.view;

import gt.usac.ing.tic.modelo.dto.TicCuentaDto;
import gt.usac.ing.tic.modelo.dto.TicUserDto;
import gt.usac.ing.tic.srv.GeneralSrv;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
	private String txt_no_cuenta="";
	private String txt_no_factura="";
	private String fecha_actual="";
	private String txt_saldo="";
	
	@ManagedProperty("#{generalSrvImpl}")
    protected GeneralSrv generalSrvImpl;    
    
    
    public GeneralSrv getGeneralSrvImpl() {
		return generalSrvImpl;
	}
	public void setGeneralSrvImpl(GeneralSrv generalSrvImpl) {
		this.generalSrvImpl = generalSrvImpl;
	}
	
	public void pagoServicio(ActionEvent actionEvent) {
		BigDecimal saldoFactura=null;
		try{
			saldoFactura=new BigDecimal(txt_saldo);
			if(saldoFactura==null){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Debe ingresar un valor factura valido"));
				return;
			}
		}catch(Exception e){
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Debe ingresar un valor factura valido"));
			return;
		}
		
		try{
			String resultado = generalSrvImpl.pagoServicio(txtUsuario,txt_no_cuenta,saldoFactura,txt_no_factura);
			if(resultado.equalsIgnoreCase("ok")){
				 Redirect("resultado.xhtml");
				 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				 session.setAttribute("usuarioSession", txtUsuario);
	             session.setAttribute("passwordSession", txtPassword);
	             session.setAttribute("cuentaSession", txt_no_cuenta);
	             session.setAttribute("saldoSession", saldoFactura);
	             session.setAttribute("facturaSession", txt_no_factura);
			}else{
				 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", resultado));
			}
		
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error"));
			return;
		}
		
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
	
	 public void iniciarSession(ComponentSystemEvent event){
		 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		 txtUsuario = (String) session.getAttribute("usuarioSession");
		 txtPassword 	= (String) session.getAttribute("passwordSession");
		 
		 DateFormat formatd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 this.fecha_actual = formatd.format(new Date());
		 if (txtUsuario != null && !txtUsuario.isEmpty()) {
			 beanUser=generalSrvImpl.findUsuarioPassword(txtUsuario,txtPassword);
			 if(beanUser!=null){
				 Iterator<TicCuentaDto> itCuenta=beanUser.getListaCuentas().iterator();
				 while(itCuenta.hasNext()){
					 TicCuentaDto ocuenta=itCuenta.next();
					 cbxCuentas.add(new SelectItem(ocuenta.getNo_Cuenta(), ocuenta.getTipo_Cuenta()+"-"+ocuenta.getNo_Cuenta()+"  "+ocuenta.getNombre_cuenta()));		 
					 try{
						 txt_no_cuenta=ocuenta.getNo_Cuenta();
					 }catch(Exception e){
						 e.printStackTrace();
					 }
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
	public String getFecha_actual() {
		return fecha_actual;
	}
	public void setFecha_actual(String fecha_actual) {
		this.fecha_actual = fecha_actual;
	}
	public String getTxt_saldo() {
		return txt_saldo;
	}
	public void setTxt_saldo(String txt_saldo) {
		this.txt_saldo = txt_saldo;
	}
}
