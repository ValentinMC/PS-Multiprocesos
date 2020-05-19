package Hilos;

public class Ej8Banco {
    // Usare integers ya que los numeros del ejercicio
    // son redondos y no se juega con decimales
    private int iDineroBanco;

    public Ej8Banco() {
        this.setiDineroBanco(500);
    }// Constructor Banco
    
    /*  Este metodo compara si el hilo ha ganado
        mas dinero del que hay en el banco.
        Si el banco no dispone de fondos simplemente no dara 
        dinero al hilo.
        Ademas se hace distincion dependiendo del hilo del que se trate
        por el contenido de su nombre.
    */
    public synchronized int getDineroGanado(Thread thread){
        if(thread.getName().contains("NCo"))
            //Es un hilo de estrategia numero concreto
            if(getiDineroBanco()>360)
                return 360;
            else return 0;
        else if(thread.getName().contains("PI"))
            //Hilo par impar
            if(getiDineroBanco()>20)
                return 20;
            else return 0;
        return 0;
    }//getDineroGanado (NCONCRETO || PAR/IMPAR)

    public int getDineroGanado(Thread currentThread, int iiDineroApuesta) {
        //Hilo Maringala
        if(getiDineroBanco()>iiDineroApuesta*36)
            return iiDineroApuesta*36;
        else return 0;
    }//getDineroGanado() (MARINGALA)

    public synchronized int getiDineroBanco() {
        return iDineroBanco;
    }//GETTER iDineroBanco()

    public synchronized void setiDineroBanco(int iDineroBanco) {
        this.iDineroBanco = iDineroBanco;
    }//SETTER iDineroBanco
}//Ej8Banco