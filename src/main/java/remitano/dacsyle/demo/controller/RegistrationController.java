package remitano.dacsyle.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import remitano.dacsyle.demo.dto.User;
import remitano.dacsyle.demo.model.UserModel;
import remitano.dacsyle.demo.service.UserService;

import javax.websocket.server.PathParam;


@Controller
public class RegistrationController
{
	@Autowired
	UserService userService;
	@Autowired
	BCryptPasswordEncoder cryptPasswordEncoder;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "sign-up";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registry(@PathVariable("username") User newUser, Model model) {

		User existedUser = userService.findByUserName(newUser.getUserName());
		if (existedUser != null) {
			return "redirect:/registration";
		}
		UserModel userModel = new UserModel();
		userModel.setActive(Boolean.TRUE);
		userModel.setPassword(cryptPasswordEncoder.encode(newUser.getPassword()));
		userModel.setUserName(newUser.getUserName());
		userService.registration(userModel);
		return "redirect:/login";
	}
}
