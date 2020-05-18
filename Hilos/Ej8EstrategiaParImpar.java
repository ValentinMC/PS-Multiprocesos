package Hilos;
import java.util.Random;

public class Ej8EstrategiaParImpar implements Runnable {

    Ej8ContadorBeneficios oBeneficios;
    Ej8Banco oBanco;
    private int iNumeroRuleta;
    private int iDineroHilo;
    boolean bPar;
    @Override
    public void run() {
        try {
            if(bTieneDinero()){
                bPar = miApostar();
                if ((iNumeroRuleta % 2 == 0) && bPar) {
                    miNumeroGanado();
                    System.out.println(Thread.currentThread().getName() + " ha ganado! Ahora tiene "+ getiDineroHilo());

                } else {
                    mvNumeroPerdido();
                    System.out.println(Thread.currentThread().getName() + " ha perdido! Ahora tiene "+ getiDineroHilo());

                }//if-eslse
            }else System.out.println(Thread.currentThread().getName()+" ya no tiene dinero suficiente para apostar");
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } // if-else
    }//run()


    private boolean bTieneDinero() {
        if(getiDineroHilo()<10)      
            return false;
        else return true;
    }//bTieneDinero

    public void setiNumeroRuleta(int iiNumeroRuleta) {
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
        //Quitamos el valor de la apuesta al hilo
        mvDisminuirDineroH(10);
        //Le damos el dinero al banco
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()+10);
        return bPar;
    }//miApostar()

    public void miNumeroGanado(){
        //Le quitamos el dinero al banco dependiendo del hilo que sea
        //y del dinero que disponga el banco
        int iDineroDisponibleBanco = oBanco.getDineroGanado(Thread.currentThread());
        //Aumentamos el dinero al hilo
        mvAumetnarDineroH(iDineroDisponibleBanco);
        //Le quitamos el dinero al banco
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()-iDineroDisponibleBanco);
        //Aumentamos los beneficios del grupo
        oBeneficios.setAumentoiEurosGrupo(iDineroDisponibleBanco);
    }//iNumeroGanado()

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
    }//AUMENTAR DINERO HILO
    
    

    public void mvNumeroPerdido(){
        oBeneficios.setAumentoiEurosGrupo(-10);
    }

}//EjEstrategiaNConcreto