package nl.abnamro.test.methods;
/**
 * @author Naveen Chenjigaram
 *
 * 
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import org.apache.http.Header;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HTTPCalls implements Constants{
		
	public static String HTTPGetEmployeeSession(String url,String domain,String username,String password) throws Exception{
		String response = "";
		 CloseableHttpClient client = HttpClients.createDefault();
		url = getSessionURL(url);
		 HttpGet get = new HttpGet(url);
		    HttpClientContext context = HttpClientContext.create();
		    NTCredentials creds = new NTCredentials(username, password, getDomainName(url), domain);
		    CredentialsProvider credsProvider = new BasicCredentialsProvider();
		    credsProvider.setCredentials(AuthScope.ANY, creds);
		    context.setCredentialsProvider(credsProvider);
		    CloseableHttpResponse response1 = client.execute(get,context);
		    for(Header h : response1.getAllHeaders()) {
		    	if(h.getName().equals("Set-Cookie")) {
		    		response = h.getValue();
		    		if(response.contains("nl.eu.abnamro.com")) {
		    			String[] cookies = response.split(";");
		    			response = cookies[0].substring(cookies[0].indexOf("=")+1);
		    			break;
		    		}
		    	}
		    }
		   client.close();
		return response;
	}
	public static String getSessionURL(String url) throws Exception {
		 CloseableHttpClient client = HttpClients.createDefault();
			    HttpPost httpPost = new HttpPost(url);			 
			    CloseableHttpResponse response = client.execute(httpPost);
			    client.close();
			    for(Header h : response.getAllHeaders()) {
			    	if(h.getName().equals("Location")) {
			    		return h.getValue();
			    	}
			    };
			    return "";
	}
	public static String getDomainName(String url) throws Exception {
	    URI uri = new URI(url);
	    String domain = uri.getHost();
	    return domain.startsWith("www.") ? domain.substring(4) : domain;
	}
	public static String internetSession(String url,String cardnumber,String passnumber,boolean isST) throws Exception {
			String server = "";
			String port = "";
			if(isST) {
				server = "msecwsinterst";
				port = "14029";
			}
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			//add reuqest header
			con.setRequestProperty("Content-Type","text/html; charset=utf-8");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			con.setRequestProperty("Connection", "keep-alive");
			con.setConnectTimeout(300000);
			String urlParameters = "server="+server+"&port="+port+"&verbose=on&cardnum="+cardnumber+"&cardseq="+passnumber+"&attu=1&channel=1&conmode=1&devtype=1&devid=&devmod=&genappid=&devpl=&udn=&stepdowntype=&pin=&regcode=&bndtoolid=&usage=&status=&sss=&userid=&otoolId=&oclientId=&oauthtoken=&sessioncred=&ologonText=&ochallenge=&ochallengeType=&oobToolID=&ohandle=&ologonPage=&FormattedXML=on&omessageId=&szRepMsgChannel=&szRepMsgResult=&szRepMsgUsedatt=&szRepMsgChhandl=&szRepMsgAtoolid=&szRepMsgMsgtype=&szRepMsgAtmplft=&szRepMsgSpare05=&szRepMsgSpare06=&szRepMsgChallng=&szRepMsgAlowatt=&action=Logon+TRaP";
			con.setRequestMethod("POST");
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    String line;
		    String smSession = "";
		    while ((line = in.readLine()) != null) {
		    	if(line.contains("sss")) {
		    		 line =line.replace("\"", "");
		    		 smSession = line.substring(line.indexOf("value")+6, line.length()-1);
		    		 break;
		    	}
		    }
		    in.close();
		    return smSession;
	}
}
