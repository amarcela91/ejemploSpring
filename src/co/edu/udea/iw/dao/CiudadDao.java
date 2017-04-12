package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.dto.Ciudad;

/**
 * Interface que me define los metodos permitidos para las ciudades
 * en el sistema
 *  @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public interface CiudadDao {
	/**Obtiene las listas de Ciudades que existen en el sistema
	 * ordenadas alfabeticamente por el nombre
	 * @return Lista de ciudades ordenadas
	 * @throws MyException ocurre cuando hay problemas con la conexion a la BD
	 */
	public List<Ciudad> get() throws MyException;
	
	/**
	 * Obtiene la informacion de una ciudad dado su codigo
	 *@param codigo codigo de la ciudad
	 *@return objeto ciudad con la informacion almacenada
	 *@throws MyException ocurre cuando hay un error consultando la informacion
	 * */
	public Ciudad get(int codigo) throws MyException;
	
	/**
	 * Almacena los datos de una ciudad en la BD
	 * @param ciudad objeto (@Ciudad) con la informacion a almacenar
	 * @throws MyException cuando hay un error
	 * */
	public void insert(Ciudad ciudad)throws MyException;
	
	/**
	 * modifica los datos de una ciudad en la BD
	 * @param ciudad objeto (@Ciudad) con la informacion a modificar
	 * @throws MyException cuando hay un error al modificar
	 * */
	public void update(Ciudad ciudad)throws MyException;
	
	/**
	 * elemina los datos de una ciudad en la BD
	 * @param ciudad objeto (@Ciudad) con la informacion a eliminar
	 * @throws MyException cuando hay un error eliminando
	 * */
	public void delete(Ciudad ciudad)throws MyException;

}
