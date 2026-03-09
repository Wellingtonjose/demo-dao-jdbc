package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.annotation.processing.FilerException;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			SellerDao sellerDao = DaoFactory.createSellerDao();
			Seller seller = sellerDao.findById(3);
			System.out.println("=== TEST 1: seller findById===");
			System.out.println(seller);
			System.out.println("\n=== TEST 2: seller findByDepartmentId===");
			Department dep = new Department(2,null);
			List<Seller> list = sellerDao.findByDepartment(dep);
			for(Seller lista: list) {
				System.out.println(lista);
			}
			System.out.println("\n=== TEST 3: seller findAll===");
			list = sellerDao.finAll();
			for(Seller lista: list) {
				System.out.println(lista);
			}
			System.out.println("\n=== TEST 4: seller InsertSeller===");
			Seller sel = new Seller(null,"gaviao","g@gmail.com",LocalDate.now(),2000.0,dep);
			sellerDao.insert(sel);
			System.out.println("Insert! New ID " + sel.getId());
			System.out.println("\n=== TEST 5: seller UpdateSeller===");
			sel = sellerDao.findById(5);
			sel.setName("Maria");
			sellerDao.update(sel);
			System.out.println("Update completed");
			System.out.println("\n=== TEST 6: seller DeleteSeller===");
			System.out.print("Enter id for delete test:");
			int id = sc.nextInt();
			sellerDao.deleteById(id);
			System.out.println("Delete completed");
		}
		
	}

