import java.util.*;
import java.math.*;

public class IbanBerechnen {
	
	//LaenderKenzeichnung aus Buchstaben um Zahlen ermitteln.
	public static String lnK(String ldk) {
		String newlnk1 ="";
		String newlnk2 ="";
		int j=0;
		String Alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				
		for (int i=10; i<=35; i++) {
						
			if(ldk.charAt(0) == Alphabet.charAt(j)) {
				newlnk1 = (""+i);;
			}
							
			if(ldk.charAt(1) == Alphabet.charAt(j)) {
				newlnk2 = (""+i);
			}
			j++;	
			
		}
		String summe = newlnk1+newlnk2;
		return summe;
	}
	
	//10 stellige Kontonummer ermitteln.
	public static String Knummer(String n) {
		
		if (n.length() < 10) {
			int summe = 10 - n.length();
		for (int i=0; i<summe; i++) {
			n = "0"+n;
		}
		
		}
		return n;
	}
	
	public static String bban(String blz, String kn) {
		String bBan = "";
		String konto = Knummer(kn);
		bBan = blz+konto;
		
		return bBan;
	}
	
	//iban Berechnung.
	
	public static String iban(String ibbn, String lc, String blz, String kn) {
		String iban = "";
		
		String firstP = ibbn.substring(0, 9);
		long a=Long.parseLong(firstP);
		long result1 = a % 97;
		
		String SecondP = result1 + ibbn.substring(9, 16);
		long b=Long.parseLong(SecondP);	
		long result2 = b % 97;
		
		String thirdP = result2 + ibbn.substring(16, 23);
		long c=Long.parseLong(thirdP);	
		long result3 = c % 97;
		
		String fourhtP = result3 + ibbn.substring(23, 24);
		long d=Long.parseLong(fourhtP);	
		long result4 = d % 97;
		
		long pZiffer = 98 - result4;
		   
		   
		  if (pZiffer < 10) {
			  iban = lc + "0" + pZiffer+ blz + kn; 
		  }
		  else
			  iban = lc + pZiffer + blz + kn;
		
		 return iban;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String laenderkennung = sc.next();
			   laenderkennung = laenderkennung.toUpperCase();
		String blz = sc.next();
		
		String knummer = sc.next();
		
		String lnKe = lnK(laenderkennung);
		String newKnummer = Knummer(knummer);
		String bban  = bban(blz, knummer);
		String ibban = bban+lnKe+"0"+"0";
		String iban = iban(ibban, laenderkennung, blz, newKnummer);
		
		System.out.println(iban);
	}

}
