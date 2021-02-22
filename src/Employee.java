import java.text.DecimalFormat;

/**
 * Employee class represents an abstract data type Employee, which models any employee in a real life situation.
 * Each employee  is designed with a profile (abstract data type with name, date hired,and department), a payment number,
 * and a decimal formatter. Multiple Employees will be held by the Company Class.
 */
public class Employee {
    private final Profile profile;
    private double payment;
    static DecimalFormat formatter = new DecimalFormat("#,###,##0.00");

    /**
     * constructor for Employee, creates Employee with given name, department, and date hired.
     * @param name name of Employee
     * @param department department of Employee
     * @param dateHired hire date of Employee
     */
    Employee( String name, String department, Date dateHired ) {
        profile = new Profile(name, department, dateHired);
    }

    /**
     * Overriden toString method converts Employee to its String representation
     * @return a formatted String containing the Employee's name, department and date hired
     */
    @Override
    public String toString() {
        return String.format(IoFields.EMPLOYEE_STRING, profile.getName(), profile.getDepartment(), profile.getDateHired());
    }

    /**
     * Overriden equals method compares two Employees and determines if they equal.
     * @param o Employee object to be evaluated for equality
     * @return true if the profiles of two employees are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Employee)) {
            return false;
        }

        // typecast o to Employee so that we can compare data members
        Employee e = (Employee) o;

        // Compare the data members and return accordingly
        if (profile.equals(e.profile)) {
            // two employees are equal only if their profiles are
            return true;
        } else {
            return false;
        }
    }

    /**
     * getter method for Profile attribute of Employee
     * @return Profile of Employee
     */
    public Profile getProfile(){
        return this.profile;
    }

    /**
     * blank method that is implemented in children of Employee
     * used to calculate payment
     */
    public void calculatePayment() {

    }

    /**
     * setter method for payment attribute of employee
     * @param amount double representation for amount of payment
     */
    public void setPayment(double amount) {
        payment = amount;
    }

    /**
     * adds additional amount for payment
     * @param amount double to be added to payment
     */
    public void addPayment(double amount) {
        payment += amount;
    }

    /**
     * getter method for formatted version of payment to two decimal places
     * @return String representation of payment to 2 decimals
     */
    public String getFormattedPayment() {
        return formatter.format(payment);
    }
}
