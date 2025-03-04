//Name: Elias Khoueiry
//Last modified: february 22 2024
//Associated Files: Vehicule.java, Car.java, Truck.java, MotorCycle.java, Shop.java, main.java

package car_shop;
import java.util.Vector;
import java.util.Scanner;
import java.io.*;

public class Shop {
	private Vector<Vehicule>storage;
	public static int storage_count=0;
	public Shop(int size,int increment) {
		storage=new Vector<Vehicule>(size,increment);
	}
	//Accessors
	public Vector<Vehicule> getStorage()
		{return storage;}
	public void addCarCount()
		{Car.incrementCount();}
	public void addTruckCount()
		{Truck.incrementCount();}
	public void addMotorcycleCount()
		{MotorCycle.incrementCount();}
	public int getCarCount()
		{return Car.getCount();}
	public int getTruckCount()
		{return Truck.getCount();}
	public int getMotorcycleCount()
		{return MotorCycle.getCount();}
	public void addStorageCount()
		{storage_count++;}
	public int getStorageCount()
	{return storage_count;}	
	
	public void ensureCapacity(int[] array) {
		//this is used to make sure the array is never full
		if(array.length==50) {
			int[]new_array=new int[array.length+50];
			for(int i=0;i<array.length;i++) {
				new_array[i]=array[i];
			}
			array=new_array;
		}
	}
	
	
	
	public void addVehicule() {
		Scanner scan=new Scanner(System.in);
		System.out.println("What is the type of the vehicule(Car,Truck, or Motorcycle):");
		String choice=scan.nextLine();
		if(choice.equalsIgnoreCase("Car")) {
			System.out.println("What is the car's brand:");
			String brand=scan.nextLine();
			System.out.println("What is the car's date of production:");
			String date=scan.nextLine();
			System.out.println("What is the car's color:");
			String c=scan.nextLine();
			System.out.println("How many seats are in the car:");
			String seats=scan.nextLine();
			System.out.println("Is the car a sedan, hatchback, or SUV:");
			String field=scan.nextLine();
			Car car=new Car(brand,date,c,seats,field);
			storage.addElement(car);
			System.out.println("Car added to the shop.");
			Car.incrementCount();
			storage_count++;
		}
		if(choice.equalsIgnoreCase("Truck")) {
			System.out.println("What is the truck's brand:");
			String brand=scan.nextLine();
			System.out.println("What is the truck's date of production:");
			String date=scan.nextLine();
			System.out.println("What is the truck's color:");
			String c=scan.nextLine();
			System.out.println("How many wheels does the truck have:");
			String wheels=scan.nextLine();
			Truck truck=new Truck(brand,date,c,wheels);
			storage.addElement(truck);
			System.out.println("Truck added to the shop.");
			Truck.incrementCount();
			storage_count++;
		}
		if(choice.equalsIgnoreCase("Motorcycle")) {
			System.out.println("What is the motorcycle's brand:");
			String brand=scan.nextLine();
			System.out.println("What is the motorcycle's date of production:");
			String date=scan.nextLine();
			System.out.println("What is the motorcycle's color:");
			String c=scan.nextLine();
			float engine_cap=0.0F;
			try{
				System.out.println("What is the engine capacity of the motorcycle(between 70 and 120):");
				engine_cap=scan.nextFloat();
				while(engine_cap<70 || engine_cap>120) {
					System.out.println("Invalid input. Enter again:");
					engine_cap=scan.nextInt();
				}
			}catch(java.util.InputMismatchException e){
				System.out.println("Invalid input.");
			}
			scan.nextLine();
			if(engine_cap!=0) {
			MotorCycle motorcycle=new MotorCycle(brand,date,c,engine_cap);
			storage.addElement(motorcycle);
			System.out.println("Motorcycle added to the shop.");
			MotorCycle.incrementCount();
			storage_count++;}
		}
		if(!choice.equalsIgnoreCase("Motorcycle") && !choice.equalsIgnoreCase("Truck") && !choice.equalsIgnoreCase("Car"))
			System.out.println("Invalid Input.");
		
	}
	public void deleteVehicule() { 
		int line=0;
		int delete_line;
		int[]indices=new int[50]; 
		ensureCapacity(indices);
		for(int i=0;i<indices.length;i++)
			indices[i]=-99;
		Scanner scan=new Scanner(System.in);
		if(storage.size()!=0) {
			System.out.println("What is the specific type of the vehicule(Car, Truck, or Motorcyle):");
			String choice=scan.nextLine();
			if(choice.equalsIgnoreCase("Car")) {
				if (Car.getCount()==0)
					System.out.println("There are no cars.");
				else {
					for(int i=0;i<storage.size();i++) {
						if(storage.elementAt(i) instanceof Car) {
							System.out.println(line+1+"- " + storage.elementAt(i));
							indices[line]=i;
							line+=1;
						}
					}
					try{
						System.out.println("The item at which line do you want to delete:");
						delete_line=scan.nextInt();  // exception..............
						scan.nextLine();
						if(delete_line<=line+1) {
							storage.remove(indices[delete_line-1]);
							System.out.println("Car removed from shop.");
							Car.decrementCount();
							storage_count-=1;}
						else
							System.out.println("Invalid input.");
					}catch(java.lang.ArrayIndexOutOfBoundsException e) {
						System.out.println("Invalid input.");
					}
		
				}
			}
			
			if(choice.equalsIgnoreCase("Truck")) {
				if(Truck.getCount()==0)
					System.out.println("There are no trucks.");
				else {
					for(int i=0;i<storage.size();i++) {
						if(storage.elementAt(i) instanceof Truck) {
							System.out.println(line+1+"- " + storage.elementAt(i));
							indices[line]=i;
							line+=1;
						}
					}
					try{
						System.out.println("The item at which line do you want to delete:");
						delete_line=scan.nextInt(); 
						scan.nextLine();
						if(delete_line<=line+1) {
							storage.remove(indices[delete_line-1]);
							Truck.decrementCount();
							System.out.println("Truck removed from shop.");
							storage_count-=1;}
						else
							System.out.println("Invalid input.");
					}catch(java.lang.ArrayIndexOutOfBoundsException e) {
						System.out.println("Invalid input.");
					}
					}
			}
		
				
			if(choice.equalsIgnoreCase("Motorcycle")) {
				if(MotorCycle.getCount()==0)
					System.out.println("There are no motorcycles.");
				else {
				for(int i=0;i<storage.size();i++) {
					if(storage.elementAt(i) instanceof MotorCycle) {
						System.out.println(line+1+"- " + storage.elementAt(i));
						indices[line]=i;
						line+=1;
					}
				}
				try{
					System.out.println("The item at which line do you want to delete:");
					delete_line=scan.nextInt();  // exception..............
					scan.nextLine();
					if(delete_line<=line+1) {
						storage.remove(indices[delete_line-1]);
						MotorCycle.decrementCount();
						System.out.println("Motorcycle removed from shop.");
						storage_count-=1;}
					else
						System.out.println("Invalid input.");
				}catch(java.lang.ArrayIndexOutOfBoundsException e) {
					System.out.println("Invalid input.");
				}
				}

			}
			if(!choice.equalsIgnoreCase("Motorcycle") && !choice.equalsIgnoreCase("Truck") && !choice.equalsIgnoreCase("Car"))
				System.out.println("Invalid Input.");
			}else
				System.out.println("The shop is empty.");
			
	}
	
	public void displayType() {
		Scanner scan=new Scanner(System.in);
		if(storage.size()!=0) {
			System.out.println("What is the type of the vehicule(Car, Truck or Motorcycle):");
			String choice=scan.nextLine();
			if(!choice.equalsIgnoreCase("Motorcycle") && !choice.equalsIgnoreCase("Truck") && !choice.equalsIgnoreCase("Car"))
				System.out.println("Invalid Input.");
			if(choice.equalsIgnoreCase("Car")) {
				for(int i=0;i<storage_count;i++) {
					if(storage.elementAt(i) instanceof Car) {
						System.out.println(storage.elementAt(i));
					}
				}
				System.out.println("Car Count: " + Car.getCount());
			}
			if(choice.equalsIgnoreCase("Truck")) {
				for(int i=0;i<storage_count;i++) {
					if(storage.elementAt(i) instanceof Truck) {
						System.out.println(storage.elementAt(i));
					}
				}
				System.out.println("Truck Count: " + Truck.getCount());
			}
			if(choice.equalsIgnoreCase("Motorcycle")) {
				for(int i=0;i<storage_count;i++) {
					if(storage.elementAt(i) instanceof MotorCycle) {
						System.out.println(storage.elementAt(i));
					}
				}
				System.out.println("Motorcycle Count: " + MotorCycle.getCount());
			}
		}else
			System.out.println("The shop is empty.");
			
		
	}
	
	public void listAll() {
		if(storage.size()==0)
			System.out.println("The shop is empty.");
		else
			for(int i=0;i<storage_count;i++) {
			System.out.println(storage.elementAt(i));
		}
	}
	
	public void importOption() {
		try {
		FileReader fr=new FileReader("textfile.txt");
		BufferedReader br=new BufferedReader(fr);
		String line;
        while ((line = br.readLine()) != null) {
            String[]sentence=line.split(", ");
            if(sentence[0].equalsIgnoreCase("Car")){
            	Car car=new Car(sentence[1],sentence[2],sentence[3],sentence[4],sentence[5]);
            	storage.addElement(car);
            	Car.incrementCount();
            	storage_count+=1;
            }
            if(sentence[0].equalsIgnoreCase("Truck")){
            	Truck truck=new Truck(sentence[1],sentence[2],sentence[3],sentence[4]);
            	storage.addElement(truck);
            	Truck.incrementCount();
            	storage_count+=1;
            }
            if(sentence[0].equalsIgnoreCase("MotorCycle")){
            	Float engine_cap=Float.parseFloat(sentence[4]);
            	MotorCycle motorcycle=new MotorCycle(sentence[1],sentence[2],sentence[3],engine_cap);
            	storage.addElement(motorcycle);
                MotorCycle.incrementCount();
            	storage_count+=1;
            }
        }
        System.out.println("Import done.");
		}catch(IOException e){
			System.out.println("This file does not exist.");}
	}
	
	public void exportOption() {
		try{
			FileWriter fw=new FileWriter("textfile.txt",true);
			PrintWriter pw=new PrintWriter(fw);
			for(int i=0;i<storage.size();i++) {
				if (storage.elementAt(i) instanceof Car) {
					pw.write("Car, "+((Car)storage.elementAt(i)).getBrandName()+", "+((Car)storage.elementAt(i)).getDateOfMake()+", "+((Car)storage.elementAt(i)).getColor()+", "+((Car)storage.elementAt(i)).getNumberOfSeats()+", "+((Car)storage.elementAt(i)).getField()+"\n");
				}
				if (storage.elementAt(i) instanceof Truck) {
					pw.write("Truck, "+((Truck)storage.elementAt(i)).getBrandName()+", "+((Truck)storage.elementAt(i)).getDateOfMake()+", "+((Truck)storage.elementAt(i)).getColor()+", "+((Truck)storage.elementAt(i)).getNumberOfWheels()+"\n");
				}
				if (storage.elementAt(i) instanceof MotorCycle) {
					pw.write("Motorcycle, "+((MotorCycle)storage.elementAt(i)).getBrandName()+", "+((MotorCycle)storage.elementAt(i)).getDateOfMake()+", "+((MotorCycle)storage.elementAt(i)).getColor()+", "+((MotorCycle)storage.elementAt(i)).getEngineCapacity()+"\n");
				}
			}
			pw.close();
			System.out.println("Export done.");
		}catch(IOException e) {
			System.out.println("Invalid input.");
		}
	}
	
	
	public void menu() {
		//menu method to output options on thw screen
		String choice;
		do {
			int counter=0;
			System.out.println("1.Add a vehicule");
			System.out.println("2.Delete a vehicule");
			System.out.println("3.Display by type");
			System.out.println("4.List all");
			System.out.println("5.Import");
			System.out.println("6.Export");
			System.out.println("7.Exit");
			System.out.println("----------------------");
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter your choice:");
			choice=scan.nextLine();
			while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7")){
				counter++;
				if(counter==5)
					System.exit(0);
				System.out.println("Invalid. Enter again:");
				choice=scan.nextLine();
			}
			if(choice.equals("1"))
				addVehicule();
			if(choice.equals("2"))
				deleteVehicule();
			if(choice.equals("3"))
				displayType();
			if(choice.equals("4"))
				listAll();
			if(choice.equals("5"))
				importOption();
			if(choice.equals("6"))
				exportOption();
		}while(!choice.equals("7"));
	}
	
	
	
}
