package dad.javafx.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import dad.javafx.puntuaciones.Jugador;

public class Persistencia {

//	public static final File FICHEROPALABRAS = new File(Persistencia.class.getResource("/archivos/palabras.txt").getFile());

//	public static final File FICHEROPALABRAS = new File(System.getProperty("user.home"), "palabrasRosmen.txt");
	public static final File FICHEROPALABRAS = new File("palabrasRosmen.txt");
//	public static final File FICHEROPUNTUACIONES = new File(System.getProperty("user.home"), "puntuacionesRosmen.txt");
	public static final File FICHEROPUNTUACIONES = new File("puntuacionesRosmen.txt");

	public static void guardarPalabras(List<String> listadoPalabras) throws IOException {

		FileUtils.writeLines(FICHEROPALABRAS, listadoPalabras);
	}

	public static List<String> cargarPalabras() throws IOException {

		if (!FICHEROPALABRAS.exists())
			return null;
		List<String> listadoPalabras = FileUtils.readLines(FICHEROPALABRAS, "UTF-8");
		return listadoPalabras;
	}

	public static void guardarJugadores(List<Jugador> listadoPalabras) throws IOException {
		List<String> aux= new ArrayList<String>();
		String stringAux=null;
		for (Jugador jugador : listadoPalabras) {
			stringAux=jugador.getNombre() + "," + jugador.getPuntuacion() + "," + jugador.getFecha();
			aux.add(stringAux);
		}
		FileUtils.writeLines(FICHEROPUNTUACIONES,aux); 
				

	}

	public static List<Jugador> cargarJugadores()  throws IOException {
		if(!FICHEROPUNTUACIONES.exists()) return null;
		List<String> listadoPuntuaciones= FileUtils.readLines(FICHEROPUNTUACIONES, "UTF-8");
		List<Jugador> result= new ArrayList<Jugador>();
		String[] aux ;
		for(String line : listadoPuntuaciones) {
			 aux=line.split(",");
			result.add(new Jugador(aux[0],Integer.parseInt(aux[1]),aux[2]));
		}
		return result;
	}
}
