package Hilos;
public class Ej8EstrategiaMaringala implements Runnable {

    Ej8ContadorBeneficios oBeneficios;
    Ej8Banco oBanco;
    private int iNumeroRuleta;
    private int iDineroHilo;
    private int iDineroApuesta;

    @Override
    public void run() {
        if (bTieneDinero()) {
            int iNumeroHilo = miApostar();
            if (getiNumeroRuleta() == iNumeroHilo) {
                miNumeroGanado();
                System.out.println(Thread.currentThread().getName() + " ha ganado! Ahora tiene " + getiDineroHilo());

            } else {
                mvNumeroPerdido();
                System.out.println(Thread.currentThread().getName() + " ha perdido! Ahora tiene " + getiDineroHilo());
            } // if-else
        } else
            System.out.println(Thread.currentThread().getName() + " se ha quedado sin dinero para apostar");
    }// run()

    private boolean bTieneDinero() {
        if(getiDineroHilo()<getiDineroApuesta())
            return false;
        else return true;
    }//bTieneDinero()

    private int getiNumeroRuleta() {
        return this.iNumeroRuleta;
    }//GETTER iNumeroRuleta()

    public Ej8EstrategiaMaringala(Ej8ContadorBeneficios ioBen, Ej8Banco ioBanco) {
        this.oBeneficios = ioBen;
        this.oBanco = ioBanco;
        this.iDineroHilo = 100;
        this.iDineroApuesta = 10;
    }// Constructor Hilo

    public void setiNumeroRuleta(int iiNumeroRuleta){
        this.iNumeroRuleta = iiNumeroRuleta;
    }//setiNumeroRuleta()

    public int miApostar() {
        //Sacamos un numero al azar
        int iNumero = (int) (Math.random() * 36 + 1);
        //Quitamos el valor de la apuesta al hilo
        mvDisminuirDineroH(getiDineroApuesta());
        //Le damos el dinero al banco
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()+getiDineroApuesta());
        return iNumero;
    }//miApostar()

    public void miNumeroGanado(){
        //Le quitamos el dinero al banco dependiendo del hilo que sea
        //y del dinero que disponga el banco
        int iDineroDisponibleBanco = oBanco.getDineroGanado(Thread.currentThread(),getiDineroApuesta());
        //Aumentamos el dinero al hilo
        mvAumetnarDineroH(iDineroDisponibleBanco);
        //Le quitamos el dinero al banco
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()-iDineroDisponibleBanco);
        //Aumentamos los beneficios del grupo
        oBeneficios.setAumentoiEurosGrupo(iDineroDisponibleBanco);
    }//iNumeroGanado()

    public void mvAumetnarDineroH(int iDinero){
        int iNuevoDinero = getiDineroHilo()+iDinero;
        setiDineroHilo(iNuevoDinero);
    }//AUMENTAR DINERO HILO

    public void mvDisminuirDineroH(int iDinero){
        int iNuevoDinero = getiDineroHilo()-iDinero;
        setiDineroHilo(iNuevoDinero);
    }//DISMINUIR DINERO HILO

    public int getiDineroHilo() {
        return iDineroHilo;
    }//getDineroHilo()

    public void setiDineroHilo(int iDineroHilo) {
        this.iDineroHilo = iDineroHilo;
    }//setDineroHilo()


    private void mvNumeroPerdido(){
        oBeneficios.setAumentoiEurosGrupo(getiDineroApuesta());
        setiDineroApuesta(getiDineroApuesta()*2);
    }//mvNumeroPerdido()

    public int getiDineroApuesta() {
        return iDineroApuesta;
    }//GETTER iDineroApuesta

    public void setiDineroApuesta(int iDineroApuesta) {
        this.iDineroApuesta = iDineroApuesta;
    }//SETTER iDineroApuesta

}//EjEstrategiaNConcreto