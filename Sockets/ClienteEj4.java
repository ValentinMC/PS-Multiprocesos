package Sockets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/*
4. Crear un programa servidor que espere un datagrama de un cliente. El cliente le envía un objeto
Mochila. La mochila irá cargada con una serie de objetos y el servidor rellenará el peso de cada
objeto. El servidor tiene guardado en un archivo una relación de objetos con sus pesos
correspondientes. La mochila también guarda el nombre del dueño de está.
    Por ejemplo:
    Cliente:                Servidor:
    Avelina                 Avelina
    Libro de física         Libro de física 800 g
    Estuche                 Estuche 200 g
    Botella de agua         Botella de agua 500 g

    Cuando el cliente reciba la mochila, mostrará por pantalla el peso total de ésta
*/
/*
    **** POR PASOS ****
    - Preguntamos al usuario el nombre de la mochila.
    - Preguntamos los objetos.
        +PROBLEMA+
        El usuario debe meter el nombre de un objeto
        y este debe coincidir con un objeto que tiene
        el servidor en un fichero. Si no coincide,
        ¿qué pasa?

        +SOLUCION+
        Al usuario le damos a elegir entre un conjunto
        de nombres ya existentes.
    -Creamos un ArrayList de CObjetos.
    -Instanciamos cada uno de los objetos del usuario.
    -Añadimos los objetos al ArrayList.
    -Instanciamos un objeto de la clase CMochila.
    -Pasamos al servidor el objeto mediante el ObjectOutputStream.
    -Calculamos el peso total en el cliente y lo mostramos por pantalla
*/
public class ClienteEj4 {
    static Scanner oTeclado = new Scanner(System.in);

    /*  Este es el Array con los nombres que se
        va a mostrar al usuario. Estamos suponiendo
        que el numero de objetos existentes es fijo.

        Ademas es publico para que lo pueda utilizar
        la clase servidor para crear un fichero de objetos
        a partir de los que hay en este Array

    */
    public static String[] asNombreObjetos = {"Libro de fisica","Estuche","Botella de agua","Cuaderno","Agenda","Portatil"};

    //Este es el ArrayList donde se van a guardar los objetos de la clase CObjeto
    static ArrayList<CObjeto> alObjeto = new ArrayList<>();

    //Variables para Socket
    static final String HOST = "127.0.0.1";
    static final int iPuerto = 12388;
    public static void main(String[] args) {
        try{
            //Nos intentamos conectar al servidor
            Socket sc = new Socket(HOST,iPuerto);

            //Preguntamos el nombre de la mochila
            System.out.println("Cual es el nombre de la mochila?");
            String sNombreMochila = oTeclado.nextLine();

            //Preguntamos que objetos quiere meter
            for(String ob : asNombreObjetos){
                System.out.println("Quieres meter un/a "+ob+" en la mochila?(SI/NO)");
                String sRespuesta = oTeclado.nextLine();
                if(sRespuesta.equalsIgnoreCase("SI"))
                    alObjeto.add(new CObjeto(ob));
            }//for

            //Instanciamos el objeto oMochila
            CMochila oMochila = new CMochila(sNombreMochila,alObjeto);

            //Enviamos el objeto al servidor
            ObjectOutputStream oos = new ObjectOutputStream(sc.getOutputStream());
            oos.writeObject(oMochila);


            //Recibimos el objeto modificado del servidor
            ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());

            //Sobreescribimos la informacion que teniamos en este objeto guardada con la nueva
            oMochila = (CMochila) ois.readObject();
            //Imprimimos la informacion
            System.out.println(oMochila.toString()+"\n\n"+oMochila.msCalcularPesoTotal());

            oos.close();
            ois.close();
            sc.close();
        }catch(IOException | ClassNotFoundException ioe){
            System.out.println(ioe);
        }//try-catch
    }//main
}//ClienteEj4


