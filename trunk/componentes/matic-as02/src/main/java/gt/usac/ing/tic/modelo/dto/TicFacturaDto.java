package gt.usac.ing.tic.modelo.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TicFacturaDto   implements java.io.Serializable{

	public TicFacturaDto(){
		
	}
	String no_Factura;
	BigDecimal valor;
	String estado;
	String usuario;
	Date fecha;
	String no_Transaccion;
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getNo_Factura() {
		return no_Factura;
	}
	public void setNo_Factura(String no_Factura) {
		this.no_Factura = no_Factura;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNo_Transaccion() {
		return no_Transaccion;
	}
	public void setNo_Transaccion(String no_Transaccion) {
		this.no_Transaccion = no_Transaccion;
	}
	
}
