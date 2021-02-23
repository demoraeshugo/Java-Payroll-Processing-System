package payroll_processing_system;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Junit test Class for Company
 * @author Hugo De Moraes, Jonathan Dong
 */

class CompanyTest {

    @Test
    void add() {
        Company testCompany = new Company();
        Fulltime f1 = new Fulltime("Cena, John", "IT", new Date("3/21/2012"), 50000);
        Assertions.assertTrue(testCompany.add(f1)); // Test Case 1: checks if adding to Company is possible
        Assertions.assertFalse(testCompany.add(f1));// Test Case 2: checks adding an existing Employee to Company
        Fulltime f2 = new Fulltime("Doe, John", "ECE", new Date("1/21/2012"), 60000);
        Parttime p3 = new Parttime("Lawrence, Johny", "ECE", new Date("3/05/1985"), 20.5);
        Management m4 = new Management("Lawrence, Johny", "ECE", new Date("3/05/1985"), 100000,3);
        Management m5 = new Management("LaRusso, Danny", "ECE", new Date("3/05/1985"), 110000,2);
        testCompany.add(f2);
        testCompany.add(p3);
        testCompany.add(m4);
        Assertions.assertTrue(testCompany.add(m5));//Test Case 3: checks grow method of Company
    }

    @Test
    void remove() {
     Company testCompany = new Company();
     Fulltime f1 = new Fulltime("Cena, John", "IT", new Date("3/21/2012"), 50000);
     Assertions.assertFalse(testCompany.remove(f1));//Test Case 4: checks removing Employee not in Company
     testCompany.add(f1);
     Assertions.assertTrue(testCompany.remove(f1));//Test Case 5: removing an existing student
    }

    @Test
    void setHours() {
        Company testCompany = new Company();

        Fulltime f1 = new Fulltime("Cena, John", "IT", new Date("3/21/2012"), 50000);
        Assertions.assertFalse(testCompany.setHours(f1));//Test Case 6: set hours on Employee not in Company
        testCompany.add(f1);

        Assertions.assertFalse(testCompany.setHours(f1));//Test Case 7: set hours on non-Parttime employee

        // create 4 different employee types
        Fulltime p3 = new Fulltime("Lawrence, Johny", "ECE", new Date("3/05/1985"), 8500.00);
        Management p4 = new Management("Lawrence, Johny", "CS", new Date("3/05/1985"), 8500.00, 1);
        Parttime p5 = new Parttime("Lawrence, Johny", "IT", new Date("3/05/1985"), 30.5);
        Parttime p6 = new Parttime("Doesnt, Exist", "IT", new Date("3/05/1985"), 80);

        // add first 3 to company
        testCompany.add(p3);
        testCompany.add(p4);
        testCompany.add(p5);

        // setHours expects to receive an EXISTING parttime employee with hours set
        Parttime setP5 = new Parttime("Lawrence, Johny", "IT", new Date("3/05/1985"), 80);

        Assertions.assertFalse(testCompany.setHours(p3));//Test Case 8: invalid employee type
        Assertions.assertFalse(testCompany.setHours(p4));//Test Case 9: invalid employee type
        Assertions.assertTrue(testCompany.setHours(setP5));//Test Case 10: set valid number of hours on existing Parttime employee
        Assertions.assertFalse(testCompany.setHours(p6));//Test Case 9: exployee not in company
    }
}
