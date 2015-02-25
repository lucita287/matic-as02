package gt.usac.ing.tic.modelo.dto;

import java.util.ArrayList;
import java.util.List;

public class TicUserDto  implements java.io.Serializable{
	public TicUserDto(){
		listaCuentas=new ArrayList<TicCuentaDto>();
	}
	private static final long serialVersionUID = 1L;
	String user;
	String nombre;
	String apellido;
	String email;
	List<TicCuentaDto> listaCuentas;
	
	public List<TicCuentaDto> getListaCuentas() {
		return listaCuentas;
	}
	public void setListaCuentas(List<TicCuentaDto> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
