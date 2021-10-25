package vsb.vea.web.controllers;

import java.util.List;

import org.springframework.stereotype.Service;

import vsb.vea.exceptions.FormatException;
import vsb.vea.services.SupplierService;
import vsb.vea.web.mapper.SupplierMapper;
import vsb.vea.web.models.SupplierBrief;
import vsb.vea.web.models.SupplierDetail;
import vsb.vea.web.models.SupplierInput;

@Service
public class SupplierController {
	private SupplierService service;
	
	public SupplierController(SupplierService service) {
		this.service = service;
	}
	
	public List<SupplierBrief> get(){
		return SupplierMapper.toSupplierBrief(service.get());
	}
	
	public SupplierDetail findById(int id) {
		try {
			return SupplierMapper.toSupplierDetail(service.findById(id));
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<SupplierBrief> findByName(String name){
		try {
			return SupplierMapper.toSupplierBrief(service.findByName(name));
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void create(SupplierInput supplier) {
		service.create(SupplierMapper.fromSupplierInput(supplier));
	}
	
	public void edit(int id, SupplierInput supplier) {
		service.edit(SupplierMapper.fromSupplierInput(supplier));
	}
	
	public void remove(int id) {
		try {
			service.remove(id);
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
