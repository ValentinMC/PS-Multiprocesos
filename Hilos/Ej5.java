/*
Crear un programa en Java que use hilos independientes, 
en clases diferentes. Un hilo imprime números pares
del 1 al 10 y la suma de dichos números, y otro hilo 
que imprime números impares del 1 al 10. 
*/
package Hilos;

public class Ej5{
    public static void main(String[] args) {
        //Instanciamos las clases individuales de cada hilo
        Hilo1Ej5 oH1 = new Hilo1Ej5();
        Hilo2Ej5 oH2 = new Hilo2Ej5();
        
        //Creamos los hilos con las clases que implementan Runnable
        Thread oTh1 = new Thread(oH1);
        oTh1.setName("Hilo1 ");
        Thread oTh2 = new Thread(oH2);
        oTh2.setName("Hilo2 ");

        //nicializamos los hilos
        oTh1.start();
        oTh2.start();
    }//main()
}//Ej5