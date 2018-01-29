import java.io.IOException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException {
		LinkedList lk = new LinkedList();
		lk.add(1);
		lk.add(2);
		lk.add(3);
		lk.remove(2);
		//System.out.println(lk.get(2));
		
		
		Scanner scan = new Scanner(System.in);
		ReadinFile rf = new ReadinFile();
		LinkedList list = new LinkedList();
		rf.readInFile("AAPL.csv");
		String stockSymbol;
		String date;
		System.out.println("Enter Stock Symbol: (AAPL)" );
		stockSymbol=scan.nextLine();
		System.out.println("Enter Starting date (YYYY-MM-DD) ");
		date = scan.nextLine();
		rf.outlinerLL(date);
	
		//EXTRA CREDIT
		String yn;
		
		System.out.println("would you like to calculate your return in investment? (y/n)");
		yn = scan.nextLine();
		if(yn.equals("y")|| yn.equals("Y")) {
			int stocks;
			System.out.println("How many stocks were purchased at the starting date?");
			stocks = scan.nextInt();
			
			rf.calcreturn(stocks,date);
		}
	}
	
	
}
