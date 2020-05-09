package Sockets;
import java.io.Serializable;

public class CObjeto implements Serializable{
    private String sNombreOb;
    private int iPeso;

    public CObjeto(String isNombreOb) {
        setsNombreOb(isNombreOb);
    }// Constructor

    public String getsNombreOb() {
        return sNombreOb;
    }//Getter Nombre

    public void setsNombreOb(String sNombreOb) {
        this.sNombreOb = sNombreOb;
    }//Setter Nombre

    public int getiPeso() {
        return iPeso;
    }//Getter Peso

    public void setiPeso(int iPeso) {
        this.iPeso = iPeso;
    }//Setter Peso
    
}//CObjeto