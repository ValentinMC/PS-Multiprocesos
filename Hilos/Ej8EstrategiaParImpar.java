package Hilos;
import java.util.Random;

public class Ej8EstrategiaParImpar implements Runnable {

    Ej8ContadorBeneficios oBeneficios;
    Ej8Banco oBanco;
    private int iNumeroRuleta;
    private int iDineroHilo;

    @Override
    public void run() {
        try {
            if ((iNumeroRuleta % 2 == 0) && miApostar()) {
                miNumeroGanado();
                System.out.println("R:" + iNumeroRuleta + "-->" + Thread.currentThread().getName() + " ha ganado! Ahora tiene "
                                + getiDineroHilo() + " " + "y el banco " + oBanco.getiDineroBanco());

            } else {
                mvNumeroPerdido();
                System.out.println( "R:" + iNumeroRuleta + "-->" + Thread.currentThread().getName() + " ha perdido! Ahora tiene "
                                + getiDineroHilo() + " " + "y el banco " + oBanco.getiDineroBanco());

            }
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // if-else
    }//run()


    public void setiNumeroRuleta(int iiNumeroRuleta){
        this.iNumeroRuleta = iiNumeroRuleta;
    }//setiNumeroRuleta()
    public Ej8EstrategiaParImpar(Ej8ContadorBeneficios ioBen, Ej8Banco ioBanco, int iNumeroRuleta) {
        this.oBeneficios = ioBen;
        this.oBanco = ioBanco;
        this.iNumeroRuleta = iNumeroRuleta;
        this.iDineroHilo = 100;
    }// Constructor Hilo

    public boolean miApostar() throws InstantiationException, IllegalAccessException {
        //Si es true es par y si es false es impar
        boolean bPar = Random.class.newInstance().nextBoolean();
        mvDisminuirDineroH(10);
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()+10);
        return bPar;
    }//miApostar()

    public int getiDineroHilo() {
        return iDineroHilo;
    }

    public void setiDineroHilo(int iDineroHilo) {
        this.iDineroHilo = iDineroHilo;
    }
    public void mvDisminuirDineroH(int iDinero){
        int iNuevoDinero = getiDineroHilo()-iDinero;
        setiDineroHilo(iNuevoDinero);
    }//DISMINUIR DINERO HILO

    public void mvAumetnarDineroH(int iDinero){
        int iNuevoDinero = getiDineroHilo()+iDinero;
        setiDineroHilo(iNuevoDinero);
    }//DISMINUIR DINERO HILO
    
    public void miNumeroGanado(){
        mvAumetnarDineroH(20);
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()-20);
        oBeneficios.setAumentoiEurosGrupo(20);
    }//iNumeroGanado()

    public void mvNumeroPerdido(){
        mvDisminuirDineroH(10);
        oBeneficios.setAumentoiEurosGrupo(-10);
    }

}//EjEstrategiaNConcreto