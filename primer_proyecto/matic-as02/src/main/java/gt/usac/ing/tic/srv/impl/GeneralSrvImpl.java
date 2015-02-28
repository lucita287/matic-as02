package gt.usac.ing.tic.srv.impl;

import gt.usac.ing.tic.dao.DaoGeneral;
import gt.usac.ing.tic.modelo.dto.TicCuentaDto;
import gt.usac.ing.tic.modelo.dto.TicFacturaDto;
import gt.usac.ing.tic.modelo.dto.TicUserDto;
import gt.usac.ing.tic.srv.GeneralSrv;

import java.io.Serializable;











import java.math.BigDecimal;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.springframework.core.env.Environment;



@Service("generalSrvImpl")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GeneralSrvImpl implements GeneralSrv, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//______________________________________________________________________________
    /**
     * <p>Genera mensajes de log para depuracion.</p>
     */
    private static Log logger = LogFactory.getLog(GeneralSrvImpl.class);

	  //______________________________________________________________________________
    /**
     * <p>Servicio gestionado por Spring, permite el acceso a la base de datos.</p>
     */
    @Resource
    private DaoGeneral daoGeneralImpl;

    public GeneralSrvImpl() {
        logger.info("construct: GeneralSrvImpl");
        cargaDatos();
    } 
    
    
    private ArrayList<TicUserDto> lstusuarios= new ArrayList<TicUserDto>();
    private ArrayList<TicFacturaDto> lstfacturas=new ArrayList<TicFacturaDto>();
    private HashMap<String,BigDecimal> lstSaldos=new HashMap<String,BigDecimal>();
    
    private void cargaDatos(){
    	TicUserDto user1 =new TicUserDto();
    	user1.setUser("lucita287@gmail.com");
    	user1.setNombre("Aura Luz");
    	user1.setApellido("Cifuentes Reyes");
    	user1.setEmail("lucita287@gmail.com");
    	user1.setPassword("lucita287");
    	TicCuentaDto cuenta1 = new TicCuentaDto();
    	cuenta1.setNo_Cuenta("33130266522");
    	cuenta1.setNombre_cuenta("AURA LUZ CIFUENTES REYES");
    	cuenta1.setTipo_Cuenta("M");
    	lstSaldos.put("33130266522", new BigDecimal(1000));
    	TicCuentaDto cuenta2 = new TicCuentaDto();
    	cuenta2.setNo_Cuenta("33230266888");
    	cuenta2.setNombre_cuenta("AURA LUZ CIFUENTES REYES");
    	cuenta2.setTipo_Cuenta("M");
    	lstSaldos.put("33230266888", new BigDecimal(5000));
    	user1.getListaCuentas().add(cuenta1);
    	user1.getListaCuentas().add(cuenta2);
    	this.lstusuarios.add(user1);

    	
    	TicUserDto user2 =new TicUserDto();
    	user2.setUser("yajomac@gmail.com");
    	user2.setNombre("Edwin Mac-donall");
    	user2.setApellido("Saban Chocojay");
    	user2.setEmail("yajomac@gmail.com");
    	user2.setPassword("yajomac");
    	TicCuentaDto cuenta3 = new TicCuentaDto();
    	cuenta3.setNo_Cuenta("44330216528");
    	lstSaldos.put("44330216528", new BigDecimal(1000));
    	cuenta3.setNombre_cuenta("Edwin Mac-donall Saban Chocojay");
    	cuenta3.setTipo_Cuenta("M");
    	user2.getListaCuentas().add(cuenta3);
    	TicCuentaDto cuenta4 = new TicCuentaDto();
    	cuenta4.setNo_Cuenta("34130216527");
    	lstSaldos.put("34130216527", new BigDecimal(2500));
    	cuenta4.setNombre_cuenta("Edwin Mac-donall Saban Chocojay");
    	cuenta4.setTipo_Cuenta("M");
    	user2.getListaCuentas().add(cuenta4);
    	this.lstusuarios.add(user2);
    	
    	TicUserDto user3 =new TicUserDto();
    	user3.setUser("prisila.flores@gmail.com");
    	user3.setNombre("Prisila Judith");
    	user3.setApellido("Flores Taracena");
    	user3.setEmail("prisila.flores@gmail.com");
    	user3.setPassword("prisila.flores");
    	TicCuentaDto cuenta5 = new TicCuentaDto();
    	cuenta5.setNo_Cuenta("31330819219");
    	lstSaldos.put("31330819219", new BigDecimal(1500));
    	cuenta5.setNombre_cuenta("Prisila Judith Flores Taracena");
    	cuenta5.setTipo_Cuenta("M");
    	user3.getListaCuentas().add(cuenta3);
    	TicCuentaDto cuenta6 = new TicCuentaDto();
    	cuenta6.setNo_Cuenta("44330815921");
    	lstSaldos.put("44330815921", new BigDecimal(1500));
    	cuenta6.setNombre_cuenta("Prisila Judith Flores Taracena");
    	cuenta6.setTipo_Cuenta("M");
    	user3.getListaCuentas().add(cuenta4);
    	this.lstusuarios.add(user3);
    	
    	TicFacturaDto facttura = new TicFacturaDto();
    	facttura.setNo_Factura("FACT0001");
    	facttura.setValor(new BigDecimal("600"));
    	facttura.setEstado("D");
    	lstfacturas.add(facttura);
    	
    	TicFacturaDto facttura2 = new TicFacturaDto();
    	facttura2.setNo_Factura("FACT0002");
    	facttura2.setValor(new BigDecimal("700"));
    	facttura2.setEstado("D");
    	lstfacturas.add(facttura2);
    	
    	
    	TicFacturaDto facttura3 = new TicFacturaDto();
    	facttura3.setNo_Factura("FACT0003");
    	facttura3.setValor(new BigDecimal("900"));
    	facttura3.setEstado("D");
    	lstfacturas.add(facttura3);
    	
    	TicFacturaDto facttura4 = new TicFacturaDto();
    	facttura4.setNo_Factura("FACT0004");
    	facttura4.setValor(new BigDecimal("800"));
    	facttura4.setEstado("D");
    	lstfacturas.add(facttura4);
    	
    	TicFacturaDto facttura5 = new TicFacturaDto();
    	facttura5.setNo_Factura("FACT0005");
    	facttura5.setValor(new BigDecimal("800"));
    	facttura5.setEstado("D");
    	lstfacturas.add(facttura5);
    	
    	
    	TicFacturaDto facttura6 = new TicFacturaDto();
    	facttura6.setNo_Factura("FACT0006");
    	facttura6.setValor(new BigDecimal("180"));
    	facttura6.setEstado("D");
    	lstfacturas.add(facttura6);
    	
    	TicFacturaDto facttura7 = new TicFacturaDto();
    	facttura7.setNo_Factura("FACT0007");
    	facttura7.setValor(new BigDecimal("80"));
    	facttura7.setEstado("D");
    	lstfacturas.add(facttura7);
    	
    	
    	lstusuarios.add(user1);
    	lstusuarios.add(user2);
    	lstusuarios.add(user3);

    }
    
    @Override
    public List<Object[]> consultaEmpleado()
          {
   	 		 
                return this.daoGeneralImpl.findByNamedQuery("findprueba");
    }
    @Override
    public String loginIniciarSession(String p_usuario,String p_password){
    	String resultado="Ha Ocurrido Error";
    	TicUserDto oUser=findUsuario(p_usuario);
    	if(oUser == null){
    		resultado="Su usuario es Incorrecto";
    	}else{
    		oUser=findUsuarioPassword(p_usuario,p_password);
    		if(oUser == null ){
    			resultado="Su clave es Incorrecta";
    		}else{
    			resultado="ok";
    		}
    	}
    	
    	return resultado;
    }
    @Override
    public String pagoServicio(String p_usuario,String p_cuenta, BigDecimal p_monto, String p_Factura){
    	String resultado="Ha ocurrido un error.";
    	try{	
	    	TicFacturaDto FAC = findFactura(p_Factura);
	    	if(FAC !=null){
		    	if(FAC.getValor().compareTo(p_monto)==0){
		    		BigDecimal saldo = findSaldoCuenta(p_cuenta);
		    		if(saldo.compareTo(p_monto)<0){
		    			resultado="Cuenta sin fondos suficientes, SALDO ACTUAL:"+saldo;
		    		}else{
		    			BigDecimal p_monto_100=new BigDecimal(1000);
		    			if(saldo.compareTo(p_monto_100)<0){
		    				resultado="El monto es mayor a mil";
		    			}else{
		    				resultado="ok";
		    			}
		    		}
		    	}else{
		    		resultado="El monton no corresponde al valor de la factura, MONTO FACTURA:"+FAC.getValor();
		    	}
	    	}else{
	    		resultado="La Factura ingresada no existe";
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return resultado;
    }
    
    
    
    
    @Override
    public TicUserDto findUsuarioPassword(String p_usuario,String p_password)
    {
    	List<Object[]> lstUsuario =new ArrayList<Object[]>();
    	TicUserDto dtoUsuario= null;
    	try{
    		lstUsuario=this.daoGeneralImpl.findByNamedQuery("findusuario_pass",p_usuario,p_password);
    		
    		if(lstUsuario!=null && lstUsuario.size()>0){
	    		dtoUsuario= new TicUserDto();
	    		Object[] oUsuario = lstUsuario.get(0);
	    		dtoUsuario.setUser(generarString(oUsuario[0]));
	    		dtoUsuario.setNombre(generarString(oUsuario[1]));
	    		dtoUsuario.setApellido(generarString(oUsuario[2]));
	    		dtoUsuario.setEmail(generarString(oUsuario[3]));
	    		
	    		List<Object[]> lstCuenta =new ArrayList<Object[]>();
	    		lstCuenta=this.daoGeneralImpl.findByNamedQuery("findcuenta",p_usuario);
	    		Iterator<Object[]> itlstCuenta = lstCuenta.iterator(); 
	    		while(itlstCuenta.hasNext()){
	    		try{	
	    			Object[] oCuenta = itlstCuenta.next();
	    			TicCuentaDto Vcuenta=new TicCuentaDto();
	    			Vcuenta.setNo_Cuenta(generarString(oCuenta[1]));
	    			Vcuenta.setUsuario(generarString(oCuenta[0]));
	    			Vcuenta.setNombre_cuenta(generarString(oCuenta[3]));
	    			Vcuenta.setTipo_Cuenta(generarString(oCuenta[2]));
	    			Vcuenta.setMoneda(generarString(oCuenta[4]));
	    			dtoUsuario.getListaCuentas().add(Vcuenta);
	    		}catch(Exception e){
	    			//e.printStackTrace();
	    		}
	    		}
    		}
    		
    		
    		if(dtoUsuario ==null){
        		Iterator<TicUserDto> ituser=this.lstusuarios.iterator();
        		while(ituser.hasNext()){
        			TicUserDto dtouser=ituser.next();
        			if(dtouser.getUser().equals(p_usuario) && dtouser.getPassword().equals(p_password)){
        				dtoUsuario=dtouser; 
        			}
        		}
        	}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
        return dtoUsuario;
    }
    
    @Override
    public TicUserDto findUsuario(String p_usuario)
    {
    	List<Object[]> lstUsuario =new ArrayList<Object[]>();
    	TicUserDto dtoUsuario= null;
    	try{
    		
    		lstUsuario=this.daoGeneralImpl.findByNamedQuery("findusuario",p_usuario);
    		
    		if(lstUsuario!=null && lstUsuario.size()>0){
	    		dtoUsuario= new TicUserDto();
	    		Object[] oUsuario = lstUsuario.get(0);
	    		dtoUsuario.setUser(generarString(oUsuario[0]));
	    		dtoUsuario.setNombre(generarString(oUsuario[1]));
	    		dtoUsuario.setApellido(generarString(oUsuario[2]));
	    		dtoUsuario.setEmail(generarString(oUsuario[3]));
	    		
	    	}
    		
    		
    	}catch(Exception e){
    		//e.printStackTrace();
    	}
    	
    	if(dtoUsuario ==null){
    		Iterator<TicUserDto> ituser=this.lstusuarios.iterator();
    		while(ituser.hasNext()){
    			TicUserDto dtouser=ituser.next();
    			if(dtouser.getUser().equalsIgnoreCase(p_usuario)){
    				dtoUsuario=dtouser; 
    			}
    		}
    	}
    	
    	
        return dtoUsuario;
    }
    
    
    
   @Override
    public TicFacturaDto findFactura(String p_no_factura)
    {
    	List<Object[]> lstFacturas =new ArrayList<Object[]>();
    	TicFacturaDto dtoFactura=null;
    	try{
    		lstFacturas=this.daoGeneralImpl.findByNamedQuery("findFactura",p_no_factura);
    		
    		if(lstFacturas!=null && lstFacturas.size()>0){
	    		dtoFactura= new TicFacturaDto();
	    		Object[] oFactura = lstFacturas.get(0);
	    		dtoFactura.setNo_Factura(generarString(oFactura[0]));
	    		dtoFactura.setValor(new BigDecimal(generarString(oFactura[1])));
	    		dtoFactura.setEstado(generarString(oFactura[2]));
	    		dtoFactura.setFecha( generarFecha(oFactura[4]));
	    		
	    	}
    		
    		
    	}catch(Exception e){
    		//e.printStackTrace();
    	}
    	
    	if(dtoFactura ==null){
    		Iterator<TicFacturaDto> itfacturar=this.lstfacturas.iterator();
    		while(itfacturar.hasNext()){
    			TicFacturaDto dtofact=itfacturar.next();
    			if(dtofact.getNo_Factura().equalsIgnoreCase(p_no_factura)){
    				dtoFactura=dtofact; 
    			}
    		}
    	}
    	
        return dtoFactura;
    }
   
   @Override
   public BigDecimal findSaldoCuenta(String no_cuenta)
   {
	   BigDecimal resultado = new BigDecimal(0);
	   List<Object> lstSaldos =new ArrayList<Object>();
	   
	   try{
		   lstSaldos=this.daoGeneralImpl.findByNamedQuery("findSaldo",no_cuenta);
	   		if(lstSaldos!=null && lstSaldos.size()>0){
		    		Object oSaldo = lstSaldos.get(0);
		    		resultado = new BigDecimal(generarString(oSaldo));		
		    }
	   	}catch(Exception e){
	   		
	   	}
	   
	   try{
		   BigDecimal resultado1=this.lstSaldos.get(no_cuenta);
		   if(resultado1!=null ){
			   resultado=resultado1;
		   }
	   }catch(Exception e1){
		   e1.printStackTrace();
	   }
	   
	   return resultado;
   }
    
   
    
    private Date generarFecha(Object fechaobj) {
        Date fechagen = null;
        SimpleDateFormat formatd = null;
        try {
            formatd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            fechagen = formatd.parse(fechaobj.toString());
        } catch (Exception e) {
            try {
                formatd = new SimpleDateFormat("yyyy-MM-dd");
                fechagen = formatd.parse(fechaobj.toString());
            } catch (Exception e1) {
                try {
                    formatd = new SimpleDateFormat("yyyy/MM/dd");
                    fechagen = formatd.parse(fechaobj.toString());
                } catch (Exception e2) {

                }
            }
        }
        return fechagen;
    }

    private String generarString(Object value) {
        String result = "";
        try {
            result = value.toString();
        } catch (Exception e) {

        }
        return result;
    }

	
}
