package com.main.flight.http.request;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestSender {
	
	public String sendRequest(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("POST");

		con.setRequestProperty("Host","www.edreams.com");
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:25.0) Gecko/20100101 Firefox/25.0");
		con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Accept-Encoding","gzip, deflate");
		con.setRequestProperty("DNT", "1");
		con.setRequestProperty("Referer","http://www.edreams.com/flights/search/multidestinations/?tripT=MULTI_SEGMENT&isIframe=undefined");
		con.setRequestProperty("Cookie", "TestTokenSpace=1#3781-2#1499-3#28727-4#99492-5#200-6#30223-7#5765|02-11-2013.18:46; TestToken=42#163_81#203_181#444_201#463_321#623_441#824_501#883_541#924_561#943_581#964_583#967_601#983_641#1023_681#1064_701#1083_721#1114_722#1130_723#1137_724#1141_725#1145_726#1146_727#1152_728#1157_729#1159_730#1163_731#1166_732#1171_733#1177_734#1179_735#1183_736#1187_737#1191_738#1194_739#1201_740#1204_741#1208_742#1213_743#1214_744#1220_745#1225_746#1228_747#1231_748#1235_749#1240_750#1243_751#1247_752#1252_753#1257_754#1260|02-11-2013.18:46; __utmz=utmcsr=edreams|utmccn=no_GA||; CPD1=941228554.20480.0000; SHARED2_GB=J; __utma=1.422662854.1383075006.1383251527.1383414447.3; __utmz=1.1383075006.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __gads=ID=071c3d3cd49bec03:T=1383075006:S=ALNI_MZoXeUdnLicCXtO3XUfAgtaggMZMQ; fsearch=ONE_WAY|Rio Branco|Frankfurt|1|0|0|09/11/2013|09/11/2013|3641|2592; JSESSIONID=488EF2E3EE8D2E73E498CDF81B942E21.thera4; __utmb=1.13.9.1383415060782; __utmc=1");
		con.setRequestProperty("Connection","keep-alive");
		
		
		String urlParameters = "&buyPath='36'&auxOrBt=''&searchMainProductTypeName='FLIGHT'&tripTypeName='MULTI_SEGMENT'&departureLocationGeoNodeId0='3641'&departureLocation0='Rio+Branco'&arrivalLocationGeoNodeId0='2592'&arrivalLocation0='Frankfurt'&departureDate0='09/11/2013'&departureLocationGeoNodeId1=''&departureLocation1=''&arrivalLocationGeoNodeId1=''&arrivalLocation1=''&departureDate1='09/11/2013'&departureLocationGeoNodeId2=''&departureLocation2=''&arrivalLocationGeoNodeId2= ''&arrivalLocation2=''&departureDate2='09/11/2013'&numAdults='1'&numChilds='0'&numInfant='0'&cabinClassName='TOURIST'&filteringCarrier=''&fake_filteringCarrier= 'All+Airlines'&collectionTypeEstimationNeeded='false'&applyAllTaxes='false'";
		//Send request
		
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
		String response = null;
		return response;

	}

}
