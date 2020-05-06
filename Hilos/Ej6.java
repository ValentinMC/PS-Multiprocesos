/*
Realizar un programa con 4 hilos. Cada uno de ellos mostrará 5 mensajes 
por pantalla indicando su nombre y la hora actual, deberán ejecutarse 
en orden primero los 5 del primero, después los 5 del segundo, después 
los 5 del tercero,…
*/
public class Ej6{
    public static void main(String[] args) {
        //Instanciamos la clase Hilos que implementa Runnable
        HilosEj6[] oHilo = new HilosEj6[4];
        
        //Creamos los hilos
        for(int i=0; i<oHilo.length;i++){
            try{
                oHilo[i] = new HilosEj6();
                Thread oTh = new Thread(oHilo[i]);
                oTh.setName("Hilo "+i);
                oTh.start();
                /*
                    Utilizamos el join() para que una vez
                    terminado un hilo, pase al siguiente
                */
                oTh.join();
            }catch(InterruptedException ie){
                System.out.println(ie);
            }//try-cacth
        }//for
    }//main()
}//Ej6