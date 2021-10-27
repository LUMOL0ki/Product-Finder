package vsb.vea.web.controller;

import org.springframework.boot.test.context.SpringBootTest;

import vsb.vea.data.mock.MockSupplierRepository;

@SpringBootTest
public class MockSupplierControllerTest extends SupplierControllerTest{

	public MockSupplierControllerTest() {
		super(new MockSupplierRepository());
	}
}
