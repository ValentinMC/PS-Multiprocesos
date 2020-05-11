package MPS;
import java.util.ArrayList;

public class CConjunto {
    public static void main(String[] args) {
        ArrayList<Integer> iValor = new ArrayList<>();
        //Aniadimos los argumentos a un arrayList de integer directamente
        for(int i = 0; i<args.length;i++)
            iValor.add(Integer.parseInt(args[i]));

        //Hacemos el calculo de la moda
        System.out.println("La moda es: "+mdCalcularModa(iValor));
        //Hacemos el calculo de la media
        System.out.println("La media es: "+mdCalcularMedia(iValor));
        
    }//main()
    static double mdCalcularMedia(ArrayList<Integer> ialNumeros){
        double dResultado = 0.0;
        int iSumaNumeros = 0;

        for (int i:ialNumeros)
            iSumaNumeros +=i;

        dResultado = (double)iSumaNumeros/ialNumeros.size();
        return dResultado;
    }//mdCalcularMedia()

    static double mdCalcularModa(ArrayList<Integer> ialNumeros){
        int iMaxRep= 0;
        double dModa= 0;

        for(int i:ialNumeros){
            int iRep= 0;
            for(int j:ialNumeros){
                if(i==j)
                    iRep++;
                if(iRep>iMaxRep){
                    dModa = i;
                    iMaxRep = iRep;
                }//if
            }//for j
        }//for i
        return dModa;
    }//mdCalcularModa()
}//CConjunto