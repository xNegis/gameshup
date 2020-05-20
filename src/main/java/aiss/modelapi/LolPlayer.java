package aiss.modelapi;

public class LolPlayer {
	
	String id;
	String nombre;
	String email;
	Integer nivel;
	
	public LolPlayer(String id, String nombre, String email, Integer nivel) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.nivel = nivel;
	}
	
	
	public LolPlayer() {
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
	
	public Integer getnivel() {
		return nivel;
	}
	
	public void setnivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	
	
}
