package Sockets;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/*
    Este servidor se encargara de recoger un
    datagrama del cliente y comprobar la
    longitud de esta y el numero de palabras
    que la contiene.
*/

public class ServidorEj3 {
    public static void main(String[] args) {

        final int PUERTO = 12121;
        byte[] buffer = new byte[1024];

        try {
            System.out.println("Iniciado el servidor UDP");
            //Creacion del socket
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);

            //Siempre atendera peticiones
            while (true) {

                //Preparo la respuesta
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                //Recibo el datagrama
                socketUDP.receive(peticion);
                System.out.println("Recibo la informacion del cliente");

                //Convierto lo recibido y mostrar el mensaje
                String mensaje = new String(peticion.getData());
                System.out.println(mensaje);

                //Obtengo el puerto y la direccion de origen
                //Sino se quiere responder, no es necesario
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();
                /*
                    Aqui hacemos la lectura del mensaje y vemos
                    su longitud, las palabras y si empieza por
                    consonante o vocal.
                */
                mensaje = "Longitud:"+peticion.getLength()+msPalabras(mensaje);

                buffer = mensaje.getBytes();

                //creo el datagrama
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

                //Envio la información
                System.out.println("Envio la informacion del cliente");
                socketUDP.send(respuesta);
                
            } // while
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }//try-catch
    }//main()

    //Calculamos la longitud del mensaje
    public static String msLongitud(String iMensaje){
        int iLongitud=0;
        iLongitud = iMensaje.length();
        return "La longitud del mensaje es: "+iLongitud;
    }//msLongitud()

    //Contamos las palabras que contiene
    public static String msPalabras(String iMensaje){
        int iPalabras=iMensaje.split(" ").length;
        return " y "+iPalabras+" palabras.";
    }//msPalabras()
}//ServidorEj3