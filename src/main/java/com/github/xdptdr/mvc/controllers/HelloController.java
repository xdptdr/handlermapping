package com.github.xdptdr.mvc.controllers;

import java.util.HashMap;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("hello");
		return mav;
	}

	@RequestMapping(value = "/helloHttpRequestMethodNotSupportedException", method = RequestMethod.GET)
	public ModelAndView helloHttpRequestMethodNotSupportedException() throws HttpRequestMethodNotSupportedException {
		throw new HttpRequestMethodNotSupportedException("method");
	}

	@RequestMapping(value = "/helloHttpMediaTypeNotSupportedException", method = RequestMethod.GET)
	public ModelAndView helloHttpMediaTypeNotSupportedException() throws HttpMediaTypeNotSupportedException {
		throw new HttpMediaTypeNotSupportedException("msg");
	}

	@RequestMapping(value = "/helloHttpMediaTypeNotAcceptableException", method = RequestMethod.GET)
	public ModelAndView helloHttpMediaTypeNotAcceptableException() throws HttpMediaTypeNotAcceptableException {
		throw new HttpMediaTypeNotAcceptableException("msg");
	}

	@RequestMapping(value = "/helloMissingPathVariableException", method = RequestMethod.GET)
	public ModelAndView helloMissingPathVariableException()
			throws MissingPathVariableException, NoSuchMethodException, SecurityException {
		throw new MissingPathVariableException("varialbEName",
				new MethodParameter(this.getClass().getMethod("foo", String.class), 0));
	}

	@RequestMapping(value = "/helloMissingServletRequestParameterException", method = RequestMethod.GET)
	public ModelAndView helloMissingServletRequestParameterException() throws MissingServletRequestParameterException {
		throw new MissingServletRequestParameterException("parameterName", "parameterType");
	}

	@RequestMapping(value = "/helloServletRequestBindingException", method = RequestMethod.GET)
	public ModelAndView helloServletRequestBindingException() throws ServletRequestBindingException {
		throw new ServletRequestBindingException("msg");
	}

	@RequestMapping(value = "/helloConversionNotSupportedException", method = RequestMethod.GET)
	public ModelAndView helloConversionNotSupportedException() {
		throw new ConversionNotSupportedException(new Object(), Object.class, null);
	}

	@RequestMapping(value = "/helloTypeMismatchException", method = RequestMethod.GET)
	public ModelAndView helloTypeMismatchException() {
		throw new TypeMismatchException(new Object(), Object.class);
	}

	@RequestMapping(value = "/helloHttpMessageNotReadableException", method = RequestMethod.GET)
	public ModelAndView helloHttpMessageNotReadableException() {
		throw new HttpMessageNotReadableException("msg");
	}

	@RequestMapping(value = "/helloHttpMessageNotWritableException", method = RequestMethod.GET)
	public ModelAndView helloHttpMessageNotWritableException() {
		throw new HttpMessageNotWritableException("msg");
	}

	@RequestMapping(value = "/helloMethodArgumentNotValidException", method = RequestMethod.GET)
	public ModelAndView helloMethodArgumentNotValidException()
			throws NoSuchMethodException, SecurityException, MethodArgumentNotValidException {
		throw new MethodArgumentNotValidException(
				new MethodParameter(this.getClass().getMethod("foo", String.class), 0),
				new MapBindingResult(new HashMap<>(), "objectName"));
	}

	@RequestMapping(value = "/helloMissingServletRequestPartException", method = RequestMethod.GET)
	public ModelAndView helloMissingServletRequestPartException() throws MissingServletRequestPartException {
		throw new MissingServletRequestPartException("partName");
	}

	@RequestMapping(value = "/helloBindException", method = RequestMethod.GET)
	public ModelAndView helloBindException() throws BindException {
		throw new BindException(new MapBindingResult(new HashMap<>(), "objectName"));
	}

	@RequestMapping(value = "/helloNoHandlerFoundException", method = RequestMethod.GET)
	public ModelAndView helloNoHandlerFoundException() throws NoHandlerFoundException {
		throw new NoHandlerFoundException("httpMethod", "requestUrl", new HttpHeaders());
	}

	@RequestMapping(value = "/helloAsyncRequestTimeoutException", method = RequestMethod.GET)
	public ModelAndView helloAsyncRequestTimeoutException() {
		throw new AsyncRequestTimeoutException();
	}

	public void foo(String foo) {
	}

}


