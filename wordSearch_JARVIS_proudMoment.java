import java.util.Scanner;
public class wordSearch_JARVIS_proudMoment  
{
    public static void main()
    {
        Scanner sc=new Scanner (System.in); 
        System.out.println("Enter the number of words: ");
        int num=sc.nextInt(); 
        String word[]=new String [num]; 
        int pos[][]= new int [num][4]; 
        System.out.println("Enter the words: ");
        for (int i=0; i<num; i++)
            word[i]=sc.next();
        System.out.println("Enter the no. of rows and cols: "); 
        int r=sc.nextInt(), c=sc.nextInt();
        char arr[][]=new char [r][c];
        System.out.println("Enter the word-search array: ");
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                arr[i][j]=sc.next().charAt(0); 

        //LOOP FOR WORDS
        for (int k=0; k<num; k++)
        {
            String wd= word[k]; //extracting word to find in word search 
            int len=wd.length();
            for (int i=0; i<r; i++)
            {
                for (int j=0; j<c; j++)
                {
                    if (arr[i][j]== wd.charAt(0)) //if a match of first char is found, check further
                    {
                        //CHECKING ROW-WISE- FRONT  
                        int x= 1, rflag= 1, row=i, col=j, m=j+1; 
                        while (x<len && m<c)
                            if (arr[row][m++]==wd.charAt(x++))
                                rflag= rflag+1; 

                        /*# System.out.println(rflag); */
                        if (rflag== len)
                        {
                            pos [k][0]= row; 
                            pos [k][1]= col; 
                            pos [k][2]= row; 
                            pos [k][3]= col+ wd.length()-1;  
                        }

                        //CHECKING ROW-WISE BACKWARD
                        rflag= 1; row=i; col=j; x=1; m=j-1; 
                        while (x<len && m>=0)
                            if (arr[row][m--]==wd.charAt(x++))
                                rflag= rflag+1; 
                             
                        if (rflag== wd.length())
                        {
                            pos[k][0]= row; 
                            pos [k][1]= col; 
                            pos [k][2]= row; 
                            pos [k][3]= col+ wd.length()-1;
                        }
                        
                        //CHECKING COL-WISE DOWNWARD
                        rflag= 1; row=i; col=j; x=1; m=i+1; 
                        while (x<len && m<r)
                            if (arr[m++][col]==wd.charAt(x++))
                                rflag= rflag+1; 
                             
                        if (rflag== wd.length())
                        {
                            pos[k][0]= row; 
                            pos [k][1]= col; 
                            pos [k][2]= row; 
                            pos [k][3]= col+ wd.length()-1;
                        }
                        
                        //CHECKING COL-WISE UPWARD 
                        rflag= 1; row=i; col=j; x=1; m=i-1; 
                        while (x<len && m>=0)
                            if (arr[m--][col]==wd.charAt(x++))
                                rflag= rflag+1; 
                             
                        if (rflag== wd.length())
                        {
                            pos[k][0]= row; 
                            pos [k][1]= col; 
                            pos [k][2]= row; 
                            pos [k][3]= col+ wd.length()-1;
                        }
                    }
                }
            }
        }
        //PRINTING 
        for (int i=0; i<num; i++)
            System.out.println(word[i]+ 
                    " ["+pos[i][0]+"] ["+pos[i][1]+"] , ["+pos[i][2]+"] ["+pos[i][3]+"]");
        }
    }

