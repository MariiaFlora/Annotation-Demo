import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MethodInfo {
    String name();

    String returnType();

    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author {
    String firstName();

    String lastName();
}

class ArrayUtils {

    @MethodInfo(name = "findMax", returnType = "int", description = "Finds the maximum value in an array")
    @Author(firstName = "Mariia", lastName = "Flora")
    public int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    @MethodInfo(name = "findMin", returnType = "int", description = "Finds the minimum value in an array")
    @Author(firstName = "Mariia", lastName = "Flora")
    public int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}

public class AnnotationDemo {
    public static void main(String[] args) {
        Class<ArrayUtils> clazz = ArrayUtils.class;

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                System.out.println("Method Name: " + methodInfo.name());
                System.out.println("Return Type: " + methodInfo.returnType());
                System.out.println("Description: " + methodInfo.description());
            }

            if (method.isAnnotationPresent(Author.class)) {
                Author author = method.getAnnotation(Author.class);
                System.out.println("Author: " + author.firstName() + " " + author.lastName());
            }

            System.out.println("----------------------------");
        }
    }
}
