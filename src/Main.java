/**Universidad Del Valle de Guatemala 
 *Algoritmos y Estructura de Datos 
 *Seccion 10- Hoja de Trabajo 6
 *------------------------------------------------------------------
 *@author
 *Pedro Joaquin Castillo 14224
 *Christopher Aju 13
 *------------------------------------------------------------------
 *Main: Clase encargada de la interaccion entre el programa
 *y el usuario 
 **/


import java.util.Scanner;
/**
 * @author PedroJoaquin
 * Main: Este metodo ejecuta el programa y pregunta al usuario diferentes
 * preguntas que debe responder para ingresar la informacion de forma 
 * correcta 
 *
 */

public class Main {
	public static void main(String[] args){
		int a = 0;
		Scanner teclado = new Scanner(System.in); //Se crea un objeto Scanner
		//int ver =0; 
		//Bienvenida al Programa 
		System.out.println("BIENVENIDO AL ORGANIZADOR DE DESARROLLADORES\nELIJA LA IMPLEMENTACION DE SET QUE DESEA UTILIZAR:\n");
		//------------------------ ELECCION DE IMPLEMENTACION A UTILIZAR --------------------------------------------
		while(a==0){
			System.out.println("1.HASHSET\n2.TREESET\n3.LINKEDHASHSET\nINGRESE SU OPCION: ");
			String opcion = teclado.nextLine();
			a = verificar(opcion);
		}	
		Organizador organizador = new Organizador(a);	//Se crea un nuevo objeto de tipo Organizador, encargado de crear los conjuntos 
		int b=0; 										//con las implementaciones correspondientes
		//------------------------------ INGRESO DE DATOS DE LOS DESARROLLADORES -------------------------------------
		while(b==0){
			System.out.println("INGRESE NOMBRE DEL DESARROLLADOR: ");		//Ingreso del Nombre 
			String nombre = teclado.nextLine();
			a=0;
			while (a==0){														//¿Es desarrollador de Java?												
				System.out.println("¿ES DESARROLLADOR DE JAVA?\n1.Si\n2.No");
				String seleccion = teclado.nextLine();
				a = verificar2(seleccion);
			}
			if(a==1)
				organizador.guardarJava(nombre);
			a=0;
			while(a==0){													//¿Es desarrollador Web?
				System.out.println("¿ES DESARROLLADOR WEB?\n1.Si\n2.No");
				String seleccion = teclado.nextLine();
				a = verificar2(seleccion);
			}
			if(a==1)
				organizador.guardarWeb(nombre);
			a=0;
			while(a==0){														//Es desarrollador de celulares 
				System.out.println("¿ES DESARROLLADOR DE CELULARES?\n1.Si\n2.No");
				String seleccion = teclado.nextLine();
				a = verificar2(seleccion);
			}
			if(a==1)
				organizador.guardarCel(nombre);
			a=0;
			while(a==0){														//Se da la opcion de ingresar otro desarrollador 
				System.out.println("¿DESEA INGRESAR OTRO NOMBRE?\n1.Si\n2.No");	//o de finalizar el ingreso de datos 
				String seleccion = teclado.nextLine();
				a = verificar2(seleccion);
			}
			if(a==2)
				b=1;												//Si termino de ingresar datos se modifica el valor de b para el 
		}															//el despliegue de resultados
		
		//-------------------------------------- CREACION DE SUBCONJUNTOS -------------------------------------------------
			organizador.javaWebCel();			//Se ejecutan los diferentes metodos de ordenamiento de la clase
			organizador.javaNoWeb();			//Organizador 
			organizador.webCel();
			organizador.webOCel();
			
		//-------------------------------------- IMPRESION DE RESULTADOS ------------------------------------------------------
			System.out.println("------------------------------------------ RESULTADOS ----------------------------------------------");
			System.out.println("DESARROLLADORES CON EXPERIENCIA JAVA, WEB Y CELULARES"); //Desarrolladores de JAVA, Web y Celulares
			if(!organizador.getJavaWebCel().isEmpty()){							 //Se verifica que el HashSet correspondiente no este vacio 
				for(String temp : organizador.getJavaWebCel()){					
					System.out.println(temp);								//Si no esta vacio se imprime su contenido 
				}
			}
			else
				System.out.println("NINGUNO");							//De estar vacio se imprime que esta vacio 
			
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("DESARROLLADORES CON EXPERIENCIA JAVA PERO NO EN WEB");
			if(!organizador.getJavaNoWeb().isEmpty()){					//Se repite el mismo procedimiento con todos los conjuntos 
				for(String temp : organizador.getJavaNoWeb()){
					System.out.println(temp);
				}
			}
			else
				System.out.println("NINGUNO");
			
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("DESARROLLADORES CON EXPERIENCIA EN WEB Y CELULARES PERO NO EN JAVA");
			if(!organizador.getWebCel().isEmpty()){						//Mismo procedimiento 
				for(String temp : organizador.getWebCel()){
					System.out.println(temp);
				}
			}
			else
				System.out.println("NINGUNO");
			
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("DESARROLLADORES CON EXPERIENCIA EN WEB O CELULARES PERO NO EN JAVA");
			if(!organizador.getWebOCel().isEmpty()){					//Mismo procedimiento 
				for(String temp : organizador.getWebOCel()){		
					System.out.println(temp);
				}
			}
			else 
				System.out.println("NINGUNO");
			
			System.out.println("----------------------------------------------------------------------------------------------------");
			if(organizador.javaSubWeb())					//Se ejecuta el metodo que determina si Java es subconjunto de WEB
				System.out.println("EL CONJUNTO DE DESARROLLADORES JAVA ES UN SUBCONJUNTO DE DESARROLLADORES WEB"); //Subconjunto 
			else
				System.out.println("EL CONJUNTO DE DESARROLLADORES JAVA NO ES UN SUBCONJUNTO DE DESARROLLADORES WEB"); //No Subconjunto 
			System.out.println("----------------------------------------------------------------------------------------------------");
			
			//---------------------------- DETERMINACION DEL CONJUNTO CON MAS DESARROLLADORES ----------------------------------
			if(organizador.mayorConjunto()==organizador.getJava()){						//Se verifica si el conjunto mas grande es Java
				System.out.println("EL CONJUNTO CON EL MAYOR NUMERO DE DESARROLLADORES ES JAVA");
				System.out.println("LA LISTA DE NOMBRES DESORDENADOS:");
				for(String temp : organizador.getJava()){
					System.out.println(temp);									//Impresion de integrantes de grupo desordenados 
				}
				System.out.println("----------------------------------------------------------------------------------------------------");
				System.out.println("LA LISTA DE NOMBRES ORDENADOS:");
				for (String temp : organizador.hashToTree(organizador.getJava())){
					System.out.println(temp);									//Impresion de integrantes de grupo ordenados 
				}
			}
			else if(organizador.mayorConjunto()==organizador.getWeb()){				//Se verifica si Web es el conjunto con mas desarrolladores 
					System.out.println("EL CONJUNTO CON EL MAYOR NUMERO DE DESARROLLADORES ES WEB");
					System.out.println("LA LISTA DE NOMBRES DESORDENADOS:");
					for(String temp : organizador.getWeb()){
						System.out.println(temp);
					}
					System.out.println("----------------------------------------------------------------------------------------------------");
					System.out.println("LA LISTA DE NOMBRES ORDENADOS:");
					for (String temp : organizador.hashToTree(organizador.getWeb())){
						System.out.println(temp);
					}	
			}
			else{
				System.out.println("EL CONJUNTO CON EL MAYOR NUMERO DE DESARROLLADORES ES CELULAR");
				System.out.println("LA LISTA DE NOMBRES DESORDENADOS:");
				for(String temp : organizador.getCel()){
					System.out.println(temp);
				}
				System.out.println("-------------------------------------------------------------------------------------------------------");
				System.out.println("LA LISTA DE NOMBRES ORDENADOS");
				for (String temp : organizador.hashToTree(organizador.getCel())){
					System.out.println(temp);
				}
			}
	}
			
	/**
	 * verificar: Este metodo tiene como funcion determinar que el ingreso de datos numericos
	 * sean verdaderamente datos numericos y que estos se encuentren dentro del rango de validez
	 * @param i String que se tratara de convertir en entero 
	 * @return val Valor obtenido del String 
	 */
	public  static int verificar(String i){
	    int val=0;								//Se declara una variable int 
		try {
			val= Integer.parseInt(i);			//Se intenta convertir el String a Int
			if (val>0 && val <= 3){				//Si es posible convertirlo se verifica que este en el 
				return val; 					//rango de validez. De asi, se devuelve el valor obtenido
			}
			else {								//Si no esta en rango se imprime una advertencia  y se retorna 0 
				System.err.println( "ERROR: EL NUMERO INGRESADO NO ES VALIDO " );
				val=0;
				return val; 
			} 
		}
		catch (Exception e){				//Si no es posible convertir a entero se imprime un mensaje de error y retorna 0 
			System.err.println( "CARACTER INVALIDO. POR FAVOR INGRESA UN NUMERO" );
			val=0;
			return val; 
		}
	}
	
	/**
	 * verificar2: Este metodo es el mismo que verificar, solo que  verificar2 verifica que el numero ingresado
	 * se encuentre entre otro rango de valores que verificar
	 * @param i String que contiene un posible valor numerico 
	 * @return	val Valor obtenido 
	 */
	public  static int verificar2(String i){
	    int val=0;
		try {
			val= Integer.parseInt(i);
			if (val>0 && val <= 2){
				return val; 
			}
			else {
				System.err.println("ERROR: EL NUMERO INGRESADO NO ES VALIDO");
				val=0;
				return val; 
			} 
		}
		catch (Exception e){
			System.err.println("CARACTER INVALIDO. POR FAVOR INGRESA UN NUMERO");
			val=0;
			return val; 
		}
	}
}
