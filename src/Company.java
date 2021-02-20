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

    // Words as intended, successfully checks for duplicates
    // check the profile before adding
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
     }

    //maintain the original sequence
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
    }

    //set working hours for a part time
    public boolean setHours(Employee employee) {
        int indexOfEmp = find(employee);

        // case employee not found
        if (indexOfEmp == -1) {
            return false;
        }

        // make sure emp in db is parttime then do rest below

        Parttime current = (Parttime) emplist[indexOfEmp];
        Parttime target = (Parttime) employee;

        current.setHours(target.getHours());

        return true;
    }

    //process payments for all employees
    public void processPayments() {
        for(int i = 0; i < emplist.length; i++) {
            if(emplist[i] != null) {
                emplist[i].calculatePayment();
            }
        }
    }

    //print earning statements for all employees
    public void print() {
        for(int i = 0; i < emplist.length; i++) {
            if(emplist[i] != null) {
                System.out.println(emplist[i].toString());
            }
        }
    }

    public void printByDepartment() { } //print earning statements by department


    public void sortByDate(){
        int n = numEmployee;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (emplist[j].getProfile().getDateHired().compareTo(emplist[min_idx].getProfile().getDateHired()) == -1)
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            Employee temp = emplist[min_idx];
            emplist[min_idx] = emplist[i];
            emplist[i] = temp;
        }

    }
    public void printByDate() {
        if (isEmpty()) {
            System.out.println(IoFields.EMPTY_DB_LOG);
        }else {
            sortByDate();
            print();
        }


    } //print earning statements by date hired

    public void printCSDepartment(){
            for(int i = 0; i < emplist.length; i++) {
                    if(emplist[i] != null && emplist[i].getProfile().getDepartment().equals("CS")) {
                        System.out.println(emplist[i].toString());
                    }
                }
    }

    public void printITDepartment(){
        for(int i = 0; i < emplist.length; i++) {
                    if(emplist[i] != null && emplist[i].getProfile().getDepartment().equals("IT")) {
                        System.out.println(emplist[i].toString());
                    }
                }
    }

    public void printECEDepartment(){
        for(int i = 0; i < emplist.length; i++) {
                    if(emplist[i] != null && emplist[i].getProfile().getDepartment().equals("ECE")) {
                        System.out.println(emplist[i].toString());
                    }
                }
    }

    public boolean isEmpty() {
        return numEmployee == 0;
    }

}
