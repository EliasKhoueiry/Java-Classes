//Name: Elias Khoueiry
//id: 202302778
//Last modified: february 22 2024
//Associated Files: Vehicule.java, Car.java, Truck.java, MotorCycle.java, Shop.java, main.java

package Assignment;

public class MotorCycle extends Vehicule{
	private float engine_capacity;
	private static int motorcycle_count=0;
	public MotorCycle(String brand,String date,String c,float engine_cap) {
		super(brand,date,c);
		engine_capacity=engine_cap;
	}
	//Accesors
	public void setEngineCapacity(float engine_cap)
		{engine_capacity=engine_cap;}
	public float getEngineCapacity()
		{return engine_capacity;}
	public static void incrementCount() {
		motorcycle_count+=1;
	}
	public static void decrementCount() {
		motorcycle_count-=1;
	}
	public static int getCount() {
		return motorcycle_count;
	}
	public String toString()
	{return "Type: Motorcycle	" + super.toString() + "		Engine Capacity: " + engine_capacity;}


}
