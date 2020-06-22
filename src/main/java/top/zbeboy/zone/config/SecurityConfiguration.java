package top.zbeboy.zone.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.session.security.web.authentication.SpringSessionRememberMeServices;
import top.zbeboy.zbase.config.Workbook;
import top.zbeboy.zone.filter.SecurityLoginFilter;
import top.zbeboy.zone.security.AjaxAuthenticationFailureHandler;
import top.zbeboy.zone.security.AjaxAuthenticationSuccessHandler;
import top.zbeboy.zone.security.MyUserDetailsServiceImpl;
import top.zbeboy.zone.security.WebSecurity;

import javax.inject.Inject;

/**
 * spring security 配置.
 *
 * @author zbeboy
 * @version 1.0
 * @since 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsService;

    @Inject
    private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;

    @Inject
    private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurity webSecurity() {
        return new WebSecurity();
    }

    @Bean
    public SpringSessionRememberMeServices rememberMeServices() {
        SpringSessionRememberMeServices rememberMeServices =
                new SpringSessionRememberMeServices();
        // optionally customize
        rememberMeServices.setAlwaysRemember(true);
        return rememberMeServices;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .ignoringAntMatchers("/api/**", Workbook.OAUTH_AUTHORIZE)
                .and()
                .headers()
                // allow same origin to frame our site to support iframe SockJS
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests().antMatchers("/css/**", "/js/**", "/fonts/**", "/images/**", "/plugins/**", "/goods/**", "/portfolios/*/avatar/**", "/webjars/**", "/webjarsjs/**").permitAll()
                .and().formLogin().loginPage("/login")
                .successHandler(this.ajaxAuthenticationSuccessHandler)
                .failureHandler(this.ajaxAuthenticationFailureHandler)
                .and().logout().logoutSuccessUrl("/")
                .permitAll().invalidateHttpSession(true)
                .and().rememberMe().rememberMeServices(rememberMeServices())
                .and().authorizeRequests().antMatchers("/web/**").access("@webSecurity.check(authentication,request)")
                .and().authorizeRequests().antMatchers("/special/channel/**").hasAnyRole("SYSTEM", "ADMIN") // 特别通道 跨controller调用共同方法使用
                .and().authorizeRequests().antMatchers("/users/**", "/api/**", Workbook.OAUTH_AUTHORIZE).authenticated()
                .and().authorizeRequests().antMatchers("/files/**", "/portfolios/**").authenticated()
                .and().authorizeRequests().antMatchers("/anyone/**").permitAll()
                .antMatchers("/metrics/**").hasRole("ACTUATOR")
                .antMatchers("/health/**").hasRole("ACTUATOR")
                .antMatchers("/trace/**").hasRole("ACTUATOR")
                .antMatchers("/dump/**").hasRole("ACTUATOR")
                .antMatchers("/shutdown/**").hasRole("ACTUATOR")
                .antMatchers("/beans/**").hasRole("ACTUATOR")
                .antMatchers("/configprops/**").hasRole("ACTUATOR")
                .antMatchers("/info/**").hasRole("ACTUATOR")
                .antMatchers("/autoconfig/**").hasRole("ACTUATOR")
                .antMatchers("/env/**").hasRole("ACTUATOR")
                .antMatchers("/mappings/**").hasRole("ACTUATOR")
                .and().addFilterBefore(new SecurityLoginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.myUserDetailsService).passwordEncoder(passwordEncoder()).and().eraseCredentials(false);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
