package dad.javafx.root;

import java.util.ArrayList;

import dad.javafx.puntuaciones.Jugador;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RootModel {
	private ListProperty<String> palabras = new SimpleListProperty<String>(FXCollections.observableArrayList(new ArrayList<String>()));
	private ListProperty<Jugador> puntuaciones = new SimpleListProperty<Jugador>(FXCollections.observableArrayList(new ArrayList<Jugador>()));
	private IntegerProperty vidas= new SimpleIntegerProperty();
	private StringProperty palabraGenerada= new SimpleStringProperty();
	public final ListProperty<String> palabrasProperty() {
		return this.palabras;
	}
	

	public final ObservableList<String> getPalabras() {
		return this.palabrasProperty().get();
	}
	

	public final void setPalabras(final ObservableList<String> palabras) {
		this.palabrasProperty().set(palabras);
	}


	public final ListProperty<Jugador> puntuacionesProperty() {
		return this.puntuaciones;
	}
	


	public final ObservableList<Jugador> getPuntuaciones() {
		return this.puntuacionesProperty().get();
	}
	


	public final void setPuntuaciones(final ObservableList<Jugador> puntuaciones) {
		this.puntuacionesProperty().set(puntuaciones);
	}


	public final IntegerProperty vidasProperty() {
		return this.vidas;
	}
	


	public final int getVidas() {
		return this.vidasProperty().get();
	}
	


	public final void setVidas(final int vidas) {
		this.vidasProperty().set(vidas);
	}


	public final StringProperty palabraGeneradaProperty() {
		return this.palabraGenerada;
	}
	


	public final String getPalabraGenerada() {
		return this.palabraGeneradaProperty().get();
	}
	


	public final void setPalabraGenerada(final String palabraGenerada) {
		this.palabraGeneradaProperty().set(palabraGenerada);
	}
	
	



	
	
	


	

}
