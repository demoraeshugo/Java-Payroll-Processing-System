public class Parttime extends Employee{
    private double hourlyRate;
    private double overtimeRate;
    private int hours;
    private final int OVERTIME_THRESHOLD = 80;

    Parttime(String name, String department, Date dateHired, double hourlyRate) {
        super(name, department, dateHired);
        this.hourlyRate = hourlyRate;
        overtimeRate = hourlyRate * 1.5;
    }

    Parttime(String name, String department, Date dateHired, int hours) {
        super(name, department, dateHired);
        this.hours = hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    private String getFormattedRate() {
        return Employee.formatter.format(hourlyRate);
    }

    @Override
    public String toString() {
        // Doe,Jane::ECE::8/1/2020::Payment $0.00::PART TIME::Hourly Rate $39.00::Hours worked this period: 0
        return super.toString() + String.format(IoFields.PARTTIME_EMPLOYEE_STRING, super.getFormattedPayment(), getFormattedRate(), hours);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        return super.equals(obj);
    }

    @Override
    public void calculatePayment() {
        int regularHours = hours;
        int overtimeHours = 0;

        if(hours > OVERTIME_THRESHOLD) {
            overtimeHours =  hours - OVERTIME_THRESHOLD;
            regularHours = OVERTIME_THRESHOLD;
        }

        super.setPayment((regularHours * hourlyRate) + (overtimeHours * overtimeRate));
    }
}
