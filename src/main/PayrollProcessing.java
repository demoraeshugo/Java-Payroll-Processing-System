import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *  PayrollProcessing class provides the interface for communicating with a Company object and handles input and output
 *  by processing commands from the console.This includes dealing with additions/removal to a Company, processing payments,
 *  printing earnings statements, etc.
 *
 *
 *  @author Hugo De Moraes, Jonathan Dong
 */
public class PayrollProcessing {
    private final Company company;
    private String userInput;
    private String[] tokens;

    /**
     * default constructor for PayrollProcessing
     */
    public PayrollProcessing() {
        company = new Company();
    }

    /**
     * tokenizes a given input String
     *
     * @param input string to be tokenized
     * @return String array of tokens (Strings split with ,)
     */
    private String[] tokenize(String input) {
        return input.split(" ");
    }

    /**
     * calls respective helper methods based on user input
     */
    private void handleUserInput() {
        switch (userInput) {
            case Commands.ADD_PARTTIME -> handleAddParttime();
            case Commands.ADD_FULLTIME -> handleAddFulltime();
            case Commands.ADD_MANAGER -> handleAddManager();
            case Commands.REMOVE_EMPLOYEE -> handleRemoveEmployee();
            case Commands.CALCULATE_PAYMENT -> handleCalculatePayment();
            case Commands.SET_HOURS -> handleSetHours();
            case Commands.PRINT_ALL -> handlePrintAll();
            case Commands.PRINT_BY_HIRE_DATE -> handlePrintByHireDate();
            case Commands.PRINT_BY_DEPARTMENT -> handlePrintByDepartment();
            default -> System.out.printf(IoFields.INVALID_COMMAND_LOG, userInput);
        }
    }

    /* -------------- Helper Methods -------------- */

    /**
     * helper method to determine if given Date object is valid
     * @param date Date object to be evaluated
     * @return true if date is valid, false otherwise
     */
    private boolean isValidDate(Date date) {
        if(!date.isValid()) {
            System.out.printf(IoFields.INVALID_DATE_LOG, date);
            return false;
        }

        return true;
    }

    /**
     * helper method to determine if department code is valid
     * @param code deptcode to be evaluated
     * @return true if code is valid, false otherwise
     */
    private boolean isValidDeptCode(String code) {
        for (String departmentCode : Company.departmentCodes) {
            if (departmentCode.equals(code)) {
                return true;
            }
        }
        System.out.printf(IoFields.INVALID_DEPARTMENT_CODE_LOG, code);
        return false;
    }

    /**
     * helper method to determine if hourlyRate is valid
     * @param rate rate to be evaluated
     * @return true if rate is greater than 0, false otherwise
     */
    private boolean isValidHourlyRate(double rate) {
        final int HOURLY_RATE_LOWER_BOUND = 0;

        if( rate < HOURLY_RATE_LOWER_BOUND ) {
            System.out.println(IoFields.INVALID_PAY_RATE_LOG);
            return false;
        }

        return true;
    }

    /**
     * helper method to determine if salary is valid
     * @param salary salary to be evaluated
     * @return true if salary is a double greater than 0, false otherwise
     */
    private boolean isValidSalary(double salary) {
        final int SALARY_LOWER_BOUND = 0;

        if( salary < SALARY_LOWER_BOUND ) {
            System.out.println(IoFields.INVALID_SALARY_LOG);
            return false;
        }
        return true;
    }

    /**
     * helper method to determine if management code is valid
     * @param code code to be evaluated
     * @return true if code is integer between 1 and 3, false otherwise
     */
    private boolean isValidMgmtCode(int code) {
        for (int managerCode : Company.managerCodes) {
            if (code == managerCode) {
                return true;
            }
        }

        System.out.println(IoFields.INVALID_MANAGER_CODE_LOG);
        return false;
    }

    /**
     * helper method to determine if hours are valid
     * @param hours num of hours to be evaluated
     * @return true if hours is int between 0 and 100 inclusive, false otherwise
     */
    private boolean isValidHours(int hours) {

        if(hours < Company.HOURS_LOWER_BOUND) {
            System.out.println(IoFields.SET_NEGATIVE_HOURS_FAILURE_LOG);
            return false;
        }

        if(hours > Company.HOURS_UPPER_BOUND) {
            System.out.println(IoFields.SET_OVER_ONE_HUNDRED_HOURS_FAILURE_LOG);
            return false;
        }

        return true;
    }

    /**
     * helper method to determine if various fields are valid
     * @param deptCode department code to be evaluated
     * @param date date object to be evaluated
     * @param salary salary to be evaluated
     * @param mgmtCode management code to be evaluated
     * @return true if all are valid, false otherwise
     */
    private boolean isValidFields(String deptCode, Date date, int salary, int mgmtCode ) {
        return isValidDeptCode(deptCode) && isValidDate(date) && isValidSalary(salary) && isValidMgmtCode(mgmtCode);
    }

    /**
     * helper method to determine if various fields are valid
     * @param deptCode department code to be evaluated
     * @param date date object to be evaluated
     * @return true if all are valid, false otherwise
     */
    private boolean isValidFields(String deptCode, Date date) {
        return isValidDeptCode(deptCode) && isValidDate(date);
    }

    /**
     * helper method for adding any employee, if true prints success log, if false prints fail log
     * @param employee Employee object to be added
     */
    private void addEmployee(Employee employee) {
        if(!company.add(employee)) {
            System.out.println(IoFields.EMPLOYEE_ADD_FAILURE_LOG);
            return;
        }

        System.out.println(IoFields.EMPLOYEE_ADD_SUCCESS_LOG);
    }

    /* -------------- Handler Methods -------------- */

    /**
     * processes user input from commmand line when adding a Parttime employee
     */
    private void handleAddParttime() {
        // get input fields
        final String NAME = tokens[1];
        final String DEPARTMENT = tokens[2];
        final Date DATE_HIRED = new Date(tokens[3]);
        final double RATE = Double.parseDouble(tokens[4]);

        // validate entry
        if(!isValidFields(DEPARTMENT, DATE_HIRED)) {
            return;
        }

        if(!isValidHourlyRate(RATE)) {
            return;
        }

        // try add
        addEmployee(new Parttime(NAME, DEPARTMENT, DATE_HIRED, RATE));
    }

    /**
     * handles user input from command line when adding Fulltime employee
     */
    private void handleAddFulltime() {
        // get input fields
        final String NAME = tokens[1];
        final String DEPARTMENT = tokens[2];
        final Date DATE_HIRED = new Date(tokens[3]);
        final double SALARY = Double.parseDouble(tokens[4]);

        // validate entry
        if(!isValidFields(DEPARTMENT, DATE_HIRED)) {
            return;
        }

        if(!isValidSalary(SALARY)) {
            return;
        }

        // try add
        addEmployee(new Fulltime(NAME, DEPARTMENT, DATE_HIRED, SALARY));
    }

    /**
     * handles user input from command line when adding Management employee
     */
    private void handleAddManager() {
        // get input fields
        final String NAME = tokens[1];
        final String DEPARTMENT = tokens[2];
        final Date DATE_HIRED = new Date(tokens[3]);
        final int SALARY = Integer.parseInt(tokens[4]);
        final int MGMT_CODE = Integer.parseInt(tokens[5]);

        // validate entry
        if(!isValidFields(DEPARTMENT, DATE_HIRED, SALARY, MGMT_CODE)) {
            return;
        }

        // try add
        addEmployee(new Management(NAME, DEPARTMENT, DATE_HIRED, SALARY, MGMT_CODE));
    }

    /**
     * handles user input from command line when removing employee
     */
    private void handleRemoveEmployee() {
        final String NAME = tokens[1];
        final String DEPARTMENT = tokens[2];
        final Date DATE_HIRED = new Date(tokens[3]);
        final Employee targetEmployee = new Employee(NAME, DEPARTMENT, DATE_HIRED);

        if(DBIsEmpty()) {
            return;
        }

        if(!company.remove(targetEmployee)) {
            System.out.println(IoFields.INVALID_EMPLOYEE_LOG);
            return;
        }

        System.out.println(IoFields.EMPLOYEE_REMOVE_SUCESS_LOG);
    }

    /**
     * handles user input from command line when calculating payment
     */
    private void handleCalculatePayment() {
        if(DBIsEmpty()) {
            return;
        }

        company.processPayments();
        System.out.printf(IoFields.PAYMENT_PROCESS_COMPLETE_LOG);
    }

    /**
     * handles user input from command line when setting hours for Parttime employee
     */
    private void handleSetHours() {
        if(DBIsEmpty()) {
            return;
        }

        final String NAME = tokens[1];
        final String DEPARTMENT = tokens[2];
        final Date DATE_HIRED = new Date(tokens[3]);
        final int HOURS = Integer.parseInt(tokens[4]);
        final Employee targetEmployee = new Parttime(NAME, DEPARTMENT, DATE_HIRED);

        // validate department code && hire date
        if(!isValidFields(DEPARTMENT, DATE_HIRED)) {
            return;
        }

        // validate hours
        if(!isValidHours(HOURS)){
            return;
        }

        // try set
        if(!company.setHours(targetEmployee, HOURS)) {
            System.out.println(IoFields.INVALID_EMPLOYEE_LOG);
        }

        System.out.println(IoFields.SET_HOURS_SUCCESS_LOG);
    }

    /**
     * handles user input from command line when printing earnings for all employees
     */
    private void handlePrintAll() {
        if(DBIsEmpty()) {
            return;
        }
        System.out.println(IoFields.PRINT_PROMPT);
        company.print();
    }

    /**
     * handles user input from command line when printing earnings statements in order of date hired
     */
    private void handlePrintByHireDate() {
        if(DBIsEmpty()) {
            return;
        }
        System.out.println(IoFields.PRINT_BY_DATE_PROMPT);
        company.printByDate();
    }

    /**
     * handles user input from command line when printing earnings statements grouped by dept
     */
    private void handlePrintByDepartment() {
        if(DBIsEmpty()) {
            return;
        }
        System.out.println(IoFields.PRINT_BY_DEPT_PROMPT);
        company.printByDepartment();
    }

    /**
     * helper method to check if company is empty  ( when numemployees = 0 )
     * @return True if there are no records in data structure/database
     */
    private boolean DBIsEmpty() {
        if(company.isEmpty()){
            System.out.println(IoFields.EMPTY_DB_LOG);
            return true;
        }
        return false;
    }

    /**
     * Readies the payroll processor for user input from command line
     */
    public void run(){
        Scanner scan = new Scanner(System.in);
        System.out.println(IoFields.START_PROMPT);

        do {
            tokens = tokenize(scan.nextLine());         //tokenize each line of user input
            userInput = tokens[0];                      //sets userInput to command (A, I, O, R , etc)
            if (!userInput.equals(Commands.QUIT)) {
                handleUserInput();
            }
        } while (!userInput.equals(Commands.QUIT));

        System.out.println(IoFields.END_PROMPT);         //when finished with kiosk, end prompt is printed
    }

    // Auto input from file
    public void runTest() {
        File file = new File("src/main/testCases.txt");
        System.out.println(IoFields.START_PROMPT);

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
            do {
                tokens = tokenize(sc.nextLine());
                userInput = tokens[0];
                if(!userInput.equals(Commands.QUIT)){
                    handleUserInput();
                }
            } while(!userInput.equals(Commands.QUIT) && sc.hasNextLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(IoFields.END_PROMPT);
    }
}
