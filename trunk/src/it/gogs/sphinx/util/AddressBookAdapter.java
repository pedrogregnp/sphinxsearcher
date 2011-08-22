package it.gogs.sphinx.util;

import it.gogs.sphinx.AddressBoook;
import it.gogs.sphinx.exception.AddressBookBizException;
import it.gogs.sphinx.exception.AddressBookTechnicalException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Adapter to fetch data from the database.
 * 
 * @author Munish Gogna
 * 
 */
public class AddressBookAdapter {

	private static Logger logger = Logger.getLogger(AddressBookAdapter.class);

	private AddressBookAdapter() {
		// use in static way..
	}

	private static Connection getConnection()
			throws AddressBookTechnicalException {
		String userName = "root";
		String password = "123456";
		String url = "jdbc:mysql://" + Utils.HOST + "/addressbook";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			throw new AddressBookTechnicalException("could not get connection");
		}
	}

	public static List getAddressBookList(List addressIds)
			throws AddressBookTechnicalException, AddressBookBizException {

		List addressBoookList = new ArrayList();

		if (addressIds == null || addressIds.size() == 0) {
			logger.error("AddressIds was null or empty, returning empty list");
			return addressBoookList;
		}

		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = getConnection();
			callableStatement = connection
					.prepareCall("{ call search_address_book(?)}");
			callableStatement.setString(1, Utils.toCommaString(addressIds));
			callableStatement.execute();
			ResultSet resultSet = callableStatement.getResultSet();
			prepareResults(resultSet, addressBoookList);
			connection.close();
		} catch (SQLException e) {
			logger.error("Problem connecting MYSQL - " + e.getMessage());
			throw new AddressBookTechnicalException(e.getMessage());
		} catch (AddressBookTechnicalException e) {
			logger.error("Problem connecting MYSQL - " + e.getMessage());
			throw e;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error("Problem closing conection - "
							+ e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return addressBoookList;
	}

	private static void prepareResults(ResultSet resultSet,
			List addressBoookList) throws SQLException {
		AddressBoook addressBoook;
		while (resultSet.next()) {
			addressBoook = new AddressBoook();
			addressBoook.setAlias(resultSet.getString("Alias"));
			addressBoook.setEmail(resultSet.getString("Email"));
			addressBoook.setFName(resultSet.getString("FName"));
			addressBoook.setLName(resultSet.getString("LName"));
			addressBoook.setLocation(resultSet.getString("Location"));
			addressBoook.setPhoneNo(resultSet.getString("PhoneNo"));
			addressBoook.setTitle(resultSet.getString("Title"));
			addressBoook.setDOJ(resultSet.getDate("DOJ"));
			addressBoook.setId(resultSet.getLong("Id"));

			addressBoookList.add(addressBoook);
		}
	}
}
