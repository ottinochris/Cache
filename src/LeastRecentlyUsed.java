import java.util.LinkedHashMap;
import java.util.Map;

//public class LeastRecentlyUsed extends LinkedHashMap implements ReplacePolicy {	

public class LeastRecentlyUsed implements ReplacePolicy {	
	
	private static final float hashTableLoadFactor = 0.75f; 
	
	private Map<Object, Object> cacheMap; 
	private int cacheSize;
	
	public LeastRecentlyUsed(int cacheSize){
		this.cacheSize = cacheSize; 
		int hashTableCapacity = (int)Math.ceil(cacheSize / hashTableLoadFactor) + 1;
		
		//Create the map with a policy to eject the least recently used item automatically.  
		cacheMap =  new LinkedHashMap<Object,Object>(hashTableCapacity, hashTableLoadFactor, true) {
		      private static final long serialVersionUID = 1;
		      @Override 
		      protected boolean removeEldestEntry (Map.Entry<Object,Object> eldest) {
		         return size() > LeastRecentlyUsed.this.cacheSize; }};
	}


	@Override
	public Cacheable getCache(Object key) {
		return (Cacheable) cacheMap.get(key); 
	}

	@Override
	public void putCache(Object id, Cacheable object) {
		cacheMap.put(id, object);
	}
	

	
	
	
	
	
}
