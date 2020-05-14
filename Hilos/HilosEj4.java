package Hilos;
public class HilosEj3 implements Runnable{
    int iTipo;
    public HilosEj3(int iiTipo){
        this.iTipo = iiTipo;
    }//Constructor
    
    @Override
    public void run() {
        int iContador = 0;
        switch(iTipo){
            case 0:
                //Sumamos e imprimimos los numeros por pantalla del primer hilo
                while(iContador < 1000)
                    System.out.println(iContador+=2);
                break;
            case 1:
                ////Sumamos e imprimimos los numeros por pantalla del segundo hilo
                while(iContador < 1000)
                    System.out.println(iContador+=5);
                break;
            case 2:
                iContador = 9;
                while(iContador < 999)
                 System.out.println(iContador+=10);
                break;
        }//switch-case()
    }//run()
}//HilosEj3 