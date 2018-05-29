import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {
// Дан список объектов произвольных типов. Найдите количество элементов списка,
// которые являются объектами типа Human или его подтипами

    public static int armElement(List<Object> Generic){
        int arm =0;
        if(Generic.isEmpty()) return 0;
        for (Object obj:Generic) {
            if(obj instanceof Human){
                arm++;
            }
        }
        return arm;
    }

// Для объекта получить список имен его открытых методов.
    public static List<String> getName(Object obj){
        Class cl = obj.getClass();
        List<String> names = new ArrayList<String>();
        for(Method m : cl.getMethods()){
            names.add(m.getName());
        }
        return names;
    }

//Для объекта получить список (в виде списка строк) имен всех его суперклассов
// до класса Object включительно
    public static List<String> getSuperName(Object obj){
        Class cls = obj.getClass().getSuperclass();
        List<String> superNames = new ArrayList<String>();
        while(cls!=null){
            superNames.add(cls.getName());
            cls=cls.getSuperclass();
        }
        return superNames;
    }
}
