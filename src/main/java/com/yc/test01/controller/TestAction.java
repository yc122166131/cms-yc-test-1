package com.yc.test01.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cn.yc.utils.JsonUtils;
import com.yc.test01.pojo.People;


@Controller
@RequestMapping(value="/testRequestMapping")
public class TestAction {

	
	
	@Autowired
	private JmsTemplate jmsTemplate;  //这个是引入 spring 管理的 activeMQ
	@Resource
	//这个是 Destination (activemq 要用的 目的地,接受方  和 发送方 必须是一样的 [topic 或者 queue 即 队列 或者 订阅 ])
	private Destination topicDestination;   
	 
	
	/**
	 * jsonp 跨域/服务  调用
	 * 本地调用 
	 * @param request
	 * @param token
	 * @param ycCallback
	 * @return
	 */
	@RequestMapping(value="/getT/{token}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getT(HttpServletRequest request,@PathVariable String token,String ycCallback){
		
		Integer _token = -1;
		if(!"".equals(token)){
			try{
			   _token = Integer.parseInt(token);
			}catch(Exception e){
				//e.printStackTrace();
				_token = -111111;
			}
		}
		
		/**
		 * jsonp 处理  (跨域)
		 */
		if(StringUtils.isNotBlank(ycCallback)){
			Map<String,People> results = new HashMap<String,People>();
			People p1  = new People("zhangsan1",1);
			People p2  = new People("李白", 3);
			People p3  = new People("小啊", 27);
			People p4  = new People("传来的值",_token);
			results.put("a1", p1);
			results.put("b2", p2);
			results.put("c3", p3);
			results.put("会有转机的", p4);
			return  ycCallback + "(" + JsonUtils.objectToJson(results) + ");";
		}
		
		
		/**
		 * 正常的 请求(同域)
		 */
		else{ 	
			
			List<String> list = new ArrayList<String>();
			list.add("aaa");
			list.add("aaa11");
			list.add("aaa222");
			list.add("aaa333");
			list.add("aaa444");
			return JsonUtils.objectToJson(list);
		}
	}
	
	
	/**
	 * activeMq 服务试运行 , 测试一下  ,
	 * 我们的 producer 是 cms-yc-test-1 项目
	 * 消费方 cms-yc-test 项目
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/testActiveMq",method=RequestMethod.POST)
	public String  testActiveMq(HttpServletRequest request){
		
		jmsTemplate.send(topicDestination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage("我传来的数据 ,您收到了吗?");
				return textMessage;
			}
		});
		
		return "";
	}
	
	
	
	/**
	 *  测试 responseBody 返回的 Json 或者 String
	 *  前台 ajax 接受 的 话 我们 一般 dataType 如果 为 Json 那么 必须 返回一个 json格式的数据 比如 Map 
	 *  一般我们  不需要 设置 dataType 这个 返回类型 那么 他也能接受 String 这种类型 , 然后我们再在前台进行转换判断也行！
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/testResponseBody1",method=RequestMethod.POST)
	public String  testResponseBody(HttpServletRequest req){
		String name = req.getParameter("name");
		System.out.println("name: "+name);
		//String str = " ";  // isBlank
		//String str = "";  // isBlank 和 isEmpty
		String str = null;  // isBlank 和 isEmpty
		//综上所述 isBlank 范围更广  比如是空格都是属于的  ,所以 我们 最好还是 在项目中选择 isBlank 比较靠谱! 
		if(StringUtils.isBlank(str)){
			System.out.println("str 是 blank !");
		}
		if(StringUtils.isEmpty(str)){
			System.out.println("str 是 empty !");
		}
		if(StringUtils.isBlank(name)){
			return "N";
		}else{
			return "{\"liushuihao\":\"YYYY\"}";   //自定义一个 对象 必须要 有转义符,否则 前端 JSON.parse 不认识的 
		}
	}
	
}
