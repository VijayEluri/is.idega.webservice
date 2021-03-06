package is.idega.webservice.vehicleregistryservice;

import is.idega.webservice.vehicleregistryservice.client.CoOwner;
import is.idega.webservice.vehicleregistryservice.client.Operator;
import is.idega.webservice.vehicleregistryservice.client.Owner;
import is.idega.webservice.vehicleregistryservice.client.Vehicle;
import is.idega.webservice.vehicleregistryservice.client.VehicleRegistryServiceLocator;
import is.idega.webservice.vehicleregistryservice.client.VehicleRegistryServiceSoap_PortType;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import com.idega.util.IWTimestamp;

public class TestClient {
	public static void main(String[] args) {
		TestClient client = new TestClient();
		client.doStuff();
	}

	private void doStuff() {
		try {
			String endpoint = "https://ws.lt.is/vehicleregistry/vehicleregistryservice.asmx";

			VehicleRegistryServiceLocator locator = new VehicleRegistryServiceLocator();
			VehicleRegistryServiceSoap_PortType port = locator.getVehicleRegistryServiceSoap(new URL(endpoint));

			//MD998, SD816
			String vehicleNumber = "SV339";
			Vehicle vehicles[] = port.basicVehicleInformation("bilastaedi6", "hS6.dbYK", "", vehicleNumber, "", "");

			Vehicle vehicle = null;
			if (vehicles != null && vehicles.length > 0) {
				if (vehicles.length == 1) {
					System.out.println("Found only one vehicle...");
					vehicle = vehicles[0];
				}
				else {
					System.out.println("Found more than one vehicle...");
					String permNo = null;
					
					Collection<Vehicle> registered = new ArrayList<Vehicle>();
					for (Vehicle vehicle1 : vehicles) {
						System.out.println("Vehicle: " + vehicle1.getPermNo() + " / " + vehicle1.getLatestRegistration());
						if (!vehicle1.getLatestRegistration().startsWith("Afskr")) {
							registered.add(vehicle1);
						}
					}
					
					if (!registered.isEmpty()) {
						if (registered.size() == 1) {
							permNo = registered.iterator().next().getPermNo();
						}
						else {
							for (Vehicle vehicle2 : registered) {
								if (vehicle2.getPermNo().equals(vehicleNumber)) {
									permNo = vehicle2.getPermNo();
									break;
								}
							}
							
							if (permNo == null) {
								IWTimestamp lastRegistration = null;
								for (Vehicle vehicle2 : registered) {
									IWTimestamp firstRegistration = new IWTimestamp(vehicle2.getFirstregDate());
									System.out.println("Vehicle: " + vehicle2.getPermNo() + " / " + vehicle2.getFirstregDate());
									if (lastRegistration == null || (lastRegistration != null && lastRegistration.isEarlierThan(firstRegistration))) {
										lastRegistration = firstRegistration;
										permNo = vehicle2.getPermNo();
									}
								}
							}
						}
					}
					
					if (permNo != null) {
						System.out.println("Using permNo: " + permNo);
						Vehicle permVehicles[] = port.basicVehicleInformation("bilastaedi6", "hS6.dbYK", permNo, "", "", "");
						if (permVehicles != null && permVehicles.length > 0) {
							System.out.println(permVehicles.length);
							vehicle = permVehicles[0];
						}
					}
				}
			}

			if (vehicle != null) {
				System.out.println("vehicle.get_import() = " + vehicle.get_import());
				System.out.println("vehicle.getColor() = " + vehicle.getColor());
				System.out.println("vehicle.getCountry() = " + vehicle.getCountry());
				System.out.println("vehicle.getCustomsDate() = " + vehicle.getCustomsDate());
				System.out.println("vehicle.getDeregDate() = " + vehicle.getDeregDate());
				System.out.println("vehicle.getDisastertype() = " + vehicle.getDisastertype());
				System.out.println("vehicle.getEutypeapproval() = " + vehicle.getEutypeapproval());
				System.out.println("vehicle.getFirstregDate() = " + vehicle.getFirstregDate());
				System.out.println("vehicle.getImportername() = " + vehicle.getImportername());
				System.out.println("vehicle.getImporterpersidno() = " + vehicle.getImporterpersidno());
				System.out.println("vehicle.getInsuranceCompany() = " + vehicle.getInsuranceCompany());
				System.out.println("vehicle.getMake() = " + vehicle.getMake());
				System.out.println("vehicle.getManufacturer() = " + vehicle.getManufacturer());
				System.out.println("vehicle.getModelcode() = " + vehicle.getModelcode());
				System.out.println("vehicle.getModelYear() = " + vehicle.getModelYear());
				System.out.println("vehicle.getNewregDate() = " + vehicle.getNewregDate());
				System.out.println("vehicle.getNextInspectionDate() = " + vehicle.getNextInspectionDate());
				System.out.println("vehicle.getOwnregDate() = " + vehicle.getOwnregDate());
				System.out.println("vehicle.getPermNo() = " + vehicle.getPermNo());
				System.out.println("vehicle.getPlateStatus() = " + vehicle.getPlateStatus());
				System.out.println("vehicle.getPlateStorageLocation() = " + vehicle.getPlateStorageLocation());
				System.out.println("vehicle.getPlateTypefront() = " + vehicle.getPlateTypefront());
				System.out.println("vehicle.getPlateTyperear() = " + vehicle.getPlateTyperear());
				System.out.println("vehicle.getPreregDate() = " + vehicle.getPreregDate());
				System.out.println("vehicle.getProductYear() = " + vehicle.getProductYear());
				System.out.println("vehicle.getRegNo() = " + vehicle.getRegNo());
				System.out.println("vehicle.getRegType() = " + vehicle.getRegType());
				System.out.println("vehicle.getReregdate() = " + vehicle.getReregdate());
				System.out.println("vehicle.getSpeccom() = " + vehicle.getSpeccom());
				System.out.println("vehicle.getTypeApproval() = " + vehicle.getTypeApproval());
				System.out.println("vehicle.getTypeapprovalextension() = " + vehicle.getTypeapprovalextension());
				System.out.println("vehicle.getTypeNo() = " + vehicle.getTypeNo());
				System.out.println("vehicle.getUsegroup() = " + vehicle.getUsegroup());
				System.out.println("vehicle.getVariant() = " + vehicle.getVariant());
				System.out.println("vehicle.getVehcom() = " + vehicle.getVehcom());
				System.out.println("vehicle.getVehiclestatus() = " + vehicle.getVehiclestatus());
				System.out.println("vehicle.getVersion() = " + vehicle.getVersion());
				System.out.println("vehicle.getVin() = " + vehicle.getVin());
				System.out.println("");

				Operator operators[] = vehicle.getOperators();
				for (Operator o : operators) {
					System.out.println("Operator.getAddress() = " + o.getAddress());
					System.out.println("Operator.getCity() = " + o.getCity());
					System.out.println("Operator.getEndDate() = " + o.getEndDate());
					System.out.println("Operator.getFullname() = " + o.getFullname());
					System.out.println("Operator.getMainoperator() = " + o.getMainoperator());
					System.out.println("Operator.getPersidno() = " + o.getPersidno());
					System.out.println("Operator.getPostalcode() = " + o.getPostalcode());
					System.out.println("Operator.getSerial() = " + o.getSerial());
					System.out.println("Operator.getStartDate() = " + o.getStartDate());
					System.out.println("Operator.isCurrent() = " + o.isCurrent());
					System.out.println("");
				}
				Owner owners[] = vehicle.getOwners();
				for (Owner o : owners) {
					System.out.println("Owner.getAddress() = " + o.getAddress());
					System.out.println("Owner.getCity() = " + o.getCity());
					CoOwner coOwners[] = o.getCoOwners();
					for (CoOwner co : coOwners) {
						System.out.println("coOwner.getAddress() = " +co.getAddress());
						System.out.println("coOwner.getCity() = " +co.getCity());
						System.out.println("coOwner.getFullname() = " +co.getFullname());
						System.out.println("coOwner.getPersidno() = " +co.getPersidno());
						System.out.println("coOwner.getPostalcode() = " +co.getPostalcode());
					}
					System.out.println("Owner.getFullname() = " + o.getFullname());
					System.out.println("Owner.getOwnerinsurancecode() = " + o.getOwnerinsurancecode());
					System.out.println("Owner.getOwnregDate() = " + o.getOwnregDate());
					System.out.println("Owner.getPersidno() = " + o.getPersidno());
					System.out.println("Owner.getPostalcode() = " + o.getPostalcode());
					System.out.println("Owner.getPurchaseDate() = " + o.getPurchaseDate());
					System.out.println("Owner.getReceptionDate() = " + o.getReceptionDate());
					System.out.println("Owner.isAnonymous() = " + o.isAnonymous());
					System.out.println("Owner.isCurrent() = " + o.isCurrent());
					System.out.println("");
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}