package ChainStore;
/**   
 * Item object class with all getter and setter methods
* @author  Mert Türker
* @author  Selin Baykal
*/

public class Item {
	
	private int id;
	private String nameString;
	private String categoryString;

	public Item(int id, String nameString, String categoryString) {

	        this.id = id;
	        this.nameString = nameString;
	        this.categoryString = categoryString;
	    }

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return nameString;
	}
	public void setName(String name) {
		this.nameString = name;
	}
	public String getCategory() {
		return categoryString;
	}
	public void setCategory(String category) {
		this.categoryString = category;
	}
	
}


