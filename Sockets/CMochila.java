package Sockets;
import java.io.Serializable;
import java.util.ArrayList;

public class CMochila implements Serializable{
    private String sNombre;
    private ArrayList<CObjeto> aListaObjetos;

    public CMochila(String isNombre, ArrayList<CObjeto> ialListaObjetos){
        sNombre = isNombre;
        aListaObjetos = ialListaObjetos;
    }//CMochila

    public String toString(){
        StringBuilder respuesta= new StringBuilder("En la mochila de " + getsNombre() + " hay: \n");
        for(CObjeto ob: getaListaObjetos())
            respuesta.append(" -").append(ob.getsNombreOb()).append(" que pesa ").append(ob.getiPeso()).append(" gramos \n");
        return respuesta.toString();
    }//toString()
    public String getsNombre() {
        return sNombre;
    }//Getter Nombre

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }//Setter Nombre
    public ArrayList<CObjeto> getaListaObjetos() {
        return aListaObjetos;
    }//Getter ArrayL

    public void setaListaObjetos(ArrayList<CObjeto> aListaObjetos) {
        this.aListaObjetos = aListaObjetos;
    }//Setter ArrayL
    public void setPesoObjetos(CObjeto ob,int iiPeso){
        ob.setiPeso(iiPeso);
    }//setPeso

    public String msCalcularPesoTotal(){
        int iPesoTotal = 0;
        for(CObjeto o : aListaObjetos)
            iPesoTotal += o.getiPeso();
        return "El peso TOTAL de la mochila es :"+iPesoTotal+" gr.";
    }//msCalcularPesoTotal
}//CMochila