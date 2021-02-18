public class Management extends Fulltime{
    private final int ROLE;
    private final int ADDITIONAL_COMP;
    private int totalCompensation;
    private static final int YEARLY_MANAGER_COMPENSATION = 5000;
    private static final int YEARLY_DEPTHEAD_COMPENSATION = 9500;
    private static final int YEARLY_DIRECTOR_COMPENSATION = 12000;
    private static final int NUM_PAY_PERIODS = 26;

    Management(String name, String department, Date dateHired, int salary, int mgmtCode) {
        super(name, department, dateHired, salary);
        final int[] BONUSES = {5000, 9500, 12000};

        ROLE = mgmtCode;
        ADDITIONAL_COMP = BONUSES[ROLE-1];
    }

    @Override
    public String toString() {
        return super.toString() + "::" + ROLE + " Compensation " + this.calculateCompensation() ; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
        return true;
    }


        if (!(obj instanceof Management)) {
            return false;
        }

        // typecast f to Fulltime so that we can compare data members
        Management m = (Management) obj;
        if(super.equals(m) &&
                (ROLE == m.ROLE)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void calculatePayment() {
        super.calculatePayment();
        totalCompensation = super.getTotalCompensation() + ADDITIONAL_COMP;
    }

    private double calculateCompensation(){
        if ( this.role.equals("Manager")){
            return YEARLY_MANAGER_COMPENSATION/NUM_PAY_PERIODS;
        }
        else if ( this.role.equals("Department Head")){
            return YEARLY_DEPTHEAD_COMPENSATION/NUM_PAY_PERIODS;
        }
        else  {
            return YEARLY_DIRECTOR_COMPENSATION/NUM_PAY_PERIODS;
        }
    }
}
