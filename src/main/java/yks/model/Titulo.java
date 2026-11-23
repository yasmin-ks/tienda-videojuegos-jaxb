package yks.model;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Titulo {

	@XmlAttribute
	String plataforma;
	
	@XmlValue
	String tituloValor;
	
	public Titulo() {
		
	}

	public Titulo(String plataforma, String tituloValor) {
		this.plataforma = plataforma;
		this.tituloValor = tituloValor;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getTituloValor() {
		return tituloValor;
	}

	public void setTituloValor(String tituloValor) {
		this.tituloValor = tituloValor;
	}

	@Override
	public String toString() {
		return tituloValor;
	}
	
	
	

}
