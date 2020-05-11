/*
Escribir un programa que simule una calculadora. De forma que se realicen dos programas, 
uno que realice las operaciones como tal y el principal donde se recogen los datos y 
ejecute la operación correspondiente. 
*/
package MPS;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;
public class Ej1{
    public static void main(String[] args) {
        //Aqui se ejecuta el programa principal donde se piden los datos
        Scanner oTeclado = new Scanner(System.in);

        //Recogemos los valores como double y la operacion como char.
        System.out.println("Dime el primer numero:");
        double dN1 = oTeclado.nextDouble();oTeclado.nextLine();
        System.out.println("Dime el segundo numero:");
        double dN2 = oTeclado.nextDouble();oTeclado.nextLine();
        System.out.println("Dime la operacion: 'mas','menos','por'");
        String sOperacion = oTeclado.nextLine();

        oTeclado.close();
        //Lanzamos el segundo programa y le mandamos las variables como argumentos
        mvLanzarOperacion(dN1,dN2,sOperacion);
    }//main()

    static void mvLanzarOperacion(double idN1,double idN2,String isOperacion){
        String sClase = "COper";
        ProcessBuilder pb;
        String linea;
        try{
            //Ejecutamos el otro programa mediante un ProcessBuilder
            pb = new ProcessBuilder("java",sClase,String.valueOf(idN1),String.valueOf(idN2),isOperacion);
            pb.redirectErrorStream(true);
            Process p = pb.start();
            
            //Leemos el resultado del otro programa
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((linea=input.readLine())!=null)         
                System.out.println(linea);
        }catch(Exception e){
            System.out.println(e);
        }//try-catch
    }//mvLanzarOperacion()
}//Ej1