package sn.dcssi.courrier.gestcourrier.dto;

import java.time.LocalDateTime;

import sn.dcssi.courrier.gestcourrier.entity.Role;

// Response DTO — données sortantes (jamais le mot de passe !)
public record UserResponse(
    Long id,
    String username,
    String email,
    Role role,
    boolean enabled,
    LocalDateTime createdAt
) {}
