package customer_address_app_Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import customer_address_app_Dto.Customer;

public class CustomerDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	
		public Customer saveCustomer(Customer customer) {
			
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(customer);
			transaction.commit();
			return customer;
			}
		public Customer UpdateCustomer(Customer customer) {
			EntityTransaction transaction = manager.getTransaction();
			Customer dbCustomer = manager .find(Customer.class,customer.getId());
			if(dbCustomer != null) {
				dbCustomer.setName(customer.getName());
				dbCustomer.setPhone(customer.getPhone());
				dbCustomer.setEmail(customer.getEmail());
				dbCustomer.setAge(customer.getAge());
				dbCustomer.setGender(customer.getGender());
				dbCustomer.setPassword(customer.getPassword());
				
				transaction.begin();
				transaction.commit();
				return dbCustomer;
			}
			return null;
			
		}
		public Customer FindById(int id) {
			return manager.find(Customer.class, id);
		}

		
		public Customer verify(long phone,String password) {
			Query q = manager.createQuery("select c from Customer c where c.phone=?1 and c.password=?2");
			q.setParameter(1, phone);
			q.setParameter(2, password);
			try {
				return (Customer) q.getSingleResult();
			}catch(NoResultException e) {
				return null;
			}
		
		}
		
		public Customer verify(String email,String password) {
			Query q = manager.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
			q.setParameter(1, email);
			q.setParameter(2, password);
			try {
				return (Customer) q.getSingleResult();
			}catch(NoResultException e) {
				return null;
			}
		}
		
		
	}



