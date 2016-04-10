
public interface Cacheable {
	
	public Object getID(); 
	//public Object createCacheObject(); We can add this if we want to delegate object creation to the user and not the cache. 
	public Object getData(); 
}
