package rojo.lab.demo.annotation;

import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMethod;

@Retention(SOURCE)
@Target(ElementType.METHOD) //can use in method only.
public @interface ApiGenTag {
	public String path();
	public RequestMethod[] method() default {};
}
