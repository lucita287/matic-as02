package gt.usac.ing.tic.srv;


import gt.usac.ing.tic.modelo.dto.TicUserDto;

import java.util.List;

public interface GeneralSrv {
	public List<Object[]> consultaEmpleado();

	public TicUserDto findUsuario(String Usuario, String Password);
	
}
