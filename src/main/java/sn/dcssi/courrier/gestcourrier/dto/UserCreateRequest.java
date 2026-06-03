package sn.dcssi.courrier.gestcourrier.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import sn.dcssi.courrier.gestcourrier.entity.Role;

// Request DTO — données entrantes
public record UserCreateRequest(
    @NotBlank(message = "Username requis")
    @Size(min = 3, max = 50)
    String username,
 
    @NotBlank @Email(message = "Email invalide")
    String email,
 
    @NotBlank
    @Size(min = 8, message = "Mot de passe : 8 caractères minimum")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
             message = "Doit contenir majuscule, minuscule et chiffre")
    String password
) {}
 



