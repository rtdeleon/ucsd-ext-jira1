package com.ucsd.jira.automation.tests.web.company.jira.basicuser;

import com.pwc.core.framework.annotations.Issue;
import com.pwc.core.framework.listeners.Retry;
import com.ucsd.jira.automation.data.Constants;
import com.ucsd.jira.automation.frameworksupport.Groups;
import com.ucsd.jira.automation.frameworksupport.JiraTestCase;
import org.testng.annotations.Test;

import static com.pwc.logging.service.LoggerService.*;

public class BasicTest extends JiraTestCase {

    @Override
    public void beforeMethod() {
    }

    @Override
    public void afterMethod() {
    }

    @Issue("STORY-1")
    @Test(retryAnalyzer = Retry.class, groups = {Groups.ACCEPTANCE_TEST})
    public void testBasic() {

        String username = "";
        LOG(getCredentials().getUsername());

        FEATURE("Jira Test - Logout");
        SCENARIO("User Logs out of user account");

        GIVEN("I am logged in as a valid user");
        webElementVisible(Constants.NAVBAR_PROFILE_BUTTON);
        webAction(Constants.NAVBAR_PROFILE_BUTTON);
        webElementVisible(Constants.PROFILE_JIRA_USER);
        username = getWebElementText(Constants.PROFILE_JIRA_USER);
        LOG(String.format("I am user %s",username));

        WHEN("I click on the logout cta option on the profile drop down menu");
        webElementVisible(Constants.PROFILE_LOGOUT_USER_CTA);
        webAction(Constants.PROFILE_LOGOUT_USER_CTA);

        THEN("I am navigated to the log out of your atlassian account page.");
        webElementVisible(Constants.LOG_OUT_OF_YOUR_ATLASSIAN_ACCT_HEADING);
        AND("My username is displayed as " + firstLetterCapitalized(username));
        webElementVisible(combine(Constants.LOG_OUT_OF_YOUR_ATLASSIAN_ACCT_HEADING_USERNAME,firstLetterCapitalized(username)));
        AND("My email address is displayed as " + getCredentials().getUsername());
        webElementTextEquals(combine(Constants.LOG_OUT_OF_YOUR_ATLASSIAN_ACCT_HEADING_USERNAME,firstLetterCapitalized(username))
                +Constants.LOG_OUT_OF_YOUR_ATLASSIAN_ACCT_HEADING_USERNAME_EMAIL,getCredentials().getUsername());

        THEN("I click on the log out cta");
        webElementVisible(Constants.LOGOUT_PAGE_CTA);
        webAction(Constants.LOGOUT_PAGE_CTA);

        THEN("I am navigated to the log in your account page account page.");
        webElementVisible(Constants.LOG_IN_TO_YOUR_ACCOUNT_HEADING);

    }

    private String firstLetterCapitalized(String username){
        return username.substring(0,1) + username.substring(1).toLowerCase();
    }
}