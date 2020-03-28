package aiss;

import java.io.IOException;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;





import pubgplayer.PlayerPubg;


/**
 * Servlet implementation class PubgServlet
 */
public class PubgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PubgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ClientResource cr = new ClientResource(uri);
//		addHeader(cr, "Accept", "application/vnd.api+json");
//		addHeader(cr, "Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiMDNhZWE2MC0zNmNlLTAxMzgtYmJjOS0zNzRkM2UxZGEzNjYiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTgyMjg2MDA0LCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InNlcmdpb3JvamFzamltIn0.dFS0GuKAPpTrOEChROMqc3APivDw-NDbwAhDpK4WMT8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			try {
				doTrustToCertificates();
				ObjectMapper objectMapper = new ObjectMapper();
				

				URL url = new URL("https://api.pubg.com/shards/steam/players?filter[playerNames]=SusurraVientos");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiMDNhZWE2MC0zNmNlLTAxMzgtYmJjOS0zNzRkM2UxZGEzNjYiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTgyMjg2MDA0LCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InNlcmdpb3JvamFzamltIn0.dFS0GuKAPpTrOEChROMqc3APivDw-NDbwAhDpK4WMT8");
				conn.setRequestProperty("Accept", "application/vnd.api+json");
				PlayerPubg player = objectMapper.readValue(conn.getInputStream(),PlayerPubg.class);
				out.println(player.getData().get(0).getAttributes().getName());
				for(int i=0;i<10;i++) {
					out.println(player.getData().get(0).getRelationships().getMatches().getData().get(i).getId()+"<br>");

				}
				
				URL url1 = new URL("https://api.pubg.com/shards/steam/matches/1463a7f3-c310-47d8-8ca3-8c0cbb390bf4");
				HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
				conn1.setRequestMethod("GET");
				conn1.setRequestProperty("Accept", "application/vnd.api+json");
				
				out.print(conn1.getInputStream());
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			
		
		

	}
	
	
	
	@SuppressWarnings("deprecation")
	public void doTrustToCertificates() throws Exception {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }
	 @SuppressWarnings("unchecked")
	  public void addHeader(ClientResource cr, String headerName, String headerValue) {
	    Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes()
	        .get(HeaderConstants.ATTRIBUTE_HEADERS);

	    if (headers == null) {
	      headers = new Series<Header>(Header.class);
	     cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
	    }
		headers.add(headerName, headerValue);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
