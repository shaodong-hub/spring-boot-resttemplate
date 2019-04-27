package com.github.springbootresttemplate.repository;

import com.github.springbootresttemplate.pojo.ResultDO;
import com.github.springbootresttemplate.pojo.UserDO;
import lombok.SneakyThrows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * <p>
 * 创建时间为 15:29 2019-04-27
 * 项目名称 spring-boot-resttemplate
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository
public class RemoteRepository {

    @Resource
    private RestTemplate template;

    @SneakyThrows(URISyntaxException.class)
    public UserDO getUserDO(String url) {
        return template.getForObject(new URI(url), UserDO.class);
    }

    @SneakyThrows(URISyntaxException.class)
    public ResultDO<UserDO> getResultDO(String url, UserDO userDO) {
        RequestEntity requestEntity = RequestEntity.post(new URI(url))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(userDO.toString());
        ParameterizedTypeReference<ResultDO<UserDO>> myBean = new ParameterizedTypeReference<ResultDO<UserDO>>() {
        };
        ResponseEntity<ResultDO<UserDO>> response = template.exchange(requestEntity, myBean);
        return response.getBody();
    }

}
