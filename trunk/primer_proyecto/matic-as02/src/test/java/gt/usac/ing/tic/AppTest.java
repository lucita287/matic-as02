package gt.usac.ing.tic;

import gt.usac.ing.tic.modelo.dto.TicCuentaDto;
import gt.usac.ing.tic.modelo.dto.TicFacturaDto;
import gt.usac.ing.tic.modelo.dto.TicUserDto;
import gt.usac.ing.tic.srv.GeneralSrv;
import gt.usac.ing.tic.srv.impl.GeneralSrvImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private BeanFactory path;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	
    	System.out.println("==================================================================================");
    	System.out.println("===================================PRUEBAS UNITARIAS=======================================");
    	System.out.println("==================================================================================");
    	System.out.println("==================================================================================");
    	System.out.println("==================================================================================");
    	System.out.println("==================================================================================");
    	System.out.println("==================================================================================");
    	
    	List<Object[]> notificacion =new ArrayList<Object[]>();
    	try{
    		path = new ClassPathXmlApplicationContext("classpath*:META-INF/applicationContextTest.xml");
    		GeneralSrv client;
        	client = (GeneralSrv) path.getBean("generalSrvImpl");
        	String resultado = client.loginIniciarSession("lucit287","123456");
        	
        	System.out.println("*******************LOGIN CORRECTO PARA lucita287*****************************");
        	System.out.println(resultado);
          	
    	}catch (Exception e){
    		
    		System.out.println("****************"+e.getMessage());
    	}
    	
    	//VERIFICAR SI EXISTE LA FACTURA
    	try{
    		path = new ClassPathXmlApplicationContext("classpath*:META-INF/applicationContextTest.xml");
    		GeneralSrv client;
        	client = (GeneralSrv) path.getBean("generalSrvImpl");
        	TicFacturaDto FAC = client.findFactura("ABC456");
        	if(FAC!=null){
        		System.out.println("************************************************");
            	System.out.println(FAC.getNo_Factura()+" "+FAC.getValor());
        	}
          	
    	}catch (Exception e){
    		
    		System.out.println("****************"+e.getMessage());
    	}
    	
    	//VERIFICAR SI TIENE SALDO
    	try{
    		path = new ClassPathXmlApplicationContext("classpath*:META-INF/applicationContextTest.xml");
    		GeneralSrv client;
        	client = (GeneralSrv) path.getBean("generalSrvImpl");
        	BigDecimal saldo = client.findSaldoCuenta("44130266522");
        	if(saldo!=null){
        		System.out.println("************************************************");
            	System.out.println("SALDO DE LA CUENTA   44130266522 "+saldo);
        	}
          	
    	}catch (Exception e){
    		
    		System.out.println("****************"+e.getMessage());
    	}
    	
    	 // Pagar Servicios en Linea 
    	// Para Pago de Servicio con cuenta con Fondos
    	// Selecciono la Cuenta asociada a mi usuario,
    	// Y  Pague se despliega el comprobante de pago.
    	
    	//VERIFICAR SI EXISTE LA FACTURA
    	try{
    		GeneralSrv client=new GeneralSrvImpl();
        	BigDecimal saldoFactura=new BigDecimal(900);
        	String resultado = client.pagoServicio("lucita287@gmail.com","33230266888",saldoFactura,"FACT0003");
        	if(resultado.equalsIgnoreCase("ok")){
        		System.out.println("+++++++++++++++ LA FACTURA EXISTE "+resultado);
        		assertTrue( true );
                
        	}else{
        		assertTrue( false );
                
        	}
        	
        	
          	
    	}catch (Exception e){
    		
    		System.out.println("****************"+e.getMessage());
    	}
    	
    	
    	System.out.println("==================================================================================");
    	System.out.println("==================================================================================");
    	System.out.println("==================================================================================");
    	System.out.println("==================================================================================");
    	System.out.println("==================================================================================");
    	
    	
    	
        
        
        
    }
}
