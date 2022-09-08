package com.demo.jwt;
import com.demo.model.user.AppUser;
import com.demo.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IAppUserRepo iAppUserRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser =  iAppUserRepo.findByUserName(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("could not find "+username);
        }
        return new CustomUserDetail(appUser);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = "1234";
        bCryptPasswordEncoder.encode(pass);
        System.out.println( bCryptPasswordEncoder.encode(pass));
    }

}