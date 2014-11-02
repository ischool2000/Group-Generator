package com.group.DAO;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.group.model.StudentSkillR;

/**
 * A data access object (DAO) providing persistence and search support for
 * StudentSkillR entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.group.DAO.StudentSkillR
 * @author MyEclipse Persistence Tools
 */
public class StudentSkillRDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(StudentSkillRDAO.class);
	// property constants
	public static final String SCALE = "scale";

	public void save(StudentSkillR transientInstance) {
		Transaction tx = getSession().beginTransaction();
		getSession().save(transientInstance);
		log.debug("save successful");
		tx.commit();
		getSession().flush();
		getSession().close();
	}

	public void delete(StudentSkillR persistentInstance) {
		log.debug("deleting StudentSkillR instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentSkillR findById(java.lang.Integer id) {
		log.debug("getting StudentSkillR instance with id: " + id);
		try {
			StudentSkillR instance = (StudentSkillR) getSession().get(
					"com.group.DAO.StudentSkillR", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StudentSkillR instance) {
		log.debug("finding StudentSkillR instance by example");
		try {
			List results = getSession()
					.createCriteria("com.group.DAO.StudentSkillR")
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
		log.debug("finding StudentSkillR instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StudentSkillR as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScale(Object scale) {
		return findByProperty(SCALE, scale);
	}

	public List findAll() {
		log.debug("finding all StudentSkillR instances");
		try {
			String queryString = "from StudentSkillR";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StudentSkillR merge(StudentSkillR detachedInstance) {
		log.debug("merging StudentSkillR instance");
		try {
			StudentSkillR result = (StudentSkillR) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentSkillR instance) {
		log.debug("attaching dirty StudentSkillR instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentSkillR instance) {
		log.debug("attaching clean StudentSkillR instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}