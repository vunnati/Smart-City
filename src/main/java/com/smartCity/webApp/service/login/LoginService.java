package com.smartCity.webApp.service.login;

import com.smartCity.repository.AccountRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class LoginService {

    @Autowired
    AccountRepository accountRepository;

    public boolean  validateLogin(String username){
        try {
            return accountRepository.existsByUsername(username);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

}
