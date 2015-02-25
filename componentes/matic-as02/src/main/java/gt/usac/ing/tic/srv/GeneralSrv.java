package gt.usac.ing.tic.srv;


import gt.usac.ing.tic.modelo.dto.TicUserDto;

import java.util.List;

public interface GeneralSrv {
	public List<Object[]> consultaEmpleado();


	public TicUserDto findUsuarioPassword(String p_usuario, String p_password);


	public TicUserDto findUsuario(String p_usuario);
	
	public String loginIniciarSession(String p_usuario,String p_password);
	
}
