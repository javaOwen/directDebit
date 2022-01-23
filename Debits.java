package j1;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class Debits {

	private final int BANKDETAILS_MAX = 31;
	private final int NODEBIT_NUMBER = 0;

	private SimpleDateFormat simpleDateFormat = null;

	private ArrayList<ArrayList<String>> outer1 = null;
	private ArrayList<String> inner1 = null;
	private ArrayList<ArrayList<ArrayList<String>>> directDebitList = new ArrayList<ArrayList<ArrayList<String>>>();

	private Boolean all = false;

	public Debits() {

		printRoutine("Initialising Debits class.");
		
		inits();
		
	}

	private void inits() {

		printRoutine("inits.");

		String pattern = "yyyy-MM-dd";
		simpleDateFormat = new SimpleDateFormat(pattern);
		initBankDetailsArray();

	}

	private void printRoutine(String s) {

		System.out.println(s);

	}

	private Boolean getAllReport() {
		return all;

	}

	public void setAllReport(Boolean b) {

		all = b;

	}

	private String getCurentMonth() {

		return (Integer.toString(Calendar.getInstance().get(Calendar.MONTH)));

	}

	private String getCurrentDate() {

		return (Integer.toString(Calendar.getInstance().get(Calendar.DATE)));

	}

	public void getThisDate() {
		printRoutine(getCurrentDate());
	}

	private int sumDirectDebitsForDate(int d) {
		int subArraySize = directDebitList.get(d).size();
		int sumDD = 0;

		for (int n = 0; n < subArraySize; n++) {

			sumDD = sumDD + Integer.parseInt(directDebitList.get(d).get(n).get(0));

		}

		return sumDD;
	}

	
	public int sumDirectDebits(int startDate) {
		int sumDD = 0;

		for (int n = startDate; n < BANKDETAILS_MAX; n++) {

			sumDD = sumDD + sumDirectDebitsForDate(n);

		}

		return sumDD;
	}

	public void printSumDD() {

		printRoutine("DD Sum");
		printRoutine("_____");
		printRoutine(Integer.toString(sumDirectDebits(0)));
	}

	public void printSumRemainingDD() {

		printRoutine("DD Remain Sum");
		printRoutine("_____");
		printRoutine(Integer.toString(sumDirectDebits(Integer.parseInt(getCurrentDate()))));
	}
	
	
	public void adddirectDebit(int d, int m, String desc) {
		ArrayList<String> tempArray = new ArrayList<String>();
		tempArray.add(0, Integer.toString(m));
		tempArray.add(1, desc);

		directDebitList.get(d).add(tempArray);
		int subArraySize = subArraySize = directDebitList.get(d).size();

		printRoutine("Added");
		printRoutine("_____");
		printRoutine("Date\tAmount\tType");

		printRoutine(Integer.toString(d) + "\t" + directDebitList.get(d).get(subArraySize - 1).get(0) + "\t"
				+ directDebitList.get(d).get(subArraySize - 1).get(1));

	}

	public void editdirectDebit(int d, int m, String desc) {
		int subArraySize = directDebitList.get(d).size();

		for (int n = 0; n < subArraySize; n++) {
			if (directDebitList.get(d).get(n).get(1).toUpperCase().equals(desc.toUpperCase())) {
				
				directDebitList.get(d).get(n).set(0, Integer.toString(m));
				directDebitList.get(d).get(n).set(1, desc);
			}
			
			printRoutine("Edit");
			printRoutine("_____");
			printRoutine("Date\tAmount\tType");

			printRoutine(Integer.toString(d) + "\t" + directDebitList.get(d).get(subArraySize - 1).get(0) + "\t"
					+ directDebitList.get(d).get(subArraySize - 1).get(1));

		}

	}

	public String printArrayEntryAll(int i1, int i2, int i3) {

		return (Integer.toString(i1) + "\t" + directDebitList.get(i1).get(i2).get(0) + "\t"
				+ directDebitList.get(i1).get(i2).get(1));

	}

	public String printArrayEntry(int i1, int i2, int i3) {

		return (Integer.toString(i1) + "\t" + directDebitList.get(i1).get(i2).get(0) + "\t"
				+ directDebitList.get(i1).get(i2).get(1));
	}

	public void printDirectDebitsFromDate(int d) {
		int subArraySize = 0;
		int d2 = d - 1;

		for (int n = d2; n < BANKDETAILS_MAX; n++) {
			subArraySize = directDebitList.get(n).size();

			for (int n1 = 0; n1 < subArraySize; n1++) {

				
				if (!directDebitList.get(n).get(n1).get(0).equals("0")) {
					printRoutine(printArrayEntryAll(n, n1, 0));
				}
				
				
				/*
				if (getAllReport()) {
					printRoutine(printArrayEntryAll(n, n1, 0));
				} else {
					printRoutine(printArrayEntry(n, n1, 0));
				}
				
				*/

			}
		}

	}

	public void printRemainingDD() {

		printRoutine("Remaining Month DD");
		printRoutine("________________");
		printDirectDebitsFromDate(Integer.parseInt(getCurrentDate()));
	}

	public void printArray() {

		printRoutine("printArray.");

		printRoutine("Print Array List");
		printRoutine("________________");
		printRoutine("Date\tAmount\tType");

		int subArraySize = 0;

		for (int n = 0; n < BANKDETAILS_MAX; n++) {
			subArraySize = directDebitList.get(n).size();

			for (int n1 = 0; n1 < subArraySize; n1++) {

				if (getAllReport()) {
					printRoutine(printArrayEntryAll(n, n1, 0));
				} else {

					if (!directDebitList.get(n).get(n1).get(0).equals("0")) {
						printRoutine(printArrayEntryAll(n, n1, 0));
					}
				}

			}
		}
	} // printArray

	private void initBankDetailsArray() {
		for (int i = 0; i < BANKDETAILS_MAX; i++) {
			inner1 = new ArrayList<String>();
			inner1.add(0, Integer.toString(0));
			inner1.add(1, Integer.toString(0));

			outer1 = new ArrayList<ArrayList<String>>();
			outer1.add(inner1);

			directDebitList.add(i, outer1);

			printRoutine("Added " + Integer.toString(i));

		}
	}

}
