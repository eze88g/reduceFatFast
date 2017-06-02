/**
 * 
 */
package ar.com.reduceFatFast.controller;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author joaco
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringBootConfiguration   // 2
@WebAppConfiguration   // 3
public class AccountControllerTest {

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.AccountController#signIn(ar.com.reduceFatFast.dto.UserDto)}.
	 */
	@Test
	public void testSignIn() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.AccountController#logOut()}.
	 */
	@Test
	public void testLogOut() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.AccountController#createAccount()}.
	 */
	@Test
	public void testCreateAccount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ar.com.reduceFatFast.controller.AccountController#deleteAccount()}.
	 */
	@Test
	public void testDeleteAccount() {
		fail("Not yet implemented");
	}

}
