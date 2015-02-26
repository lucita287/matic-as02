package gt.usac.ing.tic.srv;


import gt.usac.ing.tic.modelo.dto.TicFacturaDto;
import gt.usac.ing.tic.modelo.dto.TicUserDto;

import java.math.BigDecimal;
import java.util.List;

public interface GeneralSrv {
	public List<Object[]> consultaEmpleado();


	public TicUserDto findUsuarioPassword(String p_usuario, String p_password);


	public TicUserDto findUsuario(String p_usuario);
	
	public String loginIniciarSession(String p_usuario,String p_password);


	public TicFacturaDto findFactura(String p_factura);


	public BigDecimal findSaldoCuenta(String no_cuenta);


	public String pagoServicio(String p_usuario, String p_cuenta, BigDecimal p_monto,
			String p_Factura);
	
}
