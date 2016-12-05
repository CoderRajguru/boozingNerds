
package com.edu.helpers;

import java.util.UUID;

/**
 * @author bikash.rajguru
 *Mar 27, 2016 4:42:25 PM
 */
public class RandomString {
	
	public String RandomStringValue()
	{
		String uuid = UUID.randomUUID().toString();
		System.out.println("Inside Random");
		System.out.println("Random value is " + uuid);
		return uuid;
	}
}



