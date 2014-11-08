package com.group.DAO;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.group.model.GroupStudentR;

/**
 * A data access object (DAO) providing persistence and search support for
 * GroupStudentR entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.group.model.GroupStudentR
 * @author MyEclipse Persistence Tools
 */
public class GroupStudentRDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(GroupStudentRDAO.class);

	// property constants

	public void save(GroupStudentR transientInstance) throws RuntimeException{
		log.debug("saving GroupStudentR instance");
		Transaction tx = getSession().beginTransaction();
		getSession().save(transientInstance);
		log.debug("save successful");
		tx.commit();
		getSession().flush();
		getSession().close();
	}

	public void delete(GroupStudentR persistentInstance) {
		log.debug("deleting GroupStudentR instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GroupStudentR findById(java.lang.Integer id) {
		log.debug("getting GroupStudentR instance with id: " + id);
		try {
			GroupStudentR instance = (GroupStudentR) getSession().get(
					"com.group.model.GroupStudentR", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(GroupStudentR instance) {
		log.debug("finding GroupStudentR instance by example");
		try {
			List results = getSession()
					.createCriteria("com.group.model.GroupStudentR")
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
		log.debug("finding GroupStudentR instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from GroupStudentR as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all GroupStudentR instances");
		try {
			String queryString = "from GroupStudentR";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GroupStudentR merge(GroupStudentR detachedInstance) {
		log.debug("merging GroupStudentR instance");
		try {
			GroupStudentR result = (GroupStudentR) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GroupStudentR instance) {
		log.debug("attaching dirty GroupStudentR instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GroupStudentR instance) {
		log.debug("attaching clean GroupStudentR instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}