/*
Realizar un programa que lea frases por teclado hasta que se 
introduzca una línea con la palabra fin y lo grabe
en un fichero. Se diseñarán dos hilos, uno se encargará 
de la lectura de las frases y el otro de la grabación del
fichero. 
*/
public class Ej7{
    public static void main(String[] args) {
        //Instanciamos la clase que contendra las frases
        FrasesEj7 oFrases = new FrasesEj7();

        //Instanciamos los hilos con el objeto que contendra las frases
        HiloLectura7 hL = new HiloLectura7(oFrases);
        HiloEscritura7 hE = new HiloEscritura7(oFrases);
        try{
            //Primero ejecutamos el hilo de Lectura
            Thread thLectura = new Thread(hL);
            thLectura.start();
            
            //Esperamos a que se termine de ejcutar
            thLectura.join();

            //Ejecutamos la escritura
            Thread thEscritura = new Thread(hE);
            thEscritura.start();
        }catch(InterruptedException ie){
            System.out.println(ie);
        }//try-catch
    }//main()
}//Ej7