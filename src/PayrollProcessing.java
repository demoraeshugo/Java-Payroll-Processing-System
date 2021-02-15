import java.util.Scanner;

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
        return input.split(",");
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

    private void handleAddParttime() {

    }

    private void handleAddFulltime() {

    }

    private void handleAddManager() {

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
