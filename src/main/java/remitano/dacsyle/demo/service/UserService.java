package remitano.dacsyle.demo.service;

import remitano.dacsyle.demo.dto.User;
import remitano.dacsyle.demo.model.user.UserModel;


public interface UserService
{
	/**
	 * Registry new user account
	 * @param userModel
	 * @return
	 */
	User registration(UserModel userModel);

	/**
	 * Find user by userName
	 * @param userName
	 * @return
	 */
	User findByUserName(String userName);
}
