package cl.ubb.agil;

public class Categoria {

	String nombre;
	String codigo; 
	
	public Categoria (String nombre, String codigo) {
		
		this.nombre = nombre;
		this.codigo  =codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		if(codigo.length()>5)
			return codigo.substring(0, 5);
		else
			return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
