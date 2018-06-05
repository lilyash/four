package Lambda;

import Humans.BadYearException;
import Humans.Human;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {
    public static final Function<String, Integer> getStringLength = string -> {
        if (string == null) {
            return null;
        }
        return string.length();
    };

    public static final Function<String, Character> getFirstCharacterInString = string -> {
        if (string == null || "".equals(string)) {
            return null;
        }
        return string.charAt(0);
    };

    public static final Predicate<String> checkSpaceInString = string -> {
        if (string == null) {
            return true;
        }
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                return false;
            }
        }
        return true;
    };

    public static final Function<String, Integer> getAmountsOfWordsInString = string -> {
        if (string == null || "".equals(string)) {
            return 0;
        }
        String[] buf = string.split(",");
        int res = 0;
        for (int i = 0; i < buf.length; i++) {
            if (!"".equals(buf[i])) {
                res++;
            }
        }
        return res;
    };

    public static final Function<? extends Human, Integer> getAgeOfHuman = human -> {
        if (human == null) {
            return null;
        }
        return Human.CURRENT_YEAR - human.getYear();
    };

    public static final BiPredicate<? extends Human, ? extends Human> compareSurname = (human1, human2) -> {
        if (human1 == null || human2 == null) {
            return false;
        }
        return human1.getSurname().equals(human2.getSurname());
    };

    public static final Function<? extends Human, String> getSurnameNamePatronymic = human -> {
        if (human == null) {
            return null;
        }
        return human.getSurname() + " " + human.getName() + " " + human.getPatronymic();
    };

    public static final Function<Human, Human> makeOlder = human -> {
        if (human == null) {
            return null;
        }
        Human older = new Human(human);
        try {
            older.setYear(human.getYear() - 1);
        } catch (BadYearException e) {
            e.printStackTrace();
        }
        return older;
    };

    public static final AgeChecker checkMaxAge = (human1, human2, human3, maxAge) -> {
        if (human1 == null || human2 == null || human3 == null || maxAge == null) {
            return false;
        }
        return (maxAge > (Human.CURRENT_YEAR - human1.getYear())
                && maxAge > (Human.CURRENT_YEAR - human2.getYear())
                && maxAge > (Human.CURRENT_YEAR - human3.getYear()));
    };

}
