package Vehicle.Bicycle;

import Vehicle.Vehicle;

public class Bicycle extends Vehicle {
    
	private ChainType chain_type;
	private SeatPost seat_post;
	
	public enum ChainType{
		DERAILLEUR, ONECHAIN, DOUBLECHAIN;
		
		
		public double value() {
			switch(this) {
				case DERAILLEUR:
					return 1.1;
				case ONECHAIN:
					return 1.2;
				case DOUBLECHAIN:
					return 1.3;
				default:
					return 0;
			}
		}
	}
	
	public enum SeatPost{
		CARBONFIBER, STEEL, ALUMINUM, TITANIUM;
		
		public double value() {
			switch(this) {
				case CARBONFIBER:
					return 0.8;
				case STEEL:
					return 0.7;
				case ALUMINUM:
					return 0.9;
				case TITANIUM:
					return 0.6;
				default:
					return 0;
			}
		}
	}
	
	// CONSTRUCTORS	
	public Bicycle(String id, MonthOfSale mos, CityOfSale cis, ProductionYear py, double vat, ChainType chain_type, SeatPost seat_post) {
		super(id, mos, cis, py, vat);
		this.chain_type = chain_type;
		this.seat_post = seat_post;
	}
	
	public Bicycle() {
		super();
		this.chain_type = ChainType.DERAILLEUR;
		this.seat_post = SeatPost.CARBONFIBER;
	}
	
	public Bicycle(Vehicle v) {
		this(v.getId(), v.getMonthOfSale(), v.getCityOfSale(), v.getProductionYear(), v.getVat(), ((Bicycle) v).get_chain_type(), ((Bicycle) v).get_seat_post());
	}
	
	// GETTERS
	public ChainType get_chain_type() {
		return this.chain_type;
	}
	
	public SeatPost get_seat_post() {
		return this.seat_post;
	}
	
	// EQUALS AND TOSTRING
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		Bicycle temp;
		try {
			temp = (Bicycle) obj;
		}catch(Exception ex) {
			return false;
		}
		
		if (super.equals(temp) && this.chain_type.equals(temp.get_chain_type()) && this.seat_post.equals(temp.get_seat_post()))
			return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "+ this.chain_type + ", "+this.seat_post;
	}
	
}
