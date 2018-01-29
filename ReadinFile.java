import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
public class ReadinFile {
	String[] split;
	LinkedList list = new LinkedList();
	public void readInFile(String filename) throws IOException{
		FileReader files = new FileReader(filename); 	
		BufferedReader br = new BufferedReader(files);
		String line;
		int s=0;
		line = br.readLine();
		while ((line = br.readLine()) != null){			//Read in files and then separate them by comma 
			split= line.split(",");
			//System.out.println(split[0] + ": " +split[4]);	
			//Adds the data from each stock date
			list.addStock(split[0],Float.parseFloat(split[1]),Float.parseFloat(split[2]), Float.parseFloat(split[3]), Float.parseFloat(split[4]), Float.parseFloat(split[5]), Integer.parseInt(split[6]));
		}
	}
	public void outlinerLL(String start) {
		LinkedList out = list.getOutliners(start); //get the outliners from the Linked List class
		if(out!=null) {
			System.out.println("the outliners for " + start);
		for(int i =0; i < out.size();i++) { //Iterate over the list containing the dates that the user
											//wanted , print the date and the closing date
			
			Link lk = new Link();
			lk=out.getlink(i);
			Object date= lk.getDate();
			Object closing = lk.getClose();
			Float act = linearregression(out, start);
			//if its an "outlier" it will print
			if((float)closing > act +20 ||(float) closing < act-20) {
			System.out.println(date + ": " + closing);
			}  
			}
		}
	}
	public float linearregression(LinkedList in, String date) {
		LinkedList inlist = in;
		int size = inlist.size();
		float x=0;
		float y=0;
		int n = in.size();
		float a;
		float b;
		for(int i =0; i < n-1; i++) {
			x= x+ i;
			Link link = in.getlink(i);
			String date2 = (String) in.getDate(link);
			y = y + (float)in.getClose(date2);	
		}
		float sxy = x*y;
		float sxsquare = x*x;
		float sysquare = y*y;
		a = ((y*sxsquare) - (x*sxy))/ ((n*sxsquare)- (sxsquare));
		b =((n*sxy)- (x*y))/((n*sxsquare)- (sxsquare));
		int day = inlist.getPos(date);
		Float close = a + b*day;
		
	return close;
	}
	//EXTRA CREDIT
public void calcreturn(int stocks, String start) {
	LinkedList inLL = list.getOutliners(start);
	int n = inLL.size();
	int lastpos=0;
	for(int i =0; i <n-1;i++) {
		lastpos ++;
	}
	Link lk = new Link();
	Link lk2 = new Link();
	lk=inLL.getlink(lastpos);
	
	Object last2 = lk.getClose();
	float last =  (float) last2;

	lk2=inLL.getlink(0);
	
	Object first2 = lk2.getClose();
	float first = (float) first2;
	
	float percentage =  ((last-first)/(first));
	
	System.out.println("the percentage of the return on your stocks was " + percentage +" percent");
	float profits=0;
	float earned = stocks * (float)lk.getClose();
	float spent = stocks * (float) lk2.getClose();;
	
	profits = earned -spent;
System.out.println("Your total profit in USD is: " + " $" + profits);
}


}


