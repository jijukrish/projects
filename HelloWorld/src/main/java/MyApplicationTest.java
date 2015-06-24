import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.journaldev.spring.di.consumer.MyApplication;
import com.journaldev.spring.di.services.MessageService;

@Configuration
@ComponentScan(value="com.journaldev.spring.di.consumer")
public class MyApplicationTest {
	private AnnotationConfigApplicationContext context = null;
	
	@Bean
	public MessageService getMessageService() {
		return new MessageService() {
			public boolean sendMessage(String msg, String rec) {
				System.out.println("Mock Service");
				return true;	
			}
		};
	}

	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(MyApplication.class);
	}
	@After
	public void tearDown() throws Exception {
		context.close();
	}
	
	@Test
	public void test() {
	MyApplication appl = context.getBean(MyApplication.class);
	Assert.assertTrue(appl.processMessage("Hi Jiju krishnan", "jijukrishnan@hotmail.com"));
	}
}