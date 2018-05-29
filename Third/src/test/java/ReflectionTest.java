import BadAgeException.BadAgeException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReflectionTest {

@Test
    public static void testArmElement() throws BadAgeException {
    List<Object> Generic = new ArrayList<Object>();
    Generic.add(2);
    Generic.add(null);
    Generic.add(true);
    Generic.add(new Human("A", "B", "C", 19));
    Generic.add(5);
    Generic.add(new Human("A", "B", "C", 19));
    Generic.add(new Human("A", "B", "C", 19));
    Generic.add(false);
    Generic.add("Asds");
    Generic.add('a');
    Generic.add(new Human("A", "B", "C", 19));
    assertEquals(ReflectionDemo.armElement(Generic), 4);
}
@Test
    public static void testGetName() throws BadAgeException {
    List<String> names = new ArrayList<String>();
    names.add("getSurname");
    names.add("getName");
    names.add("getPatronymic");
    names.add("getAge");
    names.add("setSurname");
    names.add("setName");
    names.add("setPatronymic");
    names.add("setAge");
    names.add("equals");
    names.add("hashCode");
    names.add("toString");
    names.add("getClass");
    names.add("notify");
    names.add("notifyAll");
    names.add("wait");
    names.add("wait");
    names.add("wait");
    //new Human("A", "N", "A", 198).
    assertTrue(names.containsAll(ReflectionDemo.getName(new Human("A", "N", "A", 198))));
    assertTrue(ReflectionDemo.getName(new Human("A", "N", "A", 198)).containsAll(names));
}

@Test
    public static void testSuperName() throws BadAgeException {
    List<String> superNames = new ArrayList<String>();
    superNames.add("java.lang.Object");
    assertEquals(superNames, ReflectionDemo.getSuperName(new Human("A", "N", "A", 198)));
}
}
