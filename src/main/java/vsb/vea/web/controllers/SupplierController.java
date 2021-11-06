package vsb.vea.web.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vsb.vea.exceptions.FormatException;
import vsb.vea.services.SupplierService;
import vsb.vea.web.mapper.SupplierMapper;
import vsb.vea.web.models.SupplierBrief;
import vsb.vea.web.models.SupplierDetail;
import vsb.vea.web.models.SupplierInput;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
	@Autowired
	private SupplierService service;
	
	public SupplierController(SupplierService service) {
		this.service = service;
	}
	
	public List<SupplierBrief> get(){
		return service.get().stream().map(SupplierMapper::toSupplierBrief).collect(Collectors.toList());
	}
	
	public SupplierDetail findById(long id) {
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
			return service.findByName(name).stream().map(SupplierMapper::toSupplierBrief).collect(Collectors.toList());
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void create(SupplierInput supplier) {
		service.create(SupplierMapper.fromSupplierInput(supplier));
	}
	
	public void edit(long id, SupplierInput supplier) {
		service.edit(SupplierMapper.fromSupplierInput(supplier));
	}
	
	public void remove(long id) {
		try {
			service.remove(id);
		} catch (FormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
