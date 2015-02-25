package gt.usac.ing.tic.modelo.dto;

public class TicFacturaDto   implements java.io.Serializable{

	public TicFacturaDto(){
		
	}
	String no_Factura;
	String valor;
	String estado;
	String usuario;
	String fecha;
	String no_Transaccion;
	public String getNo_Factura() {
		return no_Factura;
	}
	public void setNo_Factura(String no_Factura) {
		this.no_Factura = no_Factura;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNo_Transaccion() {
		return no_Transaccion;
	}
	public void setNo_Transaccion(String no_Transaccion) {
		this.no_Transaccion = no_Transaccion;
	}
	
}
