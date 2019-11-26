package dad.javafx.palabras;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class PalabrasController implements Initializable {
	private PalabrasModel modelPalabras= new PalabrasModel();
	@FXML
	private BorderPane viewPalabras;

	@FXML
	private ListView<String> listadoPalabras;

	

	@FXML
	private Button addBoton;

	@FXML
	private Button deleteBoton;

	@FXML
	void onAddAction(ActionEvent event) {
		try {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Nuevo nombre");
			dialog.setHeaderText("Añadir nuevo nombre a la lista");
			dialog.setContentText("Nombre");
			Optional<String> result = dialog.showAndWait();
			
			if(result.isPresent() && result.get().length()>=3 && !Pattern.compile( "[0-9]" ).matcher( result.get() ).find() && result.get()!=null) {

				modelPalabras.listaPalabrasProperty().add(result.get());
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Palabra agregada");
				alert.setHeaderText("ERROR AL AGREGAR PALABRA");
				alert.setContentText("La palabra agregada debe ser >=3 y solo caracteres alfabéticos");
				alert.show();
			}
			
		} catch (Exception e) {
			
		}
	}

	@FXML
	void onDeleteAction(ActionEvent event) {
		modelPalabras.getListaPalabras().remove(modelPalabras.getPalabraSeleccionada());

	}

	public PalabrasController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PalabrasView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listadoPalabras.itemsProperty().bind(modelPalabras.listaPalabrasProperty());
		modelPalabras.palabraSeleccionadaProperty().bind(listadoPalabras.getSelectionModel().selectedIndexProperty());
	}
	public PalabrasModel getModelPalabras() {
		return modelPalabras;
	}

	public void setModelPalabras(PalabrasModel modelPalabras) {
		this.modelPalabras = modelPalabras;
	}

	public BorderPane getView() {
		return viewPalabras;
	}

}
