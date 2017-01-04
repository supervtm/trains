package edu.zime.wzd.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zime.wzd.domain.CustomMessage;
import edu.zime.wzd.domain.Message;
import edu.zime.wzd.domain.Page;
import edu.zime.wzd.domain.User;
import edu.zime.wzd.service.MessageService;
import edu.zime.wzd.util.ConversionUtil;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	/**
	 * 查询所有留言信息
	 * 
	 * @param currentPage
	 *            用于分页运算
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getMessages(Integer currentPage) throws Exception {

		Page page = new Page();
		
		if (currentPage == null) {
			currentPage = 1;
		}
		
		page.setCurrentPage(currentPage);
		// 设置显示的是从第几记录开始
		page.setStartPage((currentPage - 1) * page.getPageSize());
		// 获取所有用户记录
		page.setTotal(messageService.getTotal());

		page.setPageCount((page.getTotal() - 1) / page.getPageSize() + 1);
		// 查询所有留言信息
		List<CustomMessage> list = messageService.queryMessages(page);

		// 将留言内容转为string格式
		int i=(currentPage-1)*page.getPageSize();
		for (CustomMessage customMessage : list) {
			customMessage.setContent(ConversionUtil.unicode2String(customMessage.getContent()));
			customMessage.setFloor(++i);
			// 时间格式化
			customMessage.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm")
					.format(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(customMessage.getTime())));
		}

		JSONObject resultJSON = new JSONObject();
		resultJSON.put("page", page);
		resultJSON.put("lists", list);
		return resultJSON.toString();
	}

	/**
	 * 获取用户的所有留言<br>
	 * 从session中取出用户id
	 * 
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getMessagesByUser(HttpSession session) throws Exception {
		// 从session中取出用户userId
		User user = (User) session.getAttribute("user");
		Integer userId = user.getUserId();

		List<CustomMessage> list = messageService.queryMessagesByUser(userId);

		// 将留言内容转为string格式
		for (CustomMessage customMessage : list) {
			customMessage.setContent(ConversionUtil.unicode2String(customMessage.getContent()));

			// 时间格式化
			customMessage.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm")
					.format(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(customMessage.getTime())));
		}

		JSONObject resultJSON = new JSONObject();
		resultJSON.put("lists", list);
		return resultJSON.toString();
	}

	/**
	 * 发布留言，从session中取出用户iD
	 * 
	 * @param message
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMessage(Message message, HttpSession session) throws Exception {

		// 从session中取出用户userId
		User user = (User) session.getAttribute("user");
		Integer userId = user.getUserId();

		// 将留言内容转为Unicode格式
		message.setContent(ConversionUtil.string2Unicode(message.getContent()));

		messageService.saveMessage(userId, message);

		return "redirect:/page/main";
	}

	/**
	 * 根据留言id修改留言
	 * 
	 * @param message
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateMessage(String type, String messageId, Message message) throws Exception {

		// 将留言内容转为Unicode格式
		message.setContent(ConversionUtil.string2Unicode(message.getContent()));

		messageService.updateMessage(messageId, message);
		
		if (type!=null && !"".equals(type)) {
			return "redirect:/page/main";
		}
		return "redirect:/page/me";
	}

	/**
	 * 删除留言
	 * 
	 * @param messageId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleMessage(String messageId) throws Exception {

		messageService.delMessage(messageId);

		JSONObject resultJSON = new JSONObject();
		resultJSON.put("status", "success");
		return resultJSON.toString();
	}
}
