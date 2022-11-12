package Vehicle.Automobile;

import Vehicle.Vehicle;

public class Automobile extends Vehicle {
    
	private double engine_volume;
	private final int basePrice = 200000;

	// CONSTRUCTORS
	public Automobile(String id, MonthOfSale mos, CityOfSale cis, ProductionYear py, double vat, double engine_volume) {
		super(id, mos, cis, py, vat);
		this.engine_volume = engine_volume;
	}
	
	public Automobile() {
		super();
		this.engine_volume = 0;
	}
	
	public Automobile(Vehicle v) {
		this(v.getId(), v.getMonthOfSale(), v.getCityOfSale(), v.getProductionYear(), v.getVat(), ((Automobile) v).get_engine_volume());
	}
	
	// GETTERS
	public double get_engine_volume() {
		return this.engine_volume;
	}
	
	// EQUALS AND TOSTRING	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		Automobile temp;
		try {
			temp = (Automobile) obj;
		}catch(Exception ex) {
			return false;
		}
		
		if (super.equals(temp) && this.engine_volume == temp.get_engine_volume())
			return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "+this.get_engine_volume();
	}
	
	//calculate sct (tarık)
	public double calculateTotalPrice() {
		double sct = calculateSCT();
		
		return basePrice*(1+(sct*0.8))+(1+this.getVat()/100);
	}
	
	
	
	public double calculateSCT() {
		return 0;
	}
}
