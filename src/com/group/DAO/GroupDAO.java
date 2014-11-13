package com.group.DAO;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.group.model.ClassStudentR;
import com.group.model.Group;

/**
 * A data access object (DAO) providing persistence and search support for Group
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.group.model.Group
 * @author MyEclipse Persistence Tools
 */
public class GroupDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(GroupDAO.class);
	// property constants
	public static final String NAME = "name";
	
	public void save(Group transientInstance) throws RuntimeException{
		log.debug("saving Group instance");
		Transaction tx = getSession().beginTransaction();
		getSession().save(transientInstance);
		log.debug("save successful");
		tx.commit();
		getSession().flush();
		getSession().close();
	}
	
	public int deleteByProjectId(int projectId) {
		
		 String sql = "Delete from `Group` Where project_id = " + projectId;
		 int query =this.getSession().createSQLQuery(sql).executeUpdate();  
	       this.getSession().flush(); //清理缓存，执行批量插入  
	        this.getSession().clear(); //清空缓存中的 对象 
	     return query;
		
	}
	
	public void delete(Group persistentInstance) {
		log.debug("deleting Group instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Group findById(java.lang.Integer id) {
		log.debug("getting Group instance with id: " + id);
		try {
			Group instance = (Group) getSession()
					.get("com.group.model.Group", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Group instance) {
		log.debug("finding Group instance by example");
		try {
			List results = getSession().createCriteria("com.group.model.Group")
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
		log.debug("finding Group instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Group as model where model."
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
		log.debug("finding all Group instances");
		try {
			String queryString = "from Group";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Group merge(Group detachedInstance) {
		log.debug("merging Group instance");
		try {
			Group result = (Group) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Group instance) {
		log.debug("attaching dirty Group instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Group instance) {
		log.debug("attaching clean Group instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}