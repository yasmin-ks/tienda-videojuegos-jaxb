package yks.model;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Juego {
	
	@XmlAttribute
	private String codigo;
	
	@XmlElement
	private Titulo titulo;
	
	@XmlElement
	private Estudio estudio;
	
	@XmlElement
	private int anio;
	
	@XmlElement
	private double precio;
	
	@XmlElement(name="stock")
	private boolean hayStock;
	
	public Juego() {
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isHayStock() {
		return hayStock;
	}

	public void setHayStock(boolean hayStock) {
		this.hayStock = hayStock;
	}

	@Override
	public String toString() {
		return titulo.getTituloValor() + " | Estudio: "
				+ estudio.getNombre() + " | Año: " + anio + " | Precio: " + precio
				+ "€ | " + (hayStock?"En stock":"Sin existencias");
	}
	
	
	
	

}
