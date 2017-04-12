package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDAOHibernate implements CiudadDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Ciudad> get() throws MyException {
		Session session=null;
		Criteria criteria=null;
		List<Ciudad> ciudades= new ArrayList<Ciudad>();
		
		try{
			session=sessionFactory.getCurrentSession();
			
			criteria=session.createCriteria(Ciudad.class);
			
			ciudades=criteria.list();
			
			
		}catch (HibernateException e){
			throw new MyException("Error al consultar las ciudades",e);
		}
		
		return ciudades;
	}

	@Override
	public Ciudad get(int codigo) throws MyException {
		Session session=null;
		Criteria criteria=null;
		Ciudad ciudad= null;
		
		//SELECT FROM Ciudades where Codigo=?
		try{
			session=sessionFactory.getCurrentSession();
			
			//1. consultando ciudades con criteria:
			//criteria=session.createCriteria(Ciudad.class);
			//criteria.add(Restrictions.eq("codigo",codigo));
			//ciudad=(Ciudad)criteria.uniqueResult();
			
			//2.la segunda forma utilizando metodo get
			//si no existe en la BD Retorna nulo
			//ciudad=(Ciudad)session.get(Ciudad.class, codigo);
			
			//3.la tercera forma utilizando metodo load
			//si no existe en retorna una excepcion
			
			//utilizando el metodo get (2)
			ciudad=(Ciudad)session.get(Ciudad.class, codigo);
			
			//utilizando el metodo load
			//ciudad=(Ciudad)session.load(Ciudad.class, codigo);
			
		}catch (HibernateException e){
			throw new MyException("Error al consultar las ciudades",e);
		}
		
		return ciudad;
	}
	
	@Override
	public void insert(Ciudad ciudad) throws MyException {
		Session session=null;
				
		try{
			session=sessionFactory.getCurrentSession();
			session.save(ciudad);
												
		}catch (HibernateException e){
			throw new MyException("Error al almacenar una ciudad",e);
		}
		
	}
	
	public void update(Ciudad ciudad) throws MyException {
		Session session=null;		
		
		try{
			session=sessionFactory.getCurrentSession();
			session.update(ciudad);			
									
		}catch (HibernateException e){
			throw new MyException("Error al modificar una ciudad",e);
		}
		
	}
	
	
	public void delete(Ciudad ciudad) throws MyException {
		Session session=null;				
		
		try{
			session=sessionFactory.getCurrentSession();
			session.delete(ciudad);
												
		}catch (HibernateException e){
			throw new MyException("Error eliminando una ciudad",e);
		}
		
	}


}
