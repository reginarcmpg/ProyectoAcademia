package Decorate;

public class Main {

	public static void main(String[] args) {
		
		Client client1 = new Client("Monica");
		Service serv1 = new FacialTreatment();
		ServiceDecorate serv2 = new EssentialOils(serv1);
		serv1.Service(client1);  
        serv2.Service(client1);
        System.out.println();
        System.out.println("Total cost for " + client1.getName() + ": " + client1.getCost());
        
        System.out.println();
        
        Client client2 = new Client("Regina");
		Service serv3 = new SwedishMassage();
		ServiceDecorate serv4 = new HotStone(serv3);		
		serv3.Service(client2);  
        serv4.Service(client2);
        System.out.println();
        System.out.println("Total cost for " + client2.getName() + ": " + client2.getCost());
	}

}
