package Decorate;

public abstract class ServiceDecorate implements Service{
	
	protected Service serDecorate;
	String ExtraName;
	int extraPrice;
	
	public ServiceDecorate(Service serDecorate) {
		this.serDecorate = serDecorate;
	}

	@Override
	public void Service(Client client) {
		client.setCost(client.getCost() + extraPrice); 
		System.out.println("Extra: " + ExtraName);
		System.out.print("Price: " + extraPrice);
		
	}
	
}

