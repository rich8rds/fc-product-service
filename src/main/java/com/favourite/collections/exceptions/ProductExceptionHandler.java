/* Collections #2024 */
package com.favourite.collections.exceptions;

import com.favourite.collections.commons.core.exceptions.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ProductExceptionHandler extends GlobalExceptionHandler {
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex) {
//		log.error("Found Some Errors in MethodArgumentNotValidException", ex);
//		List<ApiSubError> errors = new ArrayList<>();
//		ex.getBindingResult().getAllErrors().forEach(error -> {
//			String fieldName = ((FieldError) error).getField();
//			String errorMessage = error.getDefaultMessage();
//			errors.add(new ApiValidationError(fieldName, errorMessage));
//		});
//
//		ApiError errorResponse = ApiError.builder().message("Error found!").debugMessage("error.validation.on.field")
//				.subErrors(errors).build();
//		return ResponseEntity.status(400).body(errorResponse);
//	}
//
//	@ExceptionHandler(WebExchangeBindException.class)
//	public ResponseEntity<ApiError> webExchangeBindException(WebExchangeBindException ex) {
//		log.error("Found Some Errors in MethodArgumentNotValidException", ex);
//		List<ApiSubError> errors = new ArrayList<>();
//		ex.getBindingResult().getAllErrors().forEach(error -> {
//			String fieldName = ((FieldError) error).getField();
//			String errorMessage = error.getDefaultMessage();
//			errors.add(new ApiValidationError(fieldName, errorMessage));
//		});
//
//		ApiError errorResponse = ApiError.builder().message("Error found!").debugMessage("error.validation.on.field")
//				.subErrors(errors).build();
//		return ResponseEntity.status(400).body(errorResponse);
//	}
//
//	@ExceptionHandler(com.favourite.collections.commons.core.exceptions.AbstractPlatformException.class)
//	public ResponseEntity<ApiError> abstractPlatformException(AbstractPlatformException ex) {
//
//		ApiError errorResponse = ApiError.builder().message(ex.getDefaultUserMessage())
//				.globalMessageCode(ex.getGlobalisationMessageCode()).debugMessage(ex.getLocalizedMessage())
//				.subErrors(ex.getApiErrors()).build();
//
//		return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
//	}
//
//	@ExceptionHandler(ConstraintValidationException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ResponseEntity<ApiError> constraintValidationException(ConstraintValidationException ex) {
//
//		ApiError errorResponse = ApiError.builder().message(ex.getDefaultUserMessage())
//				.globalMessageCode(ex.getGlobalisationMessageCode()).debugMessage(ex.getLocalizedMessage())
//				.subErrors(ex.getApiErrors()).build();
//
//		return ResponseEntity.badRequest().body(errorResponse);
//	}
//
//	@ExceptionHandler(BeanInstantiationException.class)
//	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//	public ResponseEntity<ApiError> beanInstantiationException(BeanInstantiationException ex) {
//
//		ApiError errorResponse = ApiError.builder().message(ex.getMessage())
//				.globalMessageCode("Error instantiating bean").debugMessage(ex.getLocalizedMessage())
//				.build();
//
//		return ResponseEntity.badRequest().body(errorResponse);
//	}
//
//	@ExceptionHandler(UsernameNotFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//	public ResponseEntity<ApiError> usernameNotFoundException(UsernameNotFoundException ex) {
//
//		ApiError errorResponse = ApiError.builder().message(ex.getMessage())
//				.globalMessageCode("Error instantiating bean").debugMessage(ex.getLocalizedMessage())
//				.build();
//
//		return ResponseEntity.badRequest().body(errorResponse);
//	}
//
//	@ExceptionHandler(ExpiredJwtException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ResponseEntity<ApiError> usernameNotFoundException(ExpiredJwtException ex) {
//
//		ApiError errorResponse = ApiError.builder().message(ex.getMessage())
//				.globalMessageCode("JWT has expired").debugMessage(ex.getLocalizedMessage())
//				.build();
//
//		return ResponseEntity.badRequest().body(errorResponse);
//	}
}
