package Hilos;

public class CHiloVocal implements Runnable{
    Contador oContGeneral;
    int iContadorVocal;
    String sFrase;
    int iNumHilo;
    
    public CHiloVocal(String isFrase, Contador ioContador, int iiNumHilo){
        this.sFrase = isFrase;
        this.oContGeneral = ioContador;
        this.iNumHilo = iiNumHilo;
    }//Constructor()

    @Override
    public void run() {
        switch(iNumHilo){
            case 0:
                //Recorremos la frase letra a letra
                for(int i=0; i<sFrase.length();i++)
                    if(sFrase.charAt(i)=='a'||sFrase.charAt(i)=='A'){
                        //Incrementamos el contador de vocales general
                        oContGeneral.mvIncrementar();
                        //Incrementamos el contador de la vocal especifica
                        iContadorVocal++;
                        System.out.println("El "+Thread.currentThread().getName()+" tiene "+iContadorVocal+" vocal/es a/A");
                    }//if
                break;
            case 1:
                //Recorremos la frase letra a letra
                for(int i=0; i<sFrase.length();i++)
                if(sFrase.charAt(i)=='e'||sFrase.charAt(i)=='E'){
                    //Incrementamos el contador de vocales general
                    oContGeneral.mvIncrementar();
                    //Incrementamos el contador de la vocal especifica
                    iContadorVocal++;
                    System.out.println("El "+Thread.currentThread().getName()+" tiene "+iContadorVocal+" vocal/es e/E");
                }
                break;
            case 2:
                //Recorremos la frase letra a letra
                for(int i=0; i<sFrase.length();i++)
                if(sFrase.charAt(i)=='i'||sFrase.charAt(i)=='I'){
                    //Incrementamos el contador de vocales general
                    oContGeneral.mvIncrementar();
                    //Incrementamos el contador de la vocal especifica
                    iContadorVocal++;
                    System.out.println("El "+Thread.currentThread().getName()+" tiene "+iContadorVocal+" vocal/es i/I");
                }
                break;
            case 3:
                //Recorremos la frase letra a letra
                for(int i=0; i<sFrase.length();i++)
                if(sFrase.charAt(i)=='o'||sFrase.charAt(i)=='O'){
                    //Incrementamos el contador de vocales general
                    oContGeneral.mvIncrementar();
                    //Incrementamos el contador de la vocal especifica
                    iContadorVocal++;
                    System.out.println("El "+Thread.currentThread().getName()+" tiene "+iContadorVocal+" vocal/es o/O");
                }
                break;
            case 4:
                //Recorremos la frase letra a letra
                for(int i=0; i<sFrase.length();i++)
                if(sFrase.charAt(i)=='u'||sFrase.charAt(i)=='U'){
                    //Incrementamos el contador de vocales general
                    oContGeneral.mvIncrementar();
                    //Incrementamos el contador de la vocal especifica
                    iContadorVocal++;
                    System.out.println("El "+Thread.currentThread().getName()+" tiene "+iContadorVocal+" vocal/es u/U");
                }
                break;
        }//switch-case
        System.out.println("Se han encontrado "+oContGeneral.getNumero()+" vocales en total");
    }//run()
}//CHiloVocal