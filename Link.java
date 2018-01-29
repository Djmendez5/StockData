
public class Link {
String date;
Float open;
Float high;
Float low;
Float close;
Float adjclose;
int volume;
Object data;
Link next;
Link previous;

public Link(String date, Float open, Float high, Float low, Float close, Float adjclose, int volume){
	next = null;
	previous = null;
	this.date=date;
	this.open=open;
	this.high=high;
	this.low=low;
	this.close=close;
	this.adjclose=adjclose;
	this. volume=volume;
}
public Link(Object newdata) {
	next = null;
	previous = null;
	this.data= newdata;
}
public Link() {
	next = null;
	previous = null;
	
}
public void  setData (Object data) {
	this.data = data;

}
public void setPrevious(Link node) {
	previous = node;
}
public Link getNext() {
	return next;
}
public Object getData() {
	return data;
}
public Link getPrevious() {
	return previous;
}
public String getDate() {
	return date;
}
public void setDate(String newdate) {
	this.date= newdate;
}
public Float getOpen() {
	return open;
}
public void setOpen(Float newopen) {
	this.open = newopen;
}
public Float getHigh() {
	return high;
}
public void setHigh(Float newhigh) {
	this.high = newhigh;
}
public Float getLow() {
	return low;
}
public void setLow(Float newlow) {
	this.low =newlow;
}
public Float getClose() {
	return close;
}
public void setClose(Float newclose) {
	this.close =newclose;
}
public Float getAdjclose() {
	return adjclose;
}
public void setAdjclose(Float newadj){
	this.adjclose = newadj;
}
public int getVolume() {
	return volume;
}
public void setVolume(int newVolume) {
	this.volume = newVolume;
}
}
