package PracticeProduct;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.genericbaseutility.BaseClass;

import junit.framework.Assert;
@Listeners(com.comcast.cm.Listenerutility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass {
	@Test
	public void createInvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		String title=driver.getTitle();
		Assert.assertEquals(title, "title");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
			}
	@Test
	public void createInvoicewithcontactTest()
	{
		System.out.println("execute createInvoicewithcontactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}

}
