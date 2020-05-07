package MPS;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
public class VocalA{
    public static void main(String[] args) throws FileNotFoundException{
        File f = new File(args[0]);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea="";
        try{
            //leemos las frases del fichero
            linea = br.readLine();
            while(linea!=null){
                linea += br.readLine();
            }//while()
            fr.close();
            br.close();
        }catch(IOException io){
            System.out.println(io);
        }//try-catch
        //Contamos las vocales y las sacamos por pantalla
        System.out.println(""+contadorA(linea));
    }//main()
    //Contamos las letras A o a
    static int contadorA(String lineas){
      int iContadorE = 0;
      if(lineas==null)
          return 0;
      else{
          char [] c = lineas.toCharArray();
          for(int i=0;i<c.length;i++){
              if (c[i] =='a'||c[i] == 'A')
                  iContadorE++;
          }//for
          return iContadorE;
      }//if-else
    }//contadorA()
}//VocalA
