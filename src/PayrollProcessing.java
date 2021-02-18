import java.util.Scanner;

public class PayrollProcessing {
    private final Company company;
    private String userInput;
    private String[] tokens;
    private final String[] departmentCodes = { "CS", "ECE", "IT" };
    private final int[] managerCodes = { 1, 2, 3 };

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

    private boolean isValidDate(Date date) {
        if(!date.isValid()) {
            System.out.printf(IoFields.INVALID_DATE_LOG, date);
            return false;
        }

        return true;
    }

    private boolean isValidDeptCode(String code) {
        for(int i = 0; i < departmentCodes.length; i++) {
            if( departmentCodes[i].equals(code) ) {
                return true;
            }
        }
        System.out.printf(IoFields.INVALID_DEPARTMENT_CODE_LOG, code);
        return false;
    }

    private boolean isValidHourlyRate(float rate) {
        if( rate < 0 ) {
            System.out.println(IoFields.INVALID_PAY_RATE_LOG);
            return false;
        }
        return true;
    }

    private boolean isValidSalary(int salary) {
        if( salary < 0 ) {
            System.out.println(IoFields.INVALID_SALARY_LOG);
            return false;
        }
        return true;
    }

    private boolean isValidMgmtCode(int code) {
        for(int i = 0; i < managerCodes.length; i++) {
            if( code == managerCodes[i] ) {
                return true;
            }
        }

        System.out.println(IoFields.INVALID_MANAGER_CODE_LOG);
        return false;
    }

    private boolean isValidFields(String deptCode, Date date, float rate) {
        return isValidDeptCode(deptCode) && isValidDate(date) && isValidHourlyRate(rate);
    }

    private boolean isValidFields(String deptCode, Date date, int salary) {
        return isValidDeptCode(deptCode) && isValidDate(date) && isValidSalary(salary);
    }

    private boolean isValidFields(String deptCode, Date date, int salary, int mgmtCode ) {
        return isValidDeptCode(deptCode) && isValidDate(date) && isValidSalary(salary) && isValidMgmtCode(mgmtCode);
    }

    private void addEmployee(Employee employee) {
        if(!company.add(employee)) {
            System.out.println(IoFields.EMPLOYEE_ADD_FAILURE_LOG);
            return;
        }

        System.out.println(IoFields.EMPLOYEE_ADD_SUCCESS_LOG);
    }

    /* -------------- Handler Methods -------------- */

    private void handleAddParttime() {
        // get input fields
        final String NAME = tokens[1];
        final String DEPARTMENT = tokens[2];
        final Date DATE_HIRED = new Date(tokens[3]);
        final float RATE = Float.parseFloat(tokens[4]);

        // validate entry
        if(!isValidFields(DEPARTMENT, DATE_HIRED, RATE)) {
            return;
        }

        // try add
        addEmployee(new Parttime(NAME, DEPARTMENT, DATE_HIRED, RATE));
    }

    private void handleAddFulltime() {
        // get input fields
        final String NAME = tokens[1];
        final String DEPARTMENT = tokens[2];
        final Date DATE_HIRED = new Date(tokens[3]);
        final int SALARY = Integer.parseInt(tokens[4]);

        // validate entry
        if(!isValidFields(DEPARTMENT, DATE_HIRED, SALARY)) {
            return;
        }

        // try add
        addEmployee(new Fulltime(NAME, DEPARTMENT, DATE_HIRED, SALARY));
    }

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

    // Doe,Jane ECE 3/31/2005
    private void handleRemoveEmployee() {
        final String NAME = tokens[1];
        final String DEPARTMENT = tokens[2];
        final Date DATE_HIRED = new Date(tokens[3]);
    }

    private void handleCalculatePayment() {

    }

    private void handleSetHours() {

    }

    private void handlePrintAll() {

    }

    private void handlePrintByHireDate() {

    }

    private void handlePrintByDepartment() {

    }

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
}
