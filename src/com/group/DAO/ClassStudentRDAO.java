package com.group.DAO;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.group.model.ClassStudentR;

/**
 * A data access object (DAO) providing persistence and search support for
 * ClassStudentR entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.group.model.ClassStudentR
 * @author MyEclipse Persistence Tools
 */
public class ClassStudentRDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ClassStudentRDAO.class);

	// property constants
    public boolean isExist (ClassStudentR relation) {
        String sql = "Select * from Class_Student_R Where student_id = " + relation.getStudent().getStudentId() + 
        		" And class_id = " + relation.getClasses().getClassId();
        SQLQuery query = this.getSession().createSQLQuery(sql);
        List relationList = query.list();
        return !relationList.isEmpty();
    }

	public void save(ClassStudentR transientInstance) throws RuntimeException {
		log.debug("saving ClassStudentR instance");
		Transaction tx = getSession().beginTransaction();
		getSession().save(transientInstance);
		log.debug("save successful");
		tx.commit();
		getSession().flush();
		getSession().close();
	}

	public void delete(ClassStudentR persistentInstance) {
		log.debug("deleting ClassStudentR instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ClassStudentR findById(java.lang.Integer id) {
		log.debug("getting ClassStudentR instance with id: " + id);
		try {
			ClassStudentR instance = (ClassStudentR) getSession().get(
					"com.group.model.ClassStudentR", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ClassStudentR instance) {
		log.debug("finding ClassStudentR instance by example");
		try {
			List results = getSession()
					.createCriteria("com.group.model.ClassStudentR")
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
		log.debug("finding ClassStudentR instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ClassStudentR as model where model."
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
		log.debug("finding all ClassStudentR instances");
		try {
			String queryString = "from ClassStudentR";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ClassStudentR merge(ClassStudentR detachedInstance) {
		log.debug("merging ClassStudentR instance");
		try {
			ClassStudentR result = (ClassStudentR) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClassStudentR instance) {
		log.debug("attaching dirty ClassStudentR instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClassStudentR instance) {
		log.debug("attaching clean ClassStudentR instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}