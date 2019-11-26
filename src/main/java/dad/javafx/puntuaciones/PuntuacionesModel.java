package dad.javafx.puntuaciones;

import java.util.ArrayList;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PuntuacionesModel {
	private ListProperty<Jugador> puntuacionesJugadores = new SimpleListProperty<Jugador>(FXCollections.observableArrayList(new ArrayList<Jugador>()));

	public final ListProperty<Jugador> puntuacionesJugadoresProperty() {
		return this.puntuacionesJugadores;
	}
	

	public final ObservableList<Jugador> getPuntuacionesJugadores() {
		return this.puntuacionesJugadoresProperty().get();
	}
	

	public final void setPuntuacionesJugadores(final ObservableList<Jugador> puntuacionesJugadores) {
		this.puntuacionesJugadoresProperty().set(puntuacionesJugadores);
	}
	

}
