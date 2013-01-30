package GenerateImage;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.sql.*;



public class DatabaseMethods {

	
		 private static Connection getPostgreSQLConnection() throws Exception {
			 	Class.forName("org.postgresql.Driver");
			//    System.out.println("Driver Loaded.");
			 	String Schema_name="glycodb";
			 	String User_name="postgres";
			 	String Password="root";
			   
			 	return DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+Schema_name,User_name,Password);
		 }
		 public static String[] GetCompositionID(double combination_a_mass){
			 Connection conn=null;
			 try{
				
				 conn = getPostgreSQLConnection();
				 if(conn!=null){
					 String sql = "select composition_id from composition where glycan_mass <"+String.valueOf(combination_a_mass+0.5) +" and glycan_mass > "+ String.valueOf(combination_a_mass-0.5); 
					 conn.setAutoCommit(false);  
					 PreparedStatement stmt = conn.prepareStatement(sql);
					 ResultSet rset = stmt.executeQuery();
					 LinkedList <Object[]> records=new LinkedList<Object[]>();
					 int cols = rset.getMetaData().getColumnCount();
					 
					 while ( rset.next() )
				     {
								Object[] arr = new Object[cols];
							    for(int i=0; i<cols; i++){
							      arr[i] = rset.getObject(i+1);
							    }
							    records.add(arr);
							   
				      }
					 String [] CompositionID = new  String[records.size()];
					
					 for(int i=0; i<records.size();i++){
							for(int j=0; j<records.get(i).length; j++){
								CompositionID[i] = (String) records.get(i)[j];
					//			System.out.print(records.get(i)[j]+"  ");
							}
					//		System.out.println();
					} 
					
					 	rset.close();
			    		stmt.close();
			    		conn.commit();
			    		conn.close();
			    		
			    		if(CompositionID.length==0)
			    		{
			    			return null;
			    		}else{
			    		return CompositionID;
			    		}
			       }
				 
			 }catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			 }
			 return null;
		 }
		 
		 public static String[] getStructureID(String [] compositionID){
			 Connection conn=null;
			 try{
				 conn = getPostgreSQLConnection();
				 
				 if(conn!=null){
					
					 LinkedList <String> structures = new LinkedList <String>();
					 for(int s=0; s<compositionID.length; s++){
						 String sql = "select structure_id from structure where composition_id='"+ compositionID[s]+ "'" ; 
						 
						 conn.setAutoCommit(false);  
						 
						 PreparedStatement stmt = conn.prepareStatement(sql);
						 
						 ResultSet rset = stmt.executeQuery();
						 LinkedList <Object[]> records=new LinkedList<Object[]>();
						 int cols = rset.getMetaData().getColumnCount();
						
						 while ( rset.next() )
					     {
									Object[] arr = new Object[cols];
								    for(int i=0; i<cols; i++){
								      arr[i] = rset.getObject(i+1);
								    }
								    records.add(arr);
									
					      }
						
						
						for(int i=0; i<records.size();i++){
								for(int j=0; j<records.get(i).length; j++){
									structures.add( String.valueOf(records.get(i)[j]));
							//		System.out.print(records.get(i)[j]+"  ");
								}
							//	System.out.println();
						} 
						  
						rset.close();
			    		stmt.close();
					
					 }
					 	String [] result = new String[structures.size()];
						for(int i=0; i<result.length; i++){
							result[i]= structures.get(i);
						}
						
			    		conn.commit();
			    		conn.close();
			    		
			    		return result;
				 
				 }
				
				 
			 }catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			 }
			 
			 
			 return null;
		 }
		 
		 public static void main(String args[]) {
			double mass =150;
			String [] CompositionID = GetCompositionID(mass);
						
			if(CompositionID != null){
				for(int i=0; i<CompositionID.length; i++){ 
			//		System.out.println(CompositionID[i]);
				}
				String [] structureID = getStructureID(CompositionID);
				System.out.println("structure_id for mass "+mass+" are:");
				
				for(String s: structureID){
			//		System.out.println(s);
				}
			}else{
				String [] structureID = {"null"};
			//	System.out.println(structureID[0]);
			}
			
		 }
}
