/*
Crear un programa en Java que cree 3 hilos, que se ejecutan 5 veces, 
de manera que  muestren por pantalla el nombre del hilo y un número 
que indique por qué ejecución van (terminará en el número 15). 
*/

public class Ej1{
  public static void main(String[] args) {
    //Creamos un contador comun y los tres hilos
    Contador cont = new Contador();
    CHilosEj1 hilos[] = new CHilosEj1[3];
    
    //Inicialiamos los hilos
    for(int i = 0; i<hilos.length;i++){
      //A cada hilo se le pasa el objeto contador comun
      hilos[i] = new CHilosEj1(cont);
      Thread th = new Thread(hilos[i]);
      th.setName("Hilo "+i);
      th.start();
    }//for
  }//main()
}//Ej1
