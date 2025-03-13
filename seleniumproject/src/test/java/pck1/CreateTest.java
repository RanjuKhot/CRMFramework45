package pck1;

import org.testng.annotations.Test;

public class CreateTest {
@Test
	public void createcontactTest()
	{
     String URL=System.getProperty("url");
     String BROWSER=System.getProperty("browser","firefox");
     String USERNAME=System.getProperty("username");
     String PASSWORD=System.getProperty("password");
     System.out.println(URL);
     System.out.println(BROWSER);
     System.out.println(USERNAME);
     System.out.println(PASSWORD);
     
		System.out.println("execute createcontact");
	}
		@Test
		public void modifycontactTest()
		{
			System.out.println("execute modifycontact");
		}

}
