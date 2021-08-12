package com.ucsd.jira.automation.frameworksupport;

import com.ucsd.jira.automation.data.Constants;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static com.pwc.assertion.AssertService.assertFail;
import static com.pwc.logging.service.LoggerService.LOG;

public abstract class AIUserTestCase extends JiraTestCase {

    private static final long MAXIMUM_USER_EXPERIENCE = 120000;
    private static final String HIGH_LEVEL = "HIGH";
    private static final String MEDIUM_LEVEL = "MEDIUM";
    private static final String LOW_LEVEL = "LOW";
    private static final String COMMON_SEARCH_TERM = "apache";

    public void genericSearch() {
        LOG(true, "---------- Generic Search. Likelihood=%s ----------", HIGH_LEVEL);
        webElementVisible(Constants.LOGO_HEADING);
        //Add here
    }

    public void advancedSearch() {
        LOG(true, "---------- Advanced Search. Likelihood=%s ----------", HIGH_LEVEL);
        //Add here
    }

    public void quickStats() {
        LOG(true, "---------- View Quick Stats. Likelihood=%s ----------", LOW_LEVEL);
        //Add here
    }

    public void securityIntrusion() {
        LOG(true, "---------- SQL Injection from Hacker. Likelihood=%s ----------", MEDIUM_LEVEL);
        //Add here
        webElementVisible(Constants.NO_RECORDS_FOUND_TEXT);
    }

    /**
     * Perform a User's activity based on decision
     *
     * @param decision decision percentage
     * @return pass or fail of activity
     */
    protected void performUserActivityBasedOnADecision(final Map<Integer, String> probabilities, final StopWatch visit, float decision) {
        if (visit.getTotalTimeMillis() < MAXIMUM_USER_EXPERIENCE) {
            int myDecision = calculateTheMostLikelyDecision(probabilities, decision);
            runMethodDefinedInMap(probabilities.get(myDecision));
        } else {
            assertFail("", "");
        }
    }

    /**
     * Find the most likely / closest decision to what you will make
     *
     * @param decision decision percentage
     * @return most likely <code>Integer</code> decision index
     */
    private int calculateTheMostLikelyDecision(final Map<Integer, String> probabilities, final float decision) {

        List<Integer> probabilitiesAsList = probabilities.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());

        float distance = Math.abs(probabilitiesAsList.get(0) - decision);
        int idx = 0;
        for (int c = 1; c < probabilitiesAsList.size(); c++) {
            float fDistance = Math.abs(probabilitiesAsList.get(c) - decision);
            if (fDistance < distance) {
                idx = c;
                distance = fDistance;
            }
        }
        return probabilitiesAsList.get(idx);
    }

    /**
     * Random percentage within a range of integer values
     *
     * @param lower lower bound number
     * @param upper upper bound number
     * @return percentage within range
     */
    protected static float randomPercentageInRange(final int lower, final int upper) {
        Random r = new Random();
        return lower + r.nextFloat() * (upper - lower);
    }

    /**
     * Random number within a range of integer values
     *
     * @param lower lower bound number
     * @param upper upper bound number
     * @return number within range (including either lower or upper bound)
     */
    private static int randomNumericInRange(final int lower, final int upper) {
        Random random = new Random();
        return (int) (random.nextDouble() * ((upper + 1) - lower)) + lower;
    }

    /**
     * Use recursion to call a method
     *
     * @param methodToCall method to call based on probablity
     */
    private void runMethodDefinedInMap(final String methodToCall) {
        try {
            Method x = this.getClass().getMethod(methodToCall);
            x.invoke(this);
        } catch (Exception e) {
            assertFail("Failed to perform method=%s", methodToCall, e);
        }
    }

}
