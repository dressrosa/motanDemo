/**
 * 不要因为走了很远就忘记当初出发的目的:whatever happened,be yourself
 */
package com.xiaoyu.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
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

	/**
	 * 协议配置
	 * 
	 * @return
	 */
	@Bean(name = "serverMotan")
	public ProtocolConfigBean protocolConfig() {
		ProtocolConfigBean config = new ProtocolConfigBean();
		config.setDefault(true);
		config.setId("myMotan");
		config.setName("motan");// 采用motan协议
		config.setMaxWorkerThread(500);// 最大线程
		config.setMinWorkerThread(20);// 最少线程
		config.setMaxContentLength(1048576);// 内容大小
		return config;
	}

	/**
	 * 需要本地配置zookeeper注册中心,并运行
	 * 
	 * @return
	 */
	@Bean(name = "registryConfig")
	public RegistryConfigBean registryConfig() {
		RegistryConfigBean config = new RegistryConfigBean();
		config.setDefault(true);// 不加就报错
		config.setRegProtocol("zookeeper");// 采用zookeeper注册中心
		config.setName("my_zookeeper");
		config.setAddress("127.0.0.1:2182");// 本地的zookeeper
		config.setRegister(true);
		config.setSubscribe(true);
		return config;
	}

	@Bean(name = "basicServiceConfig")
	public BasicServiceConfigBean baseServiceConfig() {
		BasicServiceConfigBean config = new BasicServiceConfigBean();
		config.setExport("serverMotan:20880");// 在20880这个端口暴漏
		config.setAccessLog(false);
		config.setRegistry("registryConfig");// 采用上面定义好的
		config.setThrowException(true);
		config.setCheck(true);
		config.setShareChannel(true);
		config.setModule("motan-demo-rpc");
		config.setApplication("myMotanDemo");
		config.setGroup("testGroup");
		return config;
	}

}
