import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
public class VocalI{
    public static void main(String[] args) throws FileNotFoundException{
        File f = new File(args[0]);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea = null;
        //leemos las frases del fichero
        try{
            linea = br.readLine();
            while(linea!=null){
                linea = br.readLine();
            }//while()

            //Contamos las vocales y las sacamos por pantalla
            fr.close();
            br.close();
        }catch(IOException io){
            System.out.println(io);
        }//try-catch
        System.out.println(""+contadorI(linea));
    }//main()
    //Contamos las vocales
    static int contadorI(String lineas){
        int iContadorI = 0;
        if(lineas==null)
            return 0;
        else{
            char [] c = lineas.toCharArray();
            for(int i=0;i<c.length;i++){
                if (c[i] =='i'||c[i] == 'I')
                    iContadorI++;
            }//for
            return iContadorI;
        }//if-else
    }//contadorI()
}//VocalI