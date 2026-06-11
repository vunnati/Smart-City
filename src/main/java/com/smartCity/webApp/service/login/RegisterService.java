package com.smartCity.webApp.service.login;

import com.smartCity.objects.users.Account;
import com.smartCity.objects.users.Admins;
import com.smartCity.objects.users.User;
import com.smartCity.repository.AccountRepository;
import com.smartCity.repository.AdminRepository;
import com.smartCity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    Admins admins;

    User user;

    public void addToUserOrAdminTable(Account account){
        if(account.getRole().equals("admin")){
            admins = new Admins();
            admins.setUsername(account.getUsername());
            admins.setPassword(account.getPassword());
            admins.setEmail(account.getEmail());
            admins.setPhoneNumber(account.getPhoneNumber());
            adminRepository.save(admins);
        }else{
            user = new User();
            user.setUsername(account.getUsername());
            user.setPassword(account.getPassword());
            user.setEmail(account.getEmail());
            user.setPhoneNumber(account.getPhoneNumber());
            userRepository.save(user);
        }
    }

    public boolean checkUserName(Account account){
        return accountRepository.existsByUsername(account.getUsername());
    }
}
