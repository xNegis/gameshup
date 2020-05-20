package aiss.modelapi;

public class PubgPlayer {
	String id;
	String nombre;
	String email;
	String plataforma;
	
	public PubgPlayer(String id, String nombre, String email, String plataforma) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.plataforma = plataforma;
	}
	
	
	public PubgPlayer() {
		super();
		
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	
}
