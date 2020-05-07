/*
Crear un programa en Java que utilice 5 hilos que representa 
el número de vocales totales. Para contar el número de vocales 
(se cuentan tanto las minúsculas como las mayúsculas) que hay 
en un determinado texto. Cada hilo se encargará de contar una 
vocal diferente, se imprimirá por pantalla el contador de cada
 vocal y el total de vocales.
*/
package Hilos;
import java.util.Scanner;
public class Ej2{
    public static void main(String[] args) {
        Scanner oTeclado = new Scanner(System.in);

        //Pedimos la frase al usuario por teclado
        System.out.println("Escriba una frase y contaremos sus vocales");
        String sFrase = oTeclado.nextLine();    
    
        //Instanciamos un contador comun para la suma de todas las vocales encontradas
        Contador oCont = new Contador();
    
        //Creamos 5 hilos, uno por cada vocal, en una calse comun.
        CHiloVocal ovHilos[] = new CHiloVocal[5];
    
        for(int i = 0; i<ovHilos.length;i++){
            //Creamos cuatro hilos que representaran cada vocal
            ovHilos[i] = new CHiloVocal(sFrase,oCont,i); 
            Thread th = new Thread(ovHilos[i]);
            th.setName("Hilo "+i);
            th.start();
        }//for 
        oTeclado.close();
    }//main()
}//Ej2