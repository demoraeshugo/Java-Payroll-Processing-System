package payroll_processing_system;

/**
 * Fulltime Class is a child class of Employee, and represents a Full-time employee with additional instance variable
 * Salary.
 *
 * @author Hugo De Moraes, Jonathan Dong
 */
public class Fulltime extends Employee {
    private double salary;
    private final int NUM_PAY_PERIODS = 26;

    /**
     * Constructor for Fulltime Object, creates Fulltime employee with given name, department, dateHired, and salary
     * @param name name of Fulltime Employee
     * @param department department of Fulltime Employee
     * @param dateHired date of hire of Fulltime Employee
     * @param salary salary of Fulltime Employee
     */
    Fulltime(String name, String department, Date dateHired, double salary) {
        super(name, department, dateHired);
        this.salary = salary;
    }

    /**
     * getter method that returns the constant NUM_PAY_PERIODS
     * @return NUM_PAY_PERIODS
     */
    public int getNumPayPeriod() {
        return NUM_PAY_PERIODS;
    }

    /**
     * Overridden toString method converts a Fulltime to its String representation
     * @return a formatted String containing name, department, dateHired, and Salary
     */
    @Override
    public String toString() {
        // Doe,Jane::ECE::1/1/2005::Payment $0.00::FULL TIME::Annual Salary $85,000.00
        return super.toString() + String.format(IoFields.FULLTIME_EMPLOYEE_STRING, super.getFormattedPayment(), useFormatter(salary));
    }

    /**
     * Overridden equals method to determine if two Fulltimes are equal
     * @param obj Fulltime Employee to be evaluated for equality
     * @return true if profiles of Employee are equal and salaries are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        return super.equals(obj);
    }

    /**
     * Overridden calculatePayment method calculates and sets the payment of Fulltime employee
     * sets payment as Salary/ number of pay periods
     */
    @Override
    public void calculatePayment() {
        super.setPayment( salary / NUM_PAY_PERIODS);
    }
}
