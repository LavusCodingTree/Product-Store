package com.js.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.js.dto.Product;

@Component
public class ProductCRUD {

	@Autowired
	EntityManagerFactory emf;

	public boolean insertProduct(Product p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(p);
		et.commit();

		if (em.find(Product.class, p.getId()) != null) {
			return true;
		} else {
			return false;
		}

	}

	// GetProductById
	public Product getProductById(int id) {
		EntityManager em = emf.createEntityManager();

		return em.find(Product.class, id);

	}

	// DeleteProductById
	public boolean deleteProductById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product p = em.find(Product.class, id);
		if (p != null) {
			et.begin();
			em.remove(p);
			et.commit();
			return true;
		} else {
			return false;
		}

	}

	// GetAllProduct
	public List<Product> getAllProduct() {
		EntityManager em = emf.createEntityManager();

		String query = "select p from Product p";

		Query q = em.createQuery(query);
		return q.getResultList();
	}

//update Product By ID

	public boolean updateProductById(int id, Product pro) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product p = em.find(Product.class, id);
		if (p != null) {

			pro.setId(id);
			et.begin();
			em.merge(pro);
			et.commit();

			return true;
		} else {
			return false;
		}
	}

}