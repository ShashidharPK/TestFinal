

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class segFaultFix {

    public void walkTheDir( String path ) {

        File rootFile = new File( path );
        
        File[] list = rootFile.listFiles();

        if (list == null) return;

        for ( File f : list ) {
        	
            if ( f.isDirectory() ) {
            	
            	walkTheDir( f.getAbsolutePath() );
              
            }
            else {
            	if ((f.getAbsoluteFile().toString()).endsWith(".java")){
            	
            		//System.out.println( f.getAbsoluteFile() );
            		try {
            			
						check(f.getAbsoluteFile().toString());
					
            		} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					}
            		
            	}
                
            }
        }
    }
    
    public void check( String path ) throws FileNotFoundException {

    	FileInputStream fstream;
		try {
			
			fstream = new FileInputStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			long lineNumber = 0;
	    	while ((strLine = br.readLine()) != null)   {
	    		lineNumber +=1;
	    	    	
	    	  if (strLine.length()>500){
	    		   
	    		  System.out.println(" Path of the file              : "+path);
	    		  System.out.println(" Line Number                   : "+lineNumber);
	    		  System.out.println(" Obeserved length of string    : "+strLine.length());	    		  
	    		  printMargin();
	    		  	    		  
	    	  }
	    	}

	    	br.close();
	    	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
    }

    public static void printMargin(){
    	
    	String margin = "";
		
		for(int i=0;i<150;i++){
			margin +="-";
		}
				
		System.out.println(margin);
		
    }
    
	public static void main(String[] args) {
		
		System.out.println("Unusua line length found on the folowing files : \n");
		
		printMargin();
		
		segFaultFix fw = new segFaultFix();
		
        fw.walkTheDir("C:\\Users\\sreehari.vr\\Desktop\\project_Code");
        

	}
}



