package co.edu.udea.iw.dao.hibernate;


import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dao.hibernate.CiudadDAOHibernate;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * Clase CiudadDAOImplTest implementa la clase CiudadDao.
 * mostrando el codigo y nombre de la ciudad en consola.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class CiudadDAOImplTest {

	@Autowired
	CiudadDao ciudadDao; //lo inyecta con el frijolito que creamos en configuracion.xml
	
	@Test
	/**
	 * Metodo que realiza el test del proyecto.
	 */
	public void testGet() {
		
		List<Ciudad> ciudades=null;
		
		try{
			ciudades=ciudadDao.get();
			
			for(Ciudad ciudad: ciudades){
				System.out.println(ciudad.getCodigo() +" : " +ciudad.getNombre());
			}
			
			assertTrue(ciudades.size()>0);
			
		}catch (MyException e){
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUno(){
		Ciudad ciudad=null;
		
		try{
			ciudad=ciudadDao.get(1000);
			assertNotNull(ciudad);
			
			System.out.println(ciudad.getCodigo() +" : " +ciudad.getNombre());
			
			
			
		}catch (MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testInsert(){
		
		Ciudad ciudad=new Ciudad();
		
		try{
			ciudad.setCodigo(5);
			ciudad.setNombre("Baranoa");
			ciudad.setCodigoArea("07");
			
			ciudadDao.insert(ciudad);		
						
			
		}catch (MyException e){
			fail(e.getMessage());
		}
		
	}
	
	
	

}
