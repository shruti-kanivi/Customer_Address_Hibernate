package customer_address_app_controller;

import java.util.List;
import java.util.Scanner;

import customer_address_app_Dao.AddressDao;
import customer_address_app_Dto.Address;
import customer_address_app_Dto.Customer;

public class AddressController {
	public static void main(String[] args) {
		AddressDao dao = new AddressDao();
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out
					.println("1.Save Address\n2.Update Address\n3.Find Address by Id\n4.Find Address by type\n5.find address by customer id\n"
							+ "6.find address by customer phone and password\n7.Exit");
			System.out.println("Enter your option");
			int op = sc.nextInt();
			switch (op) {
			case 1: {
				System.out.println("Enter the name,building_name,house_no,type,city,state,country,pincode");
				Address a = new Address();
				a.setName(sc.next());
				a.setBuilding_name(sc.next());
				a.setHouse_number(sc.next());
				a.setType(sc.next());
				a.setCity(sc.next());
				a.setState(sc.next());
				a.setCountry(sc.next());
				a.setPincode(sc.nextInt());

				System.out.println("Enter the customer id to add address");
				int cid = sc.nextInt();
				dao.saveAddress(a, cid);
				System.out.println("Address Saved Succesfully with id :" + a.getId());
			}

			case 2: {
				{
					System.out.println("Enter id,name,building_name,house_no,type,city,state,country,pincode");
					Address a = new Address();
					a.setId(sc.nextInt());
					a.setName(sc.next());
					a.setBuilding_name(sc.next());
					a.setHouse_number(sc.next());
					a.setType(sc.next());
					a.setCity(sc.next());
					a.setState(sc.next());
					a.setCountry(sc.next());
					a.setPincode(sc.nextInt());

					a = dao.UpdateAddress(a);
					if (a != null) {
						System.out.println("Address updated succesfully with id "+a.getId()+" updated");
					} else
						System.err.println("Cannot update Address as Id is Invalid");
					break;

				}
			}
			
			

			case 3: {
				System.out.println("Enter the id to find the Customer");
				Address address = dao.FindById(sc.nextInt());
				if (address != null) {
					System.out.println(address);
				} else
					System.err.println("Invalid Address id");
				break;
			}

			case 4: {
				System.out.println("Enter the type to find the Customer");
				Address address = dao.FindByType(sc.next());
				if (address != null) {
					System.out.println(address);
				} else
					System.err.println("Invalid Address Type");
				break;
			}
			case 5:{
				System.out.println("Enter the customer id to find Address");
				int id = sc.nextInt();
				List<Address> address = dao.FindByCustId(id);
				if (address.isEmpty())
					System.err.println("No address found for entered customer Id");
				else
					for (Address a : address) {
						System.out.println(a);
						System.out.println("----------------------------------");
					}
				break;
			}
			
			case 6:{
				System.out.println("Enter the Customer phone and password to find address");
				long phone = sc.nextLong();
				String password = sc.next();
				List<Address> address = dao.FindByCustPhoneAndPassword(phone, password);
				if (address.isEmpty())
					System.err.println("No address found for entered customer phone and password");
				else
					for (Address a : address) {
						System.out.println(a);
						System.out.println("----------------------------------");
					}
				break;
				
			}
			
		

			case 7: {
				System.out.println("Thank you");
				System.exit(0);
			}

			default:
				System.out.println("Invalid Option");

			}
		}
	}
}
