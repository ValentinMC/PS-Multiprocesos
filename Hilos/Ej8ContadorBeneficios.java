package Hilos;

public class Ej8ContadorBeneficios {
    private int iEurosGrupo;

    public Ej8ContadorBeneficios() {
        this.setiEurosGrupo(0);
    }// Constructor vacio

    public int getiEurosGrupo() {
        return iEurosGrupo;
    }//GETTER iEurosGrupo

    public void setiEurosGrupo(int iEurosGrupo) {
        this.iEurosGrupo += iEurosGrupo;
    }//SETTER iEurosGrupo

    public synchronized void setAumentoiEurosGrupo(int iEurosGrupo) {
        this.iEurosGrupo += iEurosGrupo;
    }//SETTER iEurosGrupo
}//Ej8ContadorBeneficios