package com.huzaifa.aichat.config;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.huzaifa.aichat.entity.User;
import com.huzaifa.aichat.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
  private final UserRepository userRepo;
  private final PasswordEncoder encoder;
  public DataInitializer(UserRepository userRepo, PasswordEncoder encoder){
    this.userRepo = userRepo; this.encoder = encoder;
  }

  @Override
  public void run(String... args) throws Exception {
    if(!userRepo.existsByUsername("admin")){
      User admin = new User("admin", encoder.encode("admin123"), Set.of("ADMIN","USER"));
      userRepo.save(admin);
      System.out.println("Admin created: admin/admin123");
    }
  }
}
