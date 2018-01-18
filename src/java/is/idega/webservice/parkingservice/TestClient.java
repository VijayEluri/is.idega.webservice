package is.idega.webservice.parkingservice;

import java.net.URL;

import stokkur.mpark.service.client.ParkedInService_PortType;
import stokkur.mpark.service.client.ParkedInService_ServiceLocator;
import stokkur.mpark.services.types.ParkedInReply;
import stokkur.mpark.services.types.ParkedInRequest;

public class TestClient {

	public static void main(String[] args) {
		TestClient client = new TestClient();
		client.doStuff();
	}

	private void doStuff() {
		try {
			String endpoint = "http://www.leggja.is/leggja/services/ParkedInService";
			//String endpoint = "http://localhost:8080/vehicleregistry/vehicleregistryservice.asmx";

			ParkedInService_ServiceLocator locator = new ParkedInService_ServiceLocator();
			ParkedInService_PortType port = locator.getParkedInServiceHttpPort(new URL(endpoint));

			ParkedInRequest request = new ParkedInRequest("UD438", "ws_bilastaedi");
			ParkedInReply reply = port.parkedIn(request);

			if (reply != null) {
				System.out.println("carInfo = " + reply.getCarInfo().toString());
				System.out.println("car number = " + reply.getCarNumber());
				System.out.println("code = " + reply.getCode());
				System.out.println("inDate = " + reply.getInDate());
				System.out.println("message = " + reply.getMessage());
				System.out.println("msisdn = " + reply.getMsisdn());
				System.out.println("parkedIn = " + reply.getParkedIn());
				System.out.println("zoneNumber = " + reply.getZoneNumber());

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}