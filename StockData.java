import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StockData  {
	LinkedList list = new LinkedList();
	private String date;
	private float open;
	private float high;
	private float low;
	private float close;
	private float adjclose;
	private int volume;
	public StockData(String date, float open, float high, float low, float close, float adjclose, int volume) {
		this.date = date;
		this.open = open;
		this.high = high;
		this.low =low;
		this.close = close;
		this.adjclose =adjclose;
		this.volume = volume;
	}
public String getdate() {
	return date;
}
public float getopen() {
	return open;
}
public float gethigh() {
	return high;
}
public float getlow() {
	return low;
}
public float getclose() {
	return close;
}
public float getadjclose() {
	return adjclose;
}
public int getvolume() {
	return volume;
}
	
	
	
}