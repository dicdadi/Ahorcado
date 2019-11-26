package dad.javafx.puntuaciones;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jugador {
	private StringProperty nombre = new SimpleStringProperty();
	private IntegerProperty puntuacion = new SimpleIntegerProperty();
	private StringProperty fecha = new SimpleStringProperty();

	public Jugador(String nombre, int puntuacion, String fecha) {
		this.nombre = new SimpleStringProperty(nombre);
		this.puntuacion = new SimpleIntegerProperty(puntuacion);
		this.fecha = new SimpleStringProperty(fecha);

	}

	public final StringProperty nombreProperty() {
		return this.nombre;
	}

	public final String getNombre() {
		return this.nombreProperty().get();
	}

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public final IntegerProperty puntuacionProperty() {
		return this.puntuacion;
	}

	public final int getPuntuacion() {
		return this.puntuacionProperty().get();
	}

	public final void setPuntuacion(final int puntuacion) {
		this.puntuacionProperty().set(puntuacion);
	}

	public final StringProperty fechaProperty() {
		return this.fecha;
	}

	public final String getFecha() {
		return this.fechaProperty().get();
	}

	public final void setFecha(final String fecha) {
		this.fechaProperty().set(fecha);
	}

}
