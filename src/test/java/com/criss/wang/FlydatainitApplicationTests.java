package com.criss.wang;

import java.math.RoundingMode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.cc.commons.MathUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlydatainitApplicationTests {

	@Test
	public void contextLoads() {
	}


	public static void main(String[] args) throws IllegalAccessException {
		int a = 12;
		int b = 200;
		System.out.println(MathUtils.div(Double.valueOf(a),  Double.valueOf(b), 2, RoundingMode.HALF_UP));
	}
}
