package mvc.repository;

import java.io.IOException;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ExchangeDao {
	public Stock get(String symbol) throws IOException {
		Stock stock = YahooFinance.get(symbol);
		return stock;
	}
	
	public static void main(String[] args) throws IOException {
		//String symbol = "USDTWD=x";  // x -> Exchange
		String symbol = "2356.TW";
		ExchangeDao dao = new ExchangeDao();
		System.out.println(dao.get(symbol));
	}
}
