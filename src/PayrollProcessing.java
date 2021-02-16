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
            case Commands.addParttime -> handleAddParttime();
            case Commands.addFulltime -> handleAddFulltime();
            case Commands.addManager -> handleAddManager();
            case Commands.removeEmployee -> handleRemoveEmployee();
            case Commands.calculatePayment -> handleCalculatePayment();
            case Commands.setHours -> handleSetHours();
            case Commands.printAll -> handlePrintAll();
            case Commands.printByHireDate -> handlePrintByHireDate();
            case Commands.printByDepartment -> handlePrintByDepartment();
            default -> System.out.printf(IoFields.invalidCommandLog, userInput);
        }
    }


    /* -------------- Helper Methods -------------- */

    private boolean isValidDate(Date date) {
        if(!date.isValid()) {
            System.out.printf(IoFields.invalidDateLog, date);
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
        System.out.printf(IoFields.invalidDepartmentCodeLog, code);
        return false;
    }

    private boolean isValidHourlyRate(float rate) {
        if( rate < 0 ) {
            System.out.println(IoFields.invalidPayRateLog);
            return false;
        }
        return true;
    }

    private boolean isValidSalary(int salary) {
        if( salary < 0 ) {
            System.out.println(IoFields.invalidPayRateLog);
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

        System.out.println(IoFields.invalidManagerCodeLog);
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

    /* -------------- Handler Methods -------------- */

    private void handleAddParttime() {
        String name = tokens[1];
        String department = tokens[2];
        Date dateHired = new Date(tokens[3]);
        float rate = Float.parseFloat(tokens[4]);

        if(!isValidFields(department, dateHired, rate)) {
            return;
        }

        if(!company.add(new Parttime(name, department, dateHired, rate))) {
            System.out.println(IoFields.employeeAddFailureLog);
            return;
        }

        System.out.println(IoFields.employeeAddSuccessLog);
    }

    private void handleAddFulltime() {
        String name = tokens[1];
        String department = tokens[2];
        Date dateHired = new Date(tokens[3]);
        int salary = Integer.parseInt(tokens[4]);

        if(!isValidFields(department, dateHired, salary)) {
            return;
        }

        if(!company.add(new Fulltime(name, department, dateHired, salary))) {
            System.out.println(IoFields.employeeAddFailureLog);
            return;
        }

        System.out.println(IoFields.employeeAddSuccessLog);
    }

    private void handleAddManager() {
        String name = tokens[1];
        String department = tokens[2];
        Date dateHired = new Date(tokens[3]);
        int salary = Integer.parseInt(tokens[4]);
        int mgmtCode = Integer.parseInt(tokens[5]);

        if(!isValidFields(department, dateHired, salary, mgmtCode)) {
            return;
        }

        if(!company.add(new Fulltime(name, department, dateHired, salary))) {
            System.out.println(IoFields.employeeAddFailureLog);
            return;
        }

        System.out.println(IoFields.employeeAddSuccessLog);
    }

    private void handleRemoveEmployee() {

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
        System.out.println(IoFields.startPrompt);

        do {
            tokens = tokenize(scan.nextLine());         //tokenize each line of user input
            userInput = tokens[0];                      //sets userInput to command (A, I, O, R , etc)
            if (!userInput.equals(Commands.quit)) {
                handleUserInput();
            }
        } while (!userInput.equals(Commands.quit));

        System.out.println(IoFields.endPrompt);         //when finished with kiosk, end prompt is printed
    }
}
