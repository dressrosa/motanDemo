/**
 * 不要因为走了很远就忘记当初出发的目的:whatever happened,be yourself
 */
package com.xiaoyu.modules.biz;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import com.xiaoyu.modules.api.MotanTestService;

@MotanService(basicService = "basicServiceConfig")
public class MotanTestServiceImpl implements MotanTestService {

	@Override
	public String sayHelloToWorld() {
		String str = "面向大海,春暖花开";
		return str;
	}

}
