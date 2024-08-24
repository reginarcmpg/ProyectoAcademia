
package InterfaceFunctional;

import static java.lang.Integer.compareUnsigned;
import static java.lang.Integer.max;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceFunctional {

    public static void main(String[] args) {
       
        
        System.out.println();
        System.out.println("1.-Supplier");
        
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
        System.out.println("2.-Consumer");

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
        System.out.println("3.-BiConsumer");

        BiConsumer<Integer, Integer> SumBiC = (x, y) -> System.out.println(x + y);
        SumBiC.accept(2, 5);
        
        BiConsumer<String, String> ConBiC = (x, y) -> System.out.println(x + y);
        ConBiC.accept("Hello", "World"); 
        
        BiConsumer<Integer, Integer> MaxBiC = (x, y) -> System.out.println(max(x, y));
        MaxBiC.accept(5, 2); 
        
        BiConsumer<Integer, Integer> BiCU = (x, y) -> System.out.println(compareUnsigned(x, y));
        BiCU.accept(8, 19); 
        
        System.out.println();
        System.out.println("****************************************");
        System.out.println("4.-Predicate");
        
        Predicate<String> Letter = (Letter1) -> Letter1.contains("r");
        boolean FinalLetter = Letter.test("Burger");
        System.out.println(FinalLetter);
        
        Predicate<String> Word = (Word1) -> Word1.startsWith("Gua");
        boolean FinalWord = Word.test("Guacamole");
        System.out.println(FinalWord);
        
         Predicate<String> PreLen = (x) -> x.length() > 12;
         boolean FinalPreLen = PreLen.test("Guacamole");
         System.out.println(FinalPreLen);
        
         Predicate<String> EmpPre = (x) -> x. isEmpty();
         boolean FinalEmpPre = EmpPre.test("Guacamole");
         System.out.println(FinalEmpPre);
         
        System.out.println();
        System.out.println("****************************************");
        System.out.println("5.-BiPredicate");
        
        BiPredicate<Integer, Integer> S1 = (s1, s2) ->  ((s1 + 2) > 5) && ((s2 + 5) > 20);
        boolean FinalS =S1.test(3,7);
        System.out.println(FinalS);

        BiPredicate<String, Integer> ComNam = (Name1, numName) -> (numName >= Name1.length());
        boolean LongName =ComNam.test("Miquelle",7);
        System.out.println(LongName);
        
        BiPredicate<String, String> Empty = (NameEm1, NameEm2) -> NameEm1.isEmpty() && NameEm2.isEmpty();
        boolean Emptyname =Empty.test("Miquelle","");
        System.out.println(Emptyname);
        
        BiPredicate<String, String> Equal = (NameEq1, NameEq2) -> NameEq1.equals(NameEq2);
        boolean Equalname =Equal.test("Miquelle","Miquelle");
        System.out.println(Equalname);
        
        System.out.println();
        System.out.println("****************************************");
        System.out.println("6.-Functions");
        
        Function<String, Integer> LenFunN = x -> x.length();
        Integer apply = LenFunN.apply("Miquelle");   
        System.out.println(apply);
        
         Function<Integer, Double> Dollar = x -> x * 18.10;
         Double finalDoll = Dollar.apply(500); 
         System.out.println(finalDoll);
        
        Function<String, String> ConNameSt = x -> x + "Ring";
        String FinRes = ConNameSt.apply("Elden"); 
        System.out.println(FinRes);
        
        Function<String, String> Low = x -> x.toUpperCase();
        String Low1 = Low.apply("elden ring"); 
        System.out.println(Low1);
    }
    
}
