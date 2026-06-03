package sn.dcssi.courrier.gestcourrier.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import sn.dcssi.courrier.gestcourrier.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserResponse toResponse(User user);

    User toEntity(UserCreateRequest request);

    List<UserResponse> toResponseList(List<User> users);
}
