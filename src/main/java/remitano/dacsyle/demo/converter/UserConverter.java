package remitano.dacsyle.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import remitano.dacsyle.demo.dto.User;
import remitano.dacsyle.demo.model.user.UserModel;

@Service
public class UserConverter implements Converter<UserModel, User>
{
	@Override
	public User convert(UserModel source)
	{
		User target = new User();
		target.setActive(source.getActive());
		target.setUserName(source.getUserName());
		target.setPassword(source.getPassword());
		return target;
	}
}
