package Hilos;
public class CHiloVocal implements Runnable{
    Contador oContGeneral;
    int iContadorVocal = 0;
    String sFrase, sVocal;
    
    public CHiloVocal(String isFrase, Contador ioContador, String isVocal){
        this.sFrase = isFrase;
        this.oContGeneral = ioContador;
        this.sVocal = isVocal;
    }//Constructor()

    @Override
    public void run() {
        //Recorremos la frase letra a letra
        for(int i=0; i<sFrase.length();i++){
            char[] vocalMayuscula = sVocal.toUpperCase().toCharArray();
            char[] vocalMinuscula = sVocal.toLowerCase().toCharArray();
            if(sFrase.charAt(i)==vocalMayuscula[0]||sFrase.charAt(i)==vocalMinuscula[0]){
                //Incrementamos el contador de vocales general
                oContGeneral.mvIncrementar();
                //Incrementamos el contador de la vocal especifica
                iContadorVocal++;
            }//if
        }//for
        System.out.println("El "+Thread.currentThread().getName()+" tiene "+iContadorVocal+" vocal/es "+sVocal);
    }//run()
}//CHiloVocal