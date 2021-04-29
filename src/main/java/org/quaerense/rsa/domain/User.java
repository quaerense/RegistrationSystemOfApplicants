package org.quaerense.rsa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Поле обязательно для заполнения")
    @NotBlank(message = "Поле обязательно для заполнения")
    @Size(min = 4, max = 16, message = "Имя пользователя должно содержать от 4 до 16 символов и быть уникальным")
    @Column(name = "username", unique = true)
    private String username;

    @Size(min = 8, message = "Пароль должен содержать минимум 8 символов")
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @NotNull(message = "Поле обязательно для заполнения")
    @NotBlank(message = "Поле обязательно для заполнения")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Поле обязательно для заполнения")
    @NotBlank(message = "Поле обязательно для заполнения")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Email(message = "Не является почтой")
    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

//    @AssertTrue(message = "Пароли должны совпадать")
//    private boolean isValid() {
//        return password.equals(confirmPassword);
//    }
}
