
package InterfaceFunctional;

import static java.lang.Integer.compareUnsigned;
import static java.lang.Integer.max;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InterfaceFunctional {

    public static void main(String[] args) {
       
        
        System.out.println();
        System.out.println("Supplier");
        
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();
        System.out.println(time);
        
       Supplier<String> a = () -> "Hello Java";
       System.out.println(a.get());
       
       Supplier<Double> randomDouble = () -> Math.random(); 
       System.out.println(randomDouble.get()); 
       
       Supplier<Integer> RandomInt = () -> new Random().nextInt(1000);
       System.out.println(RandomInt.get());

        System.out.println();
        System.out.println("****************************************");
        System.out.println("Consumer");

        Consumer<String> message = msj ->  System.out.println(msj);
        message.accept("Hello");
        
        Consumer<Integer> num = num1 ->  System.out.println(num1 + 1);
        num.accept(2);
        
        List<Integer> arr = Arrays.asList(5, 16);
        Consumer<Integer> arrCon = n -> System.out.println(n * 2);
        arr.forEach(arrCon);
        
        Consumer<String> LengCon = lencon -> System.out.println(lencon.length());
        LengCon.accept("Elephant");
        
        System.out.println();
        System.out.println("****************************************");
        System.out.println("BiConsumer");

        BiConsumer<Integer, Integer> SumBiC = (x, y) -> System.out.println(x + y);
        SumBiC.accept(2, 5);
        
        BiConsumer<String, String> ConBiC = (x, y) -> System.out.println(x + y);
        ConBiC.accept("Hello", "World"); 
        
        BiConsumer<Integer, Integer> MaxBiC = (x, y) -> System.out.println(max(x, y));
        MaxBiC.accept(5, 2); 
        
        BiConsumer<Integer, Integer> BiCU = (x, y) -> System.out.println(compareUnsigned(x, y));
        BiCU.accept(8, 19); 
        
      
        
        

        
        
        
        
        
        
        
        
        
    }
    
}
