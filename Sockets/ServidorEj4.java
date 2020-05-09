package Sockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ServidorEj4 {

    //Creamos el puerto del servidor
    static final int iPuerto = 12388;

    //Creamos un objeto de la clase CMochila para leer el objeto del cliente
    static CMochila ioMochila;

    //Declaramos el fichero con el que vamos a trabajar
    static File f = new File("objetos.bin");


    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        //Creamos un fichero binario con los nombres y objetos si no existe ya
        if(!f.exists()){
            try{
                FileOutputStream fos = new FileOutputStream(f);
                DataOutputStream dos = new DataOutputStream(fos);

                for(String sNombre : ClienteEj4.asNombreObjetos){
                    //Los gramos seran aleatorios entre 1 y 1000
                    dos.writeUTF(sNombre);
                    dos.writeInt((int)(1000 * Math.random()));
                }//for

                dos.close();
                fos.close();
                    
            }catch(FileNotFoundException fnf){
                System.out.println(fnf);
            }catch(IOException io){
                System.out.println(io);
            }//try-cacth
        }//if(fichero existe)

        //Nos comunicamos con el cliente
        try{
            //Recibimos la mochila del cliente
            ServerSocket ss = new ServerSocket(iPuerto);
            System.out.println("SERVIDOR INICIADO");

            //Nos mantenemos escuchando
            while(true){

                //Recibimos al cliente
                Socket s = ss.accept();
                if(s.isConnected())
                    System.out.println("Cliente conectado!");
                
                InputStream is = s.getInputStream();
                ObjectInputStream ios = new ObjectInputStream(is);

                ioMochila = (CMochila) ios.readObject();
                System.out.println("Mochila de "+ioMochila.getsNombre()+" detectada!\n");
                ios.close();
                is.close();

                //Metemos los objetos en un ArrayList
                ArrayList<CObjeto> alObjeto = ioMochila.getaListaObjetos();

                //Comparamos los objetos con los del fichero y les añadimos un peso
                System.out.println("Aniadiendo pesos...\n");
                try{
                    FileInputStream fis = new FileInputStream(f);
                    DataInputStream dis = new DataInputStream(fis);
                    try{
                        for(CObjeto ob: alObjeto){
                            String sNombreObjetoFichero = dis.readUTF();
                            int iPesoObjetoFichero = dis.readInt();
                            boolean bEncontrado=false;
                            while(!bEncontrado)
                                if(ob.getsNombreOb().equals(sNombreObjetoFichero)){
                                    ioMochila.setPesoObjetos(ob, iPesoObjetoFichero);
                                    bEncontrado = true;
                                }else{
                                    sNombreObjetoFichero = dis.readUTF();
                                    iPesoObjetoFichero = dis.readInt();
                                    bEncontrado = false;
                                }//if-else
                        }//for()
                    }catch(EOFException eof){
                        System.out.println("Fin de fichero!");
                    }//try-catch
                    fis.close();
                    dis.close();
                }catch(IOException io){
                    System.out.println(io);
                }//try-catch lectura fichero

                //Volvemos a enviar el objeto (ahora modificado) al usuario
                OutputStream os = s.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);
                System.out.println("Mochila devuelta!");
                oos.writeObject(ioMochila);

                //Cerramos todo excepto el servidor
                oos.close();
                os.close();
                s.close();
            }//while(escucha)
        }catch(IOException io){
            System.out.println(io);
        }catch(ClassNotFoundException cnf){
            System.out.println(cnf);
        }//try-cacth
    }//main()
}//ServidorEj4