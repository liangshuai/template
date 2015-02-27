package me.liangshuai.controller;

import java.util.Map;

import javax.servlet.ServletContext;

import me.liangshuai.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
public class HomeController {
	@Autowired
    ServletContext context; 
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String,Object> model){
		SessionFactory session = (SessionFactory) WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("sessionFactory");
		Session sess = session.openSession();
		Transaction tx = sess.beginTransaction();
		User user = new User();
		user.setUsername("liangshuai");
		user.setPassword("pwd");
		sess.save(user);
		tx.commit();
		sess.close();
		System.out.println("======================");
		return "home";
	}
}