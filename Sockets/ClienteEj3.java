/*
3. Crear un programa servidor que espere 
un datagrama de un cliente. El cliente 
le proporciona una frase y el servidor 
le indicará la longitud de ésta y cuántas 
palabras forman la frase.
*/
package Sockets;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
public class ClienteEj3 {
    public static void main(String[] args) {
        /*UDP*/
        //puerto del servidor
        final int PUERTO_SERVIDOR = 12121;
        //buffer donde se almacenara los mensajes
        byte[] buffer = new byte[1024];

        try {
            //Obtengo la localizacion de localhost
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            //Creo el socket de UDP
            DatagramSocket socketUDP = new DatagramSocket();

            //Pregunto la frase al Cliente
            Scanner oTeclado = new Scanner(System.in);
            System.out.println("Que frase quieres analizar");
            String mensaje =oTeclado.nextLine();

            //Convierto el mensaje a bytes
            buffer = mensaje.getBytes();

            //Creo un datagrama
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

            //Lo envio con send
            System.out.println("Envio el datagrama");
            socketUDP.send(pregunta);
            buffer=new byte[1024];

            //Preparo la respuesta
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            //Recibo la respuesta
            socketUDP.receive(peticion);
            System.out.println("Recibo la peticion");

            //Cojo los datos y lo muestro
            mensaje = new String(peticion.getData());
            System.out.println(mensaje);

            //cierro el socket
            socketUDP.close();

            oTeclado.close();
        }catch (SocketException ex) {
            System.out.println(ex.getMessage());
        }catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }//try-catch

    }//main()
}//ClienteEj3