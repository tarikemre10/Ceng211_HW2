package Vehicle.Automobile.SubAutomobiles;

import Vehicle.Automobile.Automobile;
import Vehicle.Vehicle;


public class Hatchback extends Automobile {
	private CityMode cityMode;
	
	public enum CityMode {
		Yes,No;
		
		public double value() {
			switch (this) {
			case Yes:
				return 0.15;
			case No:
				return 0.1;
			default:
				return 0;									
			}
		}		
	}

	public Hatchback(String id, MonthOfSale mos, CityOfSale cis, ProductionYear py, double vat, double engine_volume,
			CityMode cityMode) {
		super(id, mos, cis, py, vat, engine_volume);
		this.cityMode = cityMode;
	}
	
	public Hatchback(Vehicle v) {
		this(v.getId(),v.getMonthOfSale(),v.getCityOfSale(),v.getProductionYear(),v.getVat(),((Hatchback)v).get_engine_volume(),((Hatchback)v).cityMode);
	}
	
	public Hatchback() {
		super();
		this.cityMode=null;
	}
	
	@Override
	public double calculateSCT() {
		
		return (this.get_engine_volume()*0.3*this.getProductionYear().value())+getCityMode().value();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		Hatchback temp;
		try {
			temp = (Hatchback) obj;
		}catch(Exception ex) {
			return false;
		}
		
		if (super.equals(temp) && this.cityMode.equals(temp.getCityMode()) )
			return true;
		
		return false;
	}
	
	
	public CityMode getCityMode() {
		return cityMode;
	}

	
	@Override
	public String toString() {
		return super.toString() + ", "+ this.cityMode;
	}
	
	
	
	
}
