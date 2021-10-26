package vsb.vea.web.controller;

import vsb.vea.data.mock.MockCategoryRepository;

public class MockCategoryControllerTest extends CategoryControllerTest {
	public MockCategoryControllerTest() {
		super(new MockCategoryRepository());
	}
}
