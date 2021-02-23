package payroll_processing_system;

/**
 *   Parttime is a child class of Employee, and represents a Part-time employee with additional instance variables
 *   hourlyRate, overtimeRate, and hours
 *
 *   @author Hugo De Moraes, Jonathan Dong
 */
public class Parttime extends Employee {
    private double hourlyRate;
    private double overtimeRate;
    private int hours;

    /**
     * Constructor for Parttime object, creates Parttime employee with given name, department, dateHired and hourlyRate
     * overtimeRate is calculated from hourlyRate
     * @param name name of Parttime employee
     * @param department department of Parttime Employee
     * @param dateHired date of Hire of Parttime Employee
     * @param hourlyRate hourly pay rate of Parttime Employee
     */
    Parttime(String name, String department, Date dateHired, double hourlyRate) {
        super(name, department, dateHired);
        this.hourlyRate = hourlyRate;
        final double OVERTIME_MULTIPLE = 1.5;
        overtimeRate = hourlyRate * OVERTIME_MULTIPLE;
    }

    /**
     * alternate constructor for Parrtime object, creates Parttime employee with given name, department and dateHired
     * @param name name of Parttime employee
     * @param department department of Parttime Employee
     * @param dateHired date of Hire of Parttime Employee
     */
    Parttime(String name, String department, Date dateHired, int hours) {
        super(name, department, dateHired);
        this.hours = hours;
    }

    /**
     * getter method for hours attribute of Parttime employee
     * @return hours num hours of Parttime employee
     */
    public int getHours() { return hours; }

    /**
     * setter method for hours attribute of Parttime employee
     * @param hours num hours of Parttime employee
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Overriden toString method converts a Parttime employee to its formatted string representation
     * @return formatted String containing name, department datehired, hourly rate, and hours worked
     */
    @Override
    public String toString() {
        // Doe,Jane::ECE::8/1/2020::Payment $0.00::PART TIME::Hourly Rate $39.00::Hours worked this period: 0
        return super.toString() + String.format(IoFields.PARTTIME_EMPLOYEE_STRING, super.getFormattedPayment(), useFormatter(hourlyRate), hours);
    }

    /**
     * Overriden equals method to determine if two Parttimes are equal
     * @param obj Parttime employee to be evaluated for equality
     * @return true if profiles of Parttimes are equal and hourlyRates are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        return super.equals(obj);
    }

    /**
     * Overriden calculatePayment method calculates and sets the payment for Parttime employees
     * calculated as hours * hourlyRate with overtime hours counting as 1.5 hourlyRate
     */
    @Override
    public void calculatePayment() {
        final int OVERTIME_THRESHOLD = 80;
        int regularHours = hours;
        int overtimeHours = 0;

        if(hours > OVERTIME_THRESHOLD) {
            overtimeHours =  hours - OVERTIME_THRESHOLD;
            regularHours = OVERTIME_THRESHOLD;
        }

        super.setPayment((regularHours * hourlyRate) + (overtimeHours * overtimeRate));
    }
}
