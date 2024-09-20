package HashSalt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SenhaUtil {

    // byte[] salt = generateSalt();

  
    // Método para gerar um salt aleatório 
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Método para gerar um hash passando a senha e combinando com um salt
    public static String gerarHash(String senha, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256") ;
        md.update(Base64.getDecoder().decode(salt));
        byte[] senhaHash = md.digest(senha.getBytes());
        return Base64.getEncoder().encodeToString(senhaHash);
        // Adiciona o salt a senha 
    }

}
