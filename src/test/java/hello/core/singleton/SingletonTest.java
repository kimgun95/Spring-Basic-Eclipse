package hello.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class SingletonTest {
	@Test
	void singletonServiceTest() {
		SingletonService singletonService1 = SingletonService.getInstance();
		SingletonService singletonService2 = SingletonService.getInstance();

		System.out.println("singletonService1 = " + singletonService1);
		System.out.println("singletonService2 = " + singletonService2);
		// 호출할 때 마다 같은 객체 인스턴스를 반환함
		assertThat(singletonService1).isSameAs(singletonService2);
	}
	
}
