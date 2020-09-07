package my_spring.spring.annotations;

public class RepeatAnnotationProcessor implements AnnotationProcessor<Repeat> {
    @Override
    public Object applyAnnotation(Repeat annotation, Class<?> clazz) {
        return null;
    }
}
