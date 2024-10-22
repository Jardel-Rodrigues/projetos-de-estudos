package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n===TEST 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===TEST 3: seller findAll ====");
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===TEST 4: seller insert ====");
		Seller newSeller = new Seller( null, "Greg", "joao@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		System.out.println("\n===TEST 6: seller update ====");
		seller = sellerDao.findById(17);
		seller.setName("Joao Marques");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		
		System.out.println("\n===TEST 6: seller delete ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed!");
		
		System.out.println("======================Iniciando Testes de Department==========================");
		
		Program2();
	}
	
	public static void Program2() {

		DepartmentDao departmentDao = DaoFactory.createDapartmentDao();
		
		System.out.println("===TEST 1: Department findById ====");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n===TEST 2: Department insert ====");
		Department newDepartmet = new Department(null, "RH");
		departmentDao.insert(newDepartmet);
		System.out.println("Inserted! new id = " + newDepartmet.getId());
		
		System.out.println("\n===TEST 3: Department update ====");
		department = departmentDao.findById(22);
		department.setName("Recrutamento");
		departmentDao.update(department);
		System.out.println("Update Completed!");
		
		System.out.println("\n===TEST 4: Department delete ====");
		System.out.print("Enter com o Id for test! ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!");
		
		System.out.println("\n===TEST 5: seller findAll ====");
		List<Department> list = departmentDao.findAll();
		
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}
	
}
