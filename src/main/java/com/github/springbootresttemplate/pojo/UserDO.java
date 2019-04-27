package com.github.springbootresttemplate.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 创建时间为 15:25 2019-04-27
 * 项目名称 spring-boot-resttemplate
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
public class UserDO {

    private String name;

    private String pass;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
