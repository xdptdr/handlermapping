package com.github.xdptdr.cxf.abaddon;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.message.Attachment;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.Destination;

public class AbaddonMessage implements Message {

	private Map<String, Object> props = new HashMap<>();

	public AbaddonMessage() {
	}

	public AbaddonMessage(boolean mtomEnabled) {
		props.put(Message.MTOM_ENABLED, mtomEnabled);
	}

	@Override
	public <T> T get(Class<T> key) {
		return null;
	}

	@Override
	public <T> void put(Class<T> key, T value) {

	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public Object get(Object key) {
		return null;
	}

	@Override
	public Object put(String key, Object value) {
		return null;
	}

	@Override
	public Object remove(Object key) {
		return null;
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {

	}

	@Override
	public void clear() {

	}

	@Override
	public Set<String> keySet() {
		return null;
	}

	@Override
	public Collection<Object> values() {
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return null;
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public void setId(String id) {

	}

	@Override
	public InterceptorChain getInterceptorChain() {
		return null;
	}

	@Override
	public void setInterceptorChain(InterceptorChain chain) {

	}

	@Override
	public Destination getDestination() {
		return null;
	}

	@Override
	public Exchange getExchange() {
		return null;
	}

	@Override
	public void setExchange(Exchange exchange) {

	}

	@Override
	public Collection<Attachment> getAttachments() {
		return null;
	}

	@Override
	public void setAttachments(Collection<Attachment> attachments) {

	}

	@Override
	public <T> T getContent(Class<T> format) {
		return null;
	}

	@Override
	public <T> void setContent(Class<T> format, Object content) {

	}

	@Override
	public Set<Class<?>> getContentFormats() {
		return null;
	}

	@Override
	public <T> void removeContent(Class<T> format) {

	}

	@Override
	public Object getContextualProperty(String key) {
		return props.get(key);
	}

	@Override
	public void resetContextCache() {

	}

	@Override
	public Set<String> getContextualPropertyKeys() {
		return null;
	}

}
