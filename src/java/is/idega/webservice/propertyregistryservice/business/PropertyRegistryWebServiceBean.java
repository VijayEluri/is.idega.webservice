package is.idega.webservice.propertyregistryservice.business;

import is.idega.webservice.propertyregistryservice.client.GetDataResponseGetDataResult;
import is.idega.webservice.propertyregistryservice.client.MainLocator;
import is.idega.webservice.propertyregistryservice.client.MainSoap_PortType;
import is.idega.webservice.propertyregistryservice.data.Property;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.message.MessageElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.idega.idegaweb.IWMainApplication;

@Scope("singleton")
@Service("propertyRegistryWebService")
public class PropertyRegistryWebServiceBean implements
		PropertyRegistryWebService {

	private static final String TAX_PASSWORD = "property_tax_password";
	private static final String TAX_USER = "property_tax_user";
	private static final String TAX_ENDPOINT = "property_tax_endpoint";
	private static final String TAX_COMPANY = "property_tax_company";
	
	private static final String PROPERTY_ROOT = "MEINI";

	private static final String PROPERTY_APARTMENTNUMBER = "MEINI_FEPILOG";
	private static final String PROPERTY_FNR = "MEINI_FASTANR";
	private static final String PROPERTY_NAME = "MEINI_HEIMILISFANG";


	public List<Property> getApartmentNumberList(String address, String assessmentYear) {
		List <Property>apartmentNumbers = new ArrayList<Property>();

		String endpoint = IWMainApplication.getDefaultIWApplicationContext()
				.getApplicationSettings().getProperty(TAX_ENDPOINT, "");
		String userid = IWMainApplication.getDefaultIWApplicationContext()
				.getApplicationSettings().getProperty(TAX_USER, "");
		String password = IWMainApplication.getDefaultIWApplicationContext()
				.getApplicationSettings().getProperty(TAX_PASSWORD, "");
		String company = IWMainApplication.getDefaultIWApplicationContext()
				.getApplicationSettings().getProperty(TAX_COMPANY, "");

		try {
			MainLocator locator = new MainLocator();
			MainSoap_PortType port = locator.getMainSoap(new URL(endpoint));
			String session = port.login(company, userid, password);
			
			StringBuffer filter = new StringBuffer("meini_alagar = '");
			filter.append(assessmentYear);
			filter.append("' and meini_heimilisfang='");
			filter.append(address);
			filter.append("'");
			
			GetDataResponseGetDataResult result = port.getData(session,
					"meini", filter.toString(), false);

			
			MessageElement properties[] = result.get_any();

			int length = properties.length;
			for (int i = 0; i < length; i++) {
				List <Property>propertyList = parseProperty(properties[i]);
				if (propertyList != null && !propertyList.isEmpty()) {
					for (Property property : propertyList) {
						apartmentNumbers.add(property);
					}
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return apartmentNumbers;
	}
	
	private List<Property> parseProperty(MessageElement element) {
		List <Property>returnProperty = new ArrayList<Property>();
		Property propety = null;

		if (element.getNodeName().equals("diffgr:diffgram")) {
			List <MessageElement>properties = new ArrayList<MessageElement>();
			getPropertyElements(element, properties);
			if (properties != null && !properties.isEmpty()) {
				Iterator i = properties.iterator();
				while (i.hasNext()) {
					MessageElement vweigandi = (MessageElement) i.next();
					propety = new Property();
					Iterator it = vweigandi.getChildElements();
					while (it.hasNext()) {
						MessageElement child = (MessageElement) it.next();
						String nodeName = child.getNodeName();
						String value = child.getValue();
						if (nodeName.equals(PROPERTY_APARTMENTNUMBER)) {
							propety.setApartmentNumber(value);
						}
						else if (nodeName.equals(PROPERTY_FNR)) {
							propety.setFNR(value);
						}
						else if (nodeName.equals(PROPERTY_NAME)) {
							propety.setNameNumber(value);
						}
					}

					returnProperty.add(propety);
				}
			}
		}

		return returnProperty;
	}

	private void getPropertyElements(MessageElement element, List <MessageElement>propertyElements) {
		if (element.getNodeName().equals(PROPERTY_ROOT)) {
			propertyElements.add(element);
			return;
		}

		Iterator it = element.getChildElements();

		while (it.hasNext()) {
			MessageElement el = (MessageElement) it.next();
			if (el.getNodeName().equals(PROPERTY_ROOT)) {
				propertyElements.add(el);
			}
			else if (el.hasChildNodes()) {
				getPropertyElements(el, propertyElements);
			}
		}

		return;
	} 

}
