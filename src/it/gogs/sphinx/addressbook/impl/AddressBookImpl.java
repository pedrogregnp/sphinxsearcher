package it.gogs.sphinx.addressbook.impl;

import it.gogs.sphinx.SearchCriteria;
import it.gogs.sphinx.addressbook.AddressBook;
import it.gogs.sphinx.api.SphinxException;
import it.gogs.sphinx.exception.AddressBookBizException;
import it.gogs.sphinx.exception.AddressBookTechnicalException;
import it.gogs.sphinx.util.AddressBookAdapter;
import it.gogs.sphinx.util.SphinxInstance;

import java.util.List;

/**
 * Implementation for our Address Book example
 * 
 * @author Munish Gogna
 * 
 */
public class AddressBookImpl implements AddressBook {

	@Override
	public List getAddressBookList(SearchCriteria criteria)
			throws AddressBookTechnicalException, AddressBookBizException,
			SphinxException {

		List addressIds = SphinxInstance.getAddressBookIds(criteria);
		return AddressBookAdapter.getAddressBookList(addressIds);

	}
}
