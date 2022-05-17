package br.com.clean.engine.loyalty.usecase.port;

import java.util.List;
import java.util.Map;

import br.com.clean.engine.loyalty.domain.BucketTypeEnum;

public interface BucketsDSGateway {

	List<Map<String, Object>> findAllBuckets(List<Map<String, Object>> allRateTokens, Map<String, Object> extraArgs);

	Map<String, Object> filterBucket(BucketTypeEnum bucketTypeEnum, Map<String, Object> decodedRateToken,
                                     List<Map<String, Object>> buckets, Map<String, Object> extraArgs);
}
