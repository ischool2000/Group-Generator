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

import com.group.model.Professor;

/**
 * A data access object (DAO) providing persistence and search support for
 * Professor entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.group.model.Professor
 * @author MyEclipse Persistence Tools
 */
public class ProfessorDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ProfessorDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String EMAIL = "email";

	public void save(Professor transientInstance) throws RuntimeException{
		log.debug("saving Professor instance");
		
			Transaction tx = getSession().beginTransaction();
			getSession().save(transientInstance);
			log.debug("save successful");
			tx.commit();
			getSession().flush();
			getSession().close();
	}

	public void delete(Professor persistentInstance) {
		log.debug("deleting Professor instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Professor findById(java.lang.Integer id) {
		log.debug("getting Professor instance with id: " + id);
		try {
			Professor instance = (Professor) getSession().get(
					"com.group.model.Professor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Professor instance) {
		log.debug("finding Professor instance by example");
		try {
			List results = getSession()
					.createCriteria("com.group.model.Professor")
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
		log.debug("finding Professor instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Professor as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			//getSession().close();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findAll() {
		log.debug("finding all Professor instances");
		try {
			String queryString = "from Professor";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Professor merge(Professor detachedInstance) {
		log.debug("merging Professor instance");
		try {
			Professor result = (Professor) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Professor instance) {
		log.debug("attaching dirty Professor instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Professor instance) {
		log.debug("attaching clean Professor instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}