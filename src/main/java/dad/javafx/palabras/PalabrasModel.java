package dad.javafx.palabras;

import java.io.File;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PalabrasModel {
	private ListProperty<String> listaPalabras = new SimpleListProperty<String>(FXCollections.observableArrayList(new ArrayList<String>()));
	private IntegerProperty palabraSeleccionada= new SimpleIntegerProperty();
	public final ListProperty<String> listaPalabrasProperty() {
		return this.listaPalabras;
	}
	
	public final ObservableList<String> getListaPalabras() {
		return this.listaPalabrasProperty().get();
	}
	
	public final void setListaPalabras(final ObservableList<String> listaPalabras) {
		this.listaPalabrasProperty().set(listaPalabras);
	}
	
	public final IntegerProperty palabraSeleccionadaProperty() {
		return this.palabraSeleccionada;
	}
	
	public final int getPalabraSeleccionada() {
		return this.palabraSeleccionadaProperty().get();
	}
	
	public final void setPalabraSeleccionada(final int palabraSeleccionada) {
		this.palabraSeleccionadaProperty().set(palabraSeleccionada);
	}
	
}
