import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit test Class for Company
 * @author Hugo De Moraes, Jonathan Dong
 */

class CompanyTest {

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
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
        Assertions.assertFalse(testCompany.setHours(f1,99));//Test Case 6: set hours on Employee not in Company
        testCompany.add(f1);
        Assertions.assertFalse(testCompany.setHours(f1,88));//Test Case 7: set hours on non-Parttime employee
        Parttime p3 = new Parttime("Lawrence, Johny", "ECE", new Date("3/05/1985"), 20.5);
        testCompany.add(p3);
        Assertions.assertFalse(testCompany.setHours(p3, -5));//Test Case 8: set invalid number of hours (less than 0)
        Assertions.assertFalse(testCompany.setHours(p3,101));//Test Case 9: set invalid number of hours (over 100)
        Assertions.assertTrue(testCompany.setHours(p3,80));//Test Case 10: set valid number of hours on Parttime employee
    }
}
