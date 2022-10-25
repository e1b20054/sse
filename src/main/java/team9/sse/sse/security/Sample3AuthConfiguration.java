package team9.sse.sse.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Sample3AuthConfiguration {

  /**
   * 認証処理に関する設定（誰がどのようなロールでログインできるか）
   *
   * @return
   */
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserBuilder users = User.builder();
    UserDetails customer1 = users
        .username("kara")
        .password("$2y$10$KO3t7PPjsrEesyuDPKVDY.2kSlUpePk8dKrV0rVwNIoRMxDphvrMy")
        .roles("CUSTOMER")
        .build();
    UserDetails customer2 = users
        .username("ike")
        .password("$2y$10$fZXOr1xQOxluMR8cl46xh.Lw712/m0jMYRxuSRxVI2ASpvXf5Tk9m")
        .roles("CUSTOMER")
        .build();
    UserDetails seller = users
        .username("yoko")
        .password("$2y$10$eWpT4qHt3qKeGZmgs.sIm.UW0kKCks5k.EZx3HNoGSUx3HncvbDce")
        .roles("SELLER")
        .build();
    return new InMemoryUserDetailsManager(customer1, customer2, seller);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin();
    http.authorizeHttpRequests().mvcMatchers("/sample5/**").authenticated();
    http.logout().logoutSuccessUrl("/");
    http.csrf().disable();
    http.headers().frameOptions().disable();
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
