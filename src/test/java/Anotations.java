import org.testng.annotations.*;

public class Anotations {

    @BeforeClass //Pokreće se jednom pre SVIH testova
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod //Pokreće jednom pre SVAKOG testa
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterClass //Pokreće se jednom posle SVIH testova
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterMethod //Pokreće se jednom posle SVAKOG testa
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test //Ovo predstavlja jedan test kejs
    public void test1(){
        System.out.println("Test1");
    }

    @Test
    public void test2(){
        System.out.println("Test2");
    }

    @Test
    public void test3(){
        System.out.println("Test3");
    }
}
