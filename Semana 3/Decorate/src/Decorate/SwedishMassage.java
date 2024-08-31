package Decorate;

public class SwedishMassage implements Service {

	int price = 450;
	
	@Override
	public void Service(Client client) {
		client.setCost(client.getCost() + price);
		System.out.println("Swedish Massage Service Price: " + price);
		System.out.println("Cliente: " + client.getName());
		
	}

}
