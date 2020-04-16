package com.example.demo.Interceptor;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.PassToken;
import com.example.demo.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注解，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //没有passtoken注解将进行token认证
        // 执行认证
        if (token == null) {
            throw new RuntimeException("无token，请重新登录");
        }

        // 验证 token
        String value = TokenUtils.vaildToken(token);

        assert value != null;
        switch (value) {
            case "401":
                throw new RuntimeException("Token 无效");
            case "402":
                throw new RuntimeException("Token 已过期");
            case "403":
                throw new RuntimeException("账号为空");
            default:
                User user = userService.select(value);
                if(user==null){
                    throw new RuntimeException("账号不存在");
                }
                return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

}