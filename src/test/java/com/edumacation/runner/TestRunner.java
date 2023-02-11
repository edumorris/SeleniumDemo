package com.edumacation.runner;


import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.edumacation.steps")
//@ConfigurationParameter(key = "cucumber.glue", value = "com.edumacation.steps")
@ConfigurationParameter(key= PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME  ,
        value = "pretty, json:target/cucumber.json, html:target/cucumber.html" )
//@ConfigurationParameter(key= EXECUTION_DRY_RUN_PROPERTY_NAME , value = "false")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME , value = "@wip" )
public class TestRunner {

}
