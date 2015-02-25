package gt.usac.ing.tic.srv.impl;

import gt.usac.ing.tic.dao.DaoGeneral;
import gt.usac.ing.tic.modelo.dto.TicCuentaDto;
import gt.usac.ing.tic.modelo.dto.TicUserDto;
import gt.usac.ing.tic.srv.GeneralSrv;

import java.io.Serializable;










import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    } 
    
    
    @Override
    public List<Object[]> consultaEmpleado()
          {
   	 		 
                return this.daoGeneralImpl.findByNamedQuery("findprueba");
    }
    
    @Override
    public TicUserDto findUsuario(String p_usuario,String p_password)
    {
    	List<Object[]> lstUsuario =new ArrayList<Object[]>();
    	TicUserDto dtoUsuario= null;
    	try{
    		lstUsuario=this.daoGeneralImpl.findByNamedQuery("findusuario",p_usuario,p_password);
    		
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
	    			e.printStackTrace();
	    		}
	    		}
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
        return dtoUsuario;
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
