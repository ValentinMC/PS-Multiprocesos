/*
Crear un programa en Java que realice una firma digital de un fichero dado por parámetro
*/

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Scanner;

//import sun.misc.BASE64Encoder;

public class Ej3 {
    static Scanner oTeclado = new Scanner(System.in);
    static String sFichero;

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, SignatureException {

        if (args.length != 1) {
            System.err.println("Uso: java FirmaDigital \"texto a firmar\"");
            System.exit(1);
        }

        System.out.println("Generando un par RSA...");
        KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
        generador.initialize(1024);
        KeyPair parClaves = generador.genKeyPair();
        System.out.println("Generando el par de claves.");

        // Tomar los bytes de datos a firmar del primer argumento
        byte[] datos = args[0].getBytes("UTF8");

        // Obtener instancia del objeto Signature e inicializarlo con
        // la clave privada para firmarlo
        Signature firma = Signature.getInstance("MD5WithRSA");
        firma.initSign(parClaves.getPrivate());

        // Prepara la firma de los datos
        firma.update(datos);

        // Firmar los datos
        byte[] bytesFirma = firma.sign();

        // Mostrar en ASCII
        /*System.out.println("\nFirma:\n" +
            new BASE64Encoder().encode(bytesFirma));
        */
        // Ahora procedemos a verificar la firma. Para ello necesitaremos
        // reinicializar el objeto Signature con la clave pública.
        // Esto hace un reset de los datos de la firma con lo que hay que
        // pasárselos de nuevo para hacer el update.
        firma.initVerify(parClaves.getPublic());

        // Pasar los datos que fueron firmados
        firma.update(datos);
    
        // Verificar
        boolean verificado = false;
        try {
        verificado = firma.verify(bytesFirma);
        } catch (SignatureException se) {
        verificado = false;
        }

        if (verificado) {
        System.out.println("\nFirma verificada.");
        } else {
        System.out.println("\nFirma incorrecta.");
        }


    }//main()
}//Ej3
