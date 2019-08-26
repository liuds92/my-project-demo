package com.liuds.config.properties;



import com.liuds.base.constant.GlobalConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The class mycloud properties.
 *
 * @author
 */
@Data
//通过配置文件读取参数值
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class MycloudProperties {
	private SwaggerProperties swagger = new SwaggerProperties();
}
