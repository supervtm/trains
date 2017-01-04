package edu.zime.wzd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zime.wzd.mapper.MessageMapper;
import edu.zime.wzd.util.ConversionUtil;

@Controller
public class TestController {
	
	@Autowired
	private MessageMapper messageMapper;

	@RequestMapping(value="/test", produces="text/html;charset=utf-8")
	@ResponseBody
	public String test(String source) throws Exception {
		
	/*	Message message = new Message();
		message.setContent(returnUniCode);
		message.setUser(1);
		messageMapper.insertMessage(message );*/
		String unicode = ConversionUtil.string2Unicode(source);
		String string = ConversionUtil.unicode2String(unicode);
		return unicode+string;
	}
}
