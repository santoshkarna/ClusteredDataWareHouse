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
import com.progresssoft.ClusteredDataWarehouse.model.InvalidDeal;

@Repository
public class InvalidDealRepositoryBatchInsertImpl implements InvalidDealRepositoryBatchInsert{
	
	@PersistenceContext
	private EntityManager em;
	
	private static final int BATCH_SIZE	=	1000;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InvalidDealRepositoryBatchInsertImpl.class);

	@Override
	public void batchInsert(List<InvalidDeal> invalidDealList) {
		
		List<List<InvalidDeal>> invalidListBatchList = Lists.partition(invalidDealList, BATCH_SIZE);
		//String sql = "INSERT INTO valid_deal (id, deal_unique_id, source_file_name, from_currency_code, to_currency_code, deal_timestamp, deal_amount) values (?, ?, ?, ?, ?, ?, ?)";
		for( List<InvalidDeal> invalidDealBatch : invalidListBatchList){
			Session session = em.unwrap(Session.class);
			session.doWork(connection -> {
				PreparedStatement preparedStatement = null;
				StringBuilder stringBuilder = new StringBuilder(100000);
				stringBuilder.append("INSERT INTO invalid_deal (id, deal_unique_id, source_file_name, from_currency_code, to_currency_code, deal_timestamp, deal_amount) values  ");
				try{
					
				Iterator<InvalidDeal> iterator = 	invalidDealBatch.iterator();
				while( iterator.hasNext() ){
					InvalidDeal invalidDeal = iterator.next();
					stringBuilder.append("(");
		            stringBuilder.append("'").append(invalidDeal.getUuid()).append("', ");
		            stringBuilder.append("'").append(invalidDeal.getDealUniqueId()).append("', ");
		            stringBuilder.append("'").append(invalidDeal.getSourceFileName()).append("', ");
		            stringBuilder.append("'").append(invalidDeal.getFromCurrencyCode()).append("', ");
		            stringBuilder.append("'").append(invalidDeal.getToCurrencyCode()).append("', ");
		            stringBuilder.append("'").append(invalidDeal.getDealTimestamp().toString()).append("', ");
		            stringBuilder.append("'").append(invalidDeal.getDealAmount()).append("'");
		            stringBuilder.append(")");

		            if (iterator.hasNext()) {
		                stringBuilder.append(", ");
		            }
				}
				 preparedStatement = connection.prepareStatement(stringBuilder.toString()); 
				 preparedStatement.executeLargeUpdate();
				}catch( SQLException e ){
					LOGGER.error("Query : "+ stringBuilder.toString());
					LOGGER.error("Exception occurred on InvalidDeal Batch Insert", e);
				}finally{
					if( preparedStatement != null){
						preparedStatement.close();
					}
				}
			});
		}
		
		LOGGER.info("Invalid Deals Imported");
	}

}
