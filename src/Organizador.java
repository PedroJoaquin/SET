import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**Universidad Del Valle de Guatemala 
 *Algoritmos y Estructura de Datos 
 *Seccion 10- Hoja de Trabajo 6
 *------------------------------------------------------------------
 *@author
 *Pedro Joaquin Castillo 14224
 *Christopher Aju 13
 *------------------------------------------------------------------
 *Organuzador: Esta clase tiene como funcion desarrollar
 *los metodos que se utilizaran para guardar y ordenar los
 *datos para desplegarlos en la forma correcta 
 **/

/**
 * @author PedroJoaquin
 *
 */
/**
 * @author PedroJoaquin
 *
 */
public class Organizador {
	
	HashSet<String> JavaWebCel;
	HashSet<String> JavaNoWeb; 
	HashSet<String> WebCel;
	HashSet<String> WebOCel; 
	Set<String> java;
	Set<String> web;
	Set<String> cel; 
	
	/**
	 * Organizador: Constructor de la clase que se encarga de crear
	 * una instancia del Factory y asignarle un objeto retornado de
	 * Factory a cada uno de los conjuntos Set dependiendo del parametro. 
	 * @param i
	 * 
	 * Permite determinar que tipo de objetos se asignara a los conjuntos 
	 */
	public Organizador(int i){
		JavaWebCel = new HashSet<String>();
		JavaNoWeb = new HashSet<String>();
		WebCel = new HashSet<String>();
		WebOCel = new HashSet<String>();
		Factory <String> factory = new Factory<String>();
		java = factory.seleccion(i);
		web = factory.seleccion(i);
		cel = factory.seleccion(i);
	}
	
	/**
	 * Permite obtener el conjunto JavaWebCel
	 * @return HashSet JavaWebCel 
	 */
	public Set<String> getJavaWebCel(){
		return JavaWebCel;
	}
	
	/**
	 * Permite obtener el conjunto JavaNoWeb
	 * @return HashSet JavaNoWeb
	 */
	public Set<String> getJavaNoWeb(){
		return JavaNoWeb;
	}
	
	/**
	 * Permite obtentes el conjunto WebCel
	 * @return HashSet WebCel 
	 */
	public Set<String> getWebCel(){
		return WebCel;
	}
	
	/**
	 * Permite obtener el conjunto WebOCel 
	 * @return Hashset WebOCel 
	 */
	public Set<String> getWebOCel(){
		return WebOCel;
	}
	
	/**
	 * Permite obtener el conjunto java
	 * @return HashSet java
	 */
	public Set<String> getJava(){
		return java;
	}
	
	/**
	 * Permite obtener el conjunto web
	 * @return HashSet web
	 */
	public Set<String> getWeb(){
		return web;
	}
	
	/**
	 * Permite obtener el conjunto cel 
	 * @return hashset cel 
	 */
	public Set<String> getCel(){
		return cel;
	}
	
	
	/**
	 * guardarJava: Este metodo tiene como funcion guardar un 
	 * elemento en el conjunto de Desarrolladores de Java 
	 * @param i
	 * Este parametro indica el objeto a almacenar 
	 */
	public void guardarJava(String i){
		java.add(i);
	}

	/**
	 * guardarWeb: Este metodo tiene como funcion guardar un 
	 * elemento en el conjunto de Desarrolladores Web 
	 * @param i
	 * Este parametro indica el objeto a almacenar 
	 */
	public void guardarWeb(String i){
		web.add(i);
	}
	
	/**
	 * guardarCel: Este metodo tiene como funcion guardar un 
	 * elemento en el conjunto de Desarrolladores celulares 
	 * @param i
	 * Este parametro indica el objeto a almacenar 
	 */
	public void guardarCel(String i){
		cel.add(i);
	}
	
	/**
	 * JavaWebCel: Este metodo tiene como funcion almacenar en el
	 * HashSet JavaWebCel a los desarrolladores que se encuentran 
	 * en los tres conjuntos 
	 */
	public void javaWebCel(){
		String[] temp = new String[java.size()];
		java.toArray(temp);
		for(int i=0; i<temp.length;i++){
			if(web.contains(temp[i]) && cel.contains(temp[i])){
					JavaWebCel.add(temp[i]);
			}
		}
	}
	
	/**
	 * JavaNoWeb: Este metodo tiene como funcion alamcenar en el 
	 * HashSet JavaNoWeb el nombre de los desarrolladores que tienen
	 * experiencia en Java pero no en desarrollo Web 
	 */
	public void javaNoWeb(){
		String[] temp = new String[java.size()];
		java.toArray(temp);
		for(int i=0; i<temp.length;i++){
			if(!web.contains(temp[i])){
				JavaNoWeb.add(temp[i]);
			}
		}
	}
	
	/**
	 * WebCel: Este metodo tiene como funcion almacenar en el 
	 * HashSet WebCel el nombre de los desarrolladores que tienen
	 * experiencia en desarrollo Web y Celular pero no en Java
	 */
	public void webCel(){
		String[] temp = new String[web.size()];
		web.toArray(temp);
		for(int i=0;i<temp.length;i++){
			if(cel.contains(temp[i])){
				if(!java.contains(temp[i])){
					WebCel.add(temp[i]);
				}
			}
		}
	}
	
	/**
	 * webOCel: Este metodo tiene como funcion almacenar en el 
	 * HashSet WebOCel el nombre de los desarrolladores que tienen
	 * experiencia en desarrollo Web o Celular pero no en Java
	 */
	public void webOCel(){
		String[] temp = new String[web.size()];
		web.toArray(temp);
		for(int i=0;i<temp.length;i++){
			if(!java.contains(temp[i])){
				WebOCel.add(temp[i]);
			}
		}
		String[] temp2 = new String[cel.size()];
		cel.toArray(temp2);
		for(int i=0;i<temp2.length;i++){
			if(!java.contains(temp2[i])){
				WebOCel.add(temp2[i]);
			}
		}
	}
	
	/**
	 * Este metodo tiene como funcion determinar si el conjunto 
	 * de desarrolladores de Java es un subconjunto del conjunto
	 * de desarrolladores Web
	 * @return
	 * Retorna True si es un subconjunto
	 * Retorna False si no es un subconjunto 
	 */
	public boolean javaSubWeb(){
		int contador=0;
		String[] temp = new String[java.size()];
		java.toArray(temp);
		for(int i=0;i<temp.length;i++){
			if(web.contains(temp[i])){
				contador++;
			}
		}
		if(contador==temp.length){
			return true;
		}
		else
			return false;
	}
	
	/**
	 * mayorConjunto: Este metodo tiene como funcion determinar cual es el conjunto
	 * con el mayor numero de desarrolladores
	 * @return El HashSet con el mayor nnumero de desarrolladores 
	 */
	public Set<String> mayorConjunto(){
		if(java.size()>web.size() && java.size()>cel.size()){
			return java;
		}
		else if(web.size()>java.size() && web.size()>cel.size()){
			return web;
		}
		else if(cel.size()>java.size() && cel.size()>web.size()){
			return cel;
		}
		else 
			return null; 
	}
	
	/**
	 * hashToSet: Este metodo tiene como funcion convertir un HashSet 
	 * a un TreeSet y de esta forma ordenar los elementeos dentro del
	 * Hash 
	 * @param i HashSet que se desea convertir 
	 * @return El TreeSet generado con el HashSet
	 */
	public Set<String> hashToTree(Set<String> i){
		TreeSet<String> temp = new TreeSet<String>(i);
		return temp; 
	}

}
