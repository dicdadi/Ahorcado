package dad.javafx.puntuaciones;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class PuntuacionesController implements Initializable {
	//private ObservableList<Jugador> jugadores = FXCollections.observableArrayList();
	private PuntuacionesModel model= new PuntuacionesModel();
	   public PuntuacionesModel getModel() {
		return model;
	}

	@FXML
	    private BorderPane puntuacionesView;

	    @FXML
	    private TableView<Jugador> puntuacionestTabla;

	    @FXML
	    private TableColumn<Jugador, String> jugadorColumna;

	    @FXML
	    private TableColumn<Jugador, Integer> puntuacionColumna;

	    @FXML
	    private TableColumn<Jugador, String> fechaColumna;

	public PuntuacionesController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PuntuacionesView.fxml"));
		loader.setController(this);
		loader.load();
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		puntuacionestTabla.itemsProperty().bind(model.puntuacionesJugadoresProperty());
		jugadorColumna.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
		puntuacionColumna.setCellValueFactory(new PropertyValueFactory<>("Puntuacion"));
		fechaColumna.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
		puntuacionestTabla.viewOrderProperty().setValue(2);
//		model.add(new Jugador("rosmen",800,"10/10/2019"));
//		model.getPuntuacionesJugadores().add(new Jugador("rosmen",800,"10/10/2019"));
		//puntuacionestTabla.setItems(jugadores);
		
		
	}
	public BorderPane getView() {
		
		return puntuacionesView;
	}

}
