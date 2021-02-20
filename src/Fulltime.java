public class Fulltime extends Employee {
    private final Double SALARY;
    private final int NUM_PAY_PERIODS = 26;

    Fulltime(String name, String department, Date dateHired, double salary) {
        super(name, department, dateHired);
        this.SALARY = salary;
    }

    private String getFormattedSalary() {
        return Employee.formatter.format(SALARY);
    }

    public int getNumPayPeriod() { return NUM_PAY_PERIODS; }

    @Override
    public String toString() {
        // Doe,Jane::ECE::1/1/2005::Payment $0.00::FULL TIME::Annual Salary $85,000.00
        return super.toString() + String.format(IoFields.FULLTIME_EMPLOYEE_STRING, super.getFormattedPayment(), getFormattedSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        return super.equals(obj);
    }

    @Override
    public void calculatePayment() {
        super.setPayment( SALARY / NUM_PAY_PERIODS);
    }
}
