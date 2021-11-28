package vsb.vea.web.controller;

import org.springframework.boot.test.context.SpringBootTest;

import vsb.vea.data.jpa.JPACategoryRepository;

@SpringBootTest
public class JPACategoryControllerTest extends CategoryControllerTest {

	public JPACategoryControllerTest() {
		super(new JPACategoryRepository());
	}
}
