package yks.app;

import java.io.FileReader;
import java.nio.file.Path;
import java.util.Properties;

import yks.logica.GestionTienda;
import yks.model.Juego;

public class Main {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
	
		try {
			prop.load(new FileReader("src/main/resources/app.properties"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		GestionTienda gt = new GestionTienda(Path.of(prop.getProperty("ruta")));
		
		System.out.println("Juegos de PS5:");
		gt.mostrarPorPlataforma("PS5");
		System.out.println();
		
		System.out.println("Todos los títulos:");
		gt.mostrarTitulos();
		System.out.println();
		
		System.out.println("Juegos sin stock:");
		gt.mostrarSinStock();
		
		
		Juego j = new Juego();
		// gt.addJuego(j);
		
		

	}

}
