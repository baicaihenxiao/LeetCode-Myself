package club.cser.hello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 为了能在这里写@Test，pom里junit包的scope不能限定为test，否则编译报错
 */
//@RunWith(Suite.class)
public class TestInSrc {

	@Before
	public void init() {
		System.out.println("before");
	}

	@Test
	public void test() {
		System.out.println( "Hello World1111!" );

		fail("Not yet implemented");
	}

	@Test
	public void test1() {
		System.out.println( "Hello World2222!" );

	}

}
