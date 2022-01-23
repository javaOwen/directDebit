package j1;

import java.util.ArrayList;
import java.lang.Thread;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Console;



public class Owen1 {

	private static int counter = 0;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String inputString = null;
	private Console console = System.console();

	private static Debits de = null;

	private static String menuChoiceList[] = new String[10];
	
	private static void menu() {
		
		for(int i = 0; i<10; i++) {
			System.out.println(Integer.toString(i) + ".\t" + menuChoiceList[i]);
		}
		
	}


	private static void populateMenu() {
	
		menuChoiceList[0] = "List Month";
		menuChoiceList[1] = "List month DD";
		menuChoiceList[2] = "Add DD";
		menuChoiceList[3] = "Edit DD";
		menuChoiceList[4] = "List remain month DD";
		menuChoiceList[5] = "Get date";
		menuChoiceList[6] = "Sum month DD";
		menuChoiceList[7] = "Sum remaining month DD";
		menuChoiceList[8] = "Menu";
		menuChoiceList[9] = "Quit";
		
		}
		
		
	private static void menuSelect(int i) {

		switch (i) {

		case 0:
			System.out.println(menuChoiceList[i]);
			de.setAllReport(true);
			de.printArray();

			break;
		case 1:
			System.out.println(menuChoiceList[i]);
			de.setAllReport(false);
			de.printArray();

			break;
		case 2:

			try {

				int d = 0;
				int m = 0;
				String desc = null;
				
				System.out.println(menuChoiceList[i]);
				System.out.print("Please specify date: ");
				inputString = br.readLine();
				d = Integer.parseInt(inputString);

				System.out.print("Please specify amount: ");
				inputString = br.readLine();
				m = Integer.parseInt(inputString);

				System.out.print("Please specify description: ");
				inputString = br.readLine();
				desc = inputString;

				de.adddirectDebit(d, m, desc);
			} catch (Exception e) {
				System.out.print("case 3 Exception");

			}

			break;
			
		case 3:

			try {

				int d = 0;
				int m = 0;
				String desc = null;
				System.out.println(menuChoiceList[i]);

				System.out.print("Please specify date: ");
				inputString = br.readLine();
				d = Integer.parseInt(inputString);

				System.out.print("Please specify amount: ");
				inputString = br.readLine();
				m = Integer.parseInt(inputString);

				System.out.print("Please specify description: ");
				inputString = br.readLine();
				desc = inputString;

				de.editdirectDebit(d, m, desc);
			} catch (Exception e) {
				System.out.print("case 3 Exception");

			}

			break;
		
		case 4:
			System.out.println(menuChoiceList[i]);
			
			de.setAllReport(false);
			de.printRemainingDD();
			
			break;
			
		case 5:
			System.out.println(menuChoiceList[i]);
			de.getThisDate();
			
			break;
			
		case 6:
			System.out.println(menuChoiceList[i]);
			de.printSumDD();
			
			break;
		case 7:
			System.out.println(menuChoiceList[i]);
			de.printSumRemainingDD();
			
			break;
		case 8:
			System.out.println(menuChoiceList[i]);
			
			
			break;
			
		case 9:

			menu();

			break;

		}

	}

	public static void main(String Args[]) {
		
		de = new Debits();
		de.adddirectDebit(2, 100, "Initial start ");
		populateMenu();
		
		menu();

		try {
			while ((inputString = br.readLine()) != null || !((inputString = br.readLine()).equals("Q"))) {

				menuSelect(Integer.parseInt(inputString));
				System.out.println("_________________________________________\n");
				menu();
			}
			
			System.out.println("EXIT.");

		} catch (Exception e) {
			System.out.println("Exception inputString = br.readLine");

		}

	} // main
	
} // Owen1	
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * d.printArray();
		 * 
		 * // d.printSumDirectDebits(); // d.printSumDirectDebits();
		 * 
		 * 
		 * // d.editdirectDebit(8, 75, "great stuff"); // d.printArray();
		 * 
		 * d.printRemainingDD();
		 * 
		 * 
		 * 
		 * 
		 * System.out.println("Enter your Account number: "); accStr = br.readLine();
		 * 
		 * Thread thread = new Thread("New Thread") { public void run(){
		 * System.out.println("run by: " + getName()); } };
		 * 
		 * thread.start(); System.out.println(thread.getName());
		 * 
		 * 
		 * TimerTask timerTask = new TimerTask() {
		 * 
		 * @Override public void run() {
		 * System.out.println("TimerTask executing counter is: " + counter);
		 * counter++;//increments the counter //d.getThisDate();
		 * 
		 * } };
		 * 
		 * Timer timer = new Timer("MyTimer");//create a new Timer
		 * 
		 * //timer.scheduleAtFixedRate(timerTask, 1000, 1000);
		 * 
		 */


