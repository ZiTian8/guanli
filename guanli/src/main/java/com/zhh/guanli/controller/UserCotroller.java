/**
 * @ClassName UserCotroller
 * @Description
 * @Author HAHA
 * @Version V1.0.0
 * @Date 2019-02-28 19:50
 */
package com.zhh.guanli.controller;

//import com.mmall.common.Const;
//import com.mmall.common.ResponseCode;
//import com.mmall.common.ServerResponse;
//import com.mmall.pojo.User;
//import com.mmall.service.IUserService;
//import com.mmall.util.CookieUtil;
//import com.mmall.util.JsonUtil;
//import com.mmall.util.RedisShardedPoolUtil;
//import org.apache.commons.lang.StringUtils;
import com.zhh.guanli.common.Const;
import com.zhh.guanli.common.ServerResponse;
import com.zhh.guanli.pojo.User;
import com.zhh.guanli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

//@Controller
//@RequestMapping("/user/")
@Controller
public class UserCotroller {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */

    @PostMapping(value = "/user/login")
//    @ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, HttpServletResponse httpServletResponse, Map<String,Object> map
                        ){
        //service-->mybatis-->dao
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){

            session.setAttribute(Const.CURRENT_USER,response.getData());
            //CookieUtil.writeLoginToken(httpServletResponse,session.getId());
            //RedisShardedPoolUtil.setEx(session.getId(), JsonUtil.obj2String(response.getData()), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
            return "redirect:/main.html";
        }else{
//            map.put("msg","用户名密码错误");
            map.put("msg",response.getMsg());

            return  "login";
        }
//        return response.toString();
    }

//    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<String> logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        CookieUtil.delLoginToken(httpServletRequest,httpServletResponse);
//        RedisShardedPoolUtil.del(loginToken);
//
////        session.removeAttribute(Const.CURRENT_USER);
//
//        return ServerResponse.createBySuccess();
//    }

    @PostMapping(value = "/user/register")
    public String register(User user,Map<String,Object> map){
        ServerResponse<String> response=iUserService.register(user);
        if(response.isSuccess()){
            //注册成功
            map.put("msg",response.getMsg());
            return "redirect:/";
        }else{
            map.put("msg",response.getMsg());
            return "register";
        }

//        map.put("msg",iUserService.register(user).getMsg());
//        return "redirect:/";
//        return  "login";
//        return iUserService.register(user);
    }

    @RequestMapping(value = "check_valid.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String str,String type){
        return iUserService.checkValid(str,type);
    }

//    @RequestMapping(value = "get_user_info.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<User> getUserInfo(HttpServletRequest httpServletRequest){
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr,User.class);
//
//        if(user != null){
//            return ServerResponse.createBySuccess(user);
//        }
//        return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//    }


    @RequestMapping(value = "forget_get_question.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username){
        return iUserService.selectQuestion(username);

    }

    @RequestMapping(value = "forget_check_answer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username,String question,String answer){
        return iUserService.checkAnswer(username,question,answer);
    }

    @RequestMapping(value = "forget_reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetRestPassword(String username,String passwordNew,String forgetToken){
        return iUserService.forgetResetPassword(username,passwordNew,forgetToken);
    }

//    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<String> resetPassword(HttpServletRequest httpServletRequest, String passwordOld, String passwordNew){
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(org.apache.commons.lang3.StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr,User.class);
//        if(user==null){
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }
//        return iUserService.resetPassword(passwordOld,passwordNew,user);
//    }

//    @RequestMapping(value = "update_information.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<User> update_information(HttpServletRequest httpServletRequest, User user){
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User currentUser = JsonUtil.string2Obj(userJsonStr,User.class);
//        if(currentUser==null){
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }
//        user.setId(currentUser.getId());
//        user.setUsername(currentUser.getUsername());
//        ServerResponse<User> response =iUserService.updateInformation(user);
//        if(response.isSuccess()){
//            response.getData().setUsername(currentUser.getUsername());
//
//            //session.setAttribute(Const.CURRENT_USER,response.getData());
//            RedisShardedPoolUtil.setEx(loginToken, JsonUtil.obj2String(response.getData()),Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
//
//        }
//        return response;
//    }
//
//    @RequestMapping(value = "get_information.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<User>get_information(HttpServletRequest httpServletRequest){
//        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
//        if(StringUtils.isEmpty(loginToken)){
//            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User currentUser = JsonUtil.string2Obj(userJsonStr,User.class);
//        if(currentUser==null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录，需要强制登录ststus=10");
//        }
//        return iUserService.getInformation(currentUser.getId());
//    }





}
