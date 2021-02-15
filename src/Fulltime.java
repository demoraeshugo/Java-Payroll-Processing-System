public class Fulltime extends Employee {
    private int salary;
    Fulltime(String name, String department, Date dateHired, int salary) {
        super(name, department, dateHired);
        this.salary = salary;
    }

    @Override
    public String toString() { return " "; }

    @Override
    public boolean equals() { return true; }

    @Override
    public void calculatePayment() { }
}
