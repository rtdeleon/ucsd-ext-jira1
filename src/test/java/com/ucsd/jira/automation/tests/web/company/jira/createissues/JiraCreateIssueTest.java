package com.ucsd.jira.automation.tests.web.company.jira.createissues;

import com.pwc.core.framework.JavascriptConstants;
import com.pwc.core.framework.annotations.Issue;
import com.pwc.core.framework.listeners.Retry;
import com.ucsd.jira.automation.data.Constants;
import com.ucsd.jira.automation.frameworksupport.Groups;
import com.ucsd.jira.automation.frameworksupport.JiraTestCase;
import org.testng.annotations.Test;

import java.util.Random;

import static com.pwc.logging.service.LoggerService.*;
import static com.pwc.logging.service.LoggerService.THEN;

public class JiraCreateIssueTest extends JiraTestCase {

    @Override
    public void beforeMethod() {

    }

    @Override
    public void afterMethod() {

    }

    @Issue("STORY-2")
    @Test(/*retryAnalyzer = Retry.class,*/ groups = {Groups.ACCEPTANCE_TEST})
    public void testCreateAnIssue() throws InterruptedException {

        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        String project = "";
        String issueType = "";
        String it = "Issue";

        FEATURE("Jira Test - Create a new issue ");
        SCENARIO("User logs in and creates a new bug ticket");

        GIVEN("I am a valid user");
        webElementVisible(Constants.NAVBAR_PROFILE_BUTTON);
        webAction(Constants.NAVBAR_PROFILE_BUTTON);
        webElementVisible(Constants.PROFILE_JIRA_USER);

        WHEN("I create a new issue by clicking CREATE cta");
        webElementVisible(Constants.CREATE_SPAN);
        webAction(Constants.CREATE_SPAN);

        THEN("The expected Create issue modal is displayed");
        webElementVisible(Constants.CREATE_ISSUE_MODAL_H2);

        THEN("I select project name");
        webElementVisible(Constants.CREATE_ISSUE_MODAL_PROJECT_INPUT);
        project = getWebElementText(Constants.CREATE_ISSUE_MODAL_PROJECT_INPUT);
        LOG(String.format("Project is: [%s]", project));
        executeJavascript(combine(JavascriptConstants.CLICK_BY_XPATH,Constants.CREATE_ISSUE_MODAL_PROJECT_INPUT));
        if(!project.equalsIgnoreCase("Test Team RR (TST)" )) {
            webElementVisible(Constants.CREATE_ISSUE_MODAL_PROJECT_TTR);
            webAction(Constants.CREATE_ISSUE_MODAL_PROJECT_TTR);
        } else {  //"Test Team 2 R (TEAM)"
            webElementVisible(Constants.CREATE_ISSUE_MODAL_PROJECT_TT2R);
            webAction(Constants.CREATE_ISSUE_MODAL_PROJECT_TT2R);
        }
        Thread.sleep(1000);

        THEN("I select issue type");
        webElementVisible(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT);
        issueType = getWebElementText(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT);
        LOG(String.format("Issue Type is: [%s]", issueType));
        switch(new Random().nextInt(4) + 1) {
            case 1:
                LOG(String.format("case 1: Issue Type is the default [%s]", issueType));
                break;
            case 2:
                executeJavascript(combine(JavascriptConstants.CLICK_BY_XPATH,Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT));
                Thread.sleep(5000);
                it = "TASK";
                LOG(String.format("case 2: Changing Issue Type to: [%s]", it));
                webElementVisible(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_TASK);
                webAction(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_TASK);
                break;
            case 3:
                executeJavascript(combine(JavascriptConstants.CLICK_BY_XPATH,Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT));
                Thread.sleep(5000);
                it = "BUG";
                LOG(String.format("case 3: Changing Issue Type to: [%s]", it));
                webElementVisible(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_BUG);
                webAction(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_BUG);
                break;
            case 4:
                executeJavascript(combine(JavascriptConstants.CLICK_BY_XPATH,Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT));
                Thread.sleep(5000);
                it = "EPIC";
                LOG(String.format("case 4: Changing Issue Type to: [%s]", it));
                webElementVisible(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_EPIC);
                webAction(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_EPIC);
                break;
            default:
        }

        Thread.sleep(1000);

        THEN("I enter text in the summary field");
        webElementVisible(Constants.CREATE_ISSUE_MODAL_SUMMARY_INPUT);
        webAction(Constants.CREATE_ISSUE_MODAL_SUMMARY_INPUT, String.format("%s | Lorem ipsum dolor sit amet",it));

        THEN("I enter text in the description textarea");
        webElementVisible(Constants.CREATE_ISSUE_MODAL_DESCRIPTION_TEXTAREA);
        webAction(Constants.CREATE_ISSUE_MODAL_DESCRIPTION_TEXTAREA, description);


        THEN("I click on create cta");
        webElementVisible(Constants.CREATE_ISSUE_MODAL_CREATE_INPUT);
        webAction(Constants.CREATE_ISSUE_MODAL_CREATE_INPUT);

    }

    private static int randomNum() {
        return new Random().nextInt(4) + 1;

    }


}
