import java.text.DecimalFormat;

/**
 * Employee class represents an abstract data type Employee, which models any employee in a real life situation.
 * Each employee  is designed with a profile (abstract data type with name, date hired,and department), a payment number,
 * and a decimal formatter. Multiple Employees will be held by the Company Class.
 *
 * @author Hugo De Moraes, Jonathan Dong
 */
public class Employee {
    private Profile profile;
    private double payment;
    private DecimalFormat formatter = new DecimalFormat("#,###,##0.00");

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
     * Overridden toString method converts Employee to its String representation
     * @return a formatted String containing the Employee's name, department and date hired
     */
    @Override
    public String toString() {
        return profile.toString();
    }

    /**
     * Overridden equals method compares two Employees and determines if they equal.
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
        // two employees are equal only if their profiles are
        return profile.equals(e.profile);
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
    public void calculatePayment() { }

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
        return useFormatter(payment);
    }

    /**
     * helper method to format doubles into strings that match #,###,##0.00
     * @param value representation of number
     * @return well formatted string to 2 decimals
     */
    public String useFormatter(double value) { return formatter.format(value); }
}
