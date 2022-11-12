package FileIO;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


import Vehicle.Vehicle;
import Vehicle.Vehicle.CityOfSale;
import Vehicle.Vehicle.MonthOfSale;
import Vehicle.Vehicle.ProductionYear;
import Vehicle.Automobile.SubAutomobiles.*;
import Vehicle.Bicycle.Bicycle;
import Vehicle.Bicycle.Bicycle.ChainType;
import Vehicle.Bicycle.Bicycle.SeatPost;
import Vehicle.PickupTruck.PickupTruck;
import Vehicle.PickupTruck.PickupTruck.CabType;
import Vehicle.PickupTruck.PickupTruck.TruckBedType;

public class FileIO {
	
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public ArrayList<Vehicle> getVehicles() {

		String path = "src\\FileIO\\HW2_SoldVehicles.csv";

		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			
			while((line = bufferedReader.readLine()) != null) {
				char firsLetter = line.charAt(0);
				StringTokenizer st = new StringTokenizer(line , ",");
				
				String id = null;
				MonthOfSale month = null;
				CityOfSale city = null;
				ProductionYear  year = null;
				double vat = 0;
				
				int witchAttribute = 0;
				
				switch(firsLetter) {
					case 'S' :
						break;
						
					case 'M' :
						break;
						
					case 'H' :
						break;
						
					case 'B' :
						ChainType chainType = null;
						SeatPost seat = null; 

						while(st.hasMoreTokens()) {
							String newOne = st.nextToken();
							
							switch(witchAttribute) {
								case 0: id = newOne; break;
								case 1: month = MonthOfSale.valueOf(newOne); break;
								case 2: city = CityOfSale.valueOf(newOne); break;
								case 3: year = ProductionYear.valueOf(newOne); break;
								case 4: vat = Double.valueOf(newOne); break;
								case 5: chainType = ChainType.valueOf(newOne); break;
								case 6: seat = SeatPost.valueOf(newOne); break;
							}
							
							if(++witchAttribute ==7) {
								this.vehicles.add(new Bicycle(id, month, city, year, vat, chainType, seat));
								witchAttribute =0;
							}
						}
						break;
					
					case 'P' :
						CabType cabType = null;
						TruckBedType truckBedType = null;
						
						while(st.hasMoreTokens()) {
							String newOne = st.nextToken();
							
							switch(witchAttribute) {
								case 0: id = newOne; break;
								case 1: month = MonthOfSale.valueOf(newOne); break;
								case 2: city = CityOfSale.valueOf(newOne); break;
								case 3: year = ProductionYear.valueOf(newOne); break;
								case 4: vat = Double.valueOf(newOne); break;
								case 5: cabType = CabType.valueOf(newOne); break;
								case 6: truckBedType = TruckBedType.valueOf(newOne); break;
							}
						}
						
						if(++witchAttribute ==7) {
							this.vehicles.add(new PickupTruck(id, month, city, year, vat, cabType, truckBedType));
							witchAttribute =0;
						}
						
						break;
				}
	
			}
			
			fileReader.close();
			bufferedReader.close();
			
		}
		catch (FileNotFoundException e) {
            System.exit(-1);
            	
        }
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return this.vehicles;
		
	}
	
    
	
	
}
