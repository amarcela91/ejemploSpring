package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Interface con los metodos DAO para Usuario
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 */
public interface UsuarioDAO {
	
	/**
	 * Entrega la informacion de un usuario dado su login
	 * @param login login del usuario
	 * @return datos del usuario
	 * @throws MyException cuando hay un error consultando
	 */
	public Usuario get(String login) throws MyException;
	

}
