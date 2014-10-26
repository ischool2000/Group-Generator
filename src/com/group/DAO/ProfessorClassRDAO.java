package com.group.DAO;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.group.model.ProfessorClassR;

/**
 	* A data access object (DAO) providing persistence and search support for ProfessorClassR entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.group.model.ProfessorClassR
  * @author MyEclipse Persistence Tools 
 */
public class ProfessorClassRDAO extends BaseHibernateDAO  {
		 private static final Log log = LogFactory.getLog(ProfessorClassRDAO.class);
		//property constants



    
    public void save(ProfessorClassR transientInstance) {
        log.debug("saving ProfessorClassR instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ProfessorClassR persistentInstance) {
        log.debug("deleting ProfessorClassR instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProfessorClassR findById( java.lang.Integer id) {
        log.debug("getting ProfessorClassR instance with id: " + id);
        try {
            ProfessorClassR instance = (ProfessorClassR) getSession()
                    .get("com.group.model.ProfessorClassR", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ProfessorClassR instance) {
        log.debug("finding ProfessorClassR instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.group.model.ProfessorClassR")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding ProfessorClassR instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProfessorClassR as model where model." 
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
		log.debug("finding all ProfessorClassR instances");
		try {
			String queryString = "from ProfessorClassR";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ProfessorClassR merge(ProfessorClassR detachedInstance) {
        log.debug("merging ProfessorClassR instance");
        try {
            ProfessorClassR result = (ProfessorClassR) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ProfessorClassR instance) {
        log.debug("attaching dirty ProfessorClassR instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProfessorClassR instance) {
        log.debug("attaching clean ProfessorClassR instance");
        try {
                      	getSession().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}