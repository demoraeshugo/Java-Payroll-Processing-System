public class Management extends Fulltime{
    private String role;
    Management(String name, String department, Date dateHired, int salary, String mgmtCode) {
        super(name, department, dateHired, salary);
        this.role = mgmtCode;
    }

    @Override
    public String toString() { return " "; }

    @Override
    public boolean equals() { return true; }

    @Override
    public void calculatePayment() { }
}
