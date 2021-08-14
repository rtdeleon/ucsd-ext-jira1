package com.ucsd.jira.automation.data;

public final class Constants {

    // Application Defaults
    //SECURITY_KEY is use for ENCRYPTION/DECRYPTION
    public static final byte[] SECURITY_KEY = {0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79};
    public static final String ENCRYPTED_USER1 = "6uLvR5GI4PfzLb1PyunAchNyTEorGiiwbuhQns5jMAg="; //ucsd.ext1@gmail.com
    public static final String ENCRYPTED_PASS1 = "QMjxVo4OiaZQw7F/JC5PQg==";
//    public static final String ENCRYPTED_USER1 = "Nkhg90CUGGdHPHUz7yNX08WuMg5bg6dgulYBh8pqOk4="; //ucsd.ext10@gmail.com
//    public static final String ENCRYPTED_PASS1 = "Ht87Gt5Oad3BdV1FoxhogQ==";
    public static final String AARDVARK = "AARDVARK";

    public static final int MAX_WEB_SERVICE_RESPONSE_TIME = 3000;

    // COMMON URLs
    public static final String HOME_URL = "/MyJiraHome.jspa";

    // HEADING Elements
    public static final String LOGO_HEADING = "//h1[@id='logo']";
    public static final String TEST_HEADING = "//h1[contains(text(),'test')]";  //*[@id="dashboard"]/header/div/div[1]/div/div/div/div/h1
    public static final String NEW_TEST_HEADING = "//*[@id=\"dashboard-content\"]/div[1]/div/div[1]/h1";
    public static final String LOG_OUT_OF_YOUR_ATLASSIAN_ACCT_HEADING = "//h5[text()='Log out of your Atlassian account']";
    public static final String LOG_OUT_OF_YOUR_ATLASSIAN_ACCT_HEADING_USERNAME = "//h2[text()='%s']";
    public static final String LOG_OUT_OF_YOUR_ATLASSIAN_ACCT_HEADING_USERNAME_EMAIL = "/following-sibling::p";
    public static final String LOG_IN_TO_YOUR_ACCOUNT_HEADING = "//h5[text()='Log in to your account']";
    public static final String DASHBOARD_NAME_HEADER = "//header[@data-test-id='spa-apps-dashboard-dashboard.ui.dashboard-content.header.dashboard-header']//h1";
    public static final String DASHBOARDS_PAGE_HEADER = "//h1[text()='Dashboards']";

    // ANCHOR Elements
    public static final String FIRST_PROJECTS_ANCHOR = "//img[contains(@src, 'projectavatar')]/following-sibling::a";
    public static final String CREATE_ISSUE_MODAL_CANCEL = "//form[@name='jiraform']//a[contains(text(),'Cancel')]"; //Cancel cta

//    public static final String CREATE_ISSUE_MODAL_PROJECT_TTR = "Test Team R (TTR)";//"//li[@class='aui-list-item aui-list-item-li-test-team-r-(ttr) active']/a";
    public static final String CREATE_ISSUE_MODAL_PROJECT_TTR = "//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[starts-with(@id,'test-team-rr')]";
//    public static final String CREATE_ISSUE_MODAL_PROJECT_TT2R = "Test Team 2 R (TT2R)";//"//li[@class='aui-list-item aui-list-item-li-test-team-2-r-(tt2r) active']/a";
    public static final String CREATE_ISSUE_MODAL_PROJECT_TT2R = "//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[starts-with(@id,'test-team-2-rr')]";

//    public static final String CREATE_ISSUE_MODAL_ISSUE_TYPE_BUG = "//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[contains(@id,'bug')]";
//    public static final String CREATE_ISSUE_MODAL_ISSUE_TYPE_TASK = "//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[contains(@id,'task')]";
//    public static final String CREATE_ISSUE_MODAL_ISSUE_TYPE_EPIC = "//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[contains(@id,'epic')]";
//    public static final String CREATE_ISSUE_MODAL_ISSUE_TYPE_STORY = "//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[contains(@id,'story')]";
    public static final String CREATE_ISSUE_MODAL_ISSUE_TYPE_TASK = "//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[contains(@id,'task')]/a[text()='Task']";
    public static final String CREATE_ISSUE_MODAL_ISSUE_TYPE_BUG = "//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[contains(@id,'bug')]/a[text()='Bug']";
    public static final String CREATE_ISSUE_MODAL_ISSUE_TYPE_EPIC = "//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[contains(@id,'epic')]/a[text()='Epic']";
    public static final String CREATE_ISSUE_MODAL_ISSUE_TYPE_STORY = "//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[contains(@id,'story')]";
    public static final String PROFILE_LOGOUT_USER_CTA = "//a[@href='/logout']";

    // INPUT Elements
    public static final String USERNAME_INPUT = "//input[@id='username']";
    public static final String PASSWORD_INPUT = "//input[@id='password']";
    public static final String BASIC_SEARCH_INPUT = "//input[@type='text' and @placeholder='Search']";
    public static final String CREATE_ISSUE_MODAL_PROJECT_INPUT = "//input[@id='project-field']";
    public static final String CREATE_ISSUE_MODAL_ISSUE_TYPE_INPUT = "//input[@id='issuetype-field']";
    public static final String CREATE_ISSUE_MODAL_SUMMARY_INPUT = "//input[@id='summary']";
    public static final String CREATE_ISSUE_MODAL_PRIORITY_INPUT = "//input[@id='priority-field']";
    public static final String CREATE_ISSUE_MODAL_CREATE_INPUT = "//input[@id='create-issue-submit']";  //CREATE cta
    public static final String CREATE_DASHBOARD_MODAL_NAME = "//input[@id='shareable-entity-dialog.input-name']";
    public static final String DASHBOARDS_PAGE_SEARCH_FIELD = "//input[@name='search']";

    //TEXTAREA Elements
    public static final String CREATE_ISSUE_MODAL_DESCRIPTION_TEXTAREA = "//textarea[@id='description']";

    // BUTTON Elements
    public static final String ADVANCED_SEARCH_TEXTAREA = "advanced-search";
    public static final String NAVBAR_PROFILE_BUTTON = "//div[@id='ak-jira-navigation']//span[4]//button";
    public static final String PROFILE_JIRA_USER = "//div[starts-with(@data-ds--menu--heading-item,'t') and starts-with(text(),'U')]";
    public static final String LOGOUT_PAGE_CTA = "//button[@id='logout-submit']";

    // HEADING Elements
    public static final String VARIABLE_BY_TEXT_HEADING = "//h1[text()='%s']";
    public static final String CREATE_ISSUE_MODAL_H2 = "//h2[contains(text(),'Create issue')]";
    public static final String DASHBOARDS_PAGE_DASHBOARD_NOT_FOUND_HEADING = "//h4[text()='No dashboards were found that match your search']";

    // SPAN Elements
    public static final String VARIABLE_BY_LABEL_SPAN = "//span[contains(@aria-label, '%s')]";
    public static final String VARIABLE_BY_TEXT_SPAN = "//span[text()='%s']";
    public static final String CONTINUE_SPAN = "Continue";
    public static final String LOGIN_SPAN = "Log in";
    public static final String CREATE_SPAN = "Create";
    public static final String CLOSE_MENU_EXPAND_SPAN = "//span[@aria-label='Close']";
    public static final String VIEW_ALL_MATCHING_ISSUES_SPAN = "//span[text()='View all matching issues']";
    public static final String CREATE_DASHBOARD_MODAL_SAVE = "//span[text()='Save']";
    public static final String CREATE_DASHBOARD_MODAL = "//h4/span[text()='Create dashboard']";
    public static final String NAVIGATION_DASHBOARDS = "//span[text()='Dashboards']";
    public static final String NAVIGATION_DASHBOARDS_CREATE_DASHBOARD = "//span[text()='Create dashboard']";
    public static final String NAVIGATION_DASHBOARDS_VIEW_ALL_DASHBOARDS = "//span[text()='View all dashboards']";
    public static final String DASHBOARDS_PAGE_FIRST_ROW_MORE_CTA = "//span[@aria-label='More']";
    public static final String DASHBOARDS_PAGE_FIRST_ROW_MORE_CTA_DELETE_DASHBOARD_OPTION = "//span[text()='Delete dashboard']";
    public static final String DELETE_DASHBOARD_CONFIRMATION_MODAL_DELETE_CTA = "//span[text()='Delete']";

    // STATIC Text
    public static final String NO_RECORDS_FOUND_TEXT = "No records found, try new search criteria.";

    //DIV Elements
    public static final String VARIABLE_BY_TEXT_DIV = "//input[@placeholder='%s']";
    public static final String ISSUES_SEARCH_PREVIEW_DIV = "//div[@aria-label='Issues']";
    public static final String BOARDS_SEARCH_PREVIEW_DIV = "//div[@aria-label='Boards']";
    public static final String PROJECTS_SEARCH_PREVIEW_DIV = "//div[@aria-label='Projects']";
    public static final String ISSUES_AND_FILTERS_DIV = "//*[@id='navigation-app']/div[1]/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div/div[3]/a/div[2]/div";
    public static final String DASHBOARD_DIV = "//*[@id=\"navigation-app\"]/div[1]/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div/div[1]/a/div[2]/div";
    public static final String PROJECTS_DIV = "//*[@id=\"jira-frontend\"]/div[1]/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/a/div[2]/div";




    private Constants() {
    }

}
