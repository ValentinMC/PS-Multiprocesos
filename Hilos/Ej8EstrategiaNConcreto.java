package Hilos;
public class Ej8EstrategiaNConcreto implements Runnable{

    @Override
    public void run() {
        
    }//run()

    Ej8ContadorBeneficios oBeneficios;
    Ej8Banco oBanco;
    Ej8Ruleta oRuleta;
    private int iDineroHilo;

    public Ej8EstrategiaNConcreto(Ej8ContadorBeneficios ioBen, Ej8Banco ioBanco, int iNumeroRuleta) {
        this.oBeneficios = ioBen;
        this.oBanco = ioBanco;
    }// Constructor Hilo

    public int getiDineroHilo() {
        return iDineroHilo;
    }

    public void setiDineroHilo(int iDineroHilo) {
        this.iDineroHilo = iDineroHilo;
    }

    public int miApostar() {
        int iNumero = (int) (Math.random() * 36 + 1);
        oRuleta.mvCogerDineroApuesta(10);
        
        return iNumero;
    }//miApostar()
    /*
    NumeroGanado(){
        la banca nos devuelve lo apostado *36
    }

    miPerder(){
        el dinero va a la banca
    }
    */


    
}