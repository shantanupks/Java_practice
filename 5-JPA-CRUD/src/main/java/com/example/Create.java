package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.model.Employee;
import com.example.model.Gender;

public class Create {

	public static void main(String[] args) {

		// -------------------------------------------
		// using JPA
		// -------------------------------------------
		
		Employee employee = new Employee(); // New
		employee.setId(5);
		employee.setName("shantanu");
		employee.setSalary(400.00);
		employee.setGender(Gender.MALE);
		employee.setDob(LocalDate.now());
		employee.setJoinDate(LocalDateTime.now());

		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(employee); //managed
		employee.setSalary(40000);
		


		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}