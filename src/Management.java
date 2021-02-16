public class Management extends Fulltime{
    private String role;
    private static final int YEARLY_MANAGER_COMPENSATION = 5000;
    private static final int YEARLY_DEPTHEAD_COMPENSATION = 9500;

    private static final int YEARLY_DIRECTOR_COMPENSATION = 12000;

    private static final int NUM_PAY_PERIODS = 26;

    Management(String name, String department, Date dateHired, int salary, String mgmtCode) {
        super(name, department, dateHired, salary);
        this.role = mgmtCode;
    }

    @Override
    public String toString() {
        return super.toString() + "::" + this.role + " Compensation " + this.calculateCompensation() ; }

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
                this.role.equals(m.role)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void calculatePayment() { }

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
