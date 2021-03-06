package com.hjs.study.spring.chat;

import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.hjs.study.spring.util.DateUtil;
 
/**
 * <b>function:</b>监听客户端事件，想客户端推出消息
 */
@Component
public class ChatMessageClient implements ApplicationListener, ServletContextAware {
    
    private ServletContext ctx;
    
    public ChatMessageClient() {
		System.out.println("client构造方法");
	}
    
    public void setServletContext(ServletContext ctx) {
        this.ctx = ctx;
    }
    
    @SuppressWarnings("deprecation")
    public void onApplicationEvent(ApplicationEvent event) {
        //如果事件类型是ChatMessageEvent就执行下面操作
        if (event instanceof ChatMessageEvent) {
            Message msg = (Message) event.getSource();
            ServerContext context = ServerContextFactory.get();
            //获得客户端所有chat页面scriptsession连接数 
            //括号中的参数需要指向聊天页面所在的地址栏地址
            Collection<ScriptSession> sessions = context.getScriptSessionsByPage(ctx.getContextPath() + "/chat/chatRoom.do");
            for (ScriptSession session : sessions) {
                ScriptBuffer sb = new ScriptBuffer();
                Date time = msg.getTime();
                String s = DateUtil.parseToString(time, "HH:mm:ss");
                //执行setMessage方法
                System.out.println("sessionId:"+session.getId());
                sb.appendScript("showMessage({msg: '")
                .appendScript(msg.getMsg())
                .appendScript("', time: '")
                .appendScript(s)
                .appendScript("'})");
                System.out.println(sb.toString());
                //执行客户端script session方法，相当于浏览器执行JavaScript代码
                //上面就会执行客户端浏览器中的showMessage方法，并且传递一个对象过去
                session.addScript(sb);
            }
        }
    }
}
