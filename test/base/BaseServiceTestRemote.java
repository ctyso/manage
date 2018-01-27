/*
 * Onlyou Team Create Date 2014-4-21 Copyright 2014~2020 Onlyou.com All Rights Reserved
 */
package base;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"../conf/spring-mvc.xml","../conf/spring-mybatis.xml"})

public class BaseServiceTestRemote  {
	protected final Log logger = LogFactory.getLog(this.getClass());
	@Before
	public void init(){
		/*BeanHelper.applicationContext = applicationContext;*/
	}
}
