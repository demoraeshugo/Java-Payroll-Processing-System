public class Management extends Fulltime{
    private final int ROLE;
    private final int ADDITIONAL_COMP;
    private int totalCompensation;

    Management(String name, String department, Date dateHired, int salary, int mgmtCode) {
        super(name, department, dateHired, salary);
        final int[] BONUSES = {5000, 9500, 12000};

        ROLE = mgmtCode;
        ADDITIONAL_COMP = BONUSES[ROLE-1];
    }

    @Override
    public String toString() { return " "; }

    @Override
    public boolean equals() { return true; }

    @Override
    public void calculatePayment() {
        super.calculatePayment();
        totalCompensation = super.getTotalCompensation() + ADDITIONAL_COMP;
    }
}
