package com.e2e.flows;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.e2e.base.Log4JFactory;

/**
 * 
 * @author rahulsahu
 *
 */
@Component
public class LoginFlow extends BaseFlow {
	public Logger logger = Log4JFactory.getLogger(this.getClass().getName());

}
