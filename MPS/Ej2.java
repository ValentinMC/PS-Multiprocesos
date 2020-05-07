
/*
Escribir un programa que solicite al usuario cadenas, de manera que según se introduce 
una cadena se invierte el orden de sus letras. Tras producirse el cambio este se  guardará en un fichero de texto. 
Por ejemplo: 'hola mundo' ---> 'odnum aloh' 
*/
package MPS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Ej2{
    public static void main(String[] args) {
        Scanner oTeclado = new Scanner(System.in);
        boolean bSeguir=true;
        //Pedimos las cadenas al usuario
        while(bSeguir){
            System.out.println("Introduzca una cadena a convertir o escriba FIN para finalizar el programa");
            String sCadena = oTeclado.nextLine();
            if(sCadena.equalsIgnoreCase("FIN"))
                bSeguir = false;
            else
                mvCambiarOrden(sCadena);
        }//while()

        oTeclado.close();
    }//main()

    static void mvCambiarOrden(String isCadena){
        String sClase = "Cambio";
        ProcessBuilder pb;
        String linea;
        try{
            pb = new ProcessBuilder("java",sClase,isCadena);
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((linea = br.readLine())!=null)
                System.out.println(linea);
        }catch(Exception e){
            System.out.println(e);
        }//try-catch
    }//mvCambiarOrden()
}//Ej2