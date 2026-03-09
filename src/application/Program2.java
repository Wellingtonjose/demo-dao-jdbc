package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		
		System.out.println("\n=== TEST 1: Department Insert===");
		Department dep = new Department(null, "Roupas");
		DepartmentDao depart = DaoFactory.createDepartmentDao();
		depart.insert(dep);
		System.out.println("Insert! New ID " + dep.getId());
		
		System.out.println("\n=== TEST 2: Department Update===");
		dep.setNome("Informatica");
		depart.update(dep);
		
		System.out.println("\n=== TEST 3: Department FindById===");
		dep = depart.findById(1);
		System.out.println(dep);
		
	}
}
