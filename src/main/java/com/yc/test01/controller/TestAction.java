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

import com.cn.yc.utils.JsonUtils;
import com.yc.test01.pojo.People;


@Controller
@RequestMapping(value="/testRequestMapping")
public class TestAction {

	
	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource
	private Destination topicDestination;
	
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
	
}
