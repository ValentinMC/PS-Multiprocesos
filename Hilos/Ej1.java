/*
Crear un programa en Java que cree 3 hilos, que se ejecutan 5 veces, 
de manera que  muestren por pantalla el nombre del hilo y un número 
que indique por qué ejecución van (terminará en el número 15). 
*/
package Hilos;

public class Ej1{
  public static void main(String[] args) {
    //Creamos los tres hilos
    CHilosEj1 hilos[] = new CHilosEj1[3];
    
    //Inicialiamos los hilos
    for(int i = 0; i<hilos.length;i++){
      //Inicializamos los hilos
      hilos[i] = new CHilosEj1();
      Thread th = new Thread(hilos[i]);
      th.setName("Hilo "+i);
      th.start();
    }//for
  }//main()
}//Ej1
