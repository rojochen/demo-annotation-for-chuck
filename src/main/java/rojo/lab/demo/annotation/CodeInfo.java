package rojo.lab.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import rojo.lab.demo.type.Priority;
 

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)  
public @interface CodeInfo {
    public Priority priority() default Priority.MEDIUM;
	public boolean enabled() default true;
	public String author();
	public String date();
	public int revision() default 1;
	public String lastModified() default "N/A";
	public String lastModifiedBy() default "N/A";
	public String[] reviewers();
}
