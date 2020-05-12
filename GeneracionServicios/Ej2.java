/*
. Crear un programa Java que acepte dos parámetros de entrada:
 Una URL que corresponda a un documento HTML
 Una etiqueta HTML
Como resultado, el programa debe sacar por la salida estándar 
cuántas etiquetas hay en esa página html
*/
package GeneracionServicios;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.FileReader;
import java.io.EOFException;
import java.io.File;
/*
https://www.bde.es/bde/es/
*/
public class Ej2{
    public static void main(String[] args) {
        //Recogemos los datos de la consola
        String sURL = args[0];
        String sEtiqueta = args[1];
        /*
            Instanciamos la clase y llamamos al metodo mvBuscarEtiquetas para
            descargar el html y al otro metodo msBusquedaEtiqueta para mostrar
            las lineas en las que se encunetra ese fichero.
        */
        Ej2 ob2 = new Ej2();
        ob2.mvDescargaFichero(sURL);
        ob2.mvBusquedaEtiqueta(sEtiqueta);
    }//main()

    public void mvDescargaFichero(String url_descargar){
        try{
            //Recogemos los datos de la URL
            URL url = new URL(url_descargar);
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            
            //Escribimos la descarga en un fichero
            File f = new File("fichero.html");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea;
            while((linea=br.readLine())!=null)
                bw.write(linea);
            
            bw.close();
            fw.close();
            br.close();
            isr.close();
            is.close();
        }catch(MalformedURLException url){
            System.out.println(url);
        }catch(IOException e){
            System.out.println(e);
        }//try-catch
    }//mvDescargaFichero

    public void mvBusquedaEtiqueta(String etiqueta){
        try{
            FileReader fr = new FileReader("fichero.html");
            BufferedReader br = new BufferedReader(fr);
            int iCOntadorEtiquetas = 0;
            String linea;
            try{
                System.out.println("Buscando...");
                while((linea=br.readLine())!=null){
                    if(linea.contains(etiqueta)){ //si la línea contiene el texto buscado se aumenta el contador
                       // System.out.println(linea);
                        iCOntadorEtiquetas++;
                    }//if
                    linea = br.readLine();
                }//while
            }catch(EOFException eof){
                System.out.println("Fin de fichero");
            }//try-catch
            System.out.println("Se han encontrado "+iCOntadorEtiquetas+" etiquetas!");
            br.close();
            fr.close();
        }catch(IOException io){
            System.out.println(io);
        }//try-catch
    }//mvBusquedaEtiqueta()
}//BuscardorEtiquetas
