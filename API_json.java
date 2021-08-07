import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class API_json {
	static String inline=null;
	static List<String> chromeList = new ArrayList<String>();
	public static void main(String args[]) throws IOException {
		List<String> iphoneList = new ArrayList<String>();
		
		URL url = new URL("https://www.browserstack.com/list-of-browsers-and-platforms.json?product=automate");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responseGet = conn.getResponseCode();
		if(responseGet != 200) {
			System.out.println(responseGet);
		}
		else {
			Scanner sc = new Scanner(url.openStream());
			while(sc.hasNext()) {
				inline= inline+sc.nextLine();
			}
			//System.out.println(inline);
			//windowsChrome(inline);
			List<String> jsonList = Arrays.asList(inline.split("},"));
			for(int i=0;i<jsonList.size();i++) {
				if(jsonList.get(i).contains("iPhone 8")) {
					iphoneList.add(jsonList.get(i));
				}
			// System.out.println(jsonList.get(i));
			}
			
			String iphoneVersion = null;
			for(int i=0;i<iphoneList.size();i++) {
			   System.out.println(iphoneList.get(i)); 
			   //System.out.println("Lates OS version of iPhone"+ iphoneList.get(0));
			   String os_version[] = iphoneList.get(0).split(",");
			   iphoneVersion = os_version[2]; 
			}
			
			for(int i=0;i<chromeList.size();i++) {
				   System.out.println(chromeList.get(i)); 
				   //System.out.println("Lates OS version of iPhone"+ iphoneList.get(0));
     			   String os_version[] = iphoneList.get(0).split(",");
     			   iphoneVersion = os_version[2]; 
			}
			
			System.out.println("Lates OS version of iPhone"+ iphoneVersion);
		}
		
		
	}
	
	public static void windowsChrome(String inline) {
		List<String> jsonListforWindow = Arrays.asList(inline.split("]},"));
		for(int j=0;j<jsonListforWindow.size()-2;j++) {
		  System.out.println(jsonListforWindow.get(j));
		
		  if(jsonListforWindow.get(j).contains("Windows 8")){
			chromeList.add(jsonListforWindow.get(j));
		   }
		 // System.out.println(chromeList.get(j));
		}
	}
}
