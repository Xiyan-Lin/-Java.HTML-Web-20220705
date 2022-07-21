package bean;

public class Coffee {
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Coffee [amount=" + amount + "]";
	}
	
}
