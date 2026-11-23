package yks.model;

import java.util.List;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "tienda")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tienda {
	
	@XmlAttribute
	private String nombre;
	
	@XmlElementWrapper(name = "juegos") // Solo crea la etiqueta <juegos>
	@XmlElement(name = "juego") 
	private List<Juego> juegos;

	public Tienda() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}
	
	
	

}
