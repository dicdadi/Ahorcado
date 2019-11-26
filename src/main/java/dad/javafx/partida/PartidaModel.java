package dad.javafx.partida;

import java.util.ArrayList;

import dad.javafx.puntuaciones.Jugador;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class PartidaModel {
	private ListProperty<Jugador> puntuacionesJugadoresPartida = new SimpleListProperty<Jugador>(FXCollections.observableArrayList(new ArrayList<Jugador>()));
	private ListProperty<String> listaPalabrasPartida = new SimpleListProperty<String>(FXCollections.observableArrayList(new ArrayList<String>()));
	private IntegerProperty puntos= new SimpleIntegerProperty();
	private IntegerProperty vidas= new SimpleIntegerProperty();
	private StringProperty palabraOculta= new SimpleStringProperty();
	private StringProperty palabraIntroducida=new SimpleStringProperty();
	private ObjectProperty<Image> imagen= new SimpleObjectProperty<>();
	private StringProperty letrasIntroducidas= new SimpleStringProperty("");
	
	public final ListProperty<Jugador> puntuacionesJugadoresPartidaProperty() {
		return this.puntuacionesJugadoresPartida;
	}
	

	public final ObservableList<Jugador> getPuntuacionesJugadoresPartida() {
		return this.puntuacionesJugadoresPartidaProperty().get();
	}
	

	public final void setPuntuacionesJugadoresPartida(final ObservableList<Jugador> puntuacionesJugadoresPartida) {
		this.puntuacionesJugadoresPartidaProperty().set(puntuacionesJugadoresPartida);
	}


	public final ListProperty<String> listaPalabrasPartidaProperty() {
		return this.listaPalabrasPartida;
	}
	


	public final ObservableList<String> getListaPalabrasPartida() {
		return this.listaPalabrasPartidaProperty().get();
	}
	


	public final void setListaPalabrasPartida(final ObservableList<String> listaPalabrasPartida) {
		this.listaPalabrasPartidaProperty().set(listaPalabrasPartida);
	}


	public final IntegerProperty puntosProperty() {
		return this.puntos;
	}
	


	public final int getPuntos() {
		return this.puntosProperty().get();
	}
	


	public final void setPuntos(final int puntos) {
		this.puntosProperty().set(puntos);
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
	


	public final StringProperty palabraOcultaProperty() {
		return this.palabraOculta;
	}
	


	public final String getPalabraOculta() {
		return this.palabraOcultaProperty().get();
	}
	


	public final void setPalabraOculta(final String palabraOculta) {
		this.palabraOcultaProperty().set(palabraOculta);
	}
	


	public final StringProperty palabraIntroducidaProperty() {
		return this.palabraIntroducida;
	}
	


	public final String getPalabraIntroducida() {
		return this.palabraIntroducidaProperty().get();
	}
	


	public final void setPalabraIntroducida(final String palabraIntroducida) {
		this.palabraIntroducidaProperty().set(palabraIntroducida);
	}
	


	public final ObjectProperty<Image> imagenProperty() {
		return this.imagen;
	}
	


	public final Image getImagen() {
		return this.imagenProperty().get();
	}
	


	public final void setImagen(final Image imagen) {
		this.imagenProperty().set(imagen);
	}
	


	public final StringProperty letrasIntroducidasProperty() {
		return this.letrasIntroducidas;
	}
	


	public final String getLetrasIntroducidas() {
		return this.letrasIntroducidasProperty().get();
	}
	


	public final void setLetrasIntroducidas(final String letrasIntroducidas) {
		this.letrasIntroducidasProperty().set(letrasIntroducidas);
	}
	
	
	
}
