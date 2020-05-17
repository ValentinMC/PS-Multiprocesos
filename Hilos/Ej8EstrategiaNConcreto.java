package Hilos;
public class Ej8EstrategiaNConcreto implements Runnable{
    
    Ej8ContadorBeneficios oBeneficios;
    Ej8Banco oBanco;
    int iNumeroRuleta;
    private int iDineroHilo;


    @Override
    public void run() {
        if(iNumeroRuleta == miApostar()){
            System.out.println(Thread.currentThread().getName()+" ha ganado! Ahora tiene "+getiDineroHilo());
        }else{
            System.out.println(Thread.currentThread().getName()+" ha perdido! Ahora tiene "+getiDineroHilo());
        }//if-else
    }//run()



    public Ej8EstrategiaNConcreto(Ej8ContadorBeneficios ioBen, Ej8Banco ioBanco, int iNumeroRuleta) {
        this.oBeneficios = ioBen;
        this.oBanco = ioBanco;
        this.iNumeroRuleta = iNumeroRuleta;
    }// Constructor Hilo

    public int getiDineroHilo() {
        return iDineroHilo;
    }

    public void setiDineroHilo(int iDineroHilo) {
        this.iDineroHilo = iDineroHilo;
    }

    public int miApostar() {
        int iNumero = (int) (Math.random() * 36 + 1);
        setiDineroHilo(getiDineroHilo()-10);
        oBanco.setiDineroBanco(oBanco.getiDineroBanco()+10);
        return iNumero;
    }//miApostar()
    
    public void miNumeroGanado(){
        setiDineroHilo(getiDineroHilo()+360);

    }

}//EjEstrategiaNConcreto