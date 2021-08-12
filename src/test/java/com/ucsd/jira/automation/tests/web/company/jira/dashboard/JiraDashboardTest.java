package com.ucsd.jira.automation.tests.web.company.jira.dashboard;

import com.pwc.core.framework.JavascriptConstants;
import com.pwc.core.framework.annotations.Issue;
import com.pwc.core.framework.listeners.Retry;
import com.ucsd.jira.automation.data.Constants;
import com.ucsd.jira.automation.frameworksupport.Groups;
import com.ucsd.jira.automation.frameworksupport.JiraTestCase;
import org.testng.annotations.Test;

import java.awt.*;

import static com.pwc.logging.service.LoggerService.*;
import static com.pwc.logging.service.LoggerService.THEN;

public class JiraDashboardTest extends JiraTestCase {

    @Issue("STORY-3")
    @Test(retryAnalyzer = Retry.class, groups = {Groups.ACCEPTANCE_TEST})
    public void testCreateDashboard() {

        FEATURE("Jira Test - Create a new dashboard ");
        SCENARIO("User logs in and creates a new dashboard");

        GIVEN("I am logged in as a valid user");
        webElementVisible(Constants.NAVBAR_PROFILE_BUTTON);
        webAction(Constants.NAVBAR_PROFILE_BUTTON);
        webElementVisible(Constants.PROFILE_JIRA_USER);

        WHEN("I create a new dashboard by clicking Dashboard dropdown menu from the main header");
        webElementVisible(Constants.NAVIGATION_DASHBOARDS);
        webAction(Constants.NAVIGATION_DASHBOARDS);

        AND("I click on the Create dashboard option");
        webElementVisible(Constants.NAVIGATION_DASHBOARDS_CREATE_DASHBOARD);
        webAction(Constants.NAVIGATION_DASHBOARDS_CREATE_DASHBOARD);

        THEN("The expected Create dashboard modal is displayed");
        webElementVisible(Constants.CREATE_DASHBOARD_MODAL);

        THEN(String.format("I enter %s in the Name textbox field",Constants.AARDVARK));
        webElementVisible(Constants.CREATE_DASHBOARD_MODAL_NAME);
        webAction(Constants.CREATE_DASHBOARD_MODAL_NAME, Constants.AARDVARK);

        AND("I click the Save cta");
        webElementVisible(Constants.CREATE_DASHBOARD_MODAL_SAVE);
        webAction(Constants.CREATE_DASHBOARD_MODAL_SAVE);

        THEN(String.format("I expect the %s dashboard is displayed",Constants.AARDVARK));
        waitForBrowserToLoad();
        webElementVisible(Constants.DASHBOARD_NAME_HEADER);
        webElementTextEquals(Constants.DASHBOARD_NAME_HEADER, Constants.AARDVARK);
    }

    @Issue("STORY-4")
    @Test(retryAnalyzer = Retry.class, groups = {Groups.ACCEPTANCE_TEST})
    public void testDeleteDashboard() {

        FEATURE("Jira Test - delete dashboard");
        SCENARIO(String.format("User logs in and deletes dashboard %s", Constants.AARDVARK));

        GIVEN("I am logged in as a valid user");
        webElementVisible(Constants.NAVBAR_PROFILE_BUTTON);
        webAction(Constants.NAVBAR_PROFILE_BUTTON);
        webElementVisible(Constants.PROFILE_JIRA_USER);

        WHEN(String.format("I delete dashboard %s by clicking Dashboard dropdown menu from the main header", Constants.AARDVARK));
        webElementVisible(Constants.NAVIGATION_DASHBOARDS);
        webAction(Constants.NAVIGATION_DASHBOARDS);

        AND("I click on View all dashboards option");
        webElementVisible(Constants.NAVIGATION_DASHBOARDS_VIEW_ALL_DASHBOARDS);
        webAction(Constants.NAVIGATION_DASHBOARDS_VIEW_ALL_DASHBOARDS);

        THEN("The expected Create dashboard modal is displayed");
        webElementVisible(Constants.DASHBOARDS_PAGE_HEADER);

        THEN(String.format("I enter %s in the search field textbox",Constants.AARDVARK));
        webElementVisible(Constants.DASHBOARDS_PAGE_SEARCH_FIELD);
        webAction(Constants.DASHBOARDS_PAGE_SEARCH_FIELD, Constants.AARDVARK);

        THEN("I delete dashboard %s by clicking on the More icon cta");
        webElementVisible(Constants.DASHBOARDS_PAGE_FIRST_ROW_MORE_CTA);
        webAction(Constants.DASHBOARDS_PAGE_FIRST_ROW_MORE_CTA);

        AND("I click on Delete dashboard");
        webElementVisible(Constants.DASHBOARDS_PAGE_FIRST_ROW_MORE_CTA_DELETE_DASHBOARD_OPTION);
        webAction(Constants.DASHBOARDS_PAGE_FIRST_ROW_MORE_CTA_DELETE_DASHBOARD_OPTION);

        AND("I click on Delete cta");
        webElementVisible(Constants.DELETE_DASHBOARD_CONFIRMATION_MODAL_DELETE_CTA);
        webAction(Constants.DELETE_DASHBOARD_CONFIRMATION_MODAL_DELETE_CTA);

        THEN(String.format("I expect No dashboards were found that match your search is displayed",Constants.AARDVARK));
        webElementVisible(Constants.DASHBOARDS_PAGE_DASHBOARD_NOT_FOUND_HEADING);

    }

    @Override
    public void beforeMethod() {

    }

    @Override
    public void afterMethod() {

    }
}
