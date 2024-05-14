package customer_address_app_Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import customer_address_app_Dto.Address;
import customer_address_app_Dto.Customer;

public class AddressDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	
	public Address saveAddress(Address address,int id) {
		Customer customer = manager.find(Customer.class,id);
		if(customer !=null) {
			EntityTransaction transaction = manager.getTransaction();
			customer.getAddress().add(address);
			address.setCustomer(customer);//
			manager.persist(address);
			transaction.begin();
			transaction.commit();
			return address;
		}
		return null;
	}
		
		public Address UpdateAddress(Address address) {
			EntityTransaction transaction = manager.getTransaction();
			Address dbAddress = manager .find(Address.class,address.getId());
			if(dbAddress != null) {
				dbAddress.setName(address.getName());
				dbAddress.setBuilding_name(address.getBuilding_name());
				dbAddress.setHouse_number(address.getHouse_number());
				dbAddress.setType(address.getType());
				dbAddress.setCity(address.getCity());
				dbAddress.setState(address.getState());
				dbAddress.setCountry(address.getCountry());
				dbAddress.setPincode(address.getPincode());
				
				transaction.begin();
				transaction.commit();
				return dbAddress;
			}
			return null;
			
		}
		public Address FindById(int id) {
			return manager.find(Address.class, id);
		}
		
		
		public Address FindByType(String type) {
			
			Query q = manager.createQuery("select t from Address t where t.type=?1");
			q.setParameter(1, type);
			
			try {
				return (Address) q.getSingleResult();
			}catch(NoResultException e) {
				return null;
			}
		}
		
		public List<Address> FindByCustId(int cust_id) {
				Query q = manager.createQuery("select c.address from Customer c where c.id=?1");
				q.setParameter(1,cust_id);
				return q.getResultList();
			}
		
		public List<Address> FindByCustPhoneAndPassword(long phone,String password){
			Query q = manager.createQuery("select c.address from Customer c where c.phone=?1 and c.password=?2");
			q.setParameter(1, phone);
			q.setParameter(2, password);
			return q.getResultList();
		}
			
		
}