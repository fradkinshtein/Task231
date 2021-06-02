package task231.crud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import task231.crud.model.User;
import task231.crud.dao.UserDAO;

@Controller
public class MainController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/")
	public ModelAndView listUser(ModelAndView model){
		List<User> listUser = userDAO.list();
		model.addObject("listUser", listUser);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model){
		User newUser = new User();
		model.addObject("user", newUser);
		model.setViewName("user_form");
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		if(user.getId() == null) {
			userDAO.save(user);
		} else {
			userDAO.update(user);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		User user = userDAO.get(id);
		
		ModelAndView model = new ModelAndView("user_form");
		
		model.addObject("user", user);
		
		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam Integer id) {
		userDAO.delete(id);
		return new ModelAndView("redirect:/");
	}
	
}
