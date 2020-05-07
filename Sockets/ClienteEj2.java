package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
2. Crear un programa que simule un conversor 
de gramos a libras. El cliente le proporciona 
una serie de valores y el servidor le envía el 
valor correspondiente en libras. Ambos valores 
se irán guardando en un archivo de texto.
*/

public class ClienteEj2 {
    public static void main(String[] args) {
        //Instanciamos las clases necesarias para el cliente
        Scanner oTeclado = new Scanner(System.in);
        final String HOST = "127.0.0.1";
        final int iPuerto = 12344;
        DataInputStream dis;
        DataOutputStream dos;

        double dGramos;
        //Enviamos el mensaje al servidor
        try{
            Socket sc = new Socket(HOST,iPuerto);
            dis = new DataInputStream(sc.getInputStream());
            dos = new DataOutputStream(sc.getOutputStream());
            
            //Pedimos los gramos al usuario
            System.out.println("Digame cuantos gramos quiere convertir a libras");
            dGramos = oTeclado.nextDouble();oTeclado.nextLine();
            
            //Le pasamos el valor al servidor
            dos.writeDouble(dGramos);

            //Leemos la respuesta del servidor
            System.out.println(dis.readUTF());
            //Cerramos el socket
            sc.close();
        }catch(IOException ioe){
            System.out.println(ioe);
        }//try-catch


        oTeclado.close();
    }//main()
}//ClienteEj2