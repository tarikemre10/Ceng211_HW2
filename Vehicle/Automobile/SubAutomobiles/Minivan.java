package Vehicle.Automobile.SubAutomobiles;

import Vehicle.Automobile.Automobile;

import Vehicle.Vehicle;

public class Minivan extends Automobile {
	private NumberOfSeats numberOfSeats;
	
	public enum NumberOfSeats {
		FOUR,FİVE,SIX,SEVEN;
		
		public double value() {
			switch (this) {
			case FOUR:
				return 0.1;
			case FİVE:
				return 0.4;
			case SIX:
				return 0.6;
			case SEVEN:
				return 0.8;
			default:
				return 0;									
			}
		}
		
		public String toString() {
			switch (this) {
			case FOUR:
				return "4";
			case FİVE:
				return "5";
			case SIX:
				return "6";
			case SEVEN:
				return "7";
			default:
				return null;									
			}
			
			
		}
	}
	
	
	public Minivan(String id, MonthOfSale mos, CityOfSale cis, ProductionYear py, double vat, double engine_volume,
			String numberOfSeats1) {
		super(id, mos, cis, py, vat, engine_volume);
		this.numberOfSeats=whichnum(numberOfSeats1);
		
	}
	public Minivan(Vehicle c) {
		this(c.getId(),c.getMonthOfSale(),c.getCityOfSale(),c.getProductionYear(),c.getVat(),((Minivan)c).get_engine_volume(),((Minivan)c).numberOfSeats.toString());
		
	}
	public Minivan() {
		super();
		this.numberOfSeats=null;
	}
	
	private NumberOfSeats whichnum(String tempenum) {
		
		switch (tempenum) {
			case("4"):
				return NumberOfSeats.FOUR;
			case("5"):
				return NumberOfSeats.FİVE;
			case("6"):
				return NumberOfSeats.SIX;
			case("7"):
				return NumberOfSeats.SEVEN;
			default:
				return null;									
			}
		
			
		}
	
	@Override
	public double calculateSCT() {
		
		return (0.6*this.getProductionYear().value())/(this.get_engine_volume()+this.getNumberOfSeats().value());
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		Minivan temp;
		try {
			temp = (Minivan) obj;
		}catch(Exception ex) {
			return false;
		}
		
		if (super.equals(temp) && this.numberOfSeats.equals(temp.getNumberOfSeats()) )
			return true;
		
		return false;
	}
	
	
	
	
	//Getters
	public NumberOfSeats getNumberOfSeats() {
		return this.numberOfSeats;
	}
	
	
	
	@Override
	public String toString() {
		return super.toString() + ", "+ this.numberOfSeats;
	}

	
		
	
    
}
