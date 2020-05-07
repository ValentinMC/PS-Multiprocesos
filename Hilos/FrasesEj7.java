package Hilos;

import java.util.ArrayList;

public class FrasesEj7{
    //Usaremos un ArrayList comun para introducir frases y extraer
    ArrayList<String> alFrases = new ArrayList<String>();

    public synchronized void mvAniadirFrase(String sFrase){
        alFrases.add(sFrase);
    }//mvAniadirFrase
    /*
    public synchronized void mvEscribirEnFichero(File f, File){
        File f = new File("frases7.txt");
        FileWriter
    }//mvEscribirEnFichero()
    */
    public synchronized String toString(){
        String frases="";
        for(String s: alFrases)
            frases+=s+"\n";
        return frases;
    }//toString()
}//FrasesEj7