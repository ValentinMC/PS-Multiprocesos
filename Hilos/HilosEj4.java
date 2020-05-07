package Hilos;

public class HilosEj4 implements Runnable{
    int iTipo;
    int iMetros;

    public HilosEj4(int ioTipo){
        this.iTipo = ioTipo;
    }//HilosEj4
    @Override

    public void run() {
        switch(iTipo){
            case 0:
                if(iMetros==100){
                    System.out.println(Thread.currentThread().getName()+" ha ganado la carrera");
                    
                }
                break;
            case 1:
                break;
            case 3:
                break;
        }//switch-case
    }//run()
}//HilosEj4