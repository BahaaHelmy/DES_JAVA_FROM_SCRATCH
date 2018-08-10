/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package des;


/**
 *
 * @author Bahaa
 */
public class DES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String C0="";
        String D0="";
        String plainText="Kareemah";
        String Key="hameeraK";
        // TODO code application logic here
        DES_CLASS P=new DES_CLASS();
        String h=P.toBinary(plainText,8);
        String o=P.toBinary(Key,8);
        System.out.println("PlainText TO Binary    :"+h);
        System.out.println("Key TO Binary          :"+o);
       String pc1_result= P.pc1(P.toBinary(Key,8));
       System.out.println("PC1 RESULT: "+pc1_result);
       


       char[] pc1=pc1_result.toCharArray();
        //Splitting the keys
       for (int i=0;i<28;i++){
         C0+=pc1[i];
                }
         for (int i=28;i<56;i++){
         D0+=pc1[i];
                }
         
        System.out.println("C0: "+C0);
        System.out.println("D0: "+D0);
        
        
        P.C_Generator(C0);
        
        
        String C[]=P.C_Generator(C0);
                String D[]=P.D_Generator(D0);

                                       System.out.println("=====================  C Array  ====================================");

         for (int i=0;i<=16;i++){
                     System.out.println(C[i]);

                }
                                       System.out.println("=====================  D Array  ====================================");

         for (int i=0;i<=16;i++){
                     System.out.println(D[i]);

                }
         

         
         
    String []Keys=P.PC2(C, D);
         
 for (int i=0;i<16;i++){
                     System.out.println(Keys[i]);

                }
 
 
 
                               System.out.println("=====================  FIRST STEP FINISHED  ====================================");
                               System.out.println("=====================  NOW MESSAGE ENCODING  ====================================");

         
                               
                               System.out.println("IP : "+P.IP(h));
                               
                               
                             String LR=  P.L_R_GENERATOR(P.IP(h),Keys);


       
    }
    
    public static void hex(String hex)
    {
        
  long num = Long.parseLong(hex);
  long rem;
  while(num > 0){
  rem = num % 10;
  num = num / 10;
  if(rem != 0 && rem != 1){
  System.out.println("This is not a binary number.");
  System.out.println("Please try once again.");
  System.exit(0);
  }
  }
  int i= Integer.parseInt(hex,2);
  String hexString = Integer.toHexString(i);
  System.out.print("" + hexString);
  }
    
    
}
