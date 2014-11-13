package com.group.DAO;

import com.group.dataset.HibernateSessionFactory;
import org.hibernate.Session;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	private static Session session;
	public Session getSession() {
		if(session == null || !session.isOpen()){
			session = HibernateSessionFactory.getSession();

		}
		System.out.println(session.hashCode());
		return session;
	}
}