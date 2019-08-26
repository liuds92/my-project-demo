package com.liuds.gateway.filter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthHeaderFilter implements GlobalFilter, Ordered {

	private static final Log log = LogFactory.getLog(GatewayFilter.class);
	private static final String OPTIONS = "OPTIONS";
	private static final String COMMON_PATH = "/common";


	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
		String token = headers.getFirst(HttpHeaders.AUTHORIZATION);

		if (token == null) {
			token = request.getQueryParams().getFirst(HttpHeaders.AUTHORIZATION);
		}

		String requestURI = request.getURI().getPath();
		log.info("url: " + requestURI);
		if (requestURI.contains(COMMON_PATH)) {
			log.info("不需要校验token");
			return chain.filter(exchange);
		}

		log.info("校验token");
		ServerHttpResponse response = exchange.getResponse();
		if (StringUtils.isEmpty(token)) {
			response.setStatusCode(HttpStatus.UNAUTHORIZED);
			return response.setComplete();
		}
		//通过jwt解析获取uid
		Integer uid = 1001;
		//向headers中放文件，记得build
		ServerHttpRequest host = exchange.getRequest().mutate().header("UID", uid.toString()).build();
		//将现在的request 变成 change对象
		ServerWebExchange build = exchange.mutate().request(host).build();
		return chain.filter(build);
	}

	/**
	 * 优先级,值越小优先级越高
	 * @return
	 */
	@Override
	public int getOrder() {
		return 0;
	}

}
