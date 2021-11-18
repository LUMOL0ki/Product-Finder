package vsb.vea.web.controller;

import vsb.vea.data.jpa.JPACategoryRepository;

public class JPACategoryControllerTest extends CategoryControllerTest {

	public JPACategoryControllerTest() {
		super(new JPACategoryRepository());
	}
}
