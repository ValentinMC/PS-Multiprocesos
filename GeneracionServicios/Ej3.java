package GeneracionServicios;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
/*
 Crear un programa Java que identifique si la dirección IP 
 es unicast, multicast y el tipo de alcance de la dirección.
*/
/*
    Utilizar este link
    https://www.baeldung.com/java-broadcast-multicast
*/
public class Ej3 {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        Scanner oTeclado = new Scanner(System.in);
        
        //Pedimos una IP
        System.out.println("Digame la IP que quiera identificar");
        String sIP = oTeclado.nextLine();

        //Miramos a ver si es multicast o unicast
        InetAddress IP = InetAddress.getByName(sIP);
        if(IP.isMulticastAddress())
            System.out.println("Tu IP es multicast!");
        else if(IP.isLoopbackAddress())
            System.out.println("Tu IP es unicast!");
        else
            System.out.println("No hemos conseguido identificar tu IP");

        //Comprobamos el tipo de enlace de la direccion

        oTeclado.close();
    }//main()
}//Ej3