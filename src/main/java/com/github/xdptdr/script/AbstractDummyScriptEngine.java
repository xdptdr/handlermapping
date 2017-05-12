package com.github.xdptdr.script;

import java.io.Reader;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;

public class AbstractDummyScriptEngine implements ScriptEngine, Invocable {
	@Override
	public Bindings createBindings() {
		return null;
	}

	@Override
	public Object eval(String script) throws ScriptException {
		return null;
	}

	@Override
	public Object eval(Reader reader) throws ScriptException {
		return null;
	}

	@Override
	public Object eval(String script, ScriptContext context) throws ScriptException {
		return null;
	}

	@Override
	public Object eval(Reader reader, ScriptContext context) throws ScriptException {
		return null;
	}

	@Override
	public Object eval(String script, Bindings n) throws ScriptException {
		return null;
	}

	@Override
	public Object eval(Reader reader, Bindings n) throws ScriptException {
		return null;
	}

	@Override
	public Object get(String key) {
		return null;
	}

	@Override
	public Bindings getBindings(int scope) {
		return null;
	}

	@Override
	public ScriptContext getContext() {
		return null;
	}

	@Override
	public ScriptEngineFactory getFactory() {
		return null;
	}

	@Override
	public void put(String key, Object value) {

	}

	@Override
	public void setBindings(Bindings bindings, int scope) {
	}

	@Override
	public void setContext(ScriptContext context) {

	}

	@Override
	public <T> T getInterface(Class<T> clasz) {
		return null;
	}

	@Override
	public <T> T getInterface(Object thiz, Class<T> clasz) {
		return null;
	}

	@Override
	public Object invokeFunction(String name, Object... args) throws ScriptException, NoSuchMethodException {
		return null;
	}

	@Override
	public Object invokeMethod(Object thiz, String name, Object... args) throws ScriptException, NoSuchMethodException {
		return null;
	}
}
