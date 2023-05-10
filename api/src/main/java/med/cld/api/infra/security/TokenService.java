package med.cld.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import med.cld.api.domain.user.User;

@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String secret;
  
  public String generateToken(User user){
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.create()
          .withIssuer("API CLD.MED")
          .withSubject(user.getLogin())
          .withExpiresAt(ExpireData())
          .sign(algorithm);
  } catch (JWTCreationException exception){
    throw new RuntimeException("Error generating jwt token", exception);
  }
  }

  private Instant ExpireData() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("+01:00"));
  }

}
