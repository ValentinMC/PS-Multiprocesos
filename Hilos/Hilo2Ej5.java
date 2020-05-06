public class Hilo2Ej5 implements Runnable{
    int iNumeroImpar = 1;
    @Override
    public void run() {
        while(iNumeroImpar<10){
            System.out.println(Thread.currentThread().getName()+iNumeroImpar);
            iNumeroImpar+=2;
        }//while
    }//run()
}//Hilo2Ej5