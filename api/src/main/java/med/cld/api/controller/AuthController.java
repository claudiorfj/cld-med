package med.cld.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.cld.api.domain.user.AuthData;
import med.cld.api.domain.user.User;
import med.cld.api.infra.security.TokenJWTData;
import med.cld.api.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AuthController {

  @Autowired
  private AuthenticationManager manager;

  @Autowired
  private TokenService tokenService;
  
  @PostMapping
  public ResponseEntity login(@RequestBody @Valid AuthData data){
    var authToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
    var auth = manager.authenticate(authToken);
    var tokenJWT = tokenService.generateToken((User) auth.getPrincipal());
    return ResponseEntity.ok(new TokenJWTData(tokenJWT));
  }

}
