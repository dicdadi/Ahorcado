package dad.javafx.partida;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.puntuaciones.Jugador;
import dad.javafx.root.RootController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;

public class PartidaController implements Initializable {
	private final static int VIDAS=9;
	private PartidaModel partidaModel= new PartidaModel();
	RootController rootController;
	private String palabraOculta="";
	private String palabraFormateada="";
	private char auxLetra;
	public PartidaModel getPartidaModel() {
		return partidaModel;
	}
	@FXML
    private BorderPane partidaView;

    @FXML
    private TextField addLetrasText;

    @FXML
    private Button letraBoton;

    @FXML
    private Button resolverBoton;

    @FXML
    private ImageView imagen;

    @FXML
    private Label letrasPuestasText;

    @FXML
    private Label palabraOcultaText;

    @FXML
    private Label puntosX;

    @FXML
    private Label puntosY;

    @FXML
    void onLetraBotonAction(ActionEvent event) {
    	
    	try {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Letra ahorcado");
			dialog.setContentText("Introduce letra:");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent() && result.get()!=null) {
				char letra=result.get().toUpperCase().charAt(0);
				if(Character.isAlphabetic(result.get().charAt(0)) && result.get().length()==1) {
					if(partidaModel.getLetrasIntroducidas().contains(Character.toString(letra))) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Letra introducida");
						alert.setHeaderText("Ya has introducido esta letra.");
						alert.setContentText("No se verá contabilizado como fallo.");
						alert.show();
					}else {
					procesaLetra(letra);
					}
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR:LETRA INCORRECTA");
					alert.setHeaderText("Introduce sólo una letra alfabética válida.");
					alert.setContentText("No se verá contabilizado como fallo.");
					alert.show();
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
    	
    }

    @FXML
    void onResolverBotonAction(ActionEvent event) {
//    	nuevaPalabra(rootController.generaPalabraOculta().toUpperCase());
    	
 
    	try {
			if(partidaModel.getPalabraIntroducida().toUpperCase().equals(palabraOculta)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Palabra introducida");
				alert.setHeaderText("CORRECTO");
				alert.setContentText("Se te añadiran 10 puntos extras");
				alert.show();
				partidaModel.setPuntos(partidaModel.getPuntos()+10);
				nuevaPalabra(rootController.generaPalabraOculta().toUpperCase());
				partidaModel.setPalabraIntroducida(null);
	
			}else if(partidaModel.getVidas()>1) {
			
				partidaModel.setVidas(partidaModel.getVidas()-1);
				partidaModel.setPalabraIntroducida(null);
			}else {
				guardarPuntuacion();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
//    	rootController.cargarNuevoJuego();
    	
    }

	public PartidaController(RootController rootController) throws IOException {
		this.rootController=rootController;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PartidaView.fxml"));
		loader.setController(this);
		loader.load();

	
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		puntosX.textProperty().bindBidirectional(partidaModel.puntosProperty(),new NumberStringConverter());
		puntosY.textProperty().bindBidirectional(partidaModel.vidasProperty(),new NumberStringConverter());
		addLetrasText.textProperty().bindBidirectional(partidaModel.palabraIntroducidaProperty());
		imagen.imageProperty().bind(partidaModel.imagenProperty());
		letrasPuestasText.textProperty().bind(partidaModel.letrasIntroducidasProperty());
		palabraOcultaText.textProperty().bind(partidaModel.palabraOcultaProperty());
		partidaModel.vidasProperty().addListener((o,ov,nv)->cambiaImagen(nv));
		
		//nuevaPartida();
		
		
	}
	
	private void cambiaImagen(Number nv) {
	if(nv.intValue()>0) {
	int calculo=10-partidaModel.getVidas();
	Image nuevaImagen= new Image("/images/"+calculo+".png");
	partidaModel.setImagen(nuevaImagen);
	}
	}

	public void nuevaPartida(String palabraOculta){
		if(this.palabraOculta.equals(palabraOculta)) {
			//Si la palabra anterior es igual a la nueva que carga, solicita una diferente.
			nuevaPartida(rootController.generaPalabraOculta());
		}else {
			this.palabraOculta=palabraOculta;
			formateaPalabra(palabraOculta);
			iniciaPartida();
		}
	
	}
	private void formateaPalabra(String palabra) {
	this.palabraFormateada=palabra.replaceAll("[A-Z]", "_ ").trim();
	}
	private void procesaLetra(char letra) {
		boolean correcto=false;
		auxLetra=letra;
		//Mi palabra formateada tiene espacios de por medio luego no puedo simplemente remplazar los espacios por nada,
		//pueden haber multiples palabras con un espacio entre ellos
		// En esencia como ejemplo hace lo siguiente:
		//LA LUZ(tamaño 6) formeteada _ _  _ _ _(tamaño 10)
		//Reemplazamos todos los espacios por x -> _x_xx_x_x_
		//ahora reemplazamos la expresion xx por 1 espacio -> _x_x _x_x_
		//ahora sustituimos la x por "" para que se iguale el tamaño a la palabra oculta
		//__ ___ este seria el resultado, se nos quedaria tamaño 6
		
	//String pruebas=palabraFormateada.replaceAll(" ", "x").replaceAll("xx", " ").replaceAll("x", "");
		String nuevaCadena=palabraFormateada.replaceAll(" ", "x").replaceAll("xx", " ").replaceAll("x", "");
		String nuevoFormateo="";
		if(palabraOculta.contains(""+letra)) {
			correcto=true;
		
			
		
		for(int i =0; i < palabraOculta.length();i++) {
			if(palabraOculta.charAt(i)==letra) {
				nuevoFormateo=nuevoFormateo+letra+" ";
			}else if(Character.isAlphabetic(palabraOculta.charAt(i))) {
				nuevoFormateo=nuevoFormateo+nuevaCadena.charAt(i)+" ";
			}else {
		
				nuevoFormateo=nuevoFormateo+"  ";
			}
		}
		this.palabraFormateada=nuevoFormateo;
		partidaModel.setPalabraOculta(nuevoFormateo);
		
		}
		puntuacion(correcto);
	
	}
	private void nuevaPalabra(String palabra) {
		
		
		if(palabraOculta.equals(palabra.toUpperCase())) {
			nuevaPalabra(rootController.generaPalabraOculta().toUpperCase());
		}else {
		palabraOculta=palabra;
		formateaPalabra(palabra);
		partidaModel.setPalabraOculta(palabraFormateada);
		partidaModel.setLetrasIntroducidas("");
		}
	}
	private void puntuacion(boolean correcto) {
		
		if(palabraOculta.equals(palabraFormateada.replaceAll(" ", "x").replaceAll("xx", " ").replaceAll("x", ""))) {
			partidaModel.setPuntos(partidaModel.getPuntos()+1);
		nuevaPalabra(rootController.generaPalabraOculta().toUpperCase());
		}
	else if(correcto) {
			partidaModel.setLetrasIntroducidas(partidaModel.getLetrasIntroducidas()+" "+auxLetra);
			partidaModel.setPuntos(partidaModel.getPuntos()+1);
		}
	else {
    	if(partidaModel.getVidas()>1){
    	partidaModel.setLetrasIntroducidas(partidaModel.getLetrasIntroducidas()+" "+auxLetra);
    	partidaModel.setVidas(partidaModel.getVidas()-1);
    	}else {
    		partidaModel.setVidas(partidaModel.getVidas()-1);
    		guardarPuntuacion();

    	}
	}
		
	}
	private void guardarPuntuacion() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Fin del juego");
		dialog.setHeaderText("Se te han terminado las vidas :'(");
		dialog.setContentText("Si quieres guardar tu puntuación, introduce tu nombre.");
		Optional<String> result = dialog.showAndWait();
		if(result.isPresent()) {
			Date fecha = new Date();
		
	        SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
	        String fechaParse= formateo.format(fecha);
			partidaModel.getPuntuacionesJugadoresPartida()
			.add(new Jugador
					(result.get(),
							partidaModel.getPuntos(),
							fechaParse));
			
			
		}
		rootController.cargarNuevoJuego();
	}

	private void iniciaPartida() {
		partidaModel.setPalabraOculta(palabraFormateada);
		partidaModel.setLetrasIntroducidas("");
		partidaModel.setVidas(VIDAS);
		partidaModel.setPuntos(0);
		Image imageInicio=new Image("/images/1.png");
		partidaModel.setImagen(imageInicio);
		
	}
	public BorderPane getView() {
		return partidaView;
	}
	

}
