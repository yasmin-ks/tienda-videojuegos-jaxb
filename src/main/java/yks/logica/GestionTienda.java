package yks.logica;

import java.io.File;
import java.nio.file.Path;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import yks.model.Juego;
import yks.model.Tienda;

public class GestionTienda {
	
	Path ruta;
	
	public GestionTienda(Path ruta) {
		this.ruta = ruta;
	}

	// Unmarshal del XML
	private Tienda getTienda() {
		
		Tienda tienda = null;
		
		try {
			JAXBContext context = JAXBContext.newInstance(Tienda.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			tienda = (Tienda) unmarshaller.unmarshal(ruta.toFile());
			
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("No se ha encontrado el fichero.");
		}
		
		return tienda;
	}
	
	// Marshal con salida formateada
	private void escribirXML(Tienda t) {

		JAXBContext contexto;
		
		try {
			contexto = JAXBContext.newInstance(Tienda.class);
			
			Marshaller marshaller = contexto.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(t, ruta.toFile());
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	// imprime el título de todos los juegos
	public void mostrarTitulos() {
		
		Tienda t = getTienda();
		
		if (t==null) {
			System.out.println("No hay tienda. Adiós");
			return;
		}
		
		t.getJuegos().stream()
			.map(x -> x.getTitulo())
			.forEach(System.out::println);
	}
	
	// imprime los juegos de esa plataforma
	public void mostrarPorPlataforma(String plataforma) {
		
		Tienda t = getTienda();

		if (t==null) {
			System.out.println("No hay tienda :(");
			return;
		}
		
		t.getJuegos().stream()
			.filter(x -> x.getTitulo().getPlataforma().equals(plataforma))
			.forEach(System.out::println);
	}
	
	// devuelve el precio medio de todos los juegos
	public double precioMedio() {
		
		Tienda t = getTienda();
		
		if (t==null)
			return -1;
		
		return t.getJuegos().stream()
			.map(x -> x.getPrecio())
			.mapToDouble(x -> x)
			.average().getAsDouble();
	}
	
	// imprime los juegos que no tienen stock
	public void mostrarSinStock() {
		
		Tienda t = getTienda();
		
		if (t==null)
			return;
		
		t.getJuegos().stream()
			.filter(x -> !x.isHayStock())
			.forEach(System.out::println);
	}
	
	public void agregarJuego(Juego j) {
		
		Tienda t = getTienda();
		
		if (t==null)
			return;
		
		t.getJuegos().add(j);
		
		escribirXML(t);
	}
	
	// elimina el juego con ese código y devuelve true si lo encontró, false si no.
	public boolean eliminarJuego(String codigo) {
		Tienda t = getTienda();
		
		if (t==null)
			return false;
		
		boolean encontrado = t.getJuegos().removeIf(x -> x.getCodigo().equals(codigo));
		
		if (encontrado)
			escribirXML(t);
		
		return encontrado;
	}
	
	// Cambia el país de un estudio. Devuelve false si la tienda no se pudo leer.
	public boolean cambiarPais(String estudio, String nuevoPais) {
		
		Tienda t = getTienda();
		
		if (t==null)
			return false;
		
		boolean encontrado = false;
		
		for (Juego j : t.getJuegos()) {
			if (j.getEstudio().getNombre().equals(estudio)) {
				
				encontrado = true;
				j.getEstudio().setPaisOrigen(nuevoPais);
			}
		}
		
		if (encontrado)
		 escribirXML(t);
		
		return encontrado;
	}
	
	
	// sube el precio de todos los juegos de ese estudio un X %.
	
	public void subirPrecio(String estudio, double porcentaje) {

		Tienda t = getTienda();
		
		if (t==null)
			return;
		
		t.getJuegos().stream()
			.filter(x -> x.getEstudio().getNombre().equals(estudio))
			.forEach(x -> x.setPrecio(x.getPrecio() * (1 + porcentaje / 100)));
		
		escribirXML(t);
	}
	
	

}
