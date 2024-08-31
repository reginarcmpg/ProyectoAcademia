package builder;

public class Client {
	public static void main(String[] args) {

		
		
		Director director = new Director();
        

        CoffeBuilder coffebuilder = new CoffeBuilder();
        TeBuilder tebuilder = new TeBuilder();
        director.Coffe(coffebuilder);
        director.Te(tebuilder);
        Drink drinkCoffe = coffebuilder.getResult();
        Drink drinkTe = tebuilder.getResult();
        
        System.out.println( drinkCoffe);
        System.out.println( drinkTe);
	}
}
