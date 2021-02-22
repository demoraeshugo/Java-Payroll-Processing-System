import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for Management Class
 */
public class ManagementTest {

    @Test
    public void calculatePayment() {

        Management m1 = new Management("Lawrence, Johny",
                "ECE", new Date("3/05/1985"), 100000,1);
        m1.calculatePayment();
        Assert.assertEquals(m1.getFormattedPayment(), "4,038.46");//Test Case 1 calculates payment for Manager
        Management m2 = new Management("LaRusso, Daniel",
                "IT", new Date("2/05/1985"), 100000,2);
        m2.calculatePayment();
        Assert.assertEquals(m2.getFormattedPayment(), "4,211.54");//Test Case 2 calculates payment for Department Head
        Management m3 = new Management("Miyagi, Mr.",
                "IT", new Date("1/05/1985"), 100000,3);
        m3.calculatePayment();
        Assert.assertEquals(m3.getFormattedPayment(), "4,307.69");//Test Case 3 calculates payment for Director
    }
}