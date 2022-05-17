package br.com.clean.engine.loyalty.dataprovider;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import br.com.clean.engine.loyalty.domain.BucketTypeEnum;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import br.com.clean.engine.loyalty.usecase.port.BucketsDSGateway;

@Component
public class BucketsDataProvider implements BucketsDSGateway {

	@Override
	public List<Map<String, Object>> findAllBuckets(final List<Map<String, Object>> allRateTokens,
			final Map<String, Object> extraArgs) {
		return Lists.newArrayList(
		Map
		.of(
				"_index", "i-factor-fid", 
				"productType" , "HOT",
				"isDefault", false, 
				"code", "GEN",
				"value", 42.909,
				"tag", "0",
				"minMarkup", 0.50,
				"maxMarkup",  0.70,
				"minShare", 0.1,
				"maxShare", 0.2
				),
		Map
		.of(
				"_index", "i-factor-fid", 
				"productType" , "AIR",
				"isDefault", false, 
				"code", "GEN",
				"value", 53.0,
				"tag", "0",
				"minMarkup", 0.50,
				"maxMarkup",  0.70,
				"minShare", 0.1,
				"maxShare", 0.2
				),
		Map
		.of(
				"_index", "i-factor-fid", 
				"productType" , "HOT",
				"isDefault", false, 
				"code", "GEN",
				"value", 52.0,
				"tag", "0",
				"minMarkup", 0.50,
				"maxMarkup",  0.70,
				"minShare", 0.9,
				"maxShare", 1.0
				),
		Map
		.of(
				"_index", "i-factor-fid", 
				"productType" , "AIR",
				"isDefault", false,  
				"code", "GEN",
				"value", 52.0,
				"tag", "0",
				"minMarkup", 0.50,
				"maxMarkup",  0.70,
				"minShare", 0.9,
				"maxShare", 1.0
				),
		Map
		.of(
				"_index", "i-factor-fid", 
				"productType" , "HOT",
				"isDefault", false, 
				"code", "GEN",
				"value", 51.0,
				"tag", "0",
				"minMarkup", 0.45,
				"maxMarkup",  0.80,
				"minShare", 0.99,
				"maxShare", 1.0
				)
		);
	}

	@Override
	public Map<String, Object> filterBucket(final BucketTypeEnum bucketTypeEnum,
			final Map<String, Object> decodedRateToken, final List<Map<String, Object>> buckets,
			final Map<String, Object> extraArgs) {
		
		if (BucketTypeEnum.CALCULATION.equals(bucketTypeEnum)) {

			return buckets.stream().filter(
					bucketMap -> ((BigDecimal) (extraArgs.get("share")))
							.compareTo(BigDecimal.valueOf((Double) bucketMap.get("minShare"))) >= 0
							&& ((BigDecimal) (extraArgs.get("share")))
									.compareTo(BigDecimal.valueOf((Double) bucketMap.get("maxShare"))) <= 0)
					.findFirst().orElseThrow();
		}
		
		if (BucketTypeEnum.COMISSION.equals(bucketTypeEnum)) {
			return Map
					.of(
							"_index", "i-factor-fid", 
							"productType" , "HOT",
							"isDefault", false, 
							"code", "CMS",
							"value", 0.135
							);
		}
		
		if (BucketTypeEnum.COMISSION_POINTS.equals(bucketTypeEnum)) {
			return Map
					.of(
							"_index", "i-factor-fid", 
							"productType" , "HOT",
							"isDefault", false, 
							"code", "CMP",
							"value", 0.08
							);
		}
		
		if (BucketTypeEnum.POINTS_TO_ACCUMULATE.equals(bucketTypeEnum)) {
			return Map
					.of(
							"_index", "i-factor-fid", 
							"productType" , "HOT",
							"isDefault", false, 
							"code", "ACH",
							"value", 10.0
							);
		}
		
		if (BucketTypeEnum.PROPORTION.equals(bucketTypeEnum)) {
			return Map
					.of(
							"_index", "i-factor-fid", 
							"productType" , "HOT",
							"isDefault", false, 
							"code", "SHA",
							"value", 0.1
							);
		}
		
		if (BucketTypeEnum.DISCOUNT_CLUB.equals(bucketTypeEnum)) {
			return Map
					.of(
							"_index", "i-factor-fid", 
							"productType" , "HOT",
							"isDefault", false, 
							"code", "CLH",
							"value", 0.05
							);
		}
		
		return null;
	}

}
