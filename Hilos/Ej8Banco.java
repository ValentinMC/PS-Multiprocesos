package Hilos;

public class Ej8Banco {
    // Usare integers ya que los numeros del ejercicio
    // son redondos y no se juega con decimales
    private int iDineroBanco;

    public Ej8Banco() {
        this.setiDineroBanco(500);
    }// Constructor Banco

    public int getiDineroBanco() {
        return iDineroBanco;
    }

    public void setiDineroBanco(int iDineroBanco) {
        this.iDineroBanco = iDineroBanco;
    }

}//Ej8Banco