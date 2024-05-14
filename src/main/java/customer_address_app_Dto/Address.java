package customer_address_app_Dto;

import javax.persistence.*;

@Entity
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(nullable = false)
private String name,building_name,house_number,type;
@Column(nullable = false)
private String city,state,country;
@Column(nullable = false)
private int pincode;
@ManyToOne
private Customer customer;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBuilding_name() {
	return building_name;
}
public void setBuilding_name(String building_name) {
	this.building_name = building_name;
}
public String getHouse_number() {
	return house_number;
}
public void setHouse_number(String house_number) {
	this.house_number = house_number;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
@Override
public String toString() {
	return "Address [id=" + id + ", name=" + name + ", building_name=" + building_name + ", house_number="
			+ house_number + ", type=" + type + ", city=" + city + ", state=" + state + ", country=" + country
			+ ", pincode=" + pincode + "]";
}



}
