package com.github.xdptdr.script;

import javax.script.ScriptException;

public class DummyScriptEngine extends AbstractDummyScriptEngine {

	@Override
	public Object invokeFunction(String name, Object... args) throws ScriptException, NoSuchMethodException {
		return "Render function : " + name + " ; viewName : " + args[2] + " ; script template : " + args[0];
	}
}
