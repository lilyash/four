package Lambda;

import Humans.Human;

@FunctionalInterface
public interface AgeChecker {
    boolean checkAge(Human human1, Human human2, Human human3, Integer maxAge);
}