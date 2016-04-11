public interface GenericCache<K,V> {
	
	/**
	 * Put a Cacheable object into Cache.It is highly recommended that 
	 * this method be synchronized upon implementation if multiple 
	 * threads will be using the cache. 
	 * @param obj: Object to be placed in cache. 
	 */
	public void put(Cacheable<K,V> obj); 
	
	/**
	 * Get an object from the Cache. It is highly recommended that 
	 * this method be synchronized upon implementation if multiple 
	 * threads will be using the cache.
	 * 
	 * @param id : object key associated with obj in cache. 
	 * @return : The object in cache or null if it is not present. 
	 */
	public Cacheable<K,V> get(K id); 
	
	/**
	 * Removes an object from the Cache. 
	 * @param id : The id for the object to be removed. 
	 */
	public void cacheRemove(K id); 
	
	/**
	 * Deletes every element within the cache. 
	 */
	public void purge();
	
}
