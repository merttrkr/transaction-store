package ChainStore;
import java.io.IOException;
import FileAccess.FileIO;

/**   
 * We are using AnnualSaleInitialize class as an helper class for our 
 * StoreQuery class. This class basicly converts file reading strings into object arrays.
* @author  Selin Baykal
* @author  Mert Türker
*/

public class AnnualSaleInitialize {
	private FileIO data;


	private AnnualSale annualSale;
	private ItemTransaction[] itemTransactionArray;
	private Transaction[][] transactions;
	private Item[] items;

	public AnnualSaleInitialize() throws IOException{
		data = new FileIO();
		getAnnualSale();
		
	}
	public AnnualSale getAnnualSale() throws IOException {
		String[][] store1 = data.getTRStore(0);// get datas for each file
		String[][] store2 = data.getTRStore(1);
		String[][] store3 = data.getTRStore(2);
		String[][] store4 = data.getTRStore(3);
		String [][] itemfile = data.getItems();
		
		
		
		items = new Item[itemfile.length]; //creates an empty items array
		
		
		for (int i = 0; i < itemfile.length; i++) { //reads and assign values and creates item objects
			for (int j = 0; j < itemfile[i].length; j++) {
				String name =  itemfile[i][0];
				int id = Integer.parseInt(itemfile[i][1]);
				String cat = itemfile[i][2];
				items[id-1] = new Item(id, name, cat);
			}
		}
		
		
		itemTransactionArray = new ItemTransaction[itemfile.length]; // creates an empty itemtransaction array
		
		
			for (int i = 0; i < itemfile.length; i++) {
				int counter  = 0; //we will use it as column index for transaction 2d array because j increments by 3 
				int id = Integer.parseInt(store1[i][0]);
				Item item = new Item(id, items[i].getName(), items[i].getCategory());
				transactions = new Transaction[4][12];
				
				for (int j = 0; j+3 < store1[i].length; j=j+3) {
					
					double purchasePrice1 = Double.parseDouble(store1[i][j+1]); 
					double salePrice1 = Double.parseDouble(store1[i][j+2]);
					double numberOfSales1 = Double.parseDouble(store1[i][j+3]);
					transactions[0][counter] =  new Transaction(purchasePrice1, salePrice1, numberOfSales1);//each row of 2d transaction array is a store
					
					
					double purchasePrice2 = Double.parseDouble(store2[i][j+1]);
					double salePrice2 = Double.parseDouble(store2[i][j+2]);
					double numberOfSales2 = Double.parseDouble(store2[i][j+3]);
					transactions[1][counter]= new Transaction(purchasePrice2, salePrice2, numberOfSales2);
					
					double purchasePrice3 = Double.parseDouble(store3[i][j+1]);
					double salePrice3 = Double.parseDouble(store3[i][j+2]);
					double numberOfSales3 = Double.parseDouble(store3[i][j+3]);
					transactions[2][counter]= new Transaction(purchasePrice3, salePrice3, numberOfSales3);
					

					double purchasePrice4 = Double.parseDouble(store4[i][j+1]);
					double salePrice4 = Double.parseDouble(store4[i][j+2]);
					double numberOfSales4 = Double.parseDouble(store4[i][j+3]);
					transactions[3][counter]= new Transaction(purchasePrice4, salePrice4, numberOfSales4);
					
					counter++;					
				}
				itemTransactionArray[i] = new ItemTransaction(item, transactions); //creates itemTransaction objects
			
		}

			annualSale = new AnnualSale(itemTransactionArray);
			return annualSale;
	}
			
}



