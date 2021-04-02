package laborator1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Lungime=");
		String lungime = reader.readLine();
		int L = Integer.parseInt(lungime);
		System.out.print("Latime=");
		String latime = reader.readLine();
		int l = Integer.parseInt(latime);
		int arie, perimetru;
		arie=L*l;
		perimetru=2*L+2*l;
		System.out.println("Ati introdus lungime " +L);
		System.out.println("Ati introdus latime "+l);
		System.out.println("Arie: " +arie);
		System.out.println("Perimetru: " +perimetru);
	}

}
