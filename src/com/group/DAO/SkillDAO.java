package com.group.DAO;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.w3c.dom.ranges.RangeException;

import com.group.model.Skill;

/**
 * A data access object (DAO) providing persistence and search support for Skill
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.group.model.Skill
 * @author MyEclipse Persistence Tools
 */
public class SkillDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(SkillDAO.class);
	// property constants
	public static final String NAME = "name";

	public void save(Skill transientInstance) throws Exception{
		log.debug("saving Skill instance");
		Transaction tx = getSession().beginTransaction();
		getSession().save(transientInstance);
		log.debug("save successful");
		tx.commit();
		getSession().flush();
		getSession().close();
	}

	public void delete(Skill persistentInstance) {
		log.debug("deleting Skill instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Skill findById(java.lang.Integer id) {
		log.debug("getting Skill instance with id: " + id);
		try {
			Skill instance = (Skill) getSession()
					.get("com.group.model.Skill", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Skill instance) {
		log.debug("finding Skill instance by example");
		try {
			List results = getSession().createCriteria("com.group.model.Skill")
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
		log.debug("finding Skill instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Skill as model where model."
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
		log.debug("finding all Skill instances");
		try {
			String queryString = "from Skill";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Skill merge(Skill detachedInstance) {
		log.debug("merging Skill instance");
		try {
			Skill result = (Skill) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Skill instance) {
		log.debug("attaching dirty Skill instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Skill instance) {
		log.debug("attaching clean Skill instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}