package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository repository;

    @Autowired
    AuthService authService;

    @Transactional
    public UserDTO findById(Long id) {
        authService.validateSelfOrAdmin(id); //valida se o usuário tem recursos pra acessar oq ele está querendo acessar ou se irá bloquear o acesso dele para determinado recurso
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO findByLoggedUser() {
        User user = authService.authenticated(); //valida se o usuário tem recursos pra acessar oq ele está querendo acessar ou se irá bloquear o acesso dele para determinado recurso
        Optional<User> obj = repository.findById(user.getId());
        User entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        return new UserDTO(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //irá fazer a busca por EMAIL

        User user = repository.findByEmail(username);
        if (user == null) {
            logger.error("User not found: " + username);
            throw new UsernameNotFoundException("E-mail not found");
        }
        logger.info("User found: " +  username);
        return user;
    }
}

