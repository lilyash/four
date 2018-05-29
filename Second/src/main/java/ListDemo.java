import java.util.*;

public class ListDemo {
    // Вход: список строк и символ. Выход: количество строк входного списка, у которых первый символ совпадает с заданным.
        public static int getNumberOfCharInString(List<String> listOfString, char first) {
            int res = 0;
            for (int i = 0; i < listOfString.size(); i++) {
                if (!listOfString.get(i).isEmpty()) {
                    if (first == listOfString.get(i).charAt(0)) {
                        res++;
                    }
                }
            }
            return res;
        }
        // список однофамильцев
        public static List<Human> getListSameSurnameWithHenry(List<Human> listOfHumans, Human goodHenry) {
            List<Human> result = new ArrayList<>();
            int pos = 0;
            for (int i = 0; i < listOfHumans.size(); i++) {
                if (listOfHumans.get(i).getSurname().equals(goodHenry.getSurname())) {
                    result.add(pos, new Human(listOfHumans.get(i)));
                    pos++;
                }
            }
            return result;
        }
            // список без Генри
        public static List<Human> deleteHenryFromList(List<Human> listOfHumans, Human poorHenry) {
            List<Human> result = new ArrayList<>();
            int pos = 0;
            for (int i = 0; i < listOfHumans.size(); i++) {
                if (!poorHenry.equals(listOfHumans.get(i))) {
                    result.add(pos, new Human(listOfHumans.get(i)));
                    pos++;
                }
            }
            return result;
        }
        //Вход: список множеств целых чисел и еще одно множество. Выход: список всех множеств
       // входного списка, которые не пересекаются с заданным множеством.
        public static List<Set<Integer>> removeIntersectSets(List<Set<Integer>> listOfSets, Set<Integer> set) {
            List<Set<Integer>> result = new ArrayList<>();
//            int pos = 0, size;
            boolean flag = true;
            //Iterator<Integer> iter;
           // Set<Integer> copy = new HashSet<>();
            for (Set<Integer> iter : listOfSets) {
                if (Collections.disjoint(iter, set)) {
                    result.add(iter);
                }

//                while (iter.hasNext() && flag) {
//                    if (set.contains(iter.next())) {
//                        flag = false;
//                    }
//                }
//                if (flag) {
//                   result.add(pos, listOfSets.get(i));
//                    pos++;
//                }
//                flag = true;
            }
            return result;
        }

        // идентификатор
        public static Set<Human> identifeHumans(Map<Integer, Human> mapId, Set<Integer> setOfId) {
            Set<Human> result = new HashSet<>();
            Iterator<Integer> itr = setOfId.iterator();
            int id;
            while (itr.hasNext()) {
                id = itr.next();
                if (mapId.get(id) != null) {
                    result.add(mapId.get(id));
                }
            }
            return result;
        }
        // 18 мне уже
        public static Set<Integer> getIdAge(Map<Integer, Human> mapId) {
            Set<Integer> result = new HashSet<>();
            //Iterator<Human> iterValues = mapId.values().iterator();
            Iterator<Integer> iterKeys = mapId.keySet().iterator();
            Integer bigJhonnyKey;
            int id;
            while (iterKeys.hasNext()) {   // keys
                bigJhonnyKey = iterKeys.next();  // mapId.get(id)
                if (mapId.get(bigJhonnyKey).getAge() >= 18) {
                    result.add(bigJhonnyKey);
                }
            }
            return result;
        }
    }

