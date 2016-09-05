/**
 * 不要因为走了很远就忘记当初出发的目的:whatever happened,be yourself
 */
package com.xiaoyu.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicRefererConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;

@Configuration
public class MontanConfig {

	/**
	 * 声明Annotation用来指定需要解析的包名
	 * 
	 * @return
	 */
	@Bean
	public static AnnotationBean montanAnnotationBean() {
		AnnotationBean bean = new AnnotationBean();
		bean.setPackage("com.xiaoyu");
		return bean;
	}

	@Bean(name = "clientMotan")
	public ProtocolConfigBean protocolConfig() {
		ProtocolConfigBean config = new ProtocolConfigBean();
		config.setDefault(true);
		config.setName("motan");
		config.setLoadbalance("roundrobin");
		config.setMaxContentLength(1048576);
		return config;
	}

	@Bean(name = "registryConfig")
	public RegistryConfigBean registryConfig() {
		RegistryConfigBean config = new RegistryConfigBean();
		config.setDefault(true);
		config.setRegProtocol("zookeeper");
		config.setName("my_zookeeper");
		config.setAddress("127.0.0.1:2182");
		config.setConnectTimeout(5000);
		return config;
	}

	@Bean(name = "basicRefererConfig")
	public BasicRefererConfigBean baseRefererConfig() {
		BasicRefererConfigBean config = new BasicRefererConfigBean();
		config.setAccessLog(true);
		config.setGroup("testGroup");
		config.setModule("motan-demo-rpc");
		config.setApplication("myMotanDemo");
		config.setRegistry("registryConfig");
		config.setProtocol("clientMotan");
		config.setCheck(false);
		config.setRetries(2);
		config.setThrowException(true);
		return config;
	}

}
