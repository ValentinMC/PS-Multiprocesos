package Sockets;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
public class ServidorEj2 {
    
    public static void main(String[] args) {
        ServerSocket servidor;
        Socket sc;
        DataInputStream dis;
        DataOutputStream dos;
        final int iPuerto = 12344;

        //Declaramos las variables de fichero para poder guardar los resultados
        File f;
        FileWriter fw;
        BufferedWriter bw;


        double dGramos;
        double dLibras;
        try{
            servidor = new ServerSocket(iPuerto);
            System.out.println("¡Servidor iniciado!");

            //El servidor esta escuchando siempre
            while(true){
                sc = servidor.accept();
                dis = new DataInputStream(sc.getInputStream());
                dos = new DataOutputStream(sc.getOutputStream());

                //Leemos los gramos del cliente
                dGramos = dis.readDouble();

                //Los convertimos a libras con un metodo
                dLibras = mdConversor(dGramos);
                System.out.println(dGramos+" gramos son "+dLibras+" libras.");

                //Guardamos los resultados en un fichero
                f = new File("conversion.txt");
                fw = new FileWriter(f,true);
                bw = new BufferedWriter(fw);

                String sConversion = (dGramos+"gr -> "+dLibras+"lb");
                bw.write(sConversion+"\n");

                //Cerramos los ficheros
                bw.close();
                fw.close();

                //Enviamos un mensaje al cliente diciendo que se ha guardado con exito
                dos.writeUTF("Puede comprobrar la conversion en el fichero: conversion.txt");

                //Cierro el socket del cliente
                System.out.println("Cliente desconectado");
                sc.close();

            }//while()

        }catch(IOException ioe){
            System.out.println(ioe);
        }//try-catch
    }//main()

    static double mdConversor(double idGramos){
        double odLibras = idGramos/453.592;
        return odLibras; 
    }//mdConversor
}//ServidorEj2