import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xuxiao.model.User;
import com.xuxiao.service.UserService;

/**
 * 
 * @ClassName: UserServiceTest
 * @Description: 单元测试
 * @author zuozuo  
 * @date 2016年8月4日 上午9:17:02 
 *
 */
@ContextConfiguration(locations= {"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	@Resource
	private UserService userService;
	/**
	 * 
	 * @Title: testIsExist 
	 * @Description: 验证用户是否存在
	 * @throws
	 */
	@Test
	public void testIsExist(){
		User user =new User();
		user.setUsername("zuozuo");
		user.setPassword("123456");
		boolean result = userService.isExist(user);
		System.out.println(result);
	}
}
