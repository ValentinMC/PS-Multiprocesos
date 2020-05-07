package MPS;
public class COper{
    public static void main(String[] args) {
        //Recogemos los valores
        double dOperador1 = Double.parseDouble(args[0]);
        double dOperador2 = Double.parseDouble(args[1]);
        String sOperacion = args[2];

        //Hacemos la Operacion pedida
        System.out.println("El resultado es: "+ mvOperacion(dOperador1,dOperador2,sOperacion));
    }//main()
    static double mvOperacion(double idN1,double idN2,String isOperacion){
        double osResultado=0;
        switch(isOperacion){
            case "+":
                osResultado = idN1+idN2;
                break;
            case "-":
                osResultado = idN1-idN2;
                break;
            case "*":
                //La multiplicacion no funciona
                osResultado = (idN1*idN2);
                break;
        }//switch-case
        return osResultado;
    }//mvOperacion
}//COper