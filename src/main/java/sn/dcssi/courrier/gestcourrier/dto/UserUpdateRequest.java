package sn.dcssi.courrier.gestcourrier.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserUpdateRequest(
    @NotBlank(message = "Username requis")
    @Size(min = 3, max = 50)
    String username,
 
    @NotBlank @Email(message = "Email invalide")
    String email,
 
    @NotBlank
    @Size(min = 8, message = "Mot de passe : 8 caractères minimum")
    String password
) {}        