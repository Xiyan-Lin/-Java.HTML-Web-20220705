package mvc.entity;

import java.util.Date;

public class Exchange {
	private Double amount;   // 金額
	private String from;     // from 幣別
	private String to;       // to 幣別
	private Double exchange; // 匯率
	private Double result;   // 換匯結果
	private Date datetime;   // 匯率日期
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Double getExchange() {
		return exchange;
	}
	public void setExchange(Double exchange) {
		this.exchange = exchange;
	}
	public Double getResult() {
		return result;
	}
	public void setResult(Double result) {
		this.result = result;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	@Override
	public String toString() {
		return "Exchange [amount=" + amount + ", from=" + from + ", to=" + to + ", exchange=" + exchange + ", result="
				+ result + ", datetime=" + datetime + "]";
	}
	
	
}
