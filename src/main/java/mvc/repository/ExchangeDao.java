package mvc.repository;

import java.io.IOException;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ExchangeDao {
	public Stock get(String symbol) throws IOException {
		Stock stock = YahooFinance.get(symbol);
		return stock;
	}
	
}
