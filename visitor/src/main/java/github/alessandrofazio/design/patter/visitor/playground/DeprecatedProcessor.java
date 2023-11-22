package github.alessandrofazio.design.patter.visitor.playground;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.SimpleElementVisitor14;
import javax.lang.model.util.SimpleElementVisitor6;
import javax.lang.model.util.SimpleElementVisitor9;
import javax.tools.Diagnostic;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.stream.Collectors;

public class DeprecatedProcessor {
}

/*
@SupportedAnnotationTypes("java.lang.Deprecated")
@SupportedSourceVersion(SourceVersion.RELEASE_9)
public class DeprecatedProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }

    private final ElementVisitor<TypeElement, RoundEnvironment> DEPRECATED_VISITOR =
            new SimpleElementVisitor9<>();
    public TypeElement visitType(TypeElement type, RoundEnvironment env) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,
            env.getElementsAnnotatedWith(type).stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", type + " (", ")")));
        return super.visitType(type, env);
    }
}
 */
