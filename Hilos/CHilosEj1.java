package Hilos;
public class CHilosEj1 implements Runnable{
    
    Contador cont;
    public CHilosEj1(Contador ioCont){
        this.cont = ioCont;
    }//Constructor

    @Override
    public void run() {
        //Incrementamos el valor
        while(cont.getNumero()<15){
            cont.mvIncrementar();
            System.out.println(cont.toString()); 
        }//while
    }//run()
}//CHilosEj1