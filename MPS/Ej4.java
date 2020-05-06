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
    - (5) Programas Hijos
    - El padre se encarga de:
        + Recoger el nombre del archivo y extension donde se van a mostrar los resultados
        + Mostrar el contenido de los archivos
        + Suma los subtotales de cada fichero y lo muestra por pantalla
    - Los hijos se encargan de:
        + Contar una vocal en concreto
        + Guardar el resultado en un fichero
----------------------------------------------
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class Ej4{
    public static void main(String[] args) {
        Scanner oTeclado = new Scanner(System.in);

        //Pedimos el nombre del archivo donde se van a mostrar los resultados
        System.out.println("Digame el nombre del archivo y su extension");
        String fichero = oTeclado.nextLine();

        //Creamos el fichero
        File fRes = new File(fichero);
        try{
            if(!fRes.exists())
                fRes.createNewFile();
        }catch(IOException io){
            System.out.println(io);
        }//try-catch

        //Hacemos los calculos en este metodo
        mvLanzadorSumaTotal(fichero);
        //Leemos y guardamos el resultado en el fichero
        mvGuardarResultadoFinal(fichero);
        try{
            //Mostramos por pantalla el resultado del fichero introducido por el usuario
            System.out.println(""+getLineasFichero(fichero));
        }catch(Exception e){
            System.out.println(e);
        }//try-catch

        oTeclado.close();
    }//main()

    private static void mvLanzadorSumaTotal(String isFichero){
        String[] vocales = {"A","E","I","O","U"};
        String sFichero = "frase.txt";

        //Contamos cada vocal del fichero
        for(int i=0; i<vocales.length;i++){
            try{
                //Creamos los ficheros de las vocales
                String sNombreFVoc = "f"+vocales[i].toString()+".txt";
                File file = new File(sNombreFVoc);
                if (!file.exists())
                  file.createNewFile();

                //String linea = "";
                //Inicializamos cada proceso y guardamos el resultado en su respectivo fichero
                //Le pasamos el fichero a leer a cada proceso
                ProcessBuilder pb = new ProcessBuilder("java","Vocal"+vocales[i].toString(),sFichero);
                pb.redirectErrorStream(true);
                /*Process p = pb.start();
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while((linea=input.readLine())!=null)
                    System.out.println(linea);
                */
                pb.redirectOutput(file);
                pb.start();
            }catch(Exception e){
                System.out.println(e);
            }//try-catch
        }//for()


    }//mvLanzadorSumaTotal()

    //Metodo para leer el resultado del fichero
    public static ArrayList<String> getLineasFichero(String isFichero) throws IOException{
        ArrayList<String> lineas = new ArrayList<String>();
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
            System.out.println(io);
        }//try-catch
        return lineas;
    }//getLineasFichero()

    static void mvGuardarResultadoFinal(String isFichero){
        //Recopilamos los resultados, los sumamos y los guardamos en el fichero introducido por el usuario
        int[] iNumVocales = new int[4];
        String[] vocales = {"A","E","I","O","U"};
        for(int i=0; i<iNumVocales.length;i++){
            try{
                //Leemos el contenido del fichero
                File file = new File("f"+vocales[i].toString()+".txt");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                //Al haber solo un numero, no hace falta ningun while
                String sNumero = br.readLine();
                while(sNumero!=null)
                    sNumero = br.readLine();
                System.out.println(sNumero);

                //Convertimos el numero a integer y lo guardamos en el array
                iNumVocales[i] = Integer.parseInt(sNumero);

                //Cerramos los ficheros
                br.close();
                fr.close();
            }catch(IOException io){
                System.out.println(io);
            }//try-catch
        }//for()

        //Una vez recopilados los numeros, los sumamos y los mostramos
        int iNumFinal = 0;
        for(int i=0; i<iNumVocales.length;i++)
            iNumFinal += iNumVocales[i];

        //Guardamos el resultado en un fichero
        try{
            File f = new File(isFichero);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(iNumFinal);
            bw.close();
            fw.close();
        }catch(IOException io){
            System.out.println(io);
        }//try-catch
    }//Loquesea()
}//Ej4
