package vsb.vea.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import vsb.vea.models.Address;
import vsb.vea.web.models.*;

public class AddressMapper {

    @Autowired
    private static ModelMapper modelMapper = new ModelMapper();
    
	public static Address fromAddressBrief(AddressBrief addressBrief) {
		return modelMapper.map(addressBrief, Address.class);
	}
	
	public static Address fromAddressDetail(AddressDetail addressDetail) {
		return modelMapper.map(addressDetail, Address.class);
	}
	
	public static Address fromAddressInput(AddressInput addressInput) {
		return modelMapper.map(addressInput, Address.class);
	}

	public static Address fromAddressInput(long id, AddressInput addressInput) {
		Address address = modelMapper.map(addressInput, Address.class);
		address.setId(id);
		return address;
	}
	
	public static AddressBrief toAddressBrief(Address address) {
		return modelMapper.map(address, AddressBrief.class);
	}
	
	public static AddressDetail toAddressDetail(Address address) {
		return modelMapper.map(address, AddressDetail.class);
	}
	
	public static AddressInput toAddressInput(Address address) {
		return modelMapper.map(address, AddressInput.class);
	}
}
