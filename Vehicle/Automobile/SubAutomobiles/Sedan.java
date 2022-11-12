package Vehicle.Automobile.SubAutomobiles;

import Vehicle.Automobile.Automobile;
import Vehicle.Automobile.SubAutomobiles.Minivan.NumberOfSeats;
import Vehicle.Bicycle.Bicycle;
import Vehicle.Vehicle;

public class Sedan extends Automobile {
	
	private RoofType roofType;
	
	public enum RoofType {
		REGULAR,MOONROOF,SUNROOF;
		
		public double value() {
			switch (this) {
			case REGULAR:
				return 0.5;
			case MOONROOF:
				return 0.6;
			case SUNROOF:
				return 0.8;
			default:
				return 0;									
			}
		}		
	}
	
	private RoofType whichnum(String tempenum) {
		tempenum=tempenum.toUpperCase();
		System.out.println(tempenum);
		switch (tempenum) {
			case("REGULAR"):
				return RoofType.REGULAR;
			case("MOONROOF"):
				return RoofType.MOONROOF;
			case("SUNROOF"):
				return RoofType.SUNROOF;
			default:
				return null;									
			}
		
			
		}
	public Sedan(String id, MonthOfSale mos, CityOfSale cis, ProductionYear py, double vat, double engine_volume,String roofType) {
		super(id, mos, cis, py, vat, engine_volume);
		this.roofType = whichnum(roofType);
		
	}
	
	public Sedan(Vehicle c) {
		this(c.getId(),c.getMonthOfSale(),c.getCityOfSale(),c.getProductionYear(),c.getVat(),((Sedan)c).get_engine_volume(),((Sedan)c).roofType.toString());
		
	}
	public Sedan() {
		super();
		this.roofType=null;
	}
	
	
	@Override
	public double calculateSCT() {
		
		return (this.get_engine_volume()*0.2*this.getRoofType().value())/this.getProductionYear().value();
	}

	public RoofType getRoofType() {
		return roofType;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		Sedan temp;
		try {
			temp = (Sedan) obj;
		}catch(Exception ex) {
			return false;
		}
		
		if (super.equals(temp) && this.roofType.equals(temp.getRoofType()) )
			return true;
		
		return false;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + ", "+ this.roofType;
	}

	
	
	
	
    
}
