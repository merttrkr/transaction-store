package FileAccess;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/** 
This is our fileIO class. We read cities.csv and WeeklyForecast.csv data source files 
by using two related methods in this class.   
* @author  Mert Türker 280201097
* @author  Selin Baykal 250201002
*/
public class FileIO {
		//to get the data from item file.
		public String[][] getItems(){
			final String file = "HW1_Items.csv";
			String[][] items = getdata(file);
			return items;
		}
		
		public String[][] getTRStore(int storeID){
			
			String[][] transactions = null;
			String file ="";
			if (storeID == 0) {
				file = "HW1_Transactions_Store1.csv";
				transactions = getdata(file);
				
			}
			else if (storeID == 1) {
				file = "HW1_Transactions_Store2.csv";
				transactions= getdata(file);
			}
			else if (storeID == 2) {
				file = "HW1_Transactions_Store3.csv";
				transactions= getdata(file);
				
			}
			else if (storeID == 3) {
				file = "HW1_Transactions_Store4.csv";
				transactions= getdata(file);
				
			}
			
			return transactions;
		}
	
	    private String[][] getdata(String file) {

	        String path = file;
	        String line = "";
	        String[][] data = null;
	        int index1 = 0;
            int index2 = 0;
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(path));            
	           
	            while((line = br.readLine()) != null) {
	            	
	                String[] values = line.split(",");
	                index2 = values.length;
	                index1 ++;	                
	            }
	            br.close();
	            data = new String[index1][index2];
	            BufferedReader br_second = new BufferedReader(new FileReader(path));
	            index1=0;
	            while((line = br_second.readLine()) != null) {
	            	
	                String[] splittedLine = line.split(",");
	                for (int i = 0; i < index2; i++) {
						data[index1][i] = splittedLine[i];
					}
	                index1++;
	            }
	            br_second.close();
	            
	            } 
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return data;
	        
	        
	    }

}
	
	

