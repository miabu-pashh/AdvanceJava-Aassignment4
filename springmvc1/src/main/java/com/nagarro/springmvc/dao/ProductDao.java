package com.nagarro.springmvc.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.nagarro.springmvc.model.Product;


/**
 * The Class ProductDao.
 */
public class ProductDao implements ProductDaoInterface {

	/**
	 * Save product.
	 *
	 * @param product the product
	 */
	/*
	 * Save product.
	 *
	 */
	@Override
	public void saveProduct(Product product) {

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(product);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {

				System.out.println("Sorry some error has occured!");
				transaction.rollback();
			}
		} finally {
			session.close();
		}

	}

	/**
	 * Session get.
	 *
	 * @return the list
	 */
	/*
	 * Session get return the list of products
	 *
	 */
	@SuppressWarnings("deprecation")
	public List<Product> sessionGet() {

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Product> query = session.createQuery("from Product");
		List<Product> product = query.list();

		return product;

	}

}
