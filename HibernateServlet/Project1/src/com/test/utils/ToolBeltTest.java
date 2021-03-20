/**
 * 
 */
package com.test.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ers.utils.ToolBelt;

/**
 * @author Phil
 *
 */
public class ToolBeltTest {
	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println(utilDate.toString());
		sqlDate = new java.sql.Date(utilDate.getTime());
	}

	/**
	 * Test method for {@link com.ers.utils.ToolBelt#convertDate(java.sql.Date)}.
	 */
	@Test
	public void testConvertDate() {
		assertEquals(utilDate,ToolBelt.convertDate(sqlDate));
		assertEquals(sqlDate,ToolBelt.convertDate(utilDate));
	}
}
