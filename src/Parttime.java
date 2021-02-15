public class Parttime extends Employee{
    private float hourlyRate;
    Parttime(String name, String department, Date dateHired, float hourlyRate) {
        super(name, department, dateHired);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() { return " "; }

    @Override
    public boolean equals() { return true; }

    @Override
    public void calculatePayment() { }
}
