public class Hilo1Ej5 implements Runnable{
    int iNumeroPar = 0;
    @Override
    public void run() {
        while(iNumeroPar<10)
        System.out.println(Thread.currentThread().getName()+(iNumeroPar+=2));
    }//run()
}//Hilo1Ej5