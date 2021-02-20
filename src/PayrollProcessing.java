import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

    private boolean isValidHourlyRate(double rate) {
        final int HOURLY_RATE_LOWER_BOUND = 0;

        if( rate < HOURLY_RATE_LOWER_BOUND ) {
            System.out.println(IoFields.INVALID_PAY_RATE_LOG);
            return false;
        }

        return true;
    }

    private boolean isValidSalary(double salary) {
        final int SALARY_LOWER_BOUND = 0;

        if( salary < SALARY_LOWER_BOUND ) {
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

    private boolean isValidHours(int hours) {
        final int HOURS_LOWER_BOUND = 0;
        final int HOURS_UPPER_BOUND = 100;

        if(hours < HOURS_LOWER_BOUND) {
            System.out.println(IoFields.SET_NEGATIVE_HOURS_FAILURE_LOG);
            return false;
        }

        if(hours > HOURS_UPPER_BOUND) {
            System.out.println(IoFields.SET_OVER_ONE_HUNDRED_HOURS_FAILURE_LOG);
            return false;
        }

        return true;
    }

    private boolean isValidFields(String deptCode, Date date, int salary, int mgmtCode ) {
        return isValidDeptCode(deptCode) && isValidDate(date) && isValidSalary(salary) && isValidMgmtCode(mgmtCode);
    }

    private boolean isValidFields(String deptCode, Date date) {

        return isValidDeptCode(deptCode) && isValidDate(date);
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

    // R Doe,Jane ECE 3/31/2005
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

    private void handleCalculatePayment() {
        if(DBIsEmpty()) {
            return;
        }

        company.processPayments();
        System.out.println(IoFields.PAYMENT_PROCESS_COMPLETE_LOG);
    }

    // S Doe,John CS 7/1/2020 120
    private void handleSetHours() {
        if(DBIsEmpty()) {
            return;
        }

        final String NAME = tokens[1];
        final String DEPARTMENT = tokens[2];
        final Date DATE_HIRED = new Date(tokens[3]);
        final int HOURS = Integer.parseInt(tokens[4]);
        final Employee targetEmployee = new Parttime(NAME, DEPARTMENT, DATE_HIRED, HOURS);

        // validate department code && hire date
        if(!isValidFields(DEPARTMENT, DATE_HIRED)) {
            return;
        }

        // validate hours
        if(!isValidHours(HOURS)){
            return;
        }

        // try set
        if(!company.setHours(targetEmployee)) {
            System.out.println(IoFields.INVALID_EMPLOYEE_LOG);
        }

        System.out.println(IoFields.SET_HOURS_SUCCESS_LOG);
    }

    private void handlePrintAll() {
        if(DBIsEmpty()) {
            return;
        }

        company.print();
    }

    private void handlePrintByHireDate() {
        // calls company.printByDate()
        if(DBIsEmpty()) {
            return;
        }
           company.printByDate();

    }

    private void handlePrintByDepartment() {
        if(DBIsEmpty()) {
            return;
        }
            company.printCSDepartment();
            company.printECEDepartment();
            company.printITDepartment();

    }

    private boolean DBIsEmpty() {
        if(company.isEmpty()){
            System.out.println(IoFields.EMPTY_DB_LOG);
            return true;
        }
        return false;
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

    // Auto input from file
    public void runTest() {
        File file = new File("src/testCases.txt");
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
