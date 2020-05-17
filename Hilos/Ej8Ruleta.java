/*
Se desea simular los posibles beneficios de diversas estrategias de juego en un casino. La ruleta francesa es un
juego en el que hay una ruleta con 37 números (del 0 al 36). Cada 3000 milisegundos el croupier saca un
número al azar y los diversos hilos apuestan para ver si ganan. 

Todos los hilos empiezan con 100 euros y la banca (que controla la ruleta) con 500. Cuando los jugadores 
pierden dinero, la banca incrementa su saldo.

 Se puede jugar a un número concreto. 

Habrá 4 hilos que eligen números al azar del 1 al 36 (el 0 no) y restarán 10 euros de su saldo para apostar 
a ese ese número. Si sale su número su saldo se incrementa en 360 euros (36 veces lo apostado).

 Se puede jugar a par/impar. Habrá 4 hilos que eligen al azar si apuestan a que saldrá un número par o un
número impar. Siempre restan 10 euros para apostar y si ganan incrementan su saldo en 20 euros.

 Se puede jugar a la «martingala». Habrá 4 hilos que eligen números al azar. Elegirán un número y
empezarán restando 10 euros de su saldo para apostar a ese número. Si ganan incrementan su saldo en 360
euros. Si pierden jugarán el doble de su apuesta anterior (es decir, 20, luego 40, luego 80, y así
sucesivamente)


 La banca acepta todas las apuestas pero nunca paga más dinero del que tiene.

 Si sale el 0, todo el mundo pierde y la banca se queda con todo el dinero.


--------------------------------------------- ENTENDIMIENTO -------------------------------------------------

    - Los hilos simplemente son diversas estrategias de juego.
        + Jugar a numero concreto (4 hilos)
            * Se elige un numero entre el 1 y el 36.
            * La apuesta vale 10 euros.
            * Si se gana su saldo incrementa (*36 de lo apostado)
        + Jugar a par/impar (4 hilos)
            * Estos hilos apuestan a par o impar.
            * La apuesta vale 10 euros
            * Si se gana su saldo incrementa (*2 de lo apostado)
        + Jugar a martingala (4 hilos)
            * Estos hilos apuestan a cualquier numero excepto el 0
            * Si se gana su sueldo incrementa (*36 de lo apostado)
            * La gracia es que cuando pierden, la proxima apuesta tiene que ser del doble de la anterior.

    - Todos los hilos empiezan con 100 euros y la banca con 500.
    - La banca acepta todas las apuesta siempre y cuando el conjunto de estas no superen el total de la banca.
    - Si un hilo pierde, el dinero ira a la banca.
    - La ruleta va a ser el proceso principal.
    - Si sale el 0 todo el mundo pierde.
    - Al ser una simulación de posibles benficios, estaría bien que cada vez que
      se imprima por pantalla los beneficios de cada estrategia
    
----------------------------------------------------------------------------------------------------------------
--------------------------------------------- POR PARTES -------------------------------------------------------
    - Habra:
        + Ej8 (Clase principal) (Ruelta)
        + Ej8EstrategiaNConcreto (4 objetos hilo)
        + Ej8EstrategiaParImpar (4 objetos hilo)
        + Ej8EstrategiaMaringala (4 objetos hilo)
        + Ej8Banco (1 objeto)
        + Ej8ContadorBeneficios (1 objeto por estrategia)
    - El programa principal se encarga de crear los hilos y las partidas
    - Cada partida tendrá un .sleep(3000) para que una vez se haya terminado 
      una partida se espere a ver el resultado de todos los hilos y seguir
      con la siguiente.
    - Las partidas estarán dentro de un while(true) ya que se termian cuando 
      el numero que sale es 0

*/
package Hilos;
public class Ej8Ruleta {
    // Al ser esta la ruleta se crean sus propias propiedades
    private int iNumeroRuleta;
    private int iDineroPartida;

    public static void main(String[] args) throws InterruptedException {
        //Instanciamos los objetos necesarios para el ejercicio
        Ej8ContadorBeneficios oBeneficios = new Ej8ContadorBeneficios();
        Ej8ContadorBeneficios oBeneficiosParImpar = new Ej8ContadorBeneficios();
        Ej8Banco oBanco = new Ej8Banco();

        Ej8EstrategiaNConcreto oNConcreto[] = new Ej8EstrategiaNConcreto[4];
        //Ej8EstrategiaMaringala oMaringala[] = new Ej8EstrategiaMaringala[4];
        Ej8EstrategiaParImpar oParImpar[] = new Ej8EstrategiaParImpar[4];
        
        Ej8Ruleta oRuleta = new Ej8Ruleta();
        int iNumeroRuleta = oRuleta.miSacarNumero();
        boolean bSeguir = true;
        int iNumeroPartida = 0;
        // Comienza la partida
        for (int i = 0; i < oNConcreto.length; i++) {
            oNConcreto[i] = new Ej8EstrategiaNConcreto(oBeneficios, oBanco,iNumeroRuleta);
            oParImpar[i] = new Ej8EstrategiaParImpar(oBeneficiosParImpar, oBanco, iNumeroRuleta);
        }//Creacion de los hilos
        while(bSeguir){
            System.out.println(iNumeroPartida+"-------------------------------");
            if(iNumeroRuleta!=0){
                for (int i = 0; i < oNConcreto.length; i++) {
                    oNConcreto[i].setiNumeroRuleta(iNumeroRuleta);
                    oParImpar[i].setiNumeroRuleta(iNumeroRuleta);
                    Thread th = new Thread(oNConcreto[i]);
                    Thread thPI = new Thread(oParImpar[i]);

                    th.setName("Hilo "+i+" NCo");
                    thPI.setName("Hilo "+i+" PI");

                    th.start();
                    thPI.start();
                } // for()
                iNumeroPartida++;
                //Thread.sleep(3000);
                iNumeroRuleta = oRuleta.miSacarNumero();
            }else bSeguir = false;
        }//while()

        System.out.println("La partida ha terminado! El numero ha sido 0!");
        System.out.println("Se han recaudado "+oBeneficios.getiEurosGrupo()+" para el NConcreto");
        System.out.println("Se han recaudado "+oBeneficiosParImpar.getiEurosGrupo()+" para el ParImpar");

    }// main()



    public synchronized void mvCogerDineroApuesta(int iDineroHilo) {
        setiDineroPartida(getiDineroPartida() + iDineroHilo);
    }//mvCogerDineroApuesta

    public int miSacarNumero(){
        setiNumeroRuleta((int) (Math.random() * 36));
        return getiNumeroRuleta();
    }//miSacarNumero()

    public int getiNumeroRuleta() {
        return iNumeroRuleta;
    }

    public void setiNumeroRuleta(int iNumeroRuleta) {
        this.iNumeroRuleta = iNumeroRuleta;
    }

    public int getiDineroPartida() {
        return iDineroPartida;
    }

    public void setiDineroPartida(int iDineroPartida) {
        this.iDineroPartida = iDineroPartida;
    }
}//Ej8