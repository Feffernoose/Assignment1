package BeautySalon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VisitTest {

	@Test
	void testCalculateTotalExpense1() {
		double productDiscountRate = DiscountRate.getProductDiscountRate("premium");
		double serviceDiscountRate = DiscountRate.getServiceDiscountRate("premium");
		double totalExpense = 900.00 - (900.00 * productDiscountRate) + 1200.00 - (1200.00 * serviceDiscountRate);
		
		assertEquals(1680.00, totalExpense);
	}
	
	@Test
	void testCalculateTotalExpense2() {
		double productDiscountRate = DiscountRate.getProductDiscountRate("premium");
		double serviceDiscountRate = DiscountRate.getServiceDiscountRate("premium");
		double totalExpense = 900.00 - (900.00 * productDiscountRate) + 1200.00 - (1200.00 * serviceDiscountRate);
		
		assertNotEquals(1450.00, totalExpense);
	}

}
