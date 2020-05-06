import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class HiloEscritura7 implements Runnable{
    FrasesEj7 oFrases;
    
    public HiloEscritura7(FrasesEj7 ioFrases){
        oFrases = ioFrases;
    }//Constructor
    @Override
    public void run() {
        //Aqui escribiremos las frases en un fichero
        try{
            File f = new File("frases7.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(oFrases.toString());
            bw.close();
            fw.close();
        }catch(IOException io){
            System.out.println(io);
        }//try-catch
    }//run()
}//HiloEscritura7