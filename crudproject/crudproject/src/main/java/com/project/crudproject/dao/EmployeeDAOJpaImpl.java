package com.project.crudproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.crudproject.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		TypedQuery<Employee>theQuery = entityManager.createQuery("FROM Employee",Employee.class);
		
		List<Employee>allEmployees = theQuery.getResultList();
		
		return allEmployees;
	}

	@Override
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public Employee save(Employee employee) {
		return entityManager.merge(employee);
	}

	@Override
	public void deleteById(int id) {
		Employee theEmployee = this.findById(id);
		entityManager.remove(theEmployee);
	}

	@Override
	public int deleteAll() {
		int list = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return list;
	}

}
