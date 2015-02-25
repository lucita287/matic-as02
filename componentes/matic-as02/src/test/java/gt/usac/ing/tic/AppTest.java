package gt.usac.ing.tic;

import gt.usac.ing.tic.modelo.dto.TicCuentaDto;
import gt.usac.ing.tic.modelo.dto.TicUserDto;
import gt.usac.ing.tic.srv.GeneralSrv;

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
    	List<Object[]> notificacion =new ArrayList<Object[]>();
    	try{
    		path = new ClassPathXmlApplicationContext("classpath*:META-INF/applicationContextTest.xml");
    		GeneralSrv client;
        	client = (GeneralSrv) path.getBean("generalSrvImpl");
        	String resultado = client.loginIniciarSession("lucit287","123456");
        	
        	System.out.println("************************************************");
        	System.out.println(resultado);
          	
    	}catch (Exception e){
    		
    		System.out.println("****************"+e.getMessage());
    	}
        assertTrue( true );
    }
}
