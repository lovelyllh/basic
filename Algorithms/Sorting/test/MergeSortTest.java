import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Linghan on 4/16/2016.
 */
public class MergeSortTest {
    //step1: only declare: an instance of the class which needs to be tested,
    // or declare the variable without initialization
    MergeSort mtest;

    @BeforeClass
    //@BeforeClass is only for expensive setup,
    //such as when you need to connect to a database to do your testing
    public static void setUpBeforeClass() throws Exception {
        System.out.println("before class");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("before");
        //step2: for initialization the variables in the class methods
        //or initialization of the class instance
        mtest = new MergeSort();
    }

    @Test
    public void mergeSort() throws Exception {
        //step3: test the methods in the class, or test the logic
        System.out.println("test case for mergeSort function");
        int[] expected = {1,3,5,7};
        int[] unsortedArray = {5,3,7,1};
        assertArrayEquals(expected, mtest.mergeSort(unsortedArray));
    }

    @Test
    public void merge() throws Exception {
        System.out.println("test case for merge function");
        int[] expected = {1,3,5,7};
        int[] left = {1,3};
        int[] right = {5,7};
       /*
       assertArrayEquals(expected, mtest.merge(left, right));
       */
        assertArrayEquals("failure: Array should be equal", expected, mtest.merge(left, right));
    }

    //case1: unsorted array has only one element
    @Test
    public void should_return_1_for_mergeSort(){
        int[] unsortedArray = {1};
        int[] expected = {1};
        assertArrayEquals(expected, mtest.mergeSort(unsortedArray));
    }

    //case2:
    @Test
    public void should_return_12345_for_mergeSort(){
        int[] unsortedArray = {5,4,3,2,1};
        int[] expected = {1,2,3,4,5};
        assertArrayEquals(expected, mtest.mergeSort(unsortedArray));
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    //not nescessary
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("after class");
    }

}