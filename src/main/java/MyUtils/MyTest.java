package MyUtils;

import static com.pwc.logging.service.LoggerService.LOG;

public class MyTest extends EncryptDecryptConverter {

    private static final byte[] SECURITY_KEY = {0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79}; //ORIGINAL

    public static void main(String[] args) {

        //user10
        String username10 = "ucsd.ext10@gmail.com";
        String password10 = "ucsdtest101";
        String encryptUsername10 = "Nkhg90CUGGdHPHUz7yNX08WuMg5bg6dgulYBh8pqOk4=";
        String encryptPasswordEncrypt10 = "Ht87Gt5Oad3BdV1FoxhogQ==";

        //user1
        String username1 = "ucsd.ext1@gmail.com";
        String password1 = "Murray08";
        String encryptUsername1 = "6uLvR5GI4PfzLb1PyunAchNyTEorGiiwbuhQns5jMAg="; //ORIGINAL
        String encryptPasswordEncrypt1 = "QMjxVo4OiaZQw7F/JC5PQg=="; //ORIGINAL
        String secretString1 = "thisIsASecretKey Gabriel";

        //test
        String secretString2 = "This Secret Word";


        LOG("Test for user1: "+username1);
        LOG("encrypted-username: " + encryptUsername1 +" :: decrypted-username: "+decrypt(encryptUsername1,SECURITY_KEY));
        LOG("encrypted-password: " + encryptPasswordEncrypt1 +" :: decrypted-password: "+decrypt(encryptPasswordEncrypt1,SECURITY_KEY));
        LOG("--------------------------------------------------------");
        LOG("Test for user10: "+username10);
        LOG("decrypted-username: "+username10+" :: encrypted-username: "+encrypt(username10,SECURITY_KEY));
        LOG("decrypted-password: "+password10+" :: encrypted-password: "+encrypt(password10,SECURITY_KEY));

        LOG("--------------------------------------------------------");
        LOG("byte[] SECURITY_KEY converted to String: \""+byteToString(SECURITY_KEY)+"\"");
        LOG("String \"" + secretString1 + "\" converted to a byte array (byte[]): ");
        LOG("   "+convertStringToHex(secretString1));

        LOG("--------------------------------------------------------");
        LOG("decrypt encrypted string: ["+encryptUsername1 + "] with secretString1 [" + secretString1 + "] :: results: ["+ decrypt(encryptUsername1, secretString1)+ "]");
        //LOG("encrypt string username1: ["+username1 + "] with secretString1 [" + secretString1 + "] :: results: ["+ encrypt(username1, secretString1)+"]");

    }
}
