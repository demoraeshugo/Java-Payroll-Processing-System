public class Company {
    private Employee[] emplist;
    private int numEmployee;
    private final int sizeFactor = 4; // initialize here for use in constructor

    /**
     * default constructor to create an empty bag with numEmployee = 0
     */
    public Company() {
        emplist = new Employee[sizeFactor];
        numEmployee = 0;
    }

    private int find(Employee employee) {
        int indexOfEmp = -1;
        for (int i = 0; i < emplist.length; i++) {
            if (emplist[i] != null && emplist[i].equals(employee)) {
                indexOfEmp = i;
                break;
            }
        }
        return indexOfEmp;
    }

    /**
     * helper method to grow the capacity by 4
     */
    private void grow() {
        // create new array of length current + 4
        Employee[] newBag = new Employee[emplist.length + sizeFactor];

        // copy over all elements from current to new array
        for (int i = 0; i < emplist.length; i++) {
            newBag[i] = emplist[i];
        }

        // set new array as the emplist property
        emplist = newBag;
    }

     public boolean add(Employee employee) {
        return false;
        /*
        // check if employee already in database
        boolean alreadyExists = find(employee) != -1;
        if( alreadyExists ) {
            return false;
        }

        // grow data structure if needed
        if (numEmployee == emplist.length - 1) {
             grow();
        }

         emplist[numEmployee] = employee;
         numEmployee++;

         return true;
         */
     } //check the profile before adding

    // public boolean remove(Employee employee) { } //maintain the original sequence

    // public boolean setHours(Employee employee) { } //set working hours for a part time

    public void processPayments() { } //process payments for all employees

    public void print() { } //print earning statements for all employees

    public void printByDepartment() { } //print earning statements by department

    public void printByDate() { } //print earning statements by date hired

}
