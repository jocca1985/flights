package com.main.flight.request;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpRequestSender {
	private String url = "http://www.edreams.com/engine/ItinerarySearch/search";
	private String departureLocation0 = "Rio+De+Janeiro"; //must be stored with possibility of change
	private String arrivalLocation0 = "Frankfurt";
	private String departureDate0 = "09/05/2014"; //should be manualy enterned with possibility of manipulation
	private String returnDate = "09/06/2014";
	private String numAdults = "1";
	private String index_location = "//home//master//Desktop//index.html";

	public String sendRequestApache() throws IOException{
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		List<NameValuePair> params = generateParamsMap();		
		
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		//Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();
		StringWriter sw = new StringWriter();
		FileWriter fw = new FileWriter(index_location);
		if (entity != null) {
		    InputStream instream = entity.getContent();
		    BufferedReader in = new BufferedReader(new InputStreamReader(instream));
		    
			String inputLine;
			
			while ((inputLine = in.readLine()) != null){
				sw.write(inputLine);
				fw.write(inputLine);
			}
			in.close();
		    try {
		        System.out.println(instream);
		    } finally {
		        instream.close();
		    }
		}
		return sw.toString();
	}

	private List<NameValuePair> generateParamsMap() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new BasicNameValuePair("buyPath", "36"));
		params.add(new BasicNameValuePair("auxOrBt", ""));
		params.add(new BasicNameValuePair("searchMainProductTypeName", "FLIGHT"));
		params.add(new BasicNameValuePair("tripTypeName", "MULTI_SEGMENT"));
		//params.add(new BasicNameValuePair("departureLocationGeoNodeId0", "3641"));
		params.add(new BasicNameValuePair("departureLocation0", departureLocation0));
		params.add(new BasicNameValuePair("arrivalLocationGeoNodeId0", "2592"));
		params.add(new BasicNameValuePair("arrivalLocation0", arrivalLocation0));
		params.add(new BasicNameValuePair("departureDate0", departureDate0));
		params.add(new BasicNameValuePair("departureLocationGeoNodeId1", ""));
		params.add(new BasicNameValuePair("departureLocation1", ""));
		params.add(new BasicNameValuePair("arrivalLocationGeoNodeId1", ""));
		params.add(new BasicNameValuePair("arrivalLocation1", ""));
		params.add(new BasicNameValuePair("departureLocationGeoNodeId2", ""));
		params.add(new BasicNameValuePair("departureLocation2", ""));
		params.add(new BasicNameValuePair("arrivalLocation2Bt", ""));
		params.add(new BasicNameValuePair("returnDate", returnDate));
		params.add(new BasicNameValuePair("numAdults", numAdults));
		params.add(new BasicNameValuePair("numChilds", "0"));
		params.add(new BasicNameValuePair("numInfant", "0"));
		params.add(new BasicNameValuePair("cabinClassName", "TOURIST"));
		params.add(new BasicNameValuePair("filteringCarrier", ""));
		params.add(new BasicNameValuePair("fake_filteringCarrier", "All+Airlines"));
		params.add(new BasicNameValuePair("collectionTypeEstimationNeeded", "false"));
		params.add(new BasicNameValuePair("applyAllTaxes", "false"));
		return params;
	}
}
