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
        String respuesta= "En la mochila de "+getsNombre()+" hay: \n";
        for(CObjeto ob: getaListaObjetos())
            respuesta+=ob.getsNombreOb()+" que pesa "+ob.getiPeso()+" gramos \n";
        return respuesta;
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
}//CMochila