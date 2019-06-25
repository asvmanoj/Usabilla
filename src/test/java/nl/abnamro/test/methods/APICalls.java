package nl.abnamro.test.methods;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import nl.abnamro.test.utilities.WebDriverFactoryConstants;

public class APICalls implements WebDriverFactoryConstants{
	
	
	public  String doPost(String urls,String data,boolean isProxy ) {
		String output = "";
		  try {
				URL url = new URL(urls);
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_HOST, PROXY_PORT));
				HttpURLConnection conn = null;
				if(isProxy) {
					 conn = (HttpURLConnection) url.openConnection(proxy);
				}else {
					conn = (HttpURLConnection) url.openConnection();
				}
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				OutputStream os = conn.getOutputStream();
				os.write(data.getBytes());
				os.flush();
				System.out.println(conn.getResponseCode());
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String line ;
				while ((line = br.readLine()) != null) {
					output+=line;
				}
				System.out.println(output);
				conn.disconnect();
			  } catch (Exception e) {
				e.printStackTrace();
			  }
		  return output;
	}
	public  String doPUT(String urls,String data,boolean isProxy ) {
		String output = "";
		  try {
				URL url = new URL(urls);
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_HOST, PROXY_PORT));
				HttpURLConnection conn = null;
				if(isProxy) {
					 conn = (HttpURLConnection) url.openConnection(proxy);
				}else {
					conn = (HttpURLConnection) url.openConnection();
				}
				conn.setDoOutput(true);
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Content-Type", "application/json");
				OutputStream os = conn.getOutputStream();
				os.write(data.getBytes());
				os.flush();
				System.out.println(conn.getResponseCode());
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String line ;
				while ((line = br.readLine()) != null) {
					output+=line;
				}
				System.out.println(output);
				conn.disconnect();
			  } catch (Exception e) {
				e.printStackTrace();
			  }
		  return output;
	}
	public  String doGET(String urls,boolean isProxy ) {
		String output = "";
		  try {
				URL url = new URL(urls);
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("nl-userproxy-access.net.abnamro.com", 8080));
				HttpURLConnection conn = null;
				if(isProxy) {
					 conn = (HttpURLConnection) url.openConnection(proxy);
				}else {
					conn = (HttpURLConnection) url.openConnection();
				}
				conn.setConnectTimeout(33000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				System.out.println(conn.getResponseCode());
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String line ;
				while ((line = br.readLine()) != null) {
					output+=line;
				}
				System.out.println(output);
				conn.disconnect();
			  } catch (Exception e) {
				e.printStackTrace();
			  }
		  return output;
	}

}
