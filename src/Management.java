/**
 * Management class is a child class of Fulltime and represents a Management Employee with additional instance variables
 * roleName, roleCode, and additionalComp.
 */
public class Management extends Fulltime{
    private final int roleCode;
    private final String roleName;
    private final double additionalComp;
    private final String[] ROLES = { "Manager", "Department Head", "Director" };
    private final int[] ROLE_BONUSES = { 5000, 9500, 12000 };

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
        roleCode = mgmtCode;
        roleName = ROLES[mgmtCode-1];
        additionalComp = ROLE_BONUSES[mgmtCode-1] * 1.0 / super.getNumPayPeriod();
    }

    /**
     * Overriden toString method converts a Management employee to a formatted String representation
     * @return a formatted String containing name, date of hire, department, salary, and manager compensation
     */
    @Override
    public String toString() {
        // Doe,Jane::IT::2/28/2012::Payment $0.00::FULL TIME::Annual Salary $85,000.00::Manager Compensation $192.31
        return super.toString() + String.format(IoFields.MANAGER_STRING, roleName, getFormattedAdditionalComp());
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


//        if (!(obj instanceof Management)) {
//            return false;
//        }
//
//        // typecast f to Fulltime so that we can compare data members
//        Management m = (Management) obj;
//        if(super.equals(m) &&
//                (ROLE_CODE == m.ROLE_CODE)){
//            return true;
//        }
//        else {
//            return false;
//        }
    }

    /**
     * Overridden calculatePayment method calculates and sets the payment of Management employee
     *       sets payment as Salary/ number of pay periods plus additional compensation corresponding to roleCode
     */
    @Override
    public void calculatePayment() {
        super.calculatePayment();
        super.addPayment(additionalComp);
    }

    /**
     * returns a formatted string representing additional compensation of Management employee
     * @return formatted String of additional compensation
     */
    private String getFormattedAdditionalComp() {

        return Employee.formatter.format(additionalComp);
    }
}

// Doe,Jane::IT::2/28/2012::Payment $3,461.54::FULL TIME::Annual Salary $85,000.00::Manager Compensation $192.31
