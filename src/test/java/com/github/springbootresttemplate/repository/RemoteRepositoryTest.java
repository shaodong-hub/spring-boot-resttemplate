package com.github.springbootresttemplate.repository;

import com.github.springbootresttemplate.pojo.ResultDO;
import com.github.springbootresttemplate.pojo.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 创建时间为 16:13 2019-04-27
 * 项目名称 spring-boot-resttemplate
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@DirtiesContext
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@AutoConfigureWireMock(stubs = "classpath:/mapping", port = 8010)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RemoteRepositoryTest {

    @Resource
    private RemoteRepository repository;

    private static final String url1 = "http://127.0.0.1:8010/user";

    private static final String url2 = "http://127.0.0.1:8010/result";

    @Test
    public void getUserDO() {
        UserDO userDO = repository.getUserDO(url1);
        System.out.println(userDO);
    }

    @Test
    public void getResultDO() {
        ResultDO<UserDO> resultDO = repository.getResultDO(url2, getUserData());
        System.out.println(resultDO);
    }


    private UserDO getUserData() {
        UserDO userDO = new UserDO();
        Date date = new Date();
        userDO.setName("name:" + date);
        userDO.setPass("pass:" + date);
        return userDO;
    }


}