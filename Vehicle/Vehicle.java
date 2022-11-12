package Vehicle;

public class Vehicle {
    private String id;
    private MonthOfSale monthOfSale;
    private CityOfSale cityOfSale;
    private ProductionYear productionYear;
    private double vat;

    public enum MonthOfSale {
        January,
        May,
        August,
        October,
        December;
    
        public double value() {
            switch (this) {
                case January  : return 0.3;
                case May      : return 0.4;
                case August   : return 0.5;
                case October  : return 0.6;
                case December : return 0.7;
                default       : return 0.0;
            }
        }
    }

    public enum CityOfSale {
        Izmir,
        Ankara,
        Istanbul;

        public double value() {
            switch (this) {
                case Izmir    : return 0.1; 
                case Ankara   : return 0.2;
                case Istanbul : return 0.3;
                default       : return 0.0;
            }
        }
    }

    public enum ProductionYear {
        TwoThousund01_08,
        TwoThousund12_17,
        TwoThousund18_22;

        public double value() {
            switch (this) {
                case TwoThousund01_08 : return 1.0;
                case TwoThousund12_17 : return 1.2;
                case TwoThousund18_22 : return 1.6;
                default               : return 0.0;
            }
        }
    }

    public Vehicle(String id, MonthOfSale mos, CityOfSale cis, ProductionYear py, double vat) {
        this.id = id;
        this.monthOfSale = mos;
        this.cityOfSale = cis;
        this.productionYear = py;
        this.vat = vat;
    }

    public Vehicle(Vehicle v) {
        this(v.getId(), v.getMonthOfSale(), v.getCityOfSale(), v.getProductionYear(), v.getVat());
    }

    public Vehicle() {
        this("", MonthOfSale.January, CityOfSale.Izmir, ProductionYear.TwoThousund01_08, 0.0);
    }

    public String getId() {
        return id;
    }

    public MonthOfSale getMonthOfSale() {
        return monthOfSale;
    }

    public CityOfSale getCityOfSale() {
        return cityOfSale;
    }

    public ProductionYear getProductionYear() {
        return productionYear;
    }

    public double getVat() {
        return vat;
    }

    public String toString() {
        return id + ", " + monthOfSale + ", " + cityOfSale + ", " + productionYear + ", " + vat;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(obj == null)
    		return false;
    	
    	Vehicle temp;
    	try {
    		temp = (Vehicle) obj;
    	}catch(Exception ex) {
    		return false;
    	}
    	
    	if(id.equals(temp.getId()) && monthOfSale.equals(temp.getMonthOfSale()) && cityOfSale.equals(temp.getCityOfSale()) && productionYear.equals(temp.getProductionYear()) && vat == temp.getVat()) {
    		return true;
    	}
    	
    	return false;
    }

    /*
    public boolean equals(Vehicle other) {
        return id.equals(other.getId()) &&
            monthOfSale.equals(other.getMonthOfSale()) &&
            cityOfSale.equals(other.getCityOfSale()) &&
            productionYear.equals(other.getProductionYear()) &&
            vat == other.getVat();
    }*/
}
