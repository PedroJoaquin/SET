/**Universidad Del Valle de Guatemala 
 *Algoritmos y Estructura de Datos 
 *Seccion 10- Hoja de Trabajo 6
 *------------------------------------------------------------------
 *@author
 *Pedro Joaquin Castillo 14224
 *Christopher Aju 13
 *------------------------------------------------------------------
 *Factory:Esta clase tiene como función generar instancias de la
 *implementacion de Set que se desea utilizar para el almacenamiento
 *de los datos  
 **/

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class Factory<E> {
	
	
	/**
	 * Metodo seleccion: Este método tiene como funcion retornar una intancia
	 * de la implementacion Set seleccionada con el parametro x 
	 * @param x 
	 * Indica que instancia generar
	 * @return
	 * Retorna un objeto tipo Set<E> 
	 */
	public Set<E> seleccion(int x){
		if(x==1){
				return new HashSet<E>();
		}
		else if(x==2){
				return new TreeSet<E>();
		}
		else if(x==3){
				return new LinkedHashSet<E>();
		}
		else
			return null; 
	}
}
