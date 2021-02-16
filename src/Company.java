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
        // check if employee already in database
        if(find(employee) != -1) {
            return false;
        }

        // grow data structure if needed
        if (numEmployee == emplist.length - 1) {
             grow();
        }

         emplist[numEmployee] = employee;
         numEmployee++;

         return true;
     } //check the profile before adding

    public boolean remove(Employee employee) {
        int indexOfEmp = find(employee);

        // case employee not found
        if (indexOfEmp == -1) {
            return false;
        }

        for (int i = 0; i < emplist.length; i++) {
            // last elem will always be null by virtue of one being removed
            if (i + 1 == emplist.length) {
                emplist[i] = null;
                break;
            }
            // from the target index to end, shift elements to the left
            if (i >= indexOfEmp) {
                emplist[i] = emplist[i + 1];
            }
        }

        numEmployee--;
        return true;
    } //maintain the original sequence

    public boolean setHours(Employee employee) {
        int indexOfEmp = find(employee);

        // need to cast to parttime (I think)
        // emplist[indexOfEmp].setHours(employee.getHours());

        return true;
    } //set working hours for a part time

    public void processPayments() { } //process payments for all employees

    public void print() { } //print earning statements for all employees

    public void printByDepartment() { } //print earning statements by department

    public void printByDate() { } //print earning statements by date hired

}
