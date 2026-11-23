package yks.model;

import jakarta.xml.bind.annotation.*;

@XmlType(propOrder = {"paisOrigen", "nombre"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Estudio {
	
	@XmlElement(name="pais")
	private String paisOrigen;
	
	@XmlElement(name="nombre")
	private String nombre;
	
	@XmlTransient
	private Double valoracionInterna;
	
	public Estudio() {
		
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValoracionInterna() {
		return valoracionInterna;
	}

	public void setValoracionInterna(Double valoracionInterna) {
		this.valoracionInterna = valoracionInterna;
	}
	
	

}
