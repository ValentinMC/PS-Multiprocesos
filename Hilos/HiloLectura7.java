import java.util.Scanner;

public class HiloLectura7 implements Runnable{
    Scanner oTeclado = new Scanner(System.in);
    FrasesEj7 oFrases;
    String sFrase;
    public HiloLectura7(FrasesEj7 obF){
        oFrases = obF;
    }//Constructor

    @Override
    public void run() {
        boolean bSeguir = true;

        //Pedimos las frases al usuario y las metemos en una lista comun
        while(bSeguir){
            System.out.println("Digame una frase o introduzca FIN para terminar");
            sFrase = oTeclado.nextLine();
            if(!sFrase.equalsIgnoreCase("FIN"))
                oFrases.mvAniadirFrase(sFrase);
            else bSeguir=false;
        }//while
    }//run()
}//HiloLectura7