package ejercicio5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

	public static void main(String[] args) {

		String [] array = {"FHDgfdgfdgfdSJK", "dOS", "TREs"};
		StringBuilder sb = new StringBuilder();
		try {
			for(String palabra : array) {
				if(!validar(palabra)) {
					System.out.println("Palabra incorrecta");
					break;
				}
				sb.append(palabra.toLowerCase()).append(' ');
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(sb);
	}

	public static boolean validar(String string){
        Pattern pattern = Pattern.compile("^[\\w\\s*]{1,10}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
