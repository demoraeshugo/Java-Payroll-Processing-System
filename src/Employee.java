public class Employee {
    private final Profile profile;

    Employee( String name, String department, Date dateHired ) {
        profile = new Profile(name, department, dateHired);
    }

    @Override
    public String toString() { return " "; }

    public boolean equals() { return true; }

    public void calculatePayment() { }
}
