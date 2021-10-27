package vsb.vea.web.controller;

import org.springframework.boot.test.context.SpringBootTest;

import vsb.vea.data.mock.MockProductRepository;

@SpringBootTest
public class MockProductControllerTest extends ProductControllerTest{
	
	public MockProductControllerTest() {
		super(new MockProductRepository());
	}
}
