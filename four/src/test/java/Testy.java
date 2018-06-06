
import Lambda.LambdaDemo;
import Lambda.LambdaRunner;
import org.junit.Assert;
import org.junit.Test;

public class Testy {

    @Test
    public void getStringLengtg(){
        Assert.assertEquals(
                new Integer(3),
                LambdaRunner.run(LambdaDemo.getStringLength,"abc")
        );
}
    @Test
    public void getFirstCharacterInString(){
        Assert.assertEquals(
                new Character('a'),
                LambdaRunner.run(LambdaDemo.getFirstCharacterInString, "abc")
        );
    }

    @Test
    public void checkSpaceInString(){
        Assert.assertTrue(
                LambdaRunner.check(LambdaDemo.checkSpaceInString, "abc")
                );
    }
}
