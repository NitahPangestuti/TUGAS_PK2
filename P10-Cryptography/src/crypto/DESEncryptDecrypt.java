/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;
import java.io.UnsupportedEncodingException;
import java.security.*;
import javax.crypto.*;

/**
 *
 * @author Nitah Pangestuti
 */
public class DESEncryptDecrypt {
   public static void doEncryptDecrypt(){
       try {
           String data = "Dasar Synematric Cryptography";
           byte[] plain = data.getBytes("UTF8");
           //membuat DES private key
           KeyGenerator keyGen = KeyGenerator.getInstance("DES");
           keyGen.init(56);
           Key key = keyGen.generateKey();
           //membuat DES cipher => print ke provider
           Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
           //proses encrypt
           cipher.init(Cipher.ENCRYPT_MODE, key);
           byte[] cipherText = cipher.doFinal(plain);
           //proses descrypt
           cipher.init(Cipher.DECRYPT_MODE, key);
           byte[] originText = cipher.doFinal(cipherText);
           System.out.println("Plain Text: "+data);
           System.out.println("Enkripsi: "+new String(cipherText, "UTF8"));
           System.out.println("Enkripsi Heksa: "+ MyStringUtils.
                   getHexString(cipherText));
           System.out.println("Deskripsi: "+new String(originText, "UTF8"));
       } catch (UnsupportedEncodingException | InvalidKeyException | 
               NoSuchAlgorithmException | BadPaddingException |
               IllegalBlockSizeException | NoSuchPaddingException e) {
       }
    }
    public static void main(String[] args){
        doEncryptDecrypt();
    }
}
