
package Stream2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main2 {

    
    public static void main(String[] args) {
        
     LocalDate compareDate = LocalDate.of(2024, 7, 1);

    List<Event1> LEvent = Arrays.asList(
        new Event1("Veronica", LocalDate.of(2024, 8, 24), "XV"),
        new Event1("Lucia", LocalDate.of(2024, 9, 15), "XV"),
        new Event1("Christmas Gala", LocalDate.of(2024, 12, 25), "Holiday"),
        new Event1("Christmas Gala", LocalDate.of(2024, 12, 25), "Holiday"),
        new Event1("Summer Festival", LocalDate.of(2024, 6, 21), "Festival"),
        new Event1("Art Exhibition", LocalDate.of(2024, 7, 30), "Party"),
        new Event1("Art Exhibition", LocalDate.of(2024, 7, 30), "Party"),
        new Event1("New Year Party", LocalDate.of(2024, 1, 1), "Party")
        ); 
    
//  1.- Sort the categories in alphabetical order.
//  2.- Filter the list of events to include only those that occur after July 1, 2024.
//  3.- Map the filtered events to obtain the categories.
//  4.-Remove duplicates.
     
     LEvent.stream()
                 .sorted(Comparator.comparing(Event1::getCategory))
                 .filter(s -> s.getDate().isAfter(compareDate))
                 .map(e -> e.getCategory())
                 .distinct()

                 .forEach(System.out::println);
                
}
    
}

    

