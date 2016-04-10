
public class Cache {
	
	private ReplacePolicy rp; 
	//I think ideally the replacement policy would live in here and then 
	//take the map and decide who to replace ect. 
	public Cache(ReplacePolicy rp){
		this.rp = rp; 
	}
	
	public synchronized void put(Cacheable obj){
		rp.putCache(obj.getID(), obj);
	}
	
	public synchronized Cacheable get(Object id){
		
		Cacheable obj = (Cacheable)rp.getCache(id); 
		//object was not in cache. 
		if(obj == null){
			return null; 
		}else{
			return obj; 
		}
	}
}
