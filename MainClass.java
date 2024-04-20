package rentalCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    List<Car> cars;
    List<Customer> customers;
    List<RentCar> rentCar;

    public MainClass() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentCar = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentCar.add(new RentCar(car, customer, days));
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Sorry, the car is not available.");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        RentCar rentCarToRemove = null;
        for (RentCar rentcar : rentCar) {
            if (rentcar.getCar() == car) {
                rentCarToRemove = rentcar;
                break;
            }
        }
        if (rentCarToRemove != null) {
            rentCar.remove(rentCarToRemove);
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Car was not rented to you.");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("..............Welcome to Car Rental System.................");
            System.out.println("Type 1 if you want to rent a car.");
            System.out.println("Type 2 if you want to return a car.");
            System.out.println("Type 0 if you want to exit.");

            int choice = sc.nextInt();
            sc.nextLine();  // Consume the newline character

            if (choice == 1) {
                System.out.println("Enter your name:");
                String customerName = sc.nextLine();
                System.out.println("Available cars are:");
                for (Car car : cars) {
                    if (car.isAvailable()) {
                        System.out.println(car.CarBrand + " " + car.carName);
                    }
                }

                System.out.println("Enter car name you want to rent:");
                String carName = sc.nextLine();
                System.out.println("Enter the number of days you want to rent the car:");
                int rentalDays = sc.nextInt();
                
                
//                String CarBrand = null;
//				System.out.println("your selected car is" +CarBrand+ "" +carName);
//				System.out.println("you want car for " +rentalDays);
//				System.out.println("confirm to book car (Y/N)");
//				String confirm=sc.nextLine();
//				if (confirm.equalsIgnoreCase("y")) {
//			        
//			        System.out.println("Car rented successfully.");
//			    } else {
//			        System.out.println("Car rental cancelled.");
//			    }
				
                Customer newCustomer = new Customer(customers.size() + 1, customerName);
                addCustomer(newCustomer);
                
                
                Car selectedCar = null;
                for (Car car : cars) {
                    if ( car.isAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    rentCar(selectedCar, newCustomer, rentalDays);
                } else {
                    System.out.println("Invalid input or the car is not available. Please try again later.");
                }
            } else if (choice == 2) {
                System.out.println("Enter the car name you want to return:");
                String carName = sc.nextLine();
                Car carToReturn = null;

                for (Car car : cars) {
                    if ( !car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    returnCar(carToReturn);
                } else {
                    System.out.println("Invalid input or the car was not rented.");
                }
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid option.");
            }
        }

        System.out.println("Thank you for using the car rental system.");
    }

    public static void main(String[] args) {
        MainClass rentalSystem = new MainClass();
        Car c1 = new Car("Thar", "Mahindra", 1000);
        Car c2 = new Car("Suzuki", "Maruti", 2000);
        rentalSystem.addCar(c1);
        rentalSystem.addCar(c2);

        rentalSystem.menu();
    }
}