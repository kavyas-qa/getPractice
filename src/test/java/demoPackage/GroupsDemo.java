package demoPackage;

import org.testng.annotations.Test;

public class GroupsDemo 
{
	@Test(groups= {"Smoke"})
	public void test1()
	{
		System.out.println("Test 1: Smoke");
	}
	@Test(groups= {"Sanity"})
	public void test2()
	{
		System.out.println("Test 2: Sanity");
	}
	@Test(groups= {"Smoke", "Sanity"})
	public void test3()
	{
		System.out.println("Test 3: Smoke, Sanity");
	}
	@Test(groups= {"Regression"})
	public void test4()
	{
		System.out.println("Test 4: Regression");
	}
	@Test(groups= {"Smoke", "Regression"})
	public void test5()
	{
		System.out.println("Test 5: Smoke, Regression");
	}
	@Test(groups= {"Sanity", "Regression"})
	public void test6()
	{
		System.out.println("Test 6: Sanity, Regression");
	}
	@Test(groups= {"Smoke", "Sanity", "Regression"})
	public void test7()
	{
		System.out.println("Test 7: Smoke, Sanity, Regression");
	}
	@Test(groups= {"Integration"})
	public void test8()
	{
		System.out.println("Test 8: Integration");
	}
	@Test(groups= {"mac.Retest"})
	public void test9()
	{
		System.out.println("Test 9: Retest");
	}
	@Test(groups= {"mac.Smoke"})
	public void test10()
	{
		System.out.println("Test 10: Smoke");
	}
}
