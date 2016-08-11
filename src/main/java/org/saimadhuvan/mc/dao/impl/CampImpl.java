package org.saimadhuvan.mc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.saimadhuvan.mc.dao.HibernateUtil;
import org.saimadhuvan.mc.dao.entity.Camp;

/**
 * @author madhu.b
 *
 */
public class CampImpl {
	/**
	 * 
	 */
	public CampImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Camp> GetCamps(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		@SuppressWarnings("unchecked")
		List<Camp> camps = session.createQuery("from Camp").list();
		session.close();
		
		return camps;
	}

}

