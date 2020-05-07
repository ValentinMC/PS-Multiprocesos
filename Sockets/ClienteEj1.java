/*
Crear un programa que simule la conversación entre 
un cliente y un servidor. El servidor recibe líneas
de texto de un cliente y envía las líneas sin vocales.
*/
/*TCP*/
package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEj1 {

  public static void main(String[] args) {

    //Teclado
    Scanner oTeclado = new Scanner(System.in);
    //Host del servidor
    final String HOST = "127.0.0.1";
    //Puerto del servidor
    final int PUERTO = 12345;
    DataInputStream in;
    DataOutputStream out;

    try {
        //Creo el socket para conectarme con el cliente
        Socket sc = new Socket(HOST, PUERTO);

        in = new DataInputStream(sc.getInputStream());
        out = new DataOutputStream(sc.getOutputStream());

        //Pedimos el mensaje a enviar
        System.out.println("Escriba un mensaje para el servidor");
        String sMensaje = oTeclado.nextLine();

        //Envio un mensaje al cliente
        out.writeUTF(sMensaje);

        //Recibo el mensaje del servidor
        String mensaje = in.readUTF();

        System.out.println(mensaje);

        sc.close();

    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }//try-catch

    oTeclado.close();
  }//main()
}//Cliente
