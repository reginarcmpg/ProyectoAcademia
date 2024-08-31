package Decorate;

public class FacialTreatment implements Service{
	
	int price = 500;

	@Override
	public void Service(Client client) {
		client.setCost(client.getCost() + price);
		System.out.println("Facial Treatment Service Price: " + price);
		System.out.println("Client: " + client.getName());
		
	}

}
