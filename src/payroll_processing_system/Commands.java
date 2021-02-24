package payroll_processing_system;

/**
 * Commands class contains info on each of the console commands available to the user.
 * For example, an "AP" signifies that the user is attempting to add a Part-time employee
 *
 * @author Hugo De Moraes, Jonathan Dong
 *
 */
public final class Commands {
    public final static String ADD_PARTTIME = "AP";
    public final static String ADD_FULLTIME = "AF";
    public final static String ADD_MANAGER = "AM";
    public final static String REMOVE_EMPLOYEE = "R";
    public final static String CALCULATE_PAYMENT = "C";
    public final static String SET_HOURS = "S";
    public final static String PRINT_ALL = "PA";
    public final static String PRINT_BY_HIRE_DATE = "PH";
    public final static String PRINT_BY_DEPARTMENT = "PD";
    public final static String QUIT = "Q";
    public final static String RUN_FILE = "RF";
    public final static String NEW = "N";
}