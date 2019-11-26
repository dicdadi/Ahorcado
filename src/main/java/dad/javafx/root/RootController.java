package dad.javafx.root;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import dad.javafx.palabras.PalabrasController;
import dad.javafx.partida.PartidaController;
import dad.javafx.puntuaciones.Jugador;
import dad.javafx.puntuaciones.PuntuacionesController;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;

public class RootController implements Initializable{
	private PalabrasController palabras;
	private PartidaController partida;
	private PuntuacionesController puntuaciones;
	private RootModel model=new RootModel();
	//private ListProperty<String> palabrasProperty = new SimpleListProperty<String>(FXCollections.observableArrayList(new ArrayList<String>()));
	
    @FXML
    private BorderPane rootView;

    public RootModel getModel() {
		return model;
	}

	@FXML
    private TabPane rootTab;

    @FXML
    private Tab partidaTab;

    @FXML
    private Tab palabrasTab;

    @FXML
    private Tab puntuacionesTab;

public RootController() throws IOException {

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewRoot.fxml"));
	loader.setController(this);
	loader.load();
	
	
	
}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			palabras = new PalabrasController();
			partida= new PartidaController(this);
			puntuaciones= new PuntuacionesController();
			palabrasTab.setContent(palabras.getView());
			partidaTab.setContent(partida.getView());
			puntuacionesTab.setContent(puntuaciones.getView());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//palabrasProperty.bind(model.palabrasPropertyProperty());
	palabras.getModelPalabras().listaPalabrasProperty().bind(model.palabrasProperty());
	puntuaciones.getModel().puntuacionesJugadoresProperty().bind(model.puntuacionesProperty());
	partida.getPartidaModel().puntuacionesJugadoresPartidaProperty().bind(model.puntuacionesProperty());
	partida.getPartidaModel().listaPalabrasPartidaProperty().bind(model.palabrasProperty());
	//partida.getPartidaModel().palabraOcultaProperty().bind(model.palabraGeneradaProperty());
	//partida.getPartidaModel().palabraOcultaProperty().bind();
	//partida.getPartidaModel().vidasProperty().bind(model.vidasProperty());
	
	
	}
//	public void cargarNuevoJuego() {
//		partida.nuevaPartida(generaPalabraOculta().toUpperCase());
//
//	}
//	public String generaPalabraOculta() {
//		 
//		 return model.palabrasProperty().get((int)(Math.random()*model.palabrasProperty().getSize()));
//	      
//	}
	public BorderPane getView() {
		return rootView;
	}
	
	

}
