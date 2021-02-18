/**
 * IoFields class contains String messages that are used to display info about user commands
 * that are handled by the Kiosk class
 *
 * @author Hugo De Moraes, Jonathan Dong
 */
public final class IoFields {
    public static final String START_PROMPT = "Payroll Processing starts.";
    public static final String END_PROMPT = "Payroll Processing completed.";
    public static final String INVALID_COMMAND_LOG = "Command '%s' not supported!%n";
    public static final String INVALID_MANAGER_CODE_LOG = "invalid management code.";
    public static final String INVALID_DATE_LOG = "%s is not a valid Date!%n";
    public static final String INVALID_DEPARTMENT_CODE_LOG = "'%s' is not a valid department code.%n";
    public static final String INVALID_PAY_RATE_LOG = "Pay rate cannot be negative.";
    public static final String INVALID_SALARY_LOG = "Salary cannot be negative.";
    public static final String EMPLOYEE_ADD_SUCCESS_LOG = "Employee Added.";
    public static final String EMPLOYEE_ADD_FAILURE_LOG = "Employee is already in the list.";
}
