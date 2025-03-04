//Name: Elias Khoueiry
//Last modified: february 22 2024
//Associated Files: Vehicule.java, Car.java, Truck.java, MotorCycle.java, Shop.java, main.java

package car_shop;

public abstract class Vehicule {
	protected String brand_name;
	protected String date_of_make;
	protected String color;
	public Vehicule(String brand,String date,String c) {
		//this construct is used with the super method in the child classes
		brand_name=brand;
		date_of_make=date;
		color=c;
	}
	//Accessors
	public void setBrandName(String brand)
		{brand_name=brand;}
	public String getBrandName()
		{return brand_name;}
	public void setDateOfMake(String date)
		{date_of_make=date;}
    public String getDateOfMake()
		{return date_of_make;}
	public void setColor(String c)
		{color=c;}
	public String getColor()
		{return color;}
	public String toString() {
		return "Brand: "+brand_name+"		Date of Make: "+date_of_make+"		Color: "+color;
	}
}


