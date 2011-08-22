package it.gogs.sphinx.util;

import it.gogs.sphinx.DateRange;
import it.gogs.sphinx.SearchCriteria;
import it.gogs.sphinx.api.SphinxClient;
import it.gogs.sphinx.api.SphinxException;
import it.gogs.sphinx.api.SphinxMatch;
import it.gogs.sphinx.api.SphinxResult;
import it.gogs.sphinx.exception.AddressBookBizException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Instance that will parse our free text and provide the results.
 * 
 * 
 * Note: Make sure that 'searchd' is up and running before you use this class
 * 
 * @author Munish Gogna
 * 
 */
public class SphinxInstance {

	// private static String SPHINX_HOST = "localhost";
	private static String SPHINX_HOST = Utils.HOST;
	private static String SPHINX_INDEX = "addressBookIndex";
	private static int SPHINX_PORT = 9312;

	private static SphinxClient sphinxClient;
	private static Logger logger = Logger.getLogger(SphinxInstance.class);

	static {
		sphinxClient = new SphinxClient(SPHINX_HOST, SPHINX_PORT);
	}

	public static List getAddressBookIds(SearchCriteria criteria)
			throws AddressBookBizException, SphinxException {
		List addressIdsList = new ArrayList();

		try {
			if (Utils.isNull(criteria)) {
				logger.error("criteria is null");
				throw new AddressBookBizException("criteria is null");
			}

			if (Utils.isEmpty(criteria.getKeywords())) {
				logger.error("keyword is a required field");
				throw new AddressBookBizException("keyword is a required field");
			}

			DateRange dateRange = criteria.getDateRange();
			if (!Utils.isNull(dateRange)) {
				if (Utils.isDateRangeValid(dateRange)) {
					// this is to filter results based on joining dates if they
					// are provided
					sphinxClient.SetFilterRange("DOJ",
							getTimeInSeconds(dateRange.getFromDate()),
							getTimeInSeconds(dateRange.getToDate()), false);
				} else {
					logger.error(" fromDate/toDate should not be empty and 'fromDate' should be less than equal to 'toDate'");
					throw new AddressBookBizException(
							"fromDate/toDate should not be empty and 'fromDate' should be less than equal to 'toDate'");
				}
			}
			sphinxClient.SetMatchMode(SphinxClient.SPH_MATCH_EXTENDED2);
			sphinxClient.SetSortMode(SphinxClient.SPH_SORT_RELEVANCE, "");
			SphinxResult result = sphinxClient.Query(
					buildSearchQuery(criteria), SPHINX_INDEX,
					"buidling query for address book search");

			SphinxMatch[] matches = result.matches;

			for (SphinxMatch match : matches) {
				addressIdsList.add(String.valueOf(match.docId));
			}

		} catch (SphinxException e) {
			throw e;
		} catch (AddressBookBizException e) {
			throw e;
		}

		logger.info("Total record(s):" + addressIdsList.size());
		return addressIdsList;

	}

	private static long getTimeInSeconds(Date time) {
		return time.getTime() / 1000;
	}

	private static String buildSearchQuery(SearchCriteria criteria)
			throws AddressBookBizException {

		String keywords[] = criteria.getKeywords().split(" ");
		StringBuilder searchFor = new StringBuilder();
		for (String key : keywords) {
			if (!Utils.isEmpty(key)) {
				searchFor.append(key);
				if (searchFor.length() > 1) {
					searchFor.append("*|*");
				}
			}

		}
		searchFor.delete(searchFor.lastIndexOf("|*"), searchFor.length());
		StringBuilder queryBuilder = new StringBuilder();
		String query = searchFor.toString();
		queryBuilder.append("@FName *" + query + "  | ");
		queryBuilder.append("@LName *" + query + "  | ");
		queryBuilder.append("@Title *" + query + "  | ");
		queryBuilder.append("@Location *" + query + "  | ");
		queryBuilder.append("@Alias *" + query + "  | ");
		queryBuilder.append("@Email *" + query + "  | ");
		queryBuilder.append("@PhoneNo *" + query);

		logger.info("Sphinx Query: " + queryBuilder.toString());
		return queryBuilder.toString();
	}

}
