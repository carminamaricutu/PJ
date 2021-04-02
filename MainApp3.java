package laborator6_3;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Scanner;

@SuppressWarnings("serial")
class CNP_invalid extends Exception{
	CNP_invalid(String s){
		super(s);
	}
}

;

class Persoana{
	public String nume;
	Calendar data_nasterii;
	String CNP;
	public Persoana(String n) {
		this.nume=n;
	}
	@SuppressWarnings("null")
	public Period get_varsta(String cnp) throws CNP_invalid {
		int varsta=0, dd, mm, yy = 0;
		if(cnp.length()==13) {
			if(cnp.startsWith("1")||cnp.startsWith("2")||cnp.startsWith("3")||cnp.startsWith("4")||cnp.startsWith("5")||cnp.startsWith("6"))
			{
				if(Integer.parseInt((String) cnp.subSequence(3, 5))<13&&Integer.parseInt((String) cnp.subSequence(3, 5))>0
						&&Integer.parseInt((String) cnp.subSequence(5, 7))<31&&Integer.parseInt((String) cnp.subSequence(5, 7))>0)
				{
					if(cnp.startsWith("1")||cnp.startsWith("2")) {
					yy=1900+Integer.parseInt((String) cnp.subSequence(1, 3));}
					else if(cnp.startsWith("5")||cnp.startsWith("6")) {
						yy=2000+Integer.parseInt((String) cnp.subSequence(1, 3));
					}else if(cnp.startsWith("3")||cnp.startsWith("4")) {
						yy=1800+Integer.parseInt((String) cnp.subSequence(1, 3));
					}
					mm=Integer.parseInt((String) cnp.subSequence(3, 5));	
					dd=Integer.parseInt((String) cnp.subSequence(5, 7));
					System.out.println("yy="+yy);
					System.out.println("mm="+mm);
					System.out.println("dd="+dd);

					Calendar current_date = Calendar.getInstance() ;
					Calendar data_n = Calendar.getInstance() ;

					System.out.print("Data curenta:");
					System.out.println(current_date.get(Calendar.DAY_OF_MONTH)+"."+(current_date.get(Calendar.MONTH)+1)+"."+current_date.get(Calendar.YEAR));
					data_n.set(Calendar.YEAR, yy); 
					data_n.set(Calendar.MONTH, mm-1);
					data_n.set(Calendar.DAY_OF_MONTH, dd);
					System.out.print("Data de nastere:");
					System.out.println(data_n.get(Calendar.DAY_OF_MONTH)+"."+(data_n.get(Calendar.MONTH)+1)+"."+data_n.get(Calendar.YEAR));
					//int a=(int) (current_time.  getTimeInMillis());
					//int b=(int) (data_n.getTimeInMillis());
					//varsta=(a-b)/(86400000*365+6*365);
					LocalDate data_na = LocalDate.of(yy, mm, dd); //specify year, month, date directly
					  LocalDate data_curenta = LocalDate.now(); //gets localDate
					Period d=Period.between(data_curenta,data_na);
					//System.out.println(d);
					//System.out.println("Varsta="+varsta);
					Integer.parseInt((String) cnp.substring(7));
					return d;

				}
				else throw new CNP_invalid("DATA NASTERII PRELUATA DIN CNP NU ESTE VALIDA!");
			}else throw new CNP_invalid("CIFRA CORESPUNZATOARE SEXULUI NU ESTE VALIDA!");
		}
		else throw new CNP_invalid("NUMARUL INTRODUS NU ARE 13 CARACTERE!");
	}

}

public class MainApp3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String CNP;
		boolean ok=false;
		Persoana A = new Persoana("PERSOANA");
		do {
			System.out.print("Introduceti CNP: ");

			CNP=scan.nextLine();

			try {
				//A.get_varsta(CNP);
				System.out.println(A.get_varsta(CNP));
				ok=true;
			}catch(CNP_invalid e) {
				System.out.println(e);
			}
			catch (NumberFormatException e) {
				System.out.println("CNP-UL NU POATE CONTINE LITERE/SIMBOLURI!");
				System.out.println(e);				
			}
		}while(!ok);
		
		scan.close();
	}
}
