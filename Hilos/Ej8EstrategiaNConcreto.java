package Hilos;
public class Ej8EstrategiaNConcreto implements Runnable {

    Ej8ContadorBeneficios oBeneficios;
    Ej8Banco oBanco;
    private int iNumeroRuleta;
    private int iDineroHilo;

    @Override
    public void run() {
        int iNumeroHilo = miApostar();
        if (iNumeroRuleta == iNumeroHilo) {
            miNumeroGanado();
            System.out.println("R:" + iNumeroRuleta + "H:" + iNumeroHilo + "-->" + Thread.currentThread().getName()
                    + " ha ganado! Ahora tiene " + getiDineroHilo() + " " + "y el banco " + oBanco.getiDineroBanco());

        } else {
            mvNumeroPerdido();
            System.out.println("R:" + iNumeroRuleta + "H:" + iNumeroHilo + "-->" + Thread.currentThread().getName()
                    + " ha perdido! Ahora tiene " + getiDineroHilo() + " " + "y el banco " + oBanco.getiDineroBanco());

        } // if-else
    }//run()



    public Ej8EstrategiaNConcreto(Ej8ContadorBeneficios ioBen, Ej8Banco ioBanco, int iNumeroRuleta) {
        this.oBeneficios = ioBen;
        this.oBanco = ioBanco;
        this.iNumeroRuleta = iNumeroRuleta;
        this.iDineroHilo = 100;
    }// Constructor Hilo

    public void setiNumeroRuleta(int iiNumeroRuleta){
        this.iNumeroRuleta = iiNumeroRuleta;
    }//setiNumeroRuleta()

    public int miApostar() {
        int iNumero = (int) (Math.random() * 36 + 1);
        mvDisminuirDineroH(10);
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()+10);
        return iNumero;
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
        mvAumetnarDineroH(360);
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()-360);
        oBeneficios.setAumentoiEurosGrupo(360);
    }//iNumeroGanado()

    public void mvNumeroPerdido(){
        mvDisminuirDineroH(10);
        oBeneficios.setAumentoiEurosGrupo(-10);
    }

}//EjEstrategiaNConcreto