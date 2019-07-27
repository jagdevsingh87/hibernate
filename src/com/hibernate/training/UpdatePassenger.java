package com.hibernate.training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdatePassenger {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().addAnnotatedClass(Passenger.class);
		SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Passenger passenger = session.get(Passenger.class,1);
			passenger.setLastName("Brar");
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

}
