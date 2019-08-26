package com.liuds.config.properties;

import lombok.Data;

/**
 * The class Async task properties.
 *
 * @author
 */
@Data
public class SwaggerProperties {

	private String title;

	private String description;

	private String version = "1.0.0";
}
