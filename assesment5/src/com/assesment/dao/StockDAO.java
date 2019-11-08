package com.assesment.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.assesment.controller.HibernateOGMUtil;
import com.assesment.modal.StockModule;

public class StockDAO {
private static EntityManagerFactory entityManagerFactory;
	
	public void addStocks() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter ID");
		int id= s.nextInt();
		System.out.println("Name:");
		String name=s.next();
		System.out.println("Description:");
		String description=s.next();
		description.trim();
		System.out.println("Price:");
		int price=s.nextInt();
		System.out.println("Quantity:");
		int quantity=s.nextInt();
		
		StockModule sr=new StockModule(name,description,price,quantity);
		
		em.getTransaction().begin();
		em.persist(sr);
		em.getTransaction().commit();
	}
	
	public void updateProduct(String name) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		StockModule product=em.createQuery("select s from StockModule s where name= :name",StockModule.class).setParameter("name",name).getResultList().get(0);
		
		Scanner s=new Scanner(System.in);
		System.out.println("Name:");
		String name1=s.next();
		System.out.println("Description:");
		String description=s.next();
		System.out.println("Price:");
		int price=s.nextInt();
		System.out.println("Quantity:");
		int quantity=s.nextInt();
		product.setName(name1);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
	}
	
	public List<StockModule> printStockModule(){
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("select s from StockModule s",StockModule.class).getResultList();
	
	}
	
	public void deleteStockModule(String name)
	{
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		StockModule product=em.createQuery("select s from StockModule s where name= :name",StockModule.class).setParameter("name",name).getResultList().get(0);
		
	
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
		
	
	}

}
