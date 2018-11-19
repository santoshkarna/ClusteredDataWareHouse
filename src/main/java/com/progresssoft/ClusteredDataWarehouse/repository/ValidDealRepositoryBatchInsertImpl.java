package com.progresssoft.ClusteredDataWarehouse.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.progresssoft.ClusteredDataWarehouse.model.ValidDeal;

@Repository
public class ValidDealRepositoryBatchInsertImpl implements ValidDealRepositoryBatchInsert {

	@PersistenceContext
	private EntityManager em;

	private static final int BATCH_SIZE = 1000;

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidDealRepositoryBatchInsertImpl.class);

	@Override
	public void batchInsert(List<ValidDeal> validDealList) {

		List<List<ValidDeal>> validListBatchList = Lists.partition(validDealList, BATCH_SIZE);
		// String sql = "INSERT INTO valid_deal (id, deal_unique_id, source_file_name,
		// from_currency_code, to_currency_code, deal_timestamp, deal_amount) values (?,
		// ?, ?, ?, ?, ?, ?)";
		for (List<ValidDeal> validDealBatch : validListBatchList) {
			Session session = em.unwrap(Session.class);
			session.doWork(connection -> {
				PreparedStatement preparedStatement = null;
				StringBuilder stringBuilder = new StringBuilder(100000);
				stringBuilder.append(
						"INSERT INTO valid_deal (id, deal_unique_id, source_file_name, from_currency_code, to_currency_code, deal_timestamp, deal_amount) values  ");
				try {

					Iterator<ValidDeal> iterator = validDealBatch.iterator();
					while (iterator.hasNext()) {
						ValidDeal validDeal = iterator.next();
						stringBuilder.append("(");
						stringBuilder.append("'").append(validDeal.getUuid()).append("', ");
						stringBuilder.append("'").append(validDeal.getDealUniqueId()).append("', ");
						stringBuilder.append("'").append(validDeal.getSourceFileName()).append("', ");
						stringBuilder.append("'").append(validDeal.getFromCurrencyCode()).append("', ");
						stringBuilder.append("'").append(validDeal.getToCurrencyCode()).append("', ");
						stringBuilder.append("'").append(validDeal.getDealTimestamp().toString()).append("', ");
						stringBuilder.append(String.valueOf(validDeal.getDealAmount())).append("");
						stringBuilder.append(")");

						if (iterator.hasNext()) {
							stringBuilder.append(", ");
						}
					}
					preparedStatement = connection.prepareStatement(stringBuilder.toString());
					preparedStatement.executeLargeUpdate();
				} catch (SQLException e) {
					LOGGER.error("Exception occurred on ValidDeal Batch Insert", e);
				} finally {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
				}
			});
		}

		LOGGER.info("Valid Deals Imported");
	}

}
