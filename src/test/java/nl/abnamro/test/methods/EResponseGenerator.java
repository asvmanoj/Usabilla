package nl.abnamro.test.methods;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EResponseGenerator {

	public void signInGenerateAndStore(String cardnumber,String passnumber,String response,String key) throws IOException {
		String url = "http://mwr-st.nl.eu.abnamro.com:9200/e2_sim";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			//add reuqest header
			con.setRequestProperty("Content-Type","text/html; charset=utf-8");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			con.setRequestProperty("Connection", "keep-alive");
			con.setConnectTimeout(300000);
			String urlParameters = "cardnum="+cardnumber+"&cardseq="+passnumber+"&testenv=TM&counter=&ChipPersId=2&kdi=&challenge="+response.replace(" ", "")+"&conmode=UNC&function=SIGN&Response=Generate+response";
			con.setRequestMethod("POST");
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    String line;
		    String Login_Response = "";
		    String ResponseStarter = "Response: ";
		    while ((line = in.readLine()) != null && !line.startsWith(ResponseStarter)) {
		    	// edentifier_Login_Response += line;
		    }
		    if (line != null)
		    {
		    	Login_Response = line;
		    }
		    in.close();
		    String edentifier_Response = Login_Response.substring(ResponseStarter.length(), Login_Response.indexOf("<BR>"));
		    SavingElementsMethods.putValue(key, edentifier_Response.trim());
		    System.out.println("generated response :"+edentifier_Response);
	}
	public void loginGenerateAndStore(String cardnumber,String passnumber,String key) throws IOException {
		String url = "http://mwr-st.nl.eu.abnamro.com:9200/e2_sim";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			//add reuqest header
			con.setRequestProperty("Content-Type","text/html; charset=utf-8");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			con.setRequestProperty("Connection", "keep-alive");
			con.setConnectTimeout(300000);
			String urlParameters = "cardnum="+cardnumber+"&cardseq="+passnumber+"&testenv=TM&counter=&ChipPersId=2&kdi=&challenge=&conmode=UNC&function=LOGON&Response=Generate+response";
			con.setRequestMethod("POST");
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    String line;
		    String Login_Response = "";
		    String ResponseStarter = "Response: ";
		    while ((line = in.readLine()) != null && !line.startsWith(ResponseStarter)) {
		    	// edentifier_Login_Response += line;
		    }
		    if (line != null)
		    {
		    	Login_Response = line;
		    }
		    in.close();
		    String edentifier_Response = Login_Response.substring(ResponseStarter.length(), Login_Response.indexOf("<BR>"));
		    SavingElementsMethods.putValue(key, edentifier_Response.trim());
		    System.out.println("generated response :"+edentifier_Response);
	}
}
