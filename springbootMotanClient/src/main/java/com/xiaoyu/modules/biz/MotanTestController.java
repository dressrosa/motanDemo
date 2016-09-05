/**
 * 不要因为走了很远就忘记当初出发的目的:whatever happened,be yourself
 */
package com.xiaoyu.modules.biz;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import com.xiaoyu.modules.api.MotanTestService;

@RestController
public class MotanTestController {

	@MotanReferer(basicReferer = "basicRefererConfig")
	private MotanTestService motanTestService;

	@RequestMapping("/")
	public String sayHello() {
		String str = this.motanTestService.sayHelloToWorld();
		return str;
	}
}
