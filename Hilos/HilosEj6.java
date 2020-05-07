package Hilos;

public class HilosEj6 implements Runnable{
    //Creamos un contador para controlar las veces
    //que se mostrara la informacion por pantalla
    int iContador = 0;
    @Override   
    public void run() {
        //Imprimimos el nombre y la hora del hilo 5 veces
        String sNombreHilo = Thread.currentThread().getName();
        while(iContador<5){
            System.out.println(sNombreHilo+" HORA: "+java.time.LocalTime.now());  
            iContador++;
        }//while()
    }//run()
}//HilosEj6