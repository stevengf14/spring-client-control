package ec.com.learning.client.service;

import ec.com.learning.client.dao.UsersDao;
import ec.com.learning.client.domain.Role;
import ec.com.learning.client.domain.Users;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UsersService implements UserDetailsService{

    @Autowired
    private UsersDao userDao;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDao.findByUsername(username);
        
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        
        var roles = new ArrayList<GrantedAuthority>();
        
        for(Role rol: user.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getName()));
        }
        
        return new User(user.getUsername(), user.getPassword(), roles);
    }
    
}