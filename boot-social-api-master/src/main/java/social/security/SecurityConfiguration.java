package social.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

            //    .defaultSuccessUrl("redirect:http://localhost:3000")//
            //    .failureUrl("/login?error=true")//
                .antMatchers("/api/session").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/tickets").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/requests").authenticated()

                .and()
                .headers().frameOptions().disable() // for h2
                .and()
                .requestCache()
                .requestCache(new NullRequestCache())
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and().csrf().disable();

        //http.authorizeRequests().and().formLogin()
          //      .defaultSuccessUrl("http://localhost:3000");//"redirect:http://localhost:3000")
             //   .failureUrl("http://localhost:3000/login?error=true");
    }
}
