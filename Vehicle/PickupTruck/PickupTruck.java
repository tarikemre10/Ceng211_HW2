package Vehicle.PickupTruck;

import Vehicle.Vehicle;

public class PickupTruck extends Vehicle {
    
	private CabType cab_type;
	private TruckBedType truck_bed_type;
	
	public enum CabType{
		REGULAR, EXTENDED, CREW;
		
		public double value() {
			switch(this) {
				case REGULAR:
					return 2.5;
				case EXTENDED:
					return 2.8;
				case CREW:
					return 3;
				default:
					return 0;
			}
		}
	}
	
	public enum TruckBedType {
		REGULAR, TANKER, TRAILER;
		
		public double value() {
			switch(this) {
				case REGULAR:
					return 0.5;
				case TANKER:
					return 0.8;
				case TRAILER:
					return 1;
				default:
					return 0;
			}
		}
	}
	
	// CONSTRUCTORS
	public PickupTruck(String id, MonthOfSale mos, CityOfSale cis, ProductionYear py, double vat, CabType cab_type, TruckBedType truck_bed_type) {
		super(id, mos, cis, py, vat);
		this.cab_type = cab_type;
		this.truck_bed_type = truck_bed_type;
	}
	
	public PickupTruck() {
		super();
		this.cab_type = CabType.REGULAR;
		this.truck_bed_type = TruckBedType.REGULAR;
	}
	
	public PickupTruck(Vehicle v) {
		this(v.getId(), v.getMonthOfSale(), v.getCityOfSale(), v.getProductionYear(), v.getVat(), ((PickupTruck) v).get_cab_type(), ((PickupTruck) v).get_truck_bed_type());
	}
	
	// GETTERS 
	public CabType get_cab_type() {
		return this.cab_type;
	}
	
	public TruckBedType get_truck_bed_type() {
		return this.truck_bed_type;
	}
	
	// EQUALS AND TOSTRING
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		PickupTruck temp;
		try {
			temp = (PickupTruck) obj;
		}catch(Exception ex) {
			return false;
		}
		
		if (super.equals(temp) && this.cab_type.equals(temp.get_cab_type()) && this.truck_bed_type.equals(temp.truck_bed_type))
			return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "+ this.cab_type + ", "+this.truck_bed_type;
	}
	
}
