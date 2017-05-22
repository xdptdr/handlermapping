package com.github.xdptdr.ejb;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;

@MessageDriven
public class MyMessageDriven {
	@Resource
	MessageDrivenContext messageDrivenContext;
	
}
