package models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString//dlya zapisi testa kak on proshol
@Builder
@Getter
@Setter
public class Auth {
    String email;
    String password;
}
