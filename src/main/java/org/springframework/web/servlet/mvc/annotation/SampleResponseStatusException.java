package org.springframework.web.servlet.mvc.annotation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT, reason="I'm a teapot")
public class SampleResponseStatusException extends Exception {

	private static final long serialVersionUID = 1L;

}
