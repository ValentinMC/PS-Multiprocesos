package Hilos;
public class HilosEj4 implements Runnable{
    private int iTipo;
    private String sNombre;
    private int iMetros;
    private int iVelocidad;

    public HilosEj4(int ioTipo, String isNombre,int iiVelocidad){
        this.iTipo = ioTipo;
        this.sNombre = isNombre;
        this.iVelocidad = iiVelocidad;
    }//HilosEj4
    @Override

    public void run() {
        switch(iTipo){
            case 0:
                while(iMetros<100){
                    mvIncrementarMetros();
                    System.out.println("La posicion ahora del "+getsNombre()+" es: "+getiMetros());
                }
                System.out.println(getsNombre()+" ha ganado la carrera");
                //Una vez ha ganado un animal nos salimos del programa
                /*
                    Puede que se impriman los dos hilos restantes una vez mas porque mientras
                    el primer hilo imprime su victoria los otros dos hilos siguen ejecutandose.
                */
                System.exit(1);
                break;
            case 1:
                while(iMetros<100){
                    mvIncrementarMetros();
                    System.out.println("La posicion ahora de "+getsNombre()+" es: "+getiMetros());
                }
                System.out.println(getsNombre()+" ha ganado la carrera");
                System.exit(1);
                break;
            case 2:
                while(iMetros<100){
                    mvIncrementarMetros();
                    System.out.println("La posicion ahora de "+getsNombre()+" es: "+getiMetros());
                }
                System.out.println(getsNombre()+" ha ganado la carrera");
                System.exit(1);
                break;
        }//switch-case
    }//run()

    private String getsNombre() {
        return this.sNombre;
    }//getterNombre()

    public void mvIncrementarMetros() {
        iMetros+=iVelocidad;
    }//mvIncrementarMetros()

    public int getiMetros(){
        return this.iMetros;
    }//getterMetros()

}//HilosEj4