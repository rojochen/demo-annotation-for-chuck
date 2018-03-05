package rojo.lab.demo.processor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import javax.lang.model.SourceVersion;
import com.google.auto.service.AutoService;

@SupportedAnnotationTypes("rojo.lab.demo.annotation.ApiGenTag")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class ServiceProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("Processing " + annotations + roundEnv);
        for (TypeElement annotation : annotations) {
        		  System.out.println(annotation);
//            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
//
//            Map<Boolean, List<Element>> annotatedMethods = annotatedElements.stream().collect(Collectors.partitioningBy(element -> ((ExecutableType) element.asType()).getParameterTypes().size() == 1 && element.getSimpleName().toString().startsWith("set")));
        }
        try {
        		Map<String, String> map = new HashMap<>();
        		map.put("handle", "handle");
        		this.writeBuilderFile("rojo.lab.gencode.Hello", map);
        }catch(Exception e) {
            e.printStackTrace();

        }
		return Boolean.TRUE;
	}
	  private void writeBuilderFile(String className, Map<String, String> setterMap) throws IOException {

	        String packageName = null;
	        int lastDot = className.lastIndexOf('.');
	        if (lastDot > 0) {
	            packageName = className.substring(0, lastDot);
	        }

	        String simpleClassName = className.substring(lastDot + 1);
	        String builderClassName = className + "Builder";
	        String builderSimpleClassName = builderClassName.substring(lastDot + 1);

	        JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(builderSimpleClassName);
	        try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {

	            if (packageName != null) {
	                out.print("package ");
	                out.print(packageName);
	                out.println(";");
	                out.println();
	            }
	            out.println("import org.springframework.stereotype.Controller;");
	            out.println("@Controller");
	            out.print("public class ");
	            out.print(builderSimpleClassName);
	            out.println(" {");
	            out.println();
	       
	            out.println();

//	            setterMap.entrySet().forEach(setter -> {
//	                String methodName = setter.getKey();
//	                String argumentType = setter.getValue();
//
//	                out.print("    public ");
//	                out.print(" void ");
//	                out.print(" ");
//	                out.print(methodName);
//
//	                out.print("(");
//
//	                out.print(argumentType);
//	                out.println(" value) {");
//	    
//	                out.println("    }");
//	                out.println();
//	            });
	            out.println("}");

	        }
	  }
}
