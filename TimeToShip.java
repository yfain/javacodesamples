public class TimeToShip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box<Nokia> boxOfPhones = new Box<>();
		// boxOfPhones.add(new Nokia());
		
		Box<Blackberry> boxOfPhones2 = new Box<>();
		 
		// Create a shipment of Nokia phones
		ShippingOrder<String, Box<Nokia>> so1= 
				new ShippingOrder<> ("ph1234", boxOfPhones);
		
		// Create a shipment of Blackberry phones
	    ShippingOrder<String, Box<Blackberry>> so2= 
	    		new ShippingOrder<> ("ph4321", boxOfPhones);
	}
}
