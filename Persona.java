import java.util.Scanner;

public class Persona {
	String nombre;
	String apellido;
	int edad;
	
	public Persona() {
		
	}
	
	public void setNombre(String _nombre) {
		nombre = _nombre;
	}
	
	public void setApellido(String _apellido) {
		apellido = _apellido;
	}
	
	public void setEdad(int _edad) {
		edad = _edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public int getEdad(){
		return edad;
	}
	
	

}
