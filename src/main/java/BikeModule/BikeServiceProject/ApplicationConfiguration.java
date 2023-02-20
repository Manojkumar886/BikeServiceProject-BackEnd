package BikeModule.BikeServiceProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
public class ApplicationConfiguration
{
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsservice() {
        UserDetails myUser1=User.withUsername("manoj").password(encoder().encode("Maddysins")).roles("USER")
                .build();
        UserDetails myUser2=User.withUsername("annamalai").password(encoder().encode("annamalaisins")).roles("USER")
                .build();

        Collection<UserDetails> myusers= Stream.of(myUser1,myUser2).toList();

        return new InMemoryUserDetailsManager(myusers);
    }



    @Bean
    public SecurityFilterChain prabakaran(HttpSecurity hp) throws Exception {
        hp.authorizeHttpRequests().requestMatchers("/api/*").authenticated();
        hp.csrf().disable();
        hp.httpBasic();
        hp.formLogin();


        return hp.build();
    }
}
