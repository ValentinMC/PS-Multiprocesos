/*
Crear un programa que simule el protocolo DNS, 
dado una dirección IP nos proporcione su url y
viceversa.
*/
package GeneracionServicios;
import java.net.InetAddress;
public class Ej1{
	public static void main(String [] args){
		/*
			Instanciamos la clase InetAddress que es la que tiene los metodos
			adecuados para poder devolvernos la ip del host que introduzcamos por
			consola
		*/
		try{
			InetAddress ip=InetAddress.getByName(args[0].toString());
			System.out.println("Nombre Host: "+ip.getHostName());
			System.out.println("IP: "+ip.getHostAddress());
		}catch(Exception e){
			System.out.println(e);
		}//try-catch
	}//main()
}//DictadorDeIP