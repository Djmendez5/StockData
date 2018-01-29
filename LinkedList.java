import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LinkedList  {
 protected Link head;
 int size;

public LinkedList() {
	head = new Link();
	size =0;
}
//Adds to the list using the information found in the file
public void addStock(String date, Float open, Float high, Float low, Float close, float adjclose, int volume) {
	Link node = new Link(date, open, high, low, close, adjclose, volume);
	if( head==null) {
		node.next=null;
		head =node;
		size++;
	}
	Link current = head;
	while( current.next != null) {
		current = current.next;
	}
	node.next = current.next;
	current.next = node;
size++;

}
//adds to the file at a specific position
public void add(int pos, Object data) {
	if(pos >= 0 && pos <=size) {
		 Link node = new Link(data);
		 if(head==null) {
			 node.next=null;
			 head =node;
			 size ++;
		 }else {
		 Link current = head;
		 for(int i= 0; i <pos; i ++) {
			 current = current.next;
		 }
	node.next = current.next;
	current.next = node;
	size++;
	}
	}
}

//adds to the end of the list
public void add(Object data) {
	Link node = new Link(data);
	if( head==null) {
		node.next=null;
		head =node;
		size++;
	}
	Link current = head;
	while( current.next != null) {
		current = current.next;
	}
	node.next = current.next;
	current.next = node;
size++;
}
//return the object at a specific position 
public Object get(int pos) {
	if(pos<0 && pos>size) {
		return null;
	}else {
	Link current = head;
	for(int i =0; i <=pos; i ++) {
		current= current.next;
	}
	return current.data;
}
}
//Removes element from the list at a specific position and returns it 
public Object remove(int pos) {
	if (pos < 0 || pos >= size) {
		return null;
	}
	Link current = head;
	for (int i = 0; i < pos; i++) {
		current = current.next;
	}
	current.next = current.next.next;
	size--;
return current.data;
}
public Object getD(int pos) {
	if(pos<0 && pos>size) {
		return null;
	}else {
	Link current = head;
	
	for(int i =0; i <=pos; i ++) {
		current= current.next;
	}
	return current.date;
}
}

public int size() {
	return size;
}

//return the Link at a specific position
public Link getlink(int pos) {
	if(pos<0 && pos>size) {
		return null;
	}else {
	Link current = head;
	for(int i =0; i <=pos; i ++) {
		current= current.next;
	}
	return current;
}
}
//return the Volume value of a specific date
public Object getVolume(String date) {
	Link current = head;
	current = current.next;
	while(current.getDate().equals(date)==false && current.next != null) {
		current = current.next; 
	}
	if(current.next==null) {
		return null;
	}
	return current.getVolume();
}
//return the adjclose value of a specific date
public Object getadjclose(String date) {
	Link current = head;
	current = current.next;
	while(current.getDate().equals(date)==false && current.next != null) {
		current = current.next; 
	}
	if(current.next==null) {
		return null;
	}
	return current.getAdjclose();
}
//return the Low value of a specific date
public Object getLow(String date) {
	Link current = head;
	current = current.next;
	while(current.getDate().equals(date)==false && current.next != null) {
		current = current.next; 
	}
	if(current.next==null) {
		return null;
	}
	return current.getLow();
}
//return the high value of a specific date
public Object gethigh(String date) {
	Link current = head;
	current = current.next;
	while(current.getDate().equals(date)==false && current.next != null) {
		current = current.next; 
	}
	if(current.next==null) {
		return null;
	}
	return current.getHigh();
}
//return the Open value of a specific date
public Object getOpen(String date) {
	Link current = head;
	current = current.next;
	while(current.getDate().equals(date)==false && current.next != null) {
		current = current.next; 
	}
	if(current.next==null) {
		return null;
	}
	return current.getOpen();
}
//return the Close value of a specific date using a String
public Object getClose(String date) {
	Link current = head;
	current = current.next;
	while(current.getDate().equals(date)==false && current.next != null) {
		current = current.next; 
	}
	if(current.next==null) {
		return null;
	}
	return current.getClose();
}
//return the adjclose value of a specific date using an Object 
public Object getClose(Object date) {
	Link current = head;
	current = current.next;
	while(current.getDate().equals(date)==false && current.next != null) {
		current = current.next; 
	}
	if(current.next==null) {
		return null;
	}
	return current.getClose();
}
//return the date of an specific Link
public Object getDate(Link link) {
	return link.getDate();
}

public int getPos(String date) {
	Link current = head;
	current = current.next;
	int pos =0;
	while(current.getDate().equals(date)==false && current.next != null) {
		pos++;
		current = current.next; 
	}
return pos;
}
//Return the Outliers of the specify date
public LinkedList getOutliners(String start) {
	LinkedList out = new LinkedList();
	Link current = head;
	current = current.next;
	while(current.getDate().equals(start)==false && current.next.next != null) {
		current = current.next;
	}
	//if there are no more than one other date after the "starting date" 
	//the program will terminate 
	if(current.next.next==null) {
		System.out.println("Date not valid");
		return null;
	}
	else {
		// set the format we want 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		//sets the Date class which the format and the date we are starting with 
		Date startDate=null; 
		 		 try {
			    startDate =  df.parse(start);
			    String newDateString = df.format(startDate);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
		 		 //turn the Date class into a Calendar class
		 		 Calendar startD = Calendar.getInstance();
		 		 startD.setTime(startDate);
		 		//set the ending date
		 		Calendar enddate = Calendar.getInstance();
		 		enddate.setTime(startDate);
		 		enddate.add(Calendar.YEAR, 1);
		 		//iterate over from the starting date to the ending date
		 		for(Calendar date = startD; date.before(enddate); date.add(Calendar.DATE, 1)){
		 			String datetotest = df.format(date.getTime());
		 		//see if the current date is not null
		 			if(getClose(datetotest)!=null){
		 				//add to the link
		 				out.addStock(datetotest, (Float)getOpen(datetotest), (Float)gethigh(datetotest), (Float)getLow(datetotest), (Float)getClose(datetotest), (Float)getadjclose(datetotest), (int)getVolume(datetotest));
		 			}
		 		}
	}
	
	return out;
}

public ListIterator iterator() {
	return  new ListIterator();
}
}
