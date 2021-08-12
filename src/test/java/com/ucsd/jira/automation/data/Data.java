package com.ucsd.jira.automation.data;

import com.pwc.core.framework.data.Credentials;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public final class Data {
// public static final Credentials DEFAULT_USER_CREDENTIALS = new Credentials("6uLvR5GI4PfzLb1PyunAchNyTEorGiiwbuhQns5jMAg=", "QMjxVo4OiaZQw7F/JC5PQg==");
    public static final Credentials DEFAULT_USER_CREDENTIALS = new Credentials(Constants.ENCRYPTED_USER1, Constants.ENCRYPTED_PASS1);

// --> encrypt user/pass for:  ucsd.ext10@gmail.com
//    public static final Credentials DEFAULT_USER_CREDENTIALS = new Credentials("Nkhg90CUGGdHPHUz7yNX08WuMg5bg6dgulYBh8pqOk4=", "Ht87Gt5Oad3BdV1FoxhogQ==");

    // Default Test Data
    public static final String DEFAULT_SEARCH_TEXT = "UCSD";

    private Data() {
    }
}
