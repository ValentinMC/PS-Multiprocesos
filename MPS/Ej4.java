/*
 4. Crear un programa que sea capaz de contar cuantas vocales hay en un fichero.
 El programa padre debe lanzar cinco procesos hijo, donde cada uno de ellos se
 ocupará de contar una vocal concreta (que puede ser minúscula o mayúscula).
 Cada subproceso que cuenta vocales deberá dejar el resultado en un fichero.
 Al programa padre se le pasará por parámetro el nombre del archivo
 (incluida la extensión), además se ocupará de recuperar los resultados de
 los ficheros, sumar todos los subtotales y mostrar el resultado final en pantalla.
*/
/*
------------------ POR PARTES ---------------
    - Programa Padre
    - Programa Hijo
    - El padre se encarga de:
        + Recoger el nombre del archivo y extension donde se va a mostrar el resultado
        + Mostrar el contenido de los archivos
        + Suma los subtotales de cada fichero y lo muestra por pantalla
    - Los hijos se encargan de:
        + Contar una vocal en concreto
        + Guardar el resultado en un fichero
----------------------------------------------
*/
package MPS;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class Ej4{
    static String[] vocales = {"A","E","I","O","U"};
    static File[] ficherosVocales = new File[5];
    static Scanner oTeclado = new Scanner(System.in);

    public static void main(String[] args) {

        //Creamos los ficheros de las vocales
        mvCrearFicherosVocales();

        //Pedimos el nombre del archivo donde se van a mostrar los resultados
        System.out.println("Digame el nombre del archivo y su extension");
        String fichero = oTeclado.nextLine();

        //Creamos el fichero
        new File(fichero);

        //Llamamos al lanzador para guardar la suma de cada vocal en su fichero
        mvLanzadorSumaParcial();
        //Leemos los ficheros y guardamos el resultado final en el fichero dado por el usuario
        mvGuardarResultadoFinal(fichero);

        try{
            //Mostramos por pantalla el resultado del fichero introducido por el usuario
            System.out.println("EL numero de vocales totales son: "+getLineasFichero(fichero));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }//try-catch

        oTeclado.close();
    }//main()
    private static void mvCrearFicherosVocales(){
        int iContador = 0;
        for (String vocal : vocales) {
            String sNombreFVoc = "f_" + vocal + ".txt";
            File file = new File(sNombreFVoc);
            ficherosVocales[iContador]=file;
            iContador++;
        }//for
    }//mvCrearFicherosVocales

    private static void mvLanzadorSumaParcial(){
        //Este es el fichero donde esta guardada la frase a leer
        String sFichero = "frase.txt";
        int iContador = 0;
        //Contamos cada vocal del fichero
        for (String vocal : vocales) {
            //Creamos los ficheros de las vocales
            try {
                //Inicializamos cada proceso y guardamos el resultado en su respectivo fichero
                //Le pasamos el fichero a leer a cada proceso y la vocal que vamos a contar
                ProcessBuilder pb = new ProcessBuilder("java", "ContVocales", sFichero, vocal);
                pb.redirectErrorStream(true);
                pb.redirectOutput(ficherosVocales[iContador]);
                pb.start();
                iContador++;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }//try-catch
        }//for()
    }//mvLanzadorSumaTotal()

    //Metodo para leer el resultado del fichero
    private static ArrayList<String> getLineasFichero(String isFichero) throws IOException{
        ArrayList<String> lineas = new ArrayList<>();
        FileReader fr = new FileReader(isFichero);
        BufferedReader br =  new BufferedReader(fr);
        //Leemos las lineas del fichero
        try{
            String linea = br.readLine();
            while(linea!=null){
                //Aniadimos las lineas al array
                lineas.add(linea);
                linea = br.readLine();
            }//while()
            fr.close();
            br.close();
        }catch(IOException io){
            System.out.println(io.getMessage());
        }//try-catch
        return lineas;
    }//getLineasFichero()

    private static void mvGuardarResultadoFinal(String isFichero){
        //Recopilamos los resultados, los sumamos y los guardamos en el fichero introducido por el usuario
        int iNumeroTotalVocales = 0;
        for (File fichero : ficherosVocales) {
            int iNumeroVocLocal = 0;

            try {
                //Leemos el contenido del fichero
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);

                iNumeroVocLocal = Integer.parseInt(br.readLine());

                br.close();
                fr.close();
                System.out.println("El fichero " + fichero.toString() + " tiene: " + iNumeroVocLocal + " vocales");

                //Sumamos el numero de vocales totales
                iNumeroTotalVocales += iNumeroVocLocal;
            } catch (Exception io) {
                System.out.println(io.getMessage());
            }//try-catch
        }//for()

        //Guardamos el resultado en un fichero
        try{
            File f = new File(isFichero);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(iNumeroTotalVocales));
            System.out.println("Numero guardado!");
            bw.close();
            fw.close();
        }catch(IOException io){
            System.out.println(io.getMessage());
        }//try-catch
    }//mvGuardarResultadoFinal()
}//Ej4
