//Name: Elias Khoueiry
//Last modified: february 22 2024
//Associated Files: Vehicule.java, Car.java, Truck.java, MotorCycle.java, Shop.java, main.java

package car_shop;

import java.util.Scanner;
public class Car extends Vehicule{
	private String number_of_seats;
	private String field;
	private static int car_count=0;
	
	public Car(String brand,String date,String c,String seats,String f) {
		super(brand,date,c);
		number_of_seats=seats;
		setField(f);
	}
	//Accessors
	public void setNumberOfSeats(String seats)
		{number_of_seats=seats;}
	public String getNumberOfSeats()
		{return number_of_seats;}
	public void setField(String f) {
		while(!f.equalsIgnoreCase("Sedan") && !f.equalsIgnoreCase("Hatchback") && !f.equalsIgnoreCase("SUV")) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Invalid. Is the car a hatchback, sedan, or SUV:");
			f=scan.nextLine();
		}
		field=f;
	}
	public static void incrementCount() {
		car_count+=1;
	}
	public static void decrementCount() {
		car_count-=1;
	}
	public static int getCount() {
		return car_count;
	}
	
	public String getField()
		{return field;}
	public String toString()
		{return "Type: Car		"+ super.toString() + "		Number of Seats: "+number_of_seats+"		Field: "+field;}


}
