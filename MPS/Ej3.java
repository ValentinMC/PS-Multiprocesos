
/*
 3. Escribir una aplicación  que reciba por su entrada estándar una lista de números, 
 y averigüe la media y la moda de ese conjunto de números. Escriba dos versiones del 
 ejercicio, uno donde se imprima por pantalla el resultado y otro en un fichero se 
 guarden todos los resultados.  
*/
package MPS;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Ej3{
    static Scanner oTeclado = new Scanner(System.in);

    public static void main(String[] args) {

        //Creamos un ArrayList para introducir los comandos y valores
        ArrayList<String> alComandos = new ArrayList<>();
        //Primero añadimos los parametros iniciales
        alComandos.add("java");
        alComandos.add("CConjunto");

        boolean bSeguir = true;
        //Pedimos los valores
        while(bSeguir){
            System.out.println("Dime el un numero o introduzca FIN para completar la operacion.");
            //Metemos el valor en un avariable local
            String sNumero = oTeclado.nextLine();
            //Verificamos el valor que nos ha introducido el usuario
            if(sNumero.equalsIgnoreCase("FIN")){
                bSeguir = false;
                lanzarOperacionV1(alComandos);
                lanzarOperacionV2(alComandos);
            }else
                alComandos.add(sNumero); 
            //if-else
        }//while
        
    }//main()
    
    static void lanzarOperacionV1(ArrayList<String> alNumeros){
        //Aqui solo nos hara falta el arrayList
        String linea;
        try{
            Process p = new ProcessBuilder(alNumeros).start();

            //Imprimimos el resultado por pantalla
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((linea=br.readLine())!=null)         
                System.out.println(linea);

        }catch(Exception e){
            System.out.println(e);
        }//try-catch
    }//lanzarOperacionV1()

    static void lanzarOperacionV2(ArrayList<String> alNumeros){
        File Fichero = new File("ResultadoEj3.txt");
        try{
            //Imprimimos el resultado en un fichero
            ProcessBuilder pb = new ProcessBuilder(alNumeros);
            pb.redirectErrorStream(true);
            pb.redirectOutput(Fichero);
            pb.start();
        }catch(Exception e){
            System.out.println(e);
        }//try-catch
    }//lanzarOperacionV2
}//Ej3