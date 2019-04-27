package com.github.springbootresttemplate.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 创建时间为 15:27 2019-04-27
 * 项目名称 spring-boot-resttemplate
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
@ToString
public class ResultDO<T> {

    private Integer status;

    private T data;

}
