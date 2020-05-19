package Hilos;
public class Ej8EstrategiaNConcreto implements Runnable {

    Ej8ContadorBeneficios oBeneficios;
    Ej8Banco oBanco;
    private int iNumeroRuleta;
    private int iDineroHilo;

    @Override
    public void run() {
        if(bTieneDinero()){
            //Apostamos siempre y cuando el hilo tenga dinero
            int iNumeroHilo = miApostar();
            //Dependiendo si coinciden los numeros o no, se hace una operacion u otra
            if (getiNumeroRuleta() == iNumeroHilo) {
                miNumeroGanado();
                System.out.println(Thread.currentThread().getName()+ " ha ganado! Ahora tiene " + getiDineroHilo());

            } else {
                mvNumeroPerdido();
                System.out.println(Thread.currentThread().getName()+ " ha perdido! Ahora tiene " + getiDineroHilo());
            } // if-else
        }else 
            System.out.println(Thread.currentThread().getName()+" se ha quedado sin dinero para apostar");
    }//run()

    private boolean bTieneDinero() {
        if(getiDineroHilo()<10)
            return false;
        else return true;
    }//Verificamos si el hilo tiene dinero

    private int getiNumeroRuleta() {
        return this.iNumeroRuleta;
    }//GETTER iNumeroRuleta()

    public Ej8EstrategiaNConcreto(Ej8ContadorBeneficios ioBen, Ej8Banco ioBanco) {
        this.oBeneficios = ioBen;
        this.oBanco = ioBanco;
        this.iDineroHilo = 100;
    }// Constructor Hilo

    public void setiNumeroRuleta(int iiNumeroRuleta){
        this.iNumeroRuleta = iiNumeroRuleta;
    }//SETTER iNumeroRuleta

    private int miApostar() {
        //Sacamos un numero al azar
        int iNumero = (int) (Math.random() * 36 + 1);
        //Quitamos el valor de la apuesta al hilo
        mvDisminuirDineroH(10);
        //Le damos el dinero al banco
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()+10);
        return iNumero;
    }//miApostar()

    private void miNumeroGanado(){
        //Le quitamos el dinero al banco dependiendo del hilo que sea
        //y del dinero que disponga el banco
        int iDineroDisponibleBanco = oBanco.getDineroGanado(Thread.currentThread());
        //Aumentamos el dinero al hilo
        mvAumentarDineroH(iDineroDisponibleBanco);
        //Le quitamos el dinero al banco
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()-iDineroDisponibleBanco);
        //Aumentamos los beneficios del grupo
        oBeneficios.setAumentoiEurosGrupo(iDineroDisponibleBanco);
    }//miNumeroGanado()

    public void mvAumentarDineroH(int iDinero){
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

    public void mvNumeroPerdido(){
        /*Cuando se pierde la partida simplemente se disminuira
        el valor de los beneficios del grupo.*/
        oBeneficios.setAumentoiEurosGrupo(-10);
    }//mvNumeroPerdido()

}//EjEstrategiaNConcreto