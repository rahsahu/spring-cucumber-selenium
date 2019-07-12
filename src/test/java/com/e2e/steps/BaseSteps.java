package com.e2e.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.e2e.flows.LoginFlow;

/**
 * 
 * @author rahulsahu
 *
 */
@Scope("cucumber-glue")
public class BaseSteps {

	@Autowired
	Environment env;

	@Autowired
	LoginFlow loginFlow;

}