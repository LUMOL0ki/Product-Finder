package vsb.vea.web.controller;

import vsb.vea.data.repositories.JPASupplierRepository;

public class JPASupplierControllerTest extends SupplierControllerTest {

	public JPASupplierControllerTest() {
		super(new JPASupplierRepository());
		// TODO Auto-generated constructor stub
	}

}
