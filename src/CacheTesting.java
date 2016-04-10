import org.junit.Test;
import static org.junit.Assert.*;

public class CacheTesting {
	
	@Test
	public void TestLRUCache(){
		ReplacePolicy LRU = new LeastRecentlyUsed(2); 
		Cache myCache = new Cache(LRU);
		
		Cacheable item1 = new CacheItem("Chris", 23); 
		Cacheable item2 = new CacheItem("Kiara", 20);
		Cacheable item3 = new CacheItem("Brennan", 25); 
		
		myCache.put(item1);
		myCache.put(item2);
		myCache.get(item1.getID());
		myCache.put(item3);
		
		//Since one was used more than two it should still be in cache. 
		Cacheable test = myCache.get(item1.getID()); 
		assertEquals(item1, test); 
		
		//Since this was last added it should replace two who was Least Used.
		test = myCache.get(item3.getID()); 
		assertEquals(item3, test); 
		
		//Two should not be in cache. 
		test = myCache.get(item2.getID()); 
		assertEquals(null, test); 
	}
	
	@Test 
	public void TestMRUCache(){
		
	}

}
