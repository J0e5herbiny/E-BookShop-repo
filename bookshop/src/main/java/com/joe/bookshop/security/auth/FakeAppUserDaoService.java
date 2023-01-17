package com.joe.bookshop.security.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.joe.bookshop.security.AppUserRole.*;


@Repository("fake")
public class FakeAppUserDaoService implements AppUserDao{

    private PasswordEncoder passwordEncoder;

    @Autowired
    public FakeAppUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AppUser> selectAppUserByUsername(String username) {
        return getAppUsers()
                .stream()
                .filter(appUser -> username.equals(appUser.getUsername()))
                .findFirst();
    }

    private List<AppUser> getAppUsers(){
        List<AppUser> appUserList = Lists.newArrayList(
                new AppUser("aleph",
                        passwordEncoder.encode("password"),
                        AUTH_USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true),

                new AppUser("linda",
                        passwordEncoder.encode("password123"),
                        ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true),

                new AppUser("tom",
                        passwordEncoder.encode("password234"),
                        AUTH_USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true)

        );
        return appUserList;
    }

}
