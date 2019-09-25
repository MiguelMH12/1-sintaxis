import java.io.IOException;

public class LecturaArchivoException extends IOException {  //Hereda de IOException sabemos que es de lectura de archivo
	//Constructor no se hereda
	public LecturaArchivoException(String mensaje) {
		super(mensaje); //Invoca al constructor de la clase padre
		//Notificar acerca de este error
	}
}
