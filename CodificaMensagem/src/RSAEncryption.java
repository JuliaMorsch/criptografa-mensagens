// Criptografia Assimétrica RSA

import java.security.*;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSAEncryption {

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.genKeyPair();
    }

    public static String encrypt(String message, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedMessage, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        KeyPair keyPairArthur = generateKeyPair();
        KeyPair keyPairWallace = generateKeyPair();

        String message = "Essa é uma mensagem criptografada.";

        String encryptedMessage = encrypt(message, keyPairWallace.getPublic());
        System.out.println("Mensagem criptografada: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, keyPairWallace.getPrivate());
        System.out.println("Mensagem descriptografada: " + decryptedMessage);
    }
    
}
