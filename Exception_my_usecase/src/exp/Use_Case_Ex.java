package exp;

class OutOFStockException extends Exception {
	private String id;

	public OutOFStockException(String id) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Not enough items for item " + this.id;
	}

}

class OrderService {
	public boolean orderItem(String id, int quantity) throws OutOFStockException {
		double quantityRem = 5;

		if (quantity <= quantityRem) {
			return true;
		} else {
			throw new OutOFStockException(id);
		}
	}
}

class AmazonBooking {
	OrderService orderService = new OrderService();

	public void shopItem(String id, int quantity) {

		try {
			boolean b = orderService.orderItem(id, quantity);
			if (b) {
				System.out.println("Item booked");
			}

		} catch (OutOFStockException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

public class Use_Case_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonBooking amazonBooking = new AmazonBooking();
		amazonBooking.shopItem("A", 6);
	}

}
