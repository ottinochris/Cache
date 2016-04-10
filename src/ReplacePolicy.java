/**
 * An interface to specify the API for the Replacement Policy to be used 
 * with the Cache. A class that implements this interface should declare 
 * a Map to contain elements within the cache and a capacity for the cache. 
 * @author ChrisOttino
 *
 */
public interface ReplacePolicy {
	  
	/**
	 * 
	 * @param key : key for the object that is to be retrieved. 
	 * @return
	 */
	public Cacheable getCache(Object key);

	/**
	 * 
	 * @param object : The object to be placed in the cache. User is 
	 * responsible for wrapping the object in a Cacheable. If the cache is full 
	 * this and associated methods will have to determine who is to be ejected. 
	 */
	public void putCache(Object id, Cacheable object ); 
}
