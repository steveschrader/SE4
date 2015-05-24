package be.odisee.pajotterconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity  
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.dataSource(datasource)
			.usersByUsernameQuery("select emailadres, paswoord, true as enabled from partijen where emailadres = ?")
			.authoritiesByUsernameQuery("select partijen.emailadres, rollen.type as authority from partijen,rollen"+
											" where partijen.id=rollen.partij_id and emailadres=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/menu.html")
				.failureUrl("/login?login_error=1")
				.and()
			.logout().logoutSuccessUrl("/logoutSuccess.html")
				.and()
				.httpBasic()
				.and()
			.authorizeRequests()
			.antMatchers("/login*").permitAll()
			.antMatchers("/logout*").permitAll()
			.antMatchers("/logoutSuccess*").permitAll()
			.antMatchers("/accessDenied*").permitAll()
			.antMatchers("/Administrator/**").hasAuthority("Administrator")
			.antMatchers("/Koper/**").hasAuthority("Koper")
			/*onderstaande regel in commentaar leidt tot niets*/
			/*.antMatchers("/Pajotters/**").hasAnyAuthority("Administrator","Koper", "Leverancier", "Teler")*/
			.antMatchers("/Pajotter/**").hasAnyAuthority("Pajotter")
			.antMatchers("/Leverancier/**").hasAuthority("Leverancier")
			.antMatchers("/Bestelling/**").hasAnyAuthority("Industrie", "Koper", "Teler")
			.antMatchers("/Industrie/**").hasAuthority("Industrie")
			.antMatchers("/Teler/**").hasAuthority("Teler")

			.antMatchers("/css/**").anonymous()
			.antMatchers("/js/**").anonymous()

			.antMatchers("/**").authenticated()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied");
	}
}
