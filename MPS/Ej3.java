
/*
 3. Escribir una aplicación  que reciba por su entrada estándar una lista de números, 
 y averigüe la media y la moda de ese conjunto de números. Escriba dos versiones del 
 ejercicio, uno donde se imprima por pantalla el resultado y otro en un fichero se 
 guarden todos los resultados.  
*/
/*
        ------------------COMO HACERLO-------------
  - Guardamos los numeros en un Array de String (?) y luego los convertimos a int
  - Iniciamos un ProcessBuilder y le pasamos el array (?)
  - V.1 Imprimimos por pantalla // V.2 Guardamos en un fichero
  
*/
package MPS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
public class Ej3{
    static Scanner oTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> numeros;
        boolean bSeguir = true;
        //Creamos un Array para introducir los valores y un contador para las posiciones del Array.
        //Pedimos los valores
        while(bSeguir){
            System.out.println("Dime el un numero o introduzca FIN para completar la operacion.");
            //Metemos el valor en un avariable local
            String sNumero = oTeclado.nextLine();
            //Verificamos el valor que nos ha introducido el usuario
            if(sNumero.equals("FIN")){
                bSeguir = false;
                lanzarOperacion(numeros);
            }
            else
                numeros.add(sNumero); 
            //if-else
        }//while
        lanzarOperacion(numeros);
    }//main()
    
    static void lanzarOperacion(List alNumero){
        String sClase = "CConjunto";
        String linea;
        try{
            Process p = new ProcessBuilder("java",sClase,alNumero).start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((linea = br.readLine())!=null)
                System.out.println(linea);
        }catch(Exception e){
            System.out.println(e);
        }//try-catch
    }//lanzarOperacion()
}//Ej3