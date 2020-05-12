package MPS;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContVocales {
    public static void main(String[] args){
        //Leemos el fichero y la vocal
        File f = new File(args[0]);
        String sVocal = args[1];
        StringBuilder sFrase= new StringBuilder();

        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try{
                //leemos las frases del fichero
                String sAux = br.readLine();
                while(sAux!=null){
                    sFrase.append(sAux);
                    sAux = br.readLine();
                }//while()
            }catch(EOFException eof){
                System.out.println("FIN DE FICHERO");
            }//try-catch EOF
            br.close();
            fr.close();
        }catch(IOException io){
            System.out.println(io.getMessage());
        }//try-catch

        //Contamos las vocales y las sacamos por pantalla para que se guarde el valor en el fichero
        System.out.println(""+mvContador(sFrase.toString(), sVocal));
    }//main()

    public static int mvContador(String lineas,String sVocal){
        int iContador = 0;
        if(lineas!=null){
            //Lo convertimos todo en Array de char
            char [] c = lineas.toCharArray();
            char [] VocalMinuscula = sVocal.toLowerCase().toCharArray();
            char [] VocalMayuscula = sVocal.toUpperCase().toCharArray();
            for (char letra : c)
                if (letra == VocalMinuscula[0] || letra == VocalMayuscula[0])
                    iContador++;

            return iContador;
        }else
            return 0;
        // if-else
    }//mvContador()
}//ContVocales