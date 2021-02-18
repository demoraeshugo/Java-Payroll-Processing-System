public class Parttime extends Employee{
    private float hourlyRate;
    private int hours;

    Parttime(String name, String department, Date dateHired, float hourlyRate) {
        super(name, department, dateHired);
        this.hourlyRate = hourlyRate;
    }

    Parttime(String name, String department, Date dateHired, int hours) {
        super(name, department, dateHired);
        this.hours = hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() { return " "; }

    @Override
    public boolean equals() { return true; }

    @Override
    public void calculatePayment() {

    }
}
