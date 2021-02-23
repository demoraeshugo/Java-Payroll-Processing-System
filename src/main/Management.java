/**
 * Management class is a child class of Fulltime and represents a Management Employee with additional instance variables
 * roleName, roleCode, and additionalComp.
 */
public class Management extends Fulltime{
    private String roleName;
    private double additionalComp;
    private final String[] ROLES = { "Manager", "Department Head", "Director" };
    private final double[] ROLE_BONUSES = { 5000.00, 9500.00, 12000.00 };

    /**
     * Constructor for Managment object, creates Management employee with given name, department, date of Hire,
     * salary, and roleCode.
     * @param name name of Managment employee
     * @param department name of department
     * @param dateHired date of Hire of Management employee
     * @param salary salary of Management employee
     * @param mgmtCode roleCode of Management employee, 1 for Manager, 2 for Department Head and 3 for Director
     */
    Management(String name, String department, Date dateHired, int salary, int mgmtCode) {
        super(name, department, dateHired, salary);
        roleName = ROLES[mgmtCode-1];
        additionalComp = ROLE_BONUSES[mgmtCode-1] / super.getNumPayPeriod();
    }

    /**
     * Overriden toString method converts a Management employee to a formatted String representation
     * @return a formatted String containing name, date of hire, department, salary, and manager compensation
     */
    @Override
    public String toString() {
        // Doe,Jane::IT::2/28/2012::Payment $0.00::FULL TIME::Annual Salary $85,000.00::Manager Compensation $192.31
        return super.toString() + String.format(IoFields.MANAGER_STRING, roleName, useFormatter(additionalComp));
    }

    /**
     * Overriden equals method to determine if two Management Employees are equal
     * @param obj Management Employee to be evaluated for equality
     * @return true if two Management employees have equal profiles, salaries and roleCodes
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return super.equals(obj);
    }

    /**
     * Overridden calculatePayment method calculates and sets the payment of Management employee
     * sets payment as Salary/ number of pay periods plus additional compensation corresponding to roleCode
     */
    @Override
    public void calculatePayment() {
        super.calculatePayment();
        super.addPayment(additionalComp);
    }
}