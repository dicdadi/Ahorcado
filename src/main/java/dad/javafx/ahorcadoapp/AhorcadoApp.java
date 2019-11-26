package dad.javafx.ahorcadoapp;


import java.util.ArrayList;

import dad.javafx.puntuaciones.Jugador;
import dad.javafx.root.RootController;
import dad.javafx.utils.Persistencia;
import javafx.application.Application;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class AhorcadoApp extends Application {

private RootController root;
private ListProperty<String> listaPalabras=new SimpleListProperty<String>(FXCollections.observableArrayList(new ArrayList<String>()));
private ListProperty<Jugador> listaJugadores = new SimpleListProperty<Jugador>(FXCollections.observableArrayList(new ArrayList<Jugador>()));
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		root=new RootController();
		root.getModel().palabrasProperty().bind(listaPalabras);
		root.getModel().puntuacionesProperty().bind(listaJugadores);
		Scene scene = new Scene(root.getView());
		primaryStage.setTitle("Ahorcado");
		primaryStage.setScene(scene);
		primaryStage.show();
		root.cargarNuevoJuego();
	}
	@Override
	public void init() throws Exception {
		if(Persistencia.FICHEROPALABRAS.exists())
		{
		listaPalabras.setAll(Persistencia.cargarPalabras());
	
		}
		if(Persistencia.FICHEROPUNTUACIONES.exists()) 
		listaJugadores.setAll(Persistencia.cargarJugadores());
		super.init();
	}

	@Override
	public void stop() throws Exception {
		Persistencia.guardarPalabras(listaPalabras.get());
		Persistencia.guardarJugadores(listaJugadores.get());
		super.stop();
	}


	public static void main(String[] args) {
		launch(args);

	}

}
