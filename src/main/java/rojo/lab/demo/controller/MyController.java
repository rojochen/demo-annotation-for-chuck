package rojo.lab.demo.controller;

import java.lang.annotation.Annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rojo.lab.demo.annotation.ClassTag;
import rojo.lab.demo.annotation.CodeInfo;
import rojo.lab.demo.annotation.RuntimeTag;
import rojo.lab.demo.annotation.SourceTag;
import rojo.lab.demo.bo.MyCodeInfo;
import rojo.lab.demo.bo.MyTag;

@RestController
public class MyController {
	@RequestMapping(value = "/codeinfo", method = RequestMethod.GET)
	public @ResponseBody String getCodeInfoAuthor() {
		Class<MyCodeInfo> obj = MyCodeInfo.class;
		Annotation annotation = obj.getAnnotation(CodeInfo.class);
		CodeInfo info = (CodeInfo) annotation;
		System.out.println(info.revision());
		System.out.println(info.date());
		return info.author();
	}
	
	@RequestMapping(value = "/retention-test", method = RequestMethod.GET)
	public @ResponseBody String getAnnotationRetentionPolicy() {
		StringBuilder sb = new StringBuilder(128);
		Class<MyTag> obj = MyTag.class;
		for (Annotation anno : obj.getAnnotations()) {
			System.out.println("Annotation in Class  : " + anno);
			 if(anno instanceof RuntimeTag){
				 sb.append( ((RuntimeTag) anno).value());
				 sb.append("|");
			 }
			 if(anno instanceof SourceTag){
				 sb.append( ((SourceTag) anno).value());
				 sb.append("|");
			 }
			 if(anno instanceof RuntimeTag){
				 sb.append( ((ClassTag) anno).value());
				 sb.append("|");
			 }
		}
		return sb.toString();
	}
}
