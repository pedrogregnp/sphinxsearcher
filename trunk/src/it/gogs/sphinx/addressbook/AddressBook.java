package it.gogs.sphinx.addressbook;

import it.gogs.sphinx.SearchCriteria;
import it.gogs.sphinx.api.SphinxException;
import it.gogs.sphinx.exception.AddressBookBizException;
import it.gogs.sphinx.exception.AddressBookTechnicalException;

import java.util.List;

/**
 * 
 * @author Munish Gogna
 * 
 */
public interface AddressBook {

	/**
	 * Returns the list of AddressBook objects based on search criteria.
	 * 
	 * @param criteria
	 * @throws AddressBookTechnicalException
	 * @throws AddressBookBizException
	 * @throws SphinxException
	 */
	public List getAddressBookList(SearchCriteria criteria)
			throws AddressBookTechnicalException, AddressBookBizException,
			SphinxException;

}
