package rentalCar;

public class RentCar{
	int days;
	Car car;
	Customer customer;
	
	

	public  RentCar(Car car,Customer customer,int days) {
		this.car=car;
		this.customer=customer;
		this.days=days;
	}



	public Car getCar() {
		// TODO Auto-generated method stub
		return car;
	}



	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	
}
