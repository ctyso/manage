package com.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.annotation.Json;
import com.annotation.JspView;
import com.util.ObjectUtil;

/**
 * 
 * spring拦截器
 *
 * @author YKZHUO
 */
public class SpringInterceptor implements HandlerInterceptor {

    private static final Class<Json> JSON_CLASS = Json.class;
    private static final Class<JspView> JSPVIEW_CLASS = JspView.class;

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        initPath( request );
        return true;
    }

    @Override
    public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception {
        if ( handler instanceof HandlerMethod ) {
            HandlerMethod hm = (HandlerMethod) handler;
            Class<?> clazz = hm.getBeanType();
            Method m = hm.getMethod();
            if ( clazz != null && m != null ) {
                // JSON对象返回
                if ( ObjectUtil.nonNull( m.getAnnotation( JSON_CLASS ) ) ) handlerJson( request, response, modelAndView );

                // Jsp页面返回
                if ( ObjectUtil.nonNull( m.getAnnotation( JSPVIEW_CLASS ) ) ) handlerJsp( request, response, modelAndView );
            }
        }
    }

    @Override
    public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object handler, Exception paramException ) throws Exception {

    }

    /**
     * 全局变量初始化
     * 
     * @param config
     */
    private void initPath( HttpServletRequest request ) {
        String app_path = request.getContextPath();
        String jsp_path = app_path + "/model";
        String res_path = app_path + "/static";
        String css_path = res_path + "/css";
        String js_path = res_path + "/js";
        String img_path = res_path + "/img";
        request.setAttribute( "APP_PATH", app_path );
        request.setAttribute( "JSP_PATH", jsp_path );
        request.setAttribute( "RES_PATH", res_path );
        request.setAttribute( "CSS_PATH", css_path );
        request.setAttribute( "JS_PATH", js_path );
        request.setAttribute( "IMG_PATH", img_path );
    }

    /**
     * 处理Json返回
     */
    public void handlerJson( HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView ) {
        String json = modelAndView.getViewName();
        modelAndView.setView( new MappingJackson2JsonView() );
        modelAndView.clear();

        response.setCharacterEncoding( "utf-8" );
        response.setContentType( "text/html;charset=UTF-8" );
        response.setHeader( "pragma", "no-cache" );
        response.setHeader( "cache-control", "no-cache" );
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write( json );
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( writer != null ) writer.close();
        }
    }

    /**
     * 处理jsp页面返回
     */
    public void handlerJsp( HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView ) {
        response.setCharacterEncoding( "utf-8" );
        response.setContentType( "text/html;charset=UTF-8" );
        response.setHeader( "pragma", "no-cache" );
        response.setHeader( "cache-control", "no-cache" );
    }
}
