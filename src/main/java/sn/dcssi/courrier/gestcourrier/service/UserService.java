package sn.dcssi.courrier.gestcourrier.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sn.dcssi.courrier.gestcourrier.dto.UserCreateRequest;
import sn.dcssi.courrier.gestcourrier.dto.UserResponse;
import sn.dcssi.courrier.gestcourrier.dto.UserUpdateRequest;
import sn.dcssi.courrier.gestcourrier.entity.Role;
import sn.dcssi.courrier.gestcourrier.entity.User;


public interface UserService {

    UserResponse createUser(UserCreateRequest request);
    UserResponse getUserById(Long id);
    Page<UserResponse> getAllUsers(Pageable pageable);
    UserResponse updateUser(Long id, UserUpdateRequest request);
    void deleteUser(Long id);
    UserResponse changeRole(Long id, Role newRole);





}
