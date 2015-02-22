package gt.usac.ing.tic.modelo.dto;

public class TicUserDto  implements java.io.Serializable{
	public TicUserDto(){
		
	}
	private static final long serialVersionUID = 1L;
	String User;
	String Nombre;
	String Status;
	String Email;
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

}
