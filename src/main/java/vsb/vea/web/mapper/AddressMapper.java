package vsb.vea.web.mapper;

import vsb.vea.models.Address;
import vsb.vea.web.models.*;

public class AddressMapper {
	public static Address fromAddressBrief(AddressBrief addressBrief) {
		Address address = new Address();
		address.id = addressBrief.id;
		address.line = addressBrief.line;
		return address;
	}
	
	public static Address fromAddressDetail(AddressDetail addressDetail) {
		Address address = new Address();
		address.id = addressDetail.id;
		address.line = addressDetail.line;
		address.city = addressDetail.city;
		address.postalCode = addressDetail.postalCode;
		address.country = addressDetail.country;
		return address;
	}
	
	public static Address fromAddressInput(AddressInput addressInput) {
		Address address = new Address();
		address.line = addressInput.line;
		address.city = addressInput.city;
		address.postalCode = addressInput.postalCode;
		address.country = addressInput.country;
		return address;
	}
	
	public static AddressBrief toAddressBrief(Address address) {
		AddressBrief addressBrief = new AddressBrief();
		addressBrief.id = address.id;
		addressBrief.line = address.line;
		return addressBrief;
	}
	
	public static AddressDetail toAddressDetail(Address address) {
		AddressDetail addressDetail = new AddressDetail();
		addressDetail.id = address.id;
		addressDetail.line = address.line;
		addressDetail.city = address.city;
		addressDetail.postalCode = address.postalCode;
		addressDetail.country = address.country;
		return addressDetail;
	}
	
	public static AddressInput toAddressInput(Address address) {
		AddressInput addressInput = new AddressInput();
		addressInput.line = address.line;
		addressInput.city = address.city;
		addressInput.postalCode = address.postalCode;
		addressInput.country = address.country;
		return addressInput;
	}
}
