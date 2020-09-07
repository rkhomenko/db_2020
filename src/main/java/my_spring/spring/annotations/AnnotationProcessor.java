package my_spring.spring.annotations;

public interface AnnotationProcessor<A> {
    Object applyAnnotation(A annotation, Class<?> clazz);
}
