public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;

    Profile(String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }
    /*
    @Override
    public String toString() { }
    @Override
    public boolean equals(Object obj) { } //compare name, department and dateHired
     */
}