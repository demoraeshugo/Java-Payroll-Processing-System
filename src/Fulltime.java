public class Fulltime extends Employee {
    private final int SALARY;
    private final int NUM_PAY_PERIODS = 26;
    private int totalCompensation;

    Fulltime(String name, String department, Date dateHired, int salary) {
        super(name, department, dateHired);
        this.SALARY = salary;
    }

    public int getSalary() { return SALARY; }

    public int getNumPayPeriod() { return NUM_PAY_PERIODS; }

    public int getTotalCompensation() { return totalCompensation; }

    @Override
    public String toString() {
        return super.toString() + "::FULL TIME:: Annual Salary" +this.salary ; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }


        if (!(obj instanceof Fulltime)) {
            return false;
        }

        // typecast f to Fulltime so that we can compare data members
        Fulltime f = (Fulltime) obj;
        if(super.equals(f) &&
        this.salary == f.salary){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void calculatePayment() {
        totalCompensation = SALARY * NUM_PAY_PERIODS;
    }
}
