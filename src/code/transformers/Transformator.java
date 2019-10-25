package code.transformers;

import code.annotations.ConvertableTo;
import code.class_jerarchi.Shape;
import code.class_jerarchi.TwoDimensionalShape;

import java.util.function.Function;
import java.util.function.Supplier;

public class Transformator {
    public <T extends TwoDimensionalShape, U extends Shape> U convert(T t,
                                                                      Function<T, U> transformer,
                                                                      Supplier<U> instansiator) {
        Class<?> clazz = t.getClass();
        ConvertableTo convertableTo = clazz.getAnnotation(ConvertableTo.class);
        if (convertableTo != null) {
            U targetType = instansiator.get();
            for (Class<?> convertableClass : convertableTo.value()) {
                if (targetType.getClass().getCanonicalName().equals(convertableClass.getCanonicalName())) {
                    return transformer.apply(t);
                }
            }
        }

        return null;
    }
}
