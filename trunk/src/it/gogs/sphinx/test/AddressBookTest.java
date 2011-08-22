package it.gogs.sphinx.test;

import it.gogs.sphinx.AddressBoook;
import it.gogs.sphinx.DateRange;
import it.gogs.sphinx.SearchCriteria;
import it.gogs.sphinx.addressbook.AddressBook;
import it.gogs.sphinx.addressbook.impl.AddressBookImpl;
import it.gogs.sphinx.exception.AddressBookBizException;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

/**
 * 
 * @author Munish Gogna
 * 
 */
public class AddressBookTest extends TestCase {

	private AddressBook addressBook;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		addressBook = new AddressBookImpl();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/** this should be a unique record for Himanshu */
	public void test_search_for_himanshu() throws Exception {
		SearchCriteria criteria = new SearchCriteria();
		// remember the first 'search' example??
		criteria.setKeywords("u4732");
		List<AddressBoook> addressList = addressBook
				.getAddressBookList(criteria);
		assertTrue(addressList.size() == 1);
		assertTrue("expecting himanshu here",
				"himanshu".equals(addressList.get(0).getFName()));
		for (AddressBoook addressBoook : addressList) {
			System.out.println(addressBoook);
		}
	}

	/** only two employees have name gurleen or toshi */
	public void test_search_for_gurleen_or_toshi() throws Exception {
		SearchCriteria criteria = new SearchCriteria();
		// remember the second 'search' example??
		criteria.setKeywords("gurleen toshi");
		List<AddressBoook> addressList = addressBook
				.getAddressBookList(criteria);
		assertTrue(addressList.size() == 2);
		assertTrue("expecting toshi here",
				"toshi".equals(addressList.get(0).getFName()));
		assertTrue("expecting gurleen here",
				"gurleen".equals(addressList.get(1).getFName()));
	}

	/** there are 16 people from jammu location */
	public void test_search_for_people_from_jammu_location() throws Exception {
		SearchCriteria criteria = new SearchCriteria();
		criteria.setKeywords("jammu");
		List addressList = addressBook.getAddressBookList(criteria);
		assertTrue(addressList.size() == 16);
	}

	/** only Aalap, Manda and nitika are having title as Mrs and joined in 2010 */
	public void test_joined_in_2010_with_title_Mrs() throws Exception {

		DateRange dateRange = new DateRange();

		GregorianCalendar calendar1 = new GregorianCalendar();
		calendar1.set(Calendar.YEAR, 2010);
		calendar1.set(Calendar.MONTH, Calendar.JANUARY);
		calendar1.set(Calendar.DAY_OF_MONTH, 1);

		dateRange.setFromDate(calendar1.getTime());

		GregorianCalendar calendar2 = new GregorianCalendar();
		calendar2.set(Calendar.YEAR, 2010);
		calendar2.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar2.set(Calendar.DAY_OF_MONTH, 31);
		dateRange.setToDate(calendar2.getTime());

		SearchCriteria criteria = new SearchCriteria();
		criteria.setKeywords("Mrs");
		criteria.setDateRange(dateRange);

		List addressList = addressBook.getAddressBookList(criteria);
		assertTrue("expecting 3 records here", addressList.size() == 3);

	}

	/** should get a business exception here */
	public void test_without_specifying_keywords() {
		SearchCriteria criteria = new SearchCriteria();
		// criteria.setKeywords("Mrs");
		try {
			addressBook.getAddressBookList(criteria);
		} catch (Exception e) {
			assertTrue(e instanceof AddressBookBizException);
			assertTrue(e.getMessage().indexOf("keyword is a required field") > -1);
		}
	}
}
