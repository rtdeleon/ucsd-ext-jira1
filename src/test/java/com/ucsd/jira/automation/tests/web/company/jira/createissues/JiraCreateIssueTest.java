package com.ucsd.jira.automation.tests.web.company.jira.createissues;

import com.pwc.core.framework.JavascriptConstants;
import com.pwc.core.framework.annotations.Issue;
import com.pwc.core.framework.listeners.Retry;
import com.ucsd.jira.automation.data.Constants;
import com.ucsd.jira.automation.frameworksupport.Groups;
import com.ucsd.jira.automation.frameworksupport.JiraTestCase;
import org.testng.annotations.Test;

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
    @Test(retryAnalyzer = Retry.class, groups = {Groups.ACCEPTANCE_TEST})
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

//        THEN("I select project name");
//        webElementVisible(Constants.CREATE_ISSUE_MODAL_PROJECT_INPUT);
//        project = getWebElementText(Constants.CREATE_ISSUE_MODAL_PROJECT_INPUT);
//        LOG(String.format("Project is: [%s]", project));
//        if(!project.equalsIgnoreCase("Test Team R (TTR)")) {
//            executeJavascript(combine(JavascriptConstants.CLICK_BY_XPATH,Constants.CREATE_ISSUE_MODAL_PROJECT_INPUT));
////            webElementVisible(Constants.CREATE_ISSUE_MODAL_PROJECT_TTR);
//            wait(2);
//            waitForTextToDisplay(project);
//            webAction(Constants.CREATE_ISSUE_MODAL_PROJECT_INPUT,"Test Team R (TTR)");
////            webAction(Constants.CREATE_ISSUE_MODAL_PROJECT_TTR);
//        } else {
//            executeJavascript(combine(JavascriptConstants.CLICK_BY_XPATH,Constants.CREATE_ISSUE_MODAL_PROJECT_INPUT));
//            //           webElementVisible(Constants.CREATE_ISSUE_MODAL_PROJECT_TT2R);
//            wait(2);
//            waitForTextToDisplay(project);
//            webAction(Constants.CREATE_ISSUE_MODAL_PROJECT_INPUT,"Test Team 2 R (TT2R)");
////            webAction(Constants.CREATE_ISSUE_MODAL_PROJECT_TT2R);
//        }

//        THEN("I select issue type");
//        webElementVisible(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT);
//        issueType = getWebElementText(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT);
//        LOG(String.format("Issue Type is: [%s]", issueType));
//        executeJavascript(combine(JavascriptConstants.CLICK_BY_XPATH,Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT));
//        if(!issueType.equalsIgnoreCase("Task")) {
//            it="TASK";
//            LOG("Changing Issue Type to: [Task]");
////            executeJavascript(combine(JavascriptConstants.CLICK_BY_XPATH,Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT));
////            webElementVisible(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_TASK);
//            webAction(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT,"Task");
////            webAction(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_TASK);
//        } else /*if(!issueType.equalsIgnoreCase("Bug"))*/{
//            it="BUG";
//            LOG("Changing Issue Type to: [Bug]");
////            executeJavascript(combine(JavascriptConstants.CLICK_BY_XPATH,Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT));
////            webElementVisible(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_BUG);
//            webAction(Constants.CREATE_ISSUE_MODAL_PROJECT_INPUT,"Bug");
////            webAction(Constants.CREATE_ISSUE_MODAL_ISSUE_TYPE_BUG);
//        }

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


}
