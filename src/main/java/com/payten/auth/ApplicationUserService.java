package com.payten.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.payten.termhost.repository.ApplicationUserRepository;

@Service
public class ApplicationUserService implements UserDetailsService {
/*
    private final ApplicationUserDao applicationUserDao;

    @Autowired
    public ApplicationUserService(@Qualifier("fake") ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }
*/
	@Autowired
	ApplicationUserRepository applicationUserRepository;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 /*       return applicationUserDao
                .selectApplicationUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );
*/        com.payten.termhost.model.ApplicationUser applicationUser = applicationUserRepository.getApplicationUserByUsername(username);
    	  ApplicationUser userDetails = new ApplicationUser(applicationUser.getUsername(), applicationUser.getPassword(), null, true, true, true, true);
          return  userDetails;     
   }
}
