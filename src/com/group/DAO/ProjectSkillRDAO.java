package com.group.DAO;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.group.model.ProjectSkillR;

/**
 	* A data access object (DAO) providing persistence and search support for ProjectSkillR entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.group.model.ProjectSkillR
  * @author MyEclipse Persistence Tools 
 */
public class ProjectSkillRDAO extends BaseHibernateDAO  {
		 private static final Log log = LogFactory.getLog(ProjectSkillRDAO.class);
		//property constants



    
    public void save(ProjectSkillR transientInstance) {
        log.debug("saving ProjectSkillR instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ProjectSkillR persistentInstance) {
        log.debug("deleting ProjectSkillR instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProjectSkillR findById( java.lang.Integer id) {
        log.debug("getting ProjectSkillR instance with id: " + id);
        try {
            ProjectSkillR instance = (ProjectSkillR) getSession()
                    .get("com.group.model.ProjectSkillR", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ProjectSkillR instance) {
        log.debug("finding ProjectSkillR instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.group.model.ProjectSkillR")
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
      log.debug("finding ProjectSkillR instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProjectSkillR as model where model." 
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
		log.debug("finding all ProjectSkillR instances");
		try {
			String queryString = "from ProjectSkillR";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ProjectSkillR merge(ProjectSkillR detachedInstance) {
        log.debug("merging ProjectSkillR instance");
        try {
            ProjectSkillR result = (ProjectSkillR) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ProjectSkillR instance) {
        log.debug("attaching dirty ProjectSkillR instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProjectSkillR instance) {
        log.debug("attaching clean ProjectSkillR instance");
        try {
                      	getSession().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}