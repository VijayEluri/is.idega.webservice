package is.idega.webservice.business;

import is.skra.kosingar.kodun.KodunLocator;
import is.skra.kosingar.kodun.Kodun_PortType;
import is.skra.kosingar.kodun.Status;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.ejb.FinderException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.holders.StringHolder;

import localhost.eGovSAMLGenerator.webServices.generateSAMLFromToken.holders.__StatusHolder;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.idega.business.IBORuntimeException;
import com.idega.core.accesscontrol.business.LoginBusinessBean;
import com.idega.core.accesscontrol.data.LoginTable;
import com.idega.core.accesscontrol.data.LoginTableHome;
import com.idega.core.idgenerator.business.UUIDGenerator;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.idegaweb.IWMainApplication;
import com.idega.user.data.User;

import eGOVDKM_AuthConsumer.EGOVDKM_AuthConsumerAccessPointLocator;
import eGOVDKM_AuthConsumer.EGOVDKM_AuthConsumerType;

@Scope("singleton")
@Service("islandDotIsService")
public class IslandDotIsService {
	private static final String ELECTION_SERVICE_ENDPOINT = "island.is_election_service_endpoint";
	private static final String ELECTION_SERVICE_USER = "island.is_election_service_user";
	private static final String ELECTION_SERVICE_PASSWORD = "island.is_election_service_password";

	private static final String LOGIN_SERVICE_ENDPOINT = "island.is_login_service_endpoint";
	private static final String LOGIN_SERVICE_USER = "island.is_login_service_user";
	private static final String LOGIN_SERVICE_PASSWORD = "island.is_login_service_password";

	public boolean getHash(String personalId, String token, String ipAddress) {
		String endpoint = IWMainApplication
				.getDefaultIWApplicationContext()
				.getApplicationSettings()
				.getProperty(
						ELECTION_SERVICE_ENDPOINT,
						"https://egov.webservice.is/sst/runtime.asvc/com.actional.soapstation.eGOV_SKRA_KosningKodun");
		String user = IWMainApplication.getDefaultIWApplicationContext()
				.getApplicationSettings().getProperty(ELECTION_SERVICE_USER, "");
		
		String password = IWMainApplication.getDefaultIWApplicationContext()
				.getApplicationSettings().getProperty(ELECTION_SERVICE_PASSWORD, "");

		try {
			KodunLocator locator = new KodunLocator();
			Kodun_PortType port = locator
					.geteGovElection_wsd_kodun_Port(new URL(endpoint));
			((org.apache.axis.client.Stub) port).setUsername(user);
			((org.apache.axis.client.Stub) port).setPassword(password);
			Status status = port.hashSSNForElection(token, personalId,
					ipAddress);

			if (status.getCode() == 0) {
				return true;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return false;
	}

	public String getPersonalIDFromToken(String token, String ipAddress) {
		String endpoint = IWMainApplication
				.getDefaultIWApplicationContext()
				.getApplicationSettings()
				.getProperty(
						LOGIN_SERVICE_ENDPOINT,
						"https://egov.webservice.is/sst/runtime.asvc/com.actional.soapstation.eGOVDKM_AuthConsumer.AccessPoint?WSDL");
		String user = IWMainApplication.getDefaultIWApplicationContext()
				.getApplicationSettings().getProperty(LOGIN_SERVICE_USER, "");
		
		String password = IWMainApplication.getDefaultIWApplicationContext()
				.getApplicationSettings().getProperty(LOGIN_SERVICE_PASSWORD, "");
		
		try {
			EGOVDKM_AuthConsumerAccessPointLocator locator = new EGOVDKM_AuthConsumerAccessPointLocator();
			EGOVDKM_AuthConsumerType port = locator.geteGOVDKM_AuthConsumerAccessPointPort(new URL(endpoint));
			((org.apache.axis.client.Stub) port).setUsername(user);
			((org.apache.axis.client.Stub) port).setPassword(password);
			
			__StatusHolder status = null;
			StringHolder saml = null;
			
			port.generateSAMLFromToken(token, ipAddress, status, saml);
			
			System.out.println("status = " + status.toString());
			System.out.println("saml = " + saml.toString());
			
			return "0610703899";
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static void main(String args[]) {
		IslandDotIsService service = new IslandDotIsService();
		service.getHash("0610703899", UUIDGenerator.getInstance()
				.generateUUID(), "127.0.0.1");
	}
	
	public User authenticateUser(String username, String password) throws java.rmi.RemoteException {
		try {
			LoginBusinessBean loginBean = LoginBusinessBean
					.getDefaultLoginBusinessBean();
			LoginTable loginTable = getLoginTableHome().findByLogin(username);
			if (loginTable != null) {
				// verify password
				if (loginBean.verifyPassword(loginTable, password)) {
					return loginTable.getUser();
				}
			}
		} catch (FinderException e) {
			e.printStackTrace();
		} 

		return null;
	}
	
	private LoginTableHome getLoginTableHome() {
		try {
			return (LoginTableHome) IDOLookup.getHome(LoginTable.class);
		} catch (IDOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}
}
