package Stream2;

import java.time.LocalDate;

public class Event1 {
    private String Name;
    private LocalDate Date;
    private String Category;

    public Event1(String Name, LocalDate Date, String Category) {
        this.Name = Name;
        this.Date = Date;
        this.Category = Category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
