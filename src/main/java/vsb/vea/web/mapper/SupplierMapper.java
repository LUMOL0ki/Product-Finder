package vsb.vea.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import vsb.vea.models.Supplier;
import vsb.vea.web.models.SupplierBrief;
import vsb.vea.web.models.SupplierDetail;
import vsb.vea.web.models.SupplierInput;

public class SupplierMapper {

    @Autowired
    private static ModelMapper modelMapper = new ModelMapper();
    
	public static Supplier fromSupplierBrief(SupplierBrief supplierBrief) {
		return modelMapper.map(supplierBrief, Supplier.class);
	}
	
	public static Supplier fromSupplierDetail(SupplierDetail supplierDetail) {
		return modelMapper.map(supplierDetail, Supplier.class);
	}
	
	public static Supplier fromSupplierInput(SupplierInput supplierInput) {
		Supplier tempSupplier = modelMapper.map(supplierInput, Supplier.class);
		tempSupplier.setAddress(AddressMapper.fromAddressInput(supplierInput.getAddress()));
		return tempSupplier;
	}

	public static Supplier fromSupplierInput(long id, SupplierInput supplierInput) {
		Supplier tempSupplier = modelMapper.map(supplierInput, Supplier.class);
		tempSupplier.setId(id);
		tempSupplier.setAddress(AddressMapper.fromAddressInput(supplierInput.getAddress()));
		return tempSupplier;
	}
	
	public static SupplierBrief toSupplierBrief(Supplier supplier) {
		return modelMapper.map(supplier, SupplierBrief.class);
	}
	
	public static SupplierDetail toSupplierDetail(Supplier supplier) {
		SupplierDetail tempSupplier = modelMapper.map(supplier, SupplierDetail.class);
		tempSupplier.setAddress(AddressMapper.toAddressDetail(supplier.getAddress()));
		return tempSupplier;
	}
	
	public static SupplierInput toSupplierInput(Supplier supplier) {
		return modelMapper.map(supplier, SupplierInput.class);
	}
}
