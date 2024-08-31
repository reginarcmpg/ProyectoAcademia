package Decorate;

public class Manicure implements Service {

	int price = 180;
	
	@Override
	public void Service(Client client) {
		client.setCost(client.getCost() + price);
		System.out.println("Manicure Service Price: " + price);
		System.out.println("Cliente: " + client.getName());
		
	}

}
