package Seguridad;
import java.util.Scanner;
public class Ej1 {
    //Utilizare el metodo CESAR para este ejercicio

	static Scanner oTeclado = new Scanner(System.in);
	public static void main (String ars[]){ 
        //Valores para el mensaje, mensaje encriptado, mensaje desencriptado y valor de desplazamiento
        String sMensajeC = "";
        String sMensajeE = "";
        String sMensajeD = "";
        int iDesplazamiento = 0;
        
        
        //Pedimos el mensaje y el desplazamiento al usuario
		System.out.println("Dime una frase para cifrar");
        sMensajeC = oTeclado.nextLine();
		System.out.println("Dime un desplazamiento");
        iDesplazamiento = oTeclado.nextInt();
            
		//Char Array para el mensaje cifrado
        char caCifrado[] =  sMensajeC.toCharArray();

        //Char Array del mensaje descifrado
        char caDescifrado[];
        
		try{
            //Ciframos el mensaje
			for(int i = 0; i < caCifrado.length; i++){
				caCifrado[i] = (char)(caCifrado[i]+iDesplazamiento);
            }//for 

            //Lo mostramos
			sMensajeE = String.valueOf(caCifrado);
			System.out.println("El mensajo encriptado es: " +sMensajeE);

            //Lo desencriptamos
			caDescifrado = sMensajeE.toCharArray();
			for(int i = 0; i < caDescifrado.length; i++){
				caDescifrado[i] = (char)(caDescifrado[i]-iDesplazamiento);
            }//for

            //Lo mostramos
			sMensajeD = String.valueOf(caDescifrado);
			System.out.println("El mensaje desencriptado es: "+sMensajeD);

		}catch(Exception e){
            System.out.println(e);
        }//try-catch
	}//main()
}//Ej1