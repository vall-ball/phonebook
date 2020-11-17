// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {

    public static <T> String info(T[] array) {
        if (array.length == 0 || array == null) {
            return "[]";
        }
        if (array.length == 1) {
            return "[" + array[0] + "]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i <= array.length - 2; i++) {
            builder.append(array[i] + ", ");
        }
        builder.append(array[array.length - 1]);
        builder.append("]");
        return builder.toString();
    }
}