package customer_address_app_controller;

import java.util.Scanner;

import customer_address_app_Dao.CustomerDao;
import customer_address_app_Dto.Customer;

public class CustomerController {
public static void main(String[] args) {
	CustomerDao dao = new CustomerDao();
	while(true) {
	Scanner sc = new Scanner(System.in);
	System.out.println("1.Save Customer\n2.Update Customer\n3.Find Customer By id\n"
			+ "4.verify customer by phone and password\n5.verify Customer by email and password\n6.Exit");
	System.out.println("Enter your option");
	int op = sc.nextInt();
	switch(op) {
	case 1 :{
		System.out.println("Enter the name,phone,email,age,gender,password");
		Customer c = new Customer();
		c.setName(sc.next());
		c.setPhone(sc.nextLong());
		c.setEmail(sc.next());
		c.setAge(sc.nextInt());
		c.setGender(sc.next());
		c.setPassword(sc.next());
		
		dao.saveCustomer(c); 
		System.out.println("Customer Saved Succesfully with id :"+c.getId());
	}
	case 2 :{
		{
			System.out.println("Enter id,name,phone,email,age,gender,password");
			Customer c =new Customer();
			c.setId(sc.nextInt());
			c.setName(sc.next());
			c.setPhone(sc.nextLong());
			c.setEmail(sc.next());
			c.setAge(sc.nextInt());
			c.setGender(sc.next());
			c.setPassword(sc.next());
			
			c = dao.UpdateCustomer(c);
			if(c!=null) {
				System.out.println("Customer updated succesfully");
			}
			else
				System.err.println("Cannot update Customer as Id is Invalid");
			break;
}
	}
	case 3 : {
		System.out.println("Enter the Customer Id to display details");
		Customer customer = dao.FindById(sc.nextInt());
		if(customer !=null) {
			System.out.println(customer);
		}
		else
			System.err.println("Invalid Customer Id");
		break;
}
	
	case 4 :{
		System.out.println("Enter the Customer phone and password to verify");
		long phone = sc.nextLong();
		String password = sc.next();
		Customer customer = dao.verify(phone,password);
		if(customer !=null) {
			System.out.println(customer);
		}
		else
			System.err.println("Invalid Customer Id");
		break;
	}
	
	case 5 :{
		System.out.println("Enter the Customer email and password to verify");
		String email = sc.next();
		String password = sc.next();
		Customer customer = dao.verify(email,password);
		if(customer !=null) {
			System.out.println(customer);
		}
		else
			System.err.println("Invalid Customer Id");
		break;
	}
	case 6 : System.out.println("Thank You");
				System.exit(0);
	
	default : System.out.println(" Invalid Option");
	}
}
	}
}


