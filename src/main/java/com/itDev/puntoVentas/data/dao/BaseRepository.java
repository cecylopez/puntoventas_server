package com.itDev.puntoVentas.data.dao;




import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class BaseRepository<T> {

	public static final String PERSISTENCE_UNIT = "puntoventas_db";
	protected EntityManager eMgr;
	protected Class<T> clase;
	
	public T get(long id) {
		T t=null;
		TypedQuery<T> qry= eMgr.createQuery("SELECT o FROM "+ clase.getSimpleName() + " o WHERE o.id= :id", clase);
		qry.setParameter("id", id);
		t= qry.getSingleResult();
		return t;
	}
	
	public void close() {
		if (eMgr != null) {
			if(eMgr.isOpen()) {
				eMgr.close();
			}
			eMgr= null;
		}
	}
	
	public void add (T t) {
		eMgr.getTransaction().begin();
		eMgr.persist(t);
		eMgr.getTransaction().commit();
	}
	
	public void update(T t) {
		eMgr.getTransaction().begin();
		eMgr.merge(t);
		eMgr.getTransaction().commit();
	}
	
	public void delete(T t) {
		eMgr.getTransaction().begin();
		eMgr.remove(t);
		eMgr.getTransaction().commit();
	}
	
}
