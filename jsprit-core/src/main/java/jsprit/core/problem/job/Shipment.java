package jsprit.core.problem.job;

import jsprit.core.problem.solution.route.activity.TimeWindow;
import jsprit.core.util.Coordinate;

public class Shipment implements Job{

	public static class Builder {
		
		private int demand;
		
		private String id;
		
		private String pickupLocation;
		
		private Coordinate pickupCoord;
		
		private double pickupServiceTime = 0.0;
		
		private String deliveryLocation;
		
		private Coordinate deliveryCoord;

		private double deliveryServiceTime = 0.0;

		private TimeWindow deliveryTimeWindow = TimeWindow.newInstance(0.0, Double.MAX_VALUE);

		private TimeWindow pickupTimeWindow = TimeWindow.newInstance(0.0, Double.MAX_VALUE);;
		
		public static Builder newInstance(String id, int size){
			return new Builder(id,size);
		}
		
		Builder(String id, int size) {
			if(size < 0) throw new IllegalArgumentException("size must be greater than or equal to zero");
			this.id = id;
			this.demand = size;
		}
		
		public Builder setPickupLocation(String pickupLocation){
			this.pickupLocation = pickupLocation;
			return this;
		}
		
		public Builder setPickupCoord(Coordinate pickupCoord){
			this.pickupCoord = pickupCoord;
			return this;
		}
		
		public Builder setPickupServiceTime(double serviceTime){
			this.pickupServiceTime = serviceTime;
			return this;
		}
		
		public Builder setPickupTimeWindow(TimeWindow timeWindow){
			this.pickupTimeWindow = timeWindow;
			return this;
		}
			
		public Builder setDeliveryLocation(String deliveryLocation){
			this.deliveryLocation = deliveryLocation;
			return this;
		}
		
		public Builder setDeliveryCoord(Coordinate deliveryCoord){
			this.deliveryCoord = deliveryCoord;
			return this;
		}
		
		public Builder setDeliveryServiceTime(double deliveryServiceTime){
			this.deliveryServiceTime = deliveryServiceTime;
			return this;
		}
		
		public Builder setDeliveryTimeWindow(TimeWindow timeWindow){
			this.deliveryTimeWindow = timeWindow;
			return this;
		}
		
		public Shipment build(){
			if(pickupLocation == null) { 
				if(pickupCoord == null) throw new IllegalStateException("either locationId or a coordinate must be given. But is not.");
				pickupLocation = pickupCoord.toString();
			}
			if(deliveryLocation == null) { 
				if(deliveryCoord == null) throw new IllegalStateException("either locationId or a coordinate must be given. But is not.");
				deliveryLocation = deliveryCoord.toString();
			}
			return new Shipment(this);
		}
	}
	
	private int demand;
	
	private String id;
	
	private String pickupLocation;
	
	private Coordinate pickupCoord;
	
	private double pickupServiceTime;
	
	private String deliveryLocation;
	
	private Coordinate deliveryCoord;

	private double deliveryServiceTime;

	private TimeWindow deliveryTimeWindow;

	private TimeWindow pickupTimeWindow;
	
	Shipment(Builder builder){
		this.id = builder.id;
		this.demand = builder.demand;
		this.pickupLocation = builder.pickupLocation;
		this.pickupCoord = builder.pickupCoord;
		this.pickupServiceTime = builder.pickupServiceTime;
		this.pickupTimeWindow = builder.pickupTimeWindow;
		this.deliveryLocation = builder.deliveryLocation;
		this.deliveryCoord = builder.deliveryCoord;
		this.deliveryServiceTime = builder.deliveryServiceTime;
		this.deliveryTimeWindow = builder.deliveryTimeWindow;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public int getCapacityDemand() {
		return demand;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public Coordinate getPickupCoord() {
		return pickupCoord;
	}

	public double getPickupServiceTime() {
		return pickupServiceTime;
	}

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public Coordinate getDeliveryCoord() {
		return deliveryCoord;
	}

	public double getDeliveryServiceTime() {
		return deliveryServiceTime;
	}

	public TimeWindow getDeliveryTimeWindow() {
		return deliveryTimeWindow;
	}

	public TimeWindow getPickupTimeWindow() {
		return pickupTimeWindow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shipment other = (Shipment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
