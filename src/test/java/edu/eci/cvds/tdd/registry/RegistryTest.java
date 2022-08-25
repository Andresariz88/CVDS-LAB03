package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

	private Registry registry = new Registry();

	@Test
	public void validateRegistryResult() {
		Person person = new Person("juan", 123, 20, Gender.MALE, true);
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.VALID, result);
	}
	// TODO Complete with more test cases
	@Test
	public void validateRegistryDead() {
		Person person = new Person("juan", 123, 20, Gender.MALE, false);
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.DEAD, result);
	}
	@Test
	public void validateRegistryUnderage() {
		Person person = new Person("juan", 123, 15, Gender.MALE, true);
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.UNDERAGE, result);
	}
	@Test
	public void validateRegistryInvalidage() {
		Person person = new Person("juan", 123, -15, Gender.MALE, true);
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.INVALID_AGE, result);
		
		Person person1 = new Person("juan", 123, 200, Gender.MALE, true);
		RegisterResult result1 = registry.registerVoter(person1);
		Assert.assertEquals(RegisterResult.INVALID_AGE, result1);
	}
	@Test
	public void validateRegistryDuplicated() {
		Person person = new Person("juan", 123, 21, Gender.MALE, true);
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.VALID, result);
		Person person1 = new Person("juan", 123, 21, Gender.MALE, true);
		RegisterResult result1 = registry.registerVoter(person1);
		Assert.assertEquals(RegisterResult.DUPLICATED, result1);
		
	}

}
