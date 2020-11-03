package remitano.dacsyle.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import remitano.dacsyle.demo.model.user.UserModel;

import java.util.Collection;


public class MyUserDetail implements UserDetails
{
	private String userName;
	private String password;
	private Boolean active;

	public MyUserDetail(UserModel user)
	{
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active = user.getActive();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return null;
	}

	@Override
	public String getPassword()
	{
		return password;
	}

	@Override
	public String getUsername()
	{
		return userName;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return active;
	}
}
