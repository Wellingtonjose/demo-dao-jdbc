package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		System.out.println("\n=== TEST 4: Department Insert===");
		Department dep = new Department(null, "Roupas");
		DepartmentDao depart = DaoFactory.createDepartmentDao();
		depart.insert(dep);
		System.out.println("Insert! New ID " + dep.getId());
	}
}
