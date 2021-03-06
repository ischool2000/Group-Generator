package com.group.DAO;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.group.model.Class;
/**
 * A data access object (DAO) providing persistence and search support for Class
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.group.model.Class
 * @author MyEclipse Persistence Tools
 */
public class ClassDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ClassDAO.class);
	// property constants
	public static final String NAME = "name";
	
	public void save(com.group.model.Class classes) throws RuntimeException{
		Transaction tx = getSession().beginTransaction();
		log.debug("saving Class instance");
		
			getSession().save(classes);
			
			log.debug("save successful");
		tx.commit();
		getSession().flush();
		getSession().close();
	}

	public void delete(Class classes) throws RuntimeException{
		log.debug("deleting Class instance");
		Transaction tx = getSession().beginTransaction();
		getSession().delete(classes);
		log.debug("delete successful");
		tx.commit();
		getSession().flush();
		getSession().close();
	}

	public com.group.model.Class findById(java.lang.Integer id) {
		log.debug("getting Class instance with id: " + id);
		try {
			Class instance = (Class) getSession()
					.get("com.group.model.Class", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Class instance) {
		log.debug("finding Class instance by example");
		try {
			List results = getSession().createCriteria("com.group.model.Class")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Class instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Class as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Class instances");
		try {
			String queryString = "from Class";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Class merge(Class detachedInstance) {
		log.debug("merging Class instance");
		try {
			Class result = (Class) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Class instance) {
		log.debug("attaching dirty Class instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Class instance) {
		log.debug("attaching clean Class instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}