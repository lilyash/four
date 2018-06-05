package Lambda;

import Humans.Human;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaRunner {

    public static Object checkStringLambda(Function<String, ?> lambda, String string){
        return lambda.apply(string);
    }

    public static boolean check(Predicate<String> lambda, String string){
        return lambda.test(string);
    }

    public static <T extends Human> Object checkHumanLambda(Function<T, ?> lambda, T human){
        return lambda.apply(human);
    }

    public static boolean biPredicateHuman(BiPredicate<Human, Human> lambda, Human human1, Human human2){
        return lambda.test(human1, human2);
    }

    public static boolean checkAgeChecker(AgeChecker lambda, Human human1, Human human2, Human human3, Integer maxAge){
        return lambda.checkAge(human1, human2, human3, maxAge);
    }
}
