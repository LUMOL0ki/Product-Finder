package vsb.vea.web.controller;

import org.springframework.boot.test.context.SpringBootTest;

import vsb.vea.data.mock.MockCategoryRepository;

@SpringBootTest
public class MockCategoryControllerTest extends CategoryControllerTest {
	
	public MockCategoryControllerTest() {
		super(new MockCategoryRepository());
	}
}
