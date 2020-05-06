
public class Contador{
    int iContador = 0;
    
    public Contador(){
        this.iContador = 0;
    }//Contador()

    public synchronized void  mvIncrementar(){
        this.iContador++;
    }//Incrementar

    public synchronized int getNumero(){
        return this.iContador;
    }//Getter Contador

    public synchronized String toString(){
        return Thread.currentThread().getName()+" numero "+this.iContador;
    }//toString()
}//Contador