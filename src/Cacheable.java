/**
 * An interface defining an object that can be stored within 
 * a GenericCache or a subclass of GenericCache. 
 * @author ChrisOttino
 *
 */
public interface Cacheable <K,V>{
	/**
	 * Get the id for the Cacheable. 
	 * @return : The id object for the Cacheable. 
	 */
	public K getID(); 
	
	/**
	 * Get the value contained within the Cacheable. 
	 * @return : The value object from within the Cacheable. 
	 */
	public V getData(); 
}
