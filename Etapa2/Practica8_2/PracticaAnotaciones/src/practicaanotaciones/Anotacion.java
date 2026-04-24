
package practicaanotaciones;
import java.lang.annotation.*;

public class Anotacion {
    
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface MiAnotacion {
        String valor() default "Mi anaotacion prueba";
    }
}
