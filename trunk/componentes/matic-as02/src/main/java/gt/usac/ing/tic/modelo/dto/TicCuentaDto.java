package gt.usac.ing.tic.modelo.dto;

public class TicCuentaDto  implements java.io.Serializable{
	public TicCuentaDto(){
		
	}
	String usuario;
	String no_Cuenta;
	String tipo_Cuenta;
	String nombre_cuenta;
	String moneda;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNo_Cuenta() {
		return no_Cuenta;
	}
	public void setNo_Cuenta(String no_Cuenta) {
		this.no_Cuenta = no_Cuenta;
	}
	public String getTipo_Cuenta() {
		return tipo_Cuenta;
	}
	public void setTipo_Cuenta(String tipo_Cuenta) {
		this.tipo_Cuenta = tipo_Cuenta;
	}
	public String getNombre_cuenta() {
		return nombre_cuenta;
	}
	public void setNombre_cuenta(String nombre_cuenta) {
		this.nombre_cuenta = nombre_cuenta;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
	
}
