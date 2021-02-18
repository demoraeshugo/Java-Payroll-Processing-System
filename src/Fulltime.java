public class Fulltime extends Employee {
    private final int SALARY;
    private final int NUM_PAY_PERIODS = 26;
    private int totalCompensation;

    Fulltime(String name, String department, Date dateHired, int salary) {
        super(name, department, dateHired);
        this.SALARY = salary;
    }

    public int getSalary() { return SALARY; }

    public int getNumPayPeriod() { return NUM_PAY_PERIODS; }

    public int getTotalCompensation() { return totalCompensation; }

    @Override
    public String toString() { return " "; }

    @Override
    public boolean equals() { return true; }

    @Override
    public void calculatePayment() {
        totalCompensation = SALARY * NUM_PAY_PERIODS;
    }
}
