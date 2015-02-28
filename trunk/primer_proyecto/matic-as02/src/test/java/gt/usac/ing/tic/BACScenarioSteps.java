package gt.usac.ing.tic;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import gt.usac.ing.tic.modelo.dto.TicCuentaDto;
import gt.usac.ing.tic.modelo.dto.TicFacturaDto;
import gt.usac.ing.tic.modelo.dto.TicUserDto;
import gt.usac.ing.tic.srv.GeneralSrv;
import gt.usac.ing.tic.srv.impl.GeneralSrvImpl;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class BACScenarioSteps {

	TicCuentaDto v_Cuenta=null;
	TicFacturaDto v_factura=null;
	TicUserDto v_Usuario=null;
	GeneralSrv v_client=null;
	BigDecimal saldo_cuenta=new BigDecimal(0);
    private BigDecimal saldo_factura;
    
    private BeanFactory path;

    @Given("pagar Servicios en Linea <p_usuario>")
    public void pagarServicios(@Named("p_usuario") String p_usuario) {
    	
    	v_client = new GeneralSrvImpl();
    	
    	if(v_client!=null){
    		v_Usuario=v_client.findUsuario(p_usuario);
    		
    	}
    }
    
    @When("selecciono la Cuenta asociada a mi usuario <p_cuenta>")
    public void SeleccionoCuenta(@Named("p_cuenta") String p_cuenta) {
    	if(v_Usuario!=null){
    		v_Cuenta=new TicCuentaDto();
    		v_Cuenta.setNo_Cuenta(p_cuenta);
    		v_Usuario.setListaCuentas(new ArrayList<TicCuentaDto>());
    		v_Usuario.getListaCuentas().add(v_Cuenta);
    	}
    }

    @When("ingreso el numero de factura <p_no_factura>")
    public void ingresarNoFactura(@Named("p_no_factura") String  p_no_factura) {
    	if(v_client!=null){
    		v_factura  =v_client.findFactura(p_no_factura);
    		
    	}
    }

    @When("ingreso el monto a pagar <p_monto>")
    public void validarMonto(@Named("p_monto") String p_monto) {
    	try{
    		saldo_factura=new BigDecimal(p_monto);
			 
		}catch(Exception e){
			 
		}
    }
    
    @When("presiono el boton de Transmitir")
    public void transmitiendo() {
    	if(v_Usuario!=null ){
    		if(v_client!=null && v_Usuario.getListaCuentas().size()>0){
    			saldo_cuenta = v_client.findSaldoCuenta(v_Usuario.getListaCuentas().get(0).getNo_Cuenta());
    		}
    	}
    }
    
    @Then("la factura existe")
    public void checkFactura() {
    		if(v_factura == null){
    			assertFalse(true);
    		}else{
    			assertTrue(true);
    		}
    	    
    }
    
    @Then("el monto no corresponde a la factura")
    public void checkSaldoFactura() {
    	   if(saldo_factura!=null && v_factura!=null  ){
    		   if(v_factura.getValor().compareTo(saldo_factura)==0){
    			   assertTrue(true);
    			  
    			   
    		   }else{
    			   assertFalse(true);
    		   }
    		   
    	   }else{
    		   assertFalse(true);
    	   }
    }
    
    @Then("el monto es menor a mil")
    public void checkSaldomil() {
    	BigDecimal SaldoMil =new BigDecimal(1000);
    	   if(saldo_factura!=null  ){
    		   if(saldo_factura.compareTo(SaldoMil)<0){
    			   assertTrue(true);
    		   }else{
    			   assertFalse(true);
    		   }
    		   
    	   }else{
    		   assertFalse(true);
    	   }
    }
    
    @Then("la cuenta no tiene fondos para realizar el pago")
    public void checkSaldoCuenta() {
    	   if(saldo_cuenta!=null && saldo_factura!=null){
    		   		if(saldo_cuenta.compareTo(saldo_factura)>=0){
    				   assertTrue(true);
    			   } else{
    				   assertFalse(true);
    			   }
    		   
    	   }else{
    		   assertFalse(true);
    	   }
    }
    
    @Then("se despliega el comprobante de pago")
    public void checkUsuario() {
    	    assertNotNull(v_Usuario);
    }
    


}
