package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Department dp = new Department(1, "Wellington");
		Seller seller = new Seller(1, "Gaviao", "gaviao@gmail.com", LocalDate.parse("20/02/1996", fm), 2000.00, 1,dp);
		System.out.println(seller);
	}
}
