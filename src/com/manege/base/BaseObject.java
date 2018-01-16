package com.manege.base;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseObject implements Serializable {
	private static final long serialVersionUID = 1L;
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	

}
