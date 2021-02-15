/**
 * IoFields class contains String messages that are used to display info about user commands
 * that are handled by the Kiosk class
 *
 * @author Hugo De Moraes, Jonathan Dong
 */
public final class IoFields {
    public static final String startPrompt = "Payroll Processing starts.";
    public static final String endPrompt = "Payroll Processing completed.";
    public static final String invalidCommandLog = "Command '%s' not supported!%n";
    public static final String invalidManagerCodeLog = "invalid management code.";
    public static final String invalidDateLog = "%s is not a valid Date!%n";
    public static final String invalidDepartmentCodeLog = "'%s' is not a valid department code.%n";
    public static final String invalidPayRateLog = "Pay rate cannot be negative.";
    public static final String employeeAddSuccessLog = "Employee Added.";
    public static final String employeeAddFailureLog = "Employee is already in the list.";
}
