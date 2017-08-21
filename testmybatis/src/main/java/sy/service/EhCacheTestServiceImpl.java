package sy.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EhCacheTestServiceImpl implements EhCacheTestService {

//    @Cacheable(value = "bugTypeDaoCache", key = "#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }
    
//    @CacheEvict(value="bugTypeDaoCache",key="#param")  
    public boolean delUserRole(String param) {  
        return true;
    }  


}