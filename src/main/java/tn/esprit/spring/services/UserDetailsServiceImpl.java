package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService,IServiceUser {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }

  public List<User> retrieveAllUsers(){
    return (List<User>) userRepository.findAll();
  }

  public User updateUser(int id){
    User user = userRepository.findById(id).get();
    return userRepository.save(user);
  }

  public void deleteUser(Integer id){

    userRepository.deleteById(id);
  }

  @Override
  public Optional<User> getUserByID(Integer id) {
    return userRepository.findById(id);
  }


  public List<String> loyalUser(){
    List<User> users = (List<User>) userRepository.findAll();
    User userMax = null;
    int max = -1;
    for (User u : users){
      if(u.getEvents().size() > max){
        max = u.getEvents().size();
        userMax = u;
      }
    }
    List<String> result = List.of(userMax.getUsername(),userMax.getEmail());
    return result;
  }

}