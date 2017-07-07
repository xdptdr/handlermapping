package com.github.xdptdr.jaxws.amenhotep;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.BARE)
public interface AmenhotepBareSEI extends AmenhotepSEI {
	@Override
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	String hello();
}
