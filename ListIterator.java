public class ListIterator extends LinkedList {
private Link current;
public ListIterator() {
	current = head;
}
public boolean hasNext() {
	if(current.next != null) {
		return true;
	}
	else {
		return false;
	}
}

public Object next() {
	if(current.getNext() != null) {
		current = current.getNext();
		return current.getData();	
	}
	else {
		return null;
	}
}
public void set(Object data) {
	if(data != null) {
	current.setData(data);
	}
}
public Object remove() {
	Link temp = current;
	temp.setPrevious(current.getNext());
	if(temp.getNext() != null) {
		temp.getNext().setPrevious(temp.getPrevious());
	}
current = current.getNext();
size --;
return temp.getData();
}
}
