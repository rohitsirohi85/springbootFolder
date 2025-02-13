package com.codingshuttle.TestingApp;



import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest  // this is also running our application as well we don't need to run our spring framework now while working on testing
@Slf4j
class TestingApplicationTests {

//	@BeforeEach // run method before each test case
	@BeforeAll // run method before all test case
	static void setUp(){
		log.info("setting up the test cases: ");
	}

//	@AfterEach  // run method before each test case
	@AfterAll  // run method before each test case
	static void ending(){
		log.info(" ending this test cases: ");
	}

	@Test
	//@Disabled // disable this test
	void testDivideTwoNumbers_WhenDenominatorIsZero_ThenArithmeticException() {  // test case must be void
		log.info("test one is running");

		int a = 3;
		int b=0;

		//divideTwoNumbers(a,b); // it will normal throw the exception
		// but if we want that our test case check that this is a arithmetic exception not any other so u cna check that as well

		Assertions.assertThatThrownBy(()-> divideTwoNumbers(a,b)).isInstanceOf(ArithmeticException.class);  // so it will run this test case if it throw a arithmetic exception , else will throw error if it is actually any other 

	}


	double divideTwoNumbers(int a , int b){
		try{
		return a/b;

		}catch (ArithmeticException e){
           log.error("Arithementic exception occurred"+e.getLocalizedMessage());
		   throw new ArithmeticException(e.getLocalizedMessage());
		}
	}

	 int addTwoNum(int a , int b){
		return  a+b;
	 }


	@Test
//	@DisplayName("NewTest")  // display the enter test name while running
	void TestTwo(){
      int a=3;
	  int b=4;

	 // int result = addTwoNum(a,b);
		//System.out.println(result);

        // this assertion is from - junit.jupiter.api  // and this is not recommended bcz it can only used one method at a line

	 // Assertions.assertEquals(7,result);  // check if the test case is passed or not means the actual value is equal to expected value

		// this assertion is coming from - assertj.core.api // this is better than that

//		Assertions.assertThat(result).isEqualTo(7)
//				 .isCloseTo(8, Offset.offset(1));

		// also we can use assertion for string as well
//		Assertions.assertThat("Appl").isEqualTo("Apple")
//				.startsWith("App").endsWith("le")
//				.hasSize(5);  // if any method failed this test case will be failed


	}

}
