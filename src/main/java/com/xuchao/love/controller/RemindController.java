package com.xuchao.love.controller;

import com.xuchao.love.pojo.*;
import com.xuchao.love.service.WechatNoticeClient;
import com.xuchao.love.service.OperateLogService;
import com.xuchao.love.service.RemindService;
import com.xuchao.love.service.UserService;
import com.xuchao.love.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuchao
 * @create 2023-10-19 16:14
 */
@Component
@Slf4j
@RestController
@RequestMapping("/api")
public class RemindController {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired 
    private RemindService remindService;
    @Autowired
    private OperateLogService operateLogService;
    @Autowired
    private WechatNoticeClient wechatNoticeClient;
    @Autowired
    private UserService userService;
  
    @GetMapping("remindTask")
    public Result remindTask(@RequestParam("id") Integer id){
        try {
            String jwt = httpServletRequest.getHeader("Authorization");
            Integer operateUser = null;
            if(jwt != null){
                jwt = jwt.substring(7);
                Claims claims = JwtUtils.parseJWT(jwt);
                //登陆人ID
                operateUser = (Integer) claims.get("id");
                Task resTask = remindService.remindTask(id);
                User user = userService.selectUser(resTask.getFounderId());
                User taskUser = userService.selectCredit(resTask.getUseName());
                //微信推送信息
                Map<String, Object> sendMap = new HashMap<>();
                sendMap.put("msgtype", "news");
                Map<String, Object> contentMap = new HashMap<>();
                List<Map<String, Object>> list = new ArrayList<>();
                Map<String, Object> obj = new HashMap<>();
                String baseUrl = httpServletRequest.getRequestURL().toString();
                String requestUri = httpServletRequest.getRequestURI();
                String baseUrlWithoutPath = baseUrl.replace(requestUri, "");
                log.info(baseUrlWithoutPath);
                String url = baseUrlWithoutPath+"/#/TaskDisplay/"+resTask.getTaskId();
                Map<String, Object> firstsendMap = new HashMap<>();
                //设置消息类型 txt文本
                firstsendMap.put("msgtype", "text");
                Map<String, String> firstContentMap = new HashMap<>();
                if(operateUser == resTask.getFounderId()){
                    obj.put("title", "🥰您的宝宝"+user.getName()+"提醒您完成"+resTask.getTaskName()+"任务,快去完成任务吧!");
                    obj.put("description", "🦄快去完成任务吧，记得一定要完成今日任务啊，加油，奥利给！");
                    obj.put("url",url);
                    obj.put("picurl", resTask.getUserImage());
                    firstContentMap.put("content", "@"+resTask.getUseName());
                }
                else if(operateUser == taskUser.getNameId()){
                    obj.put("title", "🥰您的宝宝"+resTask.getUseName()+"已完成"+resTask.getTaskName()+"任务,快去帮他确认完成任务吧！");
                    obj.put("description", "🦄快去帮您的宝宝确认完成任务吧，记得您也要完成今日任务噢，加油，奥利给！");
                    url = baseUrlWithoutPath+"/#/wechatTaskDisplay/"+resTask.getTaskId();
                    obj.put("url",url);
                    obj.put("picurl", resTask.getUserImage());
                    firstContentMap.put("content", "@"+user.getName());
                }
                else {
                    return Result.error("您不能点击提醒别人的专属任务哦！");
                }
                list.add(obj);
                contentMap.put("articles", list);
                firstsendMap.put("text", firstContentMap);
                String NOTICE_KEY = userService.getWechatNoticeKey();
                wechatNoticeClient.sendWechatMsg(NOTICE_KEY, firstsendMap);
                sendMap.put("news", contentMap);
                wechatNoticeClient.sendWechatMsg(NOTICE_KEY, sendMap);
                return Result.success("提醒成功");
            }
            else return Result.error("not_Login");

        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("提醒失败");
        }
    }
    
    @GetMapping("remindRoom")
    public Result remindRoom(@RequestParam("id") Integer id){
        try {
            String jwt = httpServletRequest.getHeader("Authorization");
            Integer operateUser = null;
            if(jwt != null) {
                jwt = jwt.substring(7);
                Claims claims = JwtUtils.parseJWT(jwt);
                //登陆人ID
                operateUser = (Integer) claims.get("id");
                Room resRoom = remindService.remindRoome(id);
                User user = userService.selectUser(resRoom.getFounderId());
                //微信推送信息
                log.info(operateUser.toString());
                if (operateUser == resRoom.getFounderId()) {
                    Map<String, Object> sendMap = new HashMap<>();
                    sendMap.put("msgtype", "news");
                    Map<String, Object> contentMap = new HashMap<>();
                    List<Map<String, Object>> list = new ArrayList<>();
                    Map<String, Object> obj = new HashMap<>();
                    String baseUrl = httpServletRequest.getRequestURL().toString();
                    String requestUri = httpServletRequest.getRequestURI();
                    String baseUrlWithoutPath = baseUrl.replace(requestUri, "");
                    log.info(baseUrlWithoutPath);
                    String url = baseUrlWithoutPath +"/#/RoomDisplay/" + resRoom.getProduceId();
                    obj.put("title", "🥰您的宝宝" + user.getName() + "提醒您兑换" + resRoom.getProduceName() + "商品,快去看看吧！");
                    obj.put("description", "🌈快给你的宝宝兑换礼物吧，同时也要记得努力完成今日任务，加油，奥利给！");
                    obj.put("url", url);
                    obj.put("picurl", resRoom.getProduceImage());
                    list.add(obj);
                    contentMap.put("articles", list);
                    sendMap.put("news", contentMap);
                    String NOTICE_KEY = userService.getWechatNoticeKey();
                    wechatNoticeClient.sendWechatMsg(NOTICE_KEY, sendMap);
                    return Result.success("提醒成功");
                } else return Result.error("您不能点击提醒别人的专属商品哦！");
            }
            else return Result.error("not_Login");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("提醒失败");
        }
    }
    @GetMapping("reminded")
    public Result reminded(@RequestParam("id") Integer id){
        SendDayMessage sendMessage = null;
        try {
            sendMessage = operateLogService.selectMessage(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(sendMessage.toString());
    }
}
