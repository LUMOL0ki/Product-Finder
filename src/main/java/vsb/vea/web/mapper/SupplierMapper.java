package vsb.vea.web.mapper;

import java.util.ArrayList;
import java.util.List;

import vsb.vea.models.Supplier;
import vsb.vea.web.models.SupplierBrief;
import vsb.vea.web.models.SupplierDetail;
import vsb.vea.web.models.SupplierInput;

public class SupplierMapper {
	public static Supplier fromSupplierBrief(SupplierBrief supplierBrief) {
		Supplier supplier = new Supplier();
		supplier.id = supplierBrief.id;
		supplier.name = supplierBrief.name;
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
		Supplier supplier = new Supplier();
		supplier.id = supplierDetail.id;
		supplier.name = supplierDetail.name;
		supplier.description = supplierDetail.description;
		supplier.address = AddressMapper.fromAddressDetail(supplierDetail.address);
		supplier.web = supplierDetail.web;
		return supplier;
	}
	
	public static Supplier fromSupplierInput(SupplierInput supplierInput) {
		Supplier supplier = new Supplier();
		supplier.name = supplierInput.name;
		supplier.description = supplierInput.description;
		supplier.address = AddressMapper.fromAddressInput(supplierInput.address);
		supplier.web = supplierInput.web;
		return supplier;
	}
	
	public static SupplierBrief toSupplierBrief(Supplier supplier) {
		SupplierBrief supplierBrief = new SupplierBrief();
		supplierBrief.id = supplier.id;
		supplierBrief.name = supplier.name;
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
		supplierDetail.id = supplier.id;
		supplierDetail.name = supplier.name;
		supplierDetail.description = supplier.description;
		supplierDetail.address = AddressMapper.toAddressDetail(supplier.address);
		supplierDetail.web = supplier.web;
		return supplierDetail;
	}
	
	public static SupplierInput toSupplierInput(Supplier supplier) {
		SupplierInput supplierInput = new SupplierInput();
		supplierInput.name = supplier.name;
		supplierInput.description = supplier.description;
		supplierInput.address = AddressMapper.toAddressInput(supplier.address);
		supplierInput.web = supplier.web;
		return supplierInput;
	}
}
