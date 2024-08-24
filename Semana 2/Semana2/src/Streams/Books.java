
package Streams;

public class Books {
    
    private String Title;
    private String Author;
    private int Year;
    private double cost;

    public Books(String Title, String Author, int Year, double cost) {
        this.Title = Title;
        this.Author = Author;
        this.Year = Year;
        this.cost = cost;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
