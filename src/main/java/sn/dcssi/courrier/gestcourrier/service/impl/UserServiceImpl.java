package sn.dcssi.courrier.gestcourrier.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sn.dcssi.courrier.gestcourrier.dao.UserRepository;
import sn.dcssi.courrier.gestcourrier.dto.UserCreateRequest;
import sn.dcssi.courrier.gestcourrier.dto.UserMapper;
import sn.dcssi.courrier.gestcourrier.dto.UserResponse;
import sn.dcssi.courrier.gestcourrier.dto.UserUpdateRequest;
import sn.dcssi.courrier.gestcourrier.entity.Role;
import sn.dcssi.courrier.gestcourrier.entity.User;
import sn.dcssi.courrier.gestcourrier.exception.ResourceNotFoundException;
import sn.dcssi.courrier.gestcourrier.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    // ca vient du DAO pour acceder à la base de données
    private final UserRepository userRepository;
    // ca vient de Spring Security pour encoder les mots de passe avec un algorithme
    // de hachage sécurisé
    private final PasswordEncoder passwordEncoder;
    // ca vient de MapStruct pour convertir entre User et UserDTO
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserResponse createUser(UserCreateRequest request) {
        log.info("Création utilisateur : {}", request.email());

        // Validation métier
        if (userRepository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("Email déjà utilisé : " + request.email());
        }

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));

        User saved = userRepository.save(user);
        log.info("Utilisateur créé avec ID : {}", saved.getId());
        return userMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true) // Optimisation : transactions lecture seule
    public UserResponse getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserResponse> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toResponse);
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public UserResponse changeRole(Long id, Role newRole) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeRole'");
    }

}
