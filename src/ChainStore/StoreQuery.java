package ChainStore;

import java.io.IOException;

import java.util.Arrays; 

public class StoreQuery {

	private AnnualSale annualSale;
	
	private AnnualSaleInitialize annualSaleInitialize;
	
	public StoreQuery() throws IOException {
		annualSaleInitialize = new AnnualSaleInitialize();
		annualSale = annualSaleInitialize.getAnnualSale();
		
	}
	
	
	private double profitFinder(ItemTransaction itemTransaction) { //finds profits for one item
		Transaction[][] transaction = new Transaction[4][12];		
		transaction = itemTransaction.getItemTransaction();
		double profit= 0;
		
		for (int i = 0; i < transaction.length; i++) {
			for (int j = 0; j < transaction[i].length; j++) {
				double purchaseprice = transaction[i][j].getPurchasePrice();
				double saleprice = transaction[i][j].getSalePrice();
				double numberofsale = transaction[i][j].getNumberOfSales();
				profit = profit + (saleprice- purchaseprice) * numberofsale; //profit formula
			}
		}
		
		return profit;
	}
	

	public String mostProfitableItem() { 
		String name = "";
		double most = 0; //inital most
		
		for (int i = 0; i < annualSale.getItemTransactionArray().length; i++) {
			if (profitFinder(annualSale.getItemTransactionArray()[i])> most) {
				most = profitFinder(annualSale.getItemTransactionArray()[i]);
				name = annualSale.getItemTransactionArray()[i].getItem().getName();
				
			}
			
		}
		return name;
	
		
	}

	public String mostProfitableCategory() {
        double foodProfitCounter= 0, beverageProfitCounter= 0, homeProfitCounter= 0, personalProfitCounter= 0,snackProfitCounter = 0 ; //profits counter for each cathegory
        String name = "";
        double[] arr = new double[5];
        for(int i=0; i <annualSale.getItemTransactionArray().length; i++) {

            Item item = annualSale.getItemTransactionArray()[i].getItem();
            String category = item.getCategory();
            
            
            if(category.equals("Food")) {
                foodProfitCounter = profitFinder(annualSale.getItemTransactionArray()[i]) + foodProfitCounter; //increments profits counter for each cathegory
                arr[0] = foodProfitCounter; //places the result in a temp array, then we will sort it
            }
            if(category.equals("Snack")) {
                snackProfitCounter = profitFinder(annualSale.getItemTransactionArray()[i]) + snackProfitCounter;
                arr[1] = snackProfitCounter;
            }
            if(category.equals("Beverage")) {
                beverageProfitCounter = profitFinder(annualSale.getItemTransactionArray()[i]) + beverageProfitCounter;
                arr[2] = beverageProfitCounter;
            }
            if(category.equals("Home")) {
                homeProfitCounter = profitFinder(annualSale.getItemTransactionArray()[i]) + homeProfitCounter;
                arr[3] = homeProfitCounter;
            }
            if(category.equals("Personal")) {
                personalProfitCounter = profitFinder(annualSale.getItemTransactionArray()[i]) + personalProfitCounter;
                arr[4] = personalProfitCounter;
            }
        }
        Arrays.sort(arr); //we sort array to so the last element of the array has biggest value
        if (arr[4] == foodProfitCounter) {
            name= "food category";
        
        }else if (arr[4] == beverageProfitCounter) {
            name= "beverage category";
        
        }else if (arr[4] == homeProfitCounter) {
            name= "home category";
        
        }else if (arr[4] == personalProfitCounter) {
            name= "personal category";
        
        }else if (arr[4] == personalProfitCounter) {
            name= "snack category";
        }

            return name;

    }

	
	
	public String leastProfitableItem() {
		double least = profitFinder(annualSale.getItemTransactionArray()[0]); //finds the first items profit to compare others
		String name = annualSale.getItemTransactionArray()[0].getItem().getName();
		for (int i = 1; i < annualSale.getItemTransactionArray().length; i++) { // i starts one because we compare least(0th element) and i
			if (least > profitFinder(annualSale.getItemTransactionArray()[i])) { //compares
				least = profitFinder(annualSale.getItemTransactionArray()[i]);
				name = annualSale.getItemTransactionArray()[i].getItem().getName();
			}
			
		}
		return name;
	
	}
	public String leastProfitableCategory() {
		 double foodProfitCounter= 0, beverageProfitCounter= 0, homeProfitCounter= 0, personalProfitCounter= 0,snackProfitCounter = 0 ; // profits counters for each cathegory
	        String name = "";
	        double[] arr = new double[5]; //a temp array just to keep final profits and sort
	        for(int i=0; i <annualSale.getItemTransactionArray().length; i++) {

	            Item item = annualSale.getItemTransactionArray()[i].getItem();
	            String category = item.getCategory();
	            
	            
	            if(category.equals("Food")) {
	                foodProfitCounter = profitFinder(annualSale.getItemTransactionArray()[i]) + foodProfitCounter;
	                arr[0] = foodProfitCounter; //places final profits to array
	            }
	            if(category.equals("Snack")) {
	                snackProfitCounter = profitFinder(annualSale.getItemTransactionArray()[i]) + snackProfitCounter;
	                arr[1] = snackProfitCounter;
	            }
	            if(category.equals("Beverage")) {
	                beverageProfitCounter = profitFinder(annualSale.getItemTransactionArray()[i]) + beverageProfitCounter;
	                arr[2] = beverageProfitCounter;
	            }
	            if(category.equals("Home")) {
	                homeProfitCounter = profitFinder(annualSale.getItemTransactionArray()[i]) + homeProfitCounter;
	                arr[3] = homeProfitCounter;
	            }
	            if(category.equals("Personal")) {
	                personalProfitCounter = profitFinder(annualSale.getItemTransactionArray()[i]) + personalProfitCounter;
	                arr[4] = personalProfitCounter;
	            }
	        }
	        Arrays.sort(arr);// we sort the temp array so the first element of the array has the smallest value
	        if (arr[0] == foodProfitCounter) {
	            name= "food category";
	        
	        }else if (arr[0] == beverageProfitCounter) {
	            name= "beverage category";
	        
	        }else if (arr[0] == homeProfitCounter) {
	            name= "home category";
	        
	        }else if (arr[0] == personalProfitCounter) {
	            name= "personal category";
	        
	        }else if (arr[0] == personalProfitCounter) {
	            name= "snack category";
	        }

	            return name;
	}
	
	
	public String mostProfitableItemsingleSale() { 
		double most = 0;
		String name = "";
		
		for (int i = 0; i < annualSale.getItemTransactionArray().length; i++) { 
			double profit  = 0;
			Transaction[][] itemTransaction = annualSale.getItemTransactionArray()[i].getItemTransaction();
			
			for (int j = 0; j < itemTransaction.length; j++) {
				
				for (int k = 0; k < itemTransaction[j].length; k++) {
					profit = itemTransaction[j][k].getSalePrice() - itemTransaction[j][k].getPurchasePrice();	
				}
			}
			if (profit> most) {
				most = profit;
				name = annualSale.getItemTransactionArray()[i].getItem().getName();
			}
			
		}	return name;		
	}
	
	
	
	public String bestsellingItem() {
		String item = "";
		double best = 0; //inital best is 0
		
		for (int i = 0; i < annualSale.getItemTransactionArray().length; i++) { //for every itemtransaction object we get the 2d array of transactions number of sale attribute
			double numberofsale = 0;
			Transaction[][] itemTransaction = annualSale.getItemTransactionArray()[i].getItemTransaction();
			
			for (int j = 0; j < itemTransaction.length; j++) {
				for (int j2 = 0; j2 < itemTransaction[j].length; j2++) {
					numberofsale = numberofsale +  itemTransaction[j][j2].getNumberOfSales();
				}
			}
			if (numberofsale>best) { //comparing
				best  = numberofsale;
				
				item= annualSale.getItemTransactionArray()[i].getItem().getName();
			}
		}
		return item;
	}
	
	public String[] mostProfitablestore() {
		String[] store = new String[12]; //results for 12 months
		
		double[] arr = new double[4];
		
		
		for (int i = 0; i < 12; i++) {	
			double store1profit = 0; //each months profits will equal to zero 
			double store2profit = 0;
			double store3profit = 0;
			double store4profit = 0;
			
			for (int j = 0; j < annualSale.getItemTransactionArray().length; j++) { //for each month we get every items profit store by store

				double saleprice1 = annualSale.getItemTransactionArray()[j].getItemTransaction()[0][i].getSalePrice(); //for store one we traverse every �temtransaction object 
				double purchaseprice1 = annualSale.getItemTransactionArray()[j].getItemTransaction()[0][i].getPurchasePrice();
				double numberofsale1 = annualSale.getItemTransactionArray()[j].getItemTransaction()[0][i].getNumberOfSales();
				store1profit =  store1profit + ((saleprice1-purchaseprice1)* numberofsale1);
				arr[0]= store1profit; //place in a temp array to sort
				
				double saleprice2 = annualSale.getItemTransactionArray()[j].getItemTransaction()[1][i].getSalePrice();
				double purchaseprice2 = annualSale.getItemTransactionArray()[j].getItemTransaction()[1][i].getPurchasePrice();
				double numberofsale2 = annualSale.getItemTransactionArray()[j].getItemTransaction()[1][i].getNumberOfSales();
				store2profit = store2profit+ ((saleprice2-purchaseprice2)* numberofsale2);
				arr[1]= store2profit;
				
				double saleprice3 = annualSale.getItemTransactionArray()[j].getItemTransaction()[2][i].getSalePrice();
				double purchaseprice3 = annualSale.getItemTransactionArray()[j].getItemTransaction()[2][i].getPurchasePrice();
				double numberofsale3 = annualSale.getItemTransactionArray()[j].getItemTransaction()[2][i].getNumberOfSales();
				store3profit =  store3profit + ((saleprice3-purchaseprice3)* numberofsale3);
				arr[2]= store3profit;
				
				double saleprice4 = annualSale.getItemTransactionArray()[j].getItemTransaction()[3][i].getSalePrice();
				double purchaseprice4 = annualSale.getItemTransactionArray()[j].getItemTransaction()[3][i].getPurchasePrice();
				double numberofsale4 = annualSale.getItemTransactionArray()[j].getItemTransaction()[3][i].getNumberOfSales();
				store4profit = store4profit + ((saleprice4-purchaseprice4)* numberofsale4);	
				arr[3]= store4profit;
			}
			
			Arrays.sort(arr);//sort the array so the last element has the highest value
			if (arr[3] == store1profit) {
				store[i]= "Store1";
			}else if (arr[3] == store2profit) {
				store[i]= "Store2";
			}else if (arr[3] == store3profit) {
				store[i]= "Store3";
			}else if (arr[3] == store4profit) {
				store[i]= "Store4";
			}
			
		}
		return store;
	}
}

