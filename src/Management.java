public class Management extends Fulltime{
    private final int ROLE_CODE;
    private final String ROLE_NAME;
    private final double ADDITIONAL_COMP;
    private final String[] ROLES = { "Manager", "Department Head", "Director" };
    private final int[] ROLE_BONUSES = { 5000, 9500, 12000 };

    Management(String name, String department, Date dateHired, int salary, int mgmtCode) {
        super(name, department, dateHired, salary);
        ROLE_CODE = mgmtCode;
        ROLE_NAME = ROLES[mgmtCode-1];
        ADDITIONAL_COMP = ROLE_BONUSES[mgmtCode-1] * 1.0 / super.getNumPayPeriod();
    }

    @Override
    public String toString() {
        // Doe,Jane::IT::2/28/2012::Payment $0.00::FULL TIME::Annual Salary $85,000.00::Manager Compensation $192.31
        return super.toString() + String.format(IoFields.MANAGER_STRING, ROLE_NAME, getFormattedAdditionalComp());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        Management m = (Management) obj;

        if(m.getRoleCode() != ROLE_CODE) {
            return false;
        }

        return super.equals(obj);
    }

    public int getRoleCode() {
        return ROLE_CODE;
    }

    private String getFormattedAdditionalComp() {
        return Employee.formatter.format(ADDITIONAL_COMP);
    }

    @Override
    public void calculatePayment() {
        super.calculatePayment();
        super.addPayment(ADDITIONAL_COMP);
    }
}