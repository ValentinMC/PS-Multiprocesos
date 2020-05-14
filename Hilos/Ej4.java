package Hilos;
import java.util.Random;

/*
Crear un programa en Java que simule una carrera 
de 100 metros con tres animales e indicar quien ganó.
La velocidad del animal se genera a través de un número aleatorio.
*/
public class Ej4{
    public static void main(String[] args) {
        Random ran = new Random();
        //El constructor tiene el numero del hilo, nombre del animal, y velocidad constante generada automaticamente.
        HilosEj4 oHilo1 = new HilosEj4(0,"Conejo",1+ran.nextInt(10));
        HilosEj4 oHilo2 = new HilosEj4(1,"Tortuga",1+ran.nextInt(10));
        HilosEj4 oHilo3 = new HilosEj4(2,"Leon",1+ran.nextInt(10));

        Thread hilo1 = new Thread(oHilo1);
        hilo1.start();

        Thread hilo2 = new Thread(oHilo2);
        hilo2.start();

        Thread hilo3 = new Thread(oHilo3);
        hilo3.start();
    }////main()
}//Ej4