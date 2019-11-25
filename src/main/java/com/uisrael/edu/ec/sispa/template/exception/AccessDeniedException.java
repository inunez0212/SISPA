package com.uisrael.edu.ec.sispa.template.exception;

import java.io.Serializable;

/**
 * Created by rmpestano on 18/02/17. A marker exception to redirect user to
 * 403.xhtml. See web-fragment.xml
 */
public class AccessDeniedException extends RuntimeException implements Serializable {

	public AccessDeniedException() {
	}

	public AccessDeniedException(Throwable cause) {
		super(cause);
	}

	/**
	 *
	 * @param msg exception message
	 */
	public AccessDeniedException(String msg) {
		super(msg);
	}

}
