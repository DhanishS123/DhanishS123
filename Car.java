package rentalCar;

public class Car {
	String carName;
	String CarBrand;
	double perDayPrice;
	boolean isAvailable;
	int rentalDays;
	
	public Car(String carName,String CarBrand,double perDayPrice) {
		this.carName=carName;
		this.CarBrand=CarBrand;
		this.perDayPrice=perDayPrice;
		this.isAvailable=true;
	}
	
	public double calculatePrice(double perDayPrice) {
		
		double rent=perDayPrice * rentalDays;
				return rent;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	
	
	public void rent() {
		isAvailable=false;
	}
	
	public void returnCar() {
		isAvailable=true;
	}
	
}


