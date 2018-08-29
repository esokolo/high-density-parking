
import java.util.Scanner;
import java.util.ArrayList;
public class Parking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


String ccNumber = "";
String custName = "";
ArrayList<String> name = new ArrayList<String>();
ArrayList<String> CCnumber = new ArrayList<String>();

System.out.println("Please swipe your card");
Scanner scan= new Scanner(System.in);
String raw = "{%B<acct_no>^<cust_name>^<*>?}";
 raw= scan.nextLine();
int head = raw.indexOf("%B");
int middle = raw.indexOf("^");
int tail = raw.lastIndexOf("^");

// 2. extract acct_no
ccNumber = raw.substring(head+2, middle);
//Testing
System.out.println("Credit Card Number = " +ccNumber);

// 3. extract cust_name
custName = raw.substring(middle+1, tail);
//Testing
System.out.println("Customer Name = " +custName);

//Add To ArrayList
name.add(custName);
CCnumber.add(ccNumber);

System.out.println("in the list " + name);
System.out.println("in the list " + CCnumber);









scan.close();


	}

}
