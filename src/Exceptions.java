import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Excepcion es un posible error en Java.
 * @author Dell5458
 *
 */
public class Exceptions {
	public static void main(String[] args) {
		try {
			metodo1();
		} catch (FileNotFoundException | LecturaArchivoException e) {  //Java 7 y antes: catch dividido, ahora en el mismo catch
			System.err.println("Ocurrio un error, intenta nuevamente: ");  //try... catch por que el throws del metodo nos va a enviar el error y datos del programa, por seguridad aqui manejamos la excepcion con un mensaje, solo mostrará que hubo error
		} finally {
			System.out.println("Cerrando sesion en el sistema");
		}
		
	}
	
	public static void metodo1() throws FileNotFoundException, LecturaArchivoException{
		//Excepciones: Checked (compilacion) and Unchecked (Ejecucion)
		//Unchecked
		try{
		int division = 5/0;
		} catch(ArithmeticException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Continua programa...");
		
		//Checked, estoy obligado a atrapar la excepcion
		File archivo = new File("C:/temp/archivo.txt");
		//try ... catch, cuando  manejo el error y no afecta la operacion del sistema, el programa puede continuar
		//throws, lanza el error a quien mandó a llamarte (main), el programa no puede continuar
		FileReader reader = new FileReader(archivo);
		
		BufferedReader buffer = new BufferedReader(reader);
		//Creamos nuestra excepcion, para no usar otro throws
		try {
		String linea = buffer.readLine();
		} catch(IOException e){
			throw new LecturaArchivoException(e.getMessage());  //Ya creada la excepcion la mandamos al throws y al invocar al metodo
		}
	}

}
