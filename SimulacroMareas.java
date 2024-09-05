import java.util.Scanner;

public class SimulacroMareas 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in); //Scanner para entrada de datos.
        int fechaActual = 0, ultimaFecha = 0; //fecha actual y la última.
        double alturaMinima, alturaMaxima, diferencia = 0; //máx y min y su diferencia.
        int fechaMayorDiferencia = 0; //Fecha donde hubo piu diferencia.
        double mayorDiferencia = 0; //El valor de mayor diferencia.
        boolean hayDatos = false; //Información sobre si hay o no datos.

        //Comenzamos el programa pidiendo la fecha, el dato de entrada.
        System.out.print("Ingresa la fecha (AA/MM/DD) o -1 para finalizar: ");
        fechaActual = scanner.nextInt(); 

        //Mientras se ingrese un número != a -1 se ejecutará el bloque de código. El usuario indica que no quiere acabar el programa.
        while (fechaActual != -1) 
        {
        	//Si el numero ingresado es mayor al ultimoNumero ingresado o 0 en la primera iteración se ejecuta el programa.
            if (fechaActual > ultimaFecha) 
            {
            	//Pedimos el mín y máx de la marea.
                System.out.print("Ingresa la altura mínima de la marea: ");
                alturaMinima = scanner.nextDouble();
                System.out.print("Ingresa la altura máxima de la marea: ");
                alturaMaxima = scanner.nextDouble();

                //La altura mínima siempre debe ser menor o igual a la máxima por lo tanto si..
                if (alturaMinima > alturaMaxima) //se confundió e invertió los ingresos, los intercambiamos para que estén correctos.
                {
                    System.out.println("Las alturas están invertidas. Se intercambiarán.");
                    double temp = alturaMinima; //Variable auxiliar para no perder el valor al hacer el primer cambio.
                    alturaMinima = alturaMaxima;
                    alturaMaxima = temp; //alturaMinima almacenada en la var temporal ya que se perdió el valor en la línea anterior.
                }

                //Sacamos la diferencia de la altura.
                diferencia = alturaMaxima - alturaMinima; 

                //Salimos todos los datos pedidos.
                System.out.println("Fecha: " + fechaActual);
                System.out.println("Marea mínima: " + alturaMinima);
                System.out.println("Marea máxima: " + alturaMaxima);
                System.out.println("Diferencia: " + diferencia);
                System.out.println(" ");

                //Evaluamos si la diferencia actual es récord y actualizamos los registros de ser así, para la primer iteración se cumplirá por la primer condición.
                if (!hayDatos || diferencia > mayorDiferencia) 
                {
                    mayorDiferencia = diferencia; //Almacenamos el nuevo récord.
                    fechaMayorDiferencia = fechaActual; //Guardamos la fecha en la que sucedió.
                }

                hayDatos = true; //Nos aseguramos que a partir de ahora el anterior IF solo se pueda cumplir con la segunda condició
                ultimaFecha = fechaActual; //Actualizamos.
            } 
            else //Si no es mayor a 0 (ingresó número negativo)
            {
            	System.out.println("");
                System.out.println("Error: La fecha debe ser mayor que la anterior."); //Se lo indicamos 
            }

            System.out.print("Ingresa la fecha (AAAAMMDD) o -1 para finalizar: "); 
            fechaActual = scanner.nextInt();//Le volvemos a pedir el ingreso del número por cualquiera de las 2 bifuraciones.
        }

        //Al finalizar el bucle (ingreso de -1) evaluamos si se obtuvieron datos correctos en al menos una iteración
        if (hayDatos) 
        {
        	System.out.println("");
            System.out.println("La mayor diferencia de marea ocurrió el: " + fechaMayorDiferencia); //Devolvemos el día récord.
        } 
        else 
        {
        	System.out.println("");
            System.out.println("No hay suficientes datos procesados.");
        }

        scanner.close(); //Cerramos el Scanner por buena práctica.
	}
}
