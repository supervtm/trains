package edu.zime.wzd.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zime.wzd.domain.CustomReply;
import edu.zime.wzd.domain.Reply;
import edu.zime.wzd.domain.User;
import edu.zime.wzd.service.ReplyService;
import edu.zime.wzd.util.ConversionUtil;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	/**
	 * 根据messageID查询回复信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getReplys(String messageId) throws Exception {

		List<CustomReply> list = replyService.queryByMessage(messageId);

		// 将留言内容转为string格式
		for (CustomReply customReply : list) {
			customReply.setContent(ConversionUtil.unicode2String(customReply.getContent()));
			
			customReply.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(customReply.getTime())));
		}

		JSONObject resultJSON = new JSONObject();
		resultJSON.put("lists", list);
		return resultJSON.toString();
	}

	/**
	 * 发表回复 ,从session中取出用户iD
	 * 
	 * @param message
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addReply(String messageId, Reply reply, HttpSession session) throws Exception {

		// 从session中取出用户userId
			User user = (User) session.getAttribute("user");
			Integer userId = user.getUserId();

		// 将回复内容转为Unicode格式
		reply.setContent(ConversionUtil.string2Unicode(reply.getContent()));

		replyService.saveReply(userId, messageId, reply);

		return "redirect:/page/main";
	}

}
