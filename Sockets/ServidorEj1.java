/*TCP*/

package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEj1 {

  public static void main(String[] args) {

    ServerSocket servidor = null;
    Socket sc = null;
    DataInputStream in;
    DataOutputStream out;

    //puerto de nuestro servidor
    final int PUERTO = 12345;

    try {
        //Creamos el socket del servidor
        servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado");

        //Siempre estara escuchando peticiones
        while (true) {
            //Espero a que un cliente se conecte
            sc = servidor.accept();

            System.out.println("Cliente conectado");
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            //Leo el mensaje que me envia
            String mensaje = in.readUTF();
            System.out.println("Mensaje del cliente: "+mensaje);

            //Quitamos las vocales al mensaje
            String sNuevoMensaje ="";
            for(int i = 0; i<mensaje.length();i++)
                if(mensaje.charAt(i)!='a'&&mensaje.charAt(i)!='e'&&mensaje.charAt(i)!='i'&&mensaje.charAt(i)!='o'&&mensaje.charAt(i)!='u')
                    sNuevoMensaje+=mensaje.charAt(i);

            System.out.println("Mensaje nuevo a enviar: "+sNuevoMensaje);

            //Le envio un mensaje
            System.out.println("Enviando mensaje...");
            out.writeUTF(sNuevoMensaje);

            //Cierro el socket
            sc.close();
            System.out.println("Cliente desconectado\n\n");
        }//while
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }//try-catch
  }//main()
}//Servidor