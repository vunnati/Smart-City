package com.smartCity.config;

import com.smartCity.objects.users.Account;
import com.smartCity.repository.AccountRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Data
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username);

        if(account == null){
            throw new UsernameNotFoundException("Username could not be found");
        }else{
            // Populate roles of the user
            String role = account.getRole();
            return org.springframework.security.core.userdetails.User.withUsername(username)
                    .password(account.getPassword()) // Assuming password is stored in Account object
                    .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase())))
                    .build();
        }
    }
}
