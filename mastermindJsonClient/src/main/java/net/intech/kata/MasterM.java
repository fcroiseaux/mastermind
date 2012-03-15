package net.intech.kata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: croiseaux
 * Date: 15/03/12
 * Time: 07:49
 * To change this template use File | Settings | File Templates.
 */
public class MasterM {
    
    private String urlString;
    
    MasterM(String url) {
        // http://localhost:9000/check
        urlString = url;
    }
    
    public static class Result{
        public final int noir;
        public final int blanc;
        public Result(int n, int b){
            noir=n;
            blanc=b;
        }
        public String toString(){
            return "Noir : "+noir+" Blanc : "+blanc;
        }
    }
    

    public Result check(List<String> coups) {

        try {

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

			String code = "";
			for(String s : coups){
				if(code.length()>0) code+=",";
				code+=s;
			}
            String input = "{\"coup\":\""+code+"\"}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            //System.out.println(conn.getResponseCode());

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = br.readLine();
            StringTokenizer st= new StringTokenizer(output,",");
            int nbNoir=0;
            int nbBanc=0;
            while(st.hasMoreElements()){
                String tok=st.nextToken();
                if(tok.startsWith("{\"noirs")){
                    String tmp=tok.substring(10);
                    tmp=tmp.substring(0,tmp.indexOf("\""));
                    nbNoir=new Integer(tmp).intValue();
                }
                else{
                    String tmp=tok.substring(10);
                    tmp=tmp.substring(0,tmp.indexOf("\""));
                    nbBanc=new Integer(tmp).intValue();
                }
            }
            conn.disconnect();

            return new Result(nbNoir,nbBanc);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }
}
