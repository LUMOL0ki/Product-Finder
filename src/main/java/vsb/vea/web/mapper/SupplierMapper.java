package vsb.vea.web.mapper;

import java.util.ArrayList;
import java.util.List;

import vsb.vea.models.Supplier;
import vsb.vea.web.models.SupplierBrief;
import vsb.vea.web.models.SupplierDetail;
import vsb.vea.web.models.SupplierInput;

public class SupplierMapper {
	public static Supplier fromSupplierBrief(SupplierBrief supplierBrief) {
		Supplier supplier = new Supplier(
				supplierBrief.id,
				supplierBrief.name
				);
		return supplier;
	}
	
	public static List<Supplier> fromSupplierBrief(List<SupplierBrief> supplierBriefs){
		List<Supplier> suppliers = new ArrayList<Supplier>();
		for(SupplierBrief supplierBrief : supplierBriefs) {
			suppliers.add(fromSupplierBrief(supplierBrief));
		}
		return suppliers;
	}
	
	public static Supplier fromSupplierDetail(SupplierDetail supplierDetail) {
		Supplier supplier = new Supplier(
				supplierDetail.id, 
				supplierDetail.name, 
				supplierDetail.description, 
				AddressMapper.fromAddressDetail(supplierDetail.address), 
				supplierDetail.web
				);
		return supplier;
	}
	
	public static Supplier fromSupplierInput(SupplierInput supplierInput) {
		Supplier supplier = new Supplier(
				supplierInput.name,
				supplierInput.description,
				AddressMapper.fromAddressInput(supplierInput.address),
				supplierInput.web
				);
		return supplier;
	}
	
	public static SupplierBrief toSupplierBrief(Supplier supplier) {
		SupplierBrief supplierBrief = new SupplierBrief();
		supplierBrief.id = supplier.getId();
		supplierBrief.name = supplier.getName();
		return supplierBrief;
	}

	public static List<SupplierBrief> toSupplierBrief(List<Supplier> suppliers){
		List<SupplierBrief> supplierBriefs = new ArrayList<SupplierBrief>();
		for(Supplier supplier : suppliers) {
			supplierBriefs.add(SupplierMapper.toSupplierBrief(supplier));
		}
		return supplierBriefs;
	}
	
	public static SupplierDetail toSupplierDetail(Supplier supplier) {
		SupplierDetail supplierDetail = new SupplierDetail();
		supplierDetail.id = supplier.getId();
		supplierDetail.name = supplier.getName();
		supplierDetail.description = supplier.getDescription();
		supplierDetail.address = AddressMapper.toAddressDetail(supplier.getAddress());
		supplierDetail.web = supplier.getWeb();
		return supplierDetail;
	}
	
	public static SupplierInput toSupplierInput(Supplier supplier) {
		SupplierInput supplierInput = new SupplierInput();
		supplierInput.name = supplier.getName();
		supplierInput.description = supplier.getDescription();
		supplierInput.address = AddressMapper.toAddressInput(supplier.getAddress());
		supplierInput.web = supplier.getWeb();
		return supplierInput;
	}
}
