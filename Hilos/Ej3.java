/*
Crear un programa en Java que ejecute tres hilos de forma concurrente. 
Uno de ellos debe sumar los números múltiplos de dos del 1 al 1000, 
otro los múltiplos de 5, y otro, los que terminan en nueve.
*/
public class Ej3{
    public static void main(String[] args) {
        //Creamos 3 hilos
        HilosEj3 ovHilo[] = new HilosEj3[3];
    
        for(int i = 0; i<ovHilo.length;i++){
            //Le introducimos un numero identificativo en el constructor
            ovHilo[i] = new HilosEj3(i); 
            try{
                Thread th = new Thread(ovHilo[i]);
                th.setName("Hilo "+i);
                th.start();
                //El .join() nos ayudara a que se ejecuten de forma concurrente
                th.join();
            }catch(InterruptedException ie){
                System.out.println(ie);
            }//try-catch
        }//for 
    }//main()
}//Ej3