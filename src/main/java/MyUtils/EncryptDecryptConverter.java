package MyUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.StandardCharsets;

import static com.pwc.logging.service.LoggerService.LOG;

public class EncryptDecryptConverter {

    protected static String decrypt(final String source,byte[] securityKey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            final SecretKeySpec secretKey = new SecretKeySpec(securityKey, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(org.apache.commons.codec.binary.Base64.decodeBase64(source)));
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static String decrypt(String s, String securityKey) {
        byte[] result = null;
        try {
            java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
            SecretKeySpec skey = new SecretKeySpec(securityKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            result = cipher.doFinal(decoder.decode(s));
        } catch (Exception e) {
            LOG("OOPS!!!! :: ",e);
//            LOG(e.toString());
//            LOG("not able to decrypt :: [" + s + "][" + securityKey + "]");
        } finally {
            if (result != null)
                return new String(result);
            else
                return null;
        }
    }

    protected static String encrypt(final String source,byte[] securityKey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            final SecretKeySpec secretKey = new SecretKeySpec(securityKey, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return org.apache.commons.codec.binary.Base64.encodeBase64String(cipher.doFinal(source.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encrypt(String input, String securityKey) {
        byte[] crypted = null;
        try {

            SecretKeySpec skey = new SecretKeySpec(securityKey.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(input.getBytes());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();

        return new String(encoder.encodeToString(crypted));
    }

    protected static String byteToString(byte[] myByte){
        return new String(myByte, StandardCharsets.UTF_8);
    }

    protected static byte[] stringToByte(String s){
        return  s.getBytes(StandardCharsets.UTF_8);
    }

    protected static String convertStringToHex(String s) {
        StringBuilder result = new StringBuilder();
        result.append("{");
        byte[] b = s.getBytes(StandardCharsets.UTF_8);

        for (int i = 0; i <= b.length; i++) {
            if(i < b.length-1 )
                result.append(String.format(" 0x%02x, ", b[i]));
            else if (i == b.length -1)
                result.append(String.format(" 0x%02x }", b[i]));
        }
        return result.toString();
    }

}
