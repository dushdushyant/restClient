package com.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class RestTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Test Begin");
		RestTest obj = new RestTest();
		try {
			obj.sendPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendGet() throws Exception {
		 
		String url = "https://indianrailways.p.mashape.com/findstations.php?station=delhi";
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		
//		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to 	URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
	
	// HTTP POST request
		private void sendPost() throws Exception {
	 
			/*String url = "https://selfsolve.apple.com/wcResults.do";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	 
			//add reuqest header
			con.setRequestMethod("POST");
//			con.setRequestProperty("User-Agent", USER_AGENT);
//			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	 
			String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
	 
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());*/
			
			String url = "https://indianrailways.p.mashape.com/findstations.php?station=delhi";
//			String url = "https://indianrailways.p.mashape.com/index.php?pnr=1234567890";
			 
			HttpPost request = new HttpPost(url);
			request.addHeader("X-Mashape-Key", "TWgJouV7r2mshiqCeqlWgC5JHR6up1MilTfjsnHnGQXRETqIBk");
//			request.addHeader("Authorization", "Basic ThisIsJustAnExample");
			
			HttpParams httpParams = new BasicHttpParams();
			HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
			HttpConnectionParams.setConnectionTimeout(httpParams, 3000);
			HttpClient httpclient = null;
			httpclient = new DefaultHttpClient(httpParams);

			HttpResponse response = httpclient.execute(request);
			System.out.println("Status Code: "+response.getStatusLine().getStatusCode());
			InputStream resultStream=response.getEntity().getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(resultStream));
			String inputLine;
			StringBuffer sb = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine);
			}
			br.close();
	 
			//print result
			System.out.println(sb.toString());
			
			
	 
		}
}
