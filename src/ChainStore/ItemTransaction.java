package ChainStore;
/**   
 * ItemTransaction object class with all getter and setter methods
* @author  Mert Türker
* @author  Selin Baykal
*/
public class ItemTransaction {
	
	private Item item;
	private Transaction[][] itemTransaction;
	
	 public ItemTransaction( Item item, Transaction[][] itemTransaction) {
 
		 this.item = item;
		 this.itemTransaction = itemTransaction;
		 
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Transaction[][] getItemTransaction() {
		return itemTransaction;
	}
	public void setItemTransaction(Transaction[][] itemTransaction) {
		this.itemTransaction = itemTransaction;
	}
	
}
