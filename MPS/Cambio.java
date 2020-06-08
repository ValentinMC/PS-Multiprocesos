package MPS;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Cambio{
    public static void main(String[] args) {
        //Recogemos los valores
        String sLinea = args[0];
        //Le damos la vuelta y lo guardamos
        mvGuardar(msVuelta(sLinea));
    }//main()

    static String msVuelta(String isLinea){
        //Le damos la vuelta
        String vuelta = " ";
        for(int i = isLinea.length()-1;i>=0;i--)
            vuelta += isLinea.charAt(i);
        return vuelta;
    }//msVuelta()

    static void mvGuardar(String isVuelta){
        //Al tratarse de una simple linea, lo haremos de forma simple
        try{
            File f = new File("Ej2Vuelta.txt");
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(isVuelta);
            bw.close();
            fw.close();
        }catch(IOException io){
            System.out.println(io);
        }//try-catch
    }//mvGuardar()
}//Cambio