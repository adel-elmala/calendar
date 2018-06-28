/*   algorithm
 OK 1- get the month & year from the user 
 OK	1.1- convert month & year form string type to int type
2- print the month body
	OK	2.1- calculate the number of days in the month entered 
	OK	2.1.1- determine if the year is regular or leap
	2.2- get the start day of week in the month 
	OK	2.2.1- calculate the total days since 1800 till the last month right before the required month 


*/
import javax.swing.JOptionPane;
public class calendar{
	/** main method*/
	public static void main(String[] args){
		//promot the user to enter the year
		String stingYear = JOptionPane.showInputDialog(null,"Enter the year","Calendar",JOptionPane.INFORMATION_MESSAGE);
		// convert the year entered to int type
		int year = Integer.parseInt(stingYear);
		// prompt the user to enter the month
		String stringMonth = JOptionPane.showInputDialog(null,"Enter the month","calendar",JOptionPane.INFORMATION_MESSAGE);
		// convert the year entered to int type

		int month = Integer.parseInt(stringMonth);
		printBody(year,month);
	}
	/** print body method */
	public static void printBody(int year, int month){
		String title = "          " + monthName(month) + " , " + year;
		title += '\n' + "-----------------------------------";
		title += '\n' + " Sun Mon Tue Wed Thu Fri Sat";
		System.out.println(startDay(year,month));
		System.out.println(title);
		for(int i=1;i<=startDay(year,month);i++){
			System.out.print("    ");
		}
		
		for(int j = 1;j<= monthDays(year,month);j++){
			if(j<10)
				System.out.print("   "+j);
			else
				System.out.print("  "+j);

			if((j+startDay(year,month))%7 == 0)
				System.out.println();
		}
		

		






	}
	/** calculate the total number of days */
	public static long totalDays1800(int year,int month){
			long total = 0;
		for(int i = 1800;i< year;i++){
			if(isleap(i))
				total += 366;
			else
				total += 365;

		}
		for(int j = 1; j<month;j++){
			total += monthDays(year,j);

		}
		return total;
	}
	/** getting the number of Days in each month*/
	public static int monthDays(int year,int month){
		int days = 0 ;
		if(month == 1 ||month == 3 ||month == 5 ||month == 7 ||month == 8 ||month == 10 ||month == 12)
			days= 31;

		if (month == 4 ||month == 6 ||month == 9 ||month == 11)
			days= 30;

		if(month == 2){
			if(isleap(year))
				days= 29;
			else
				days= 28;
		}
		return days;
	}



	/** checking if the year is LEAP year*/
	public static boolean isleap(int year){
		if((year%400 ==0) || (year%4 == 0) && (year%100 != 0))
			return true;
		else
			return false;
	}
	/** get the start day of the month */
	public static int startDay(int year,int month){
		int startDay1800 = 3;
		long totalNumDays = totalDays1800(year,month);
		return (int)((totalNumDays+startDay1800)%7);
	}
	/** get the name of month entered*/
	public static String monthName(int month){
		String monthName = null;
		switch (month){
			case 1:monthName ="January";break;
			case 2:monthName ="February";break;
			case 3:monthName ="March";break;
			case 4:monthName ="April";break;
			case 5:monthName ="May";break;
			case 6:monthName ="June";break;
			case 7:monthName ="July";break;
			case 8:monthName ="August";break;
			case 9:monthName ="Septemper";break;
			case 10:monthName ="October";break;
			case 11:monthName ="November";break;
			case 12:monthName ="december";break;
		}
		return monthName;
	}
}
