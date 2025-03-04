//Name: Elias Khoueiry
//Last modified: february 22 2024
//Associated Files: Vehicule.java, Car.java, Truck.java, MotorCycle.java, Shop.java, main.java

package car_shop;

public class Truck extends Vehicule{
	private String number_of_wheels;
	private static int truck_count=0;
	public Truck(String brand,String date,String c,String wheels) {
		super(brand,date,c);
		number_of_wheels=wheels;
	}
	//Accessors
	public void setNumberOfWheels(String wheels)
		{number_of_wheels=wheels;}
	public String getNumberOfWheels()
		{return number_of_wheels;}
	public static void incrementCount() {
		truck_count+=1;
	}
	public static void decrementCount() {
		truck_count-=1;
	}
	public static int getCount() {
		return truck_count;
	}
	public String toString()
	{return "Type: Truck		"+super.toString() + "		Number of Wheels: "+number_of_wheels;}


}
