/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package des;

import static des.DES.hex;
import java.util.Arrays;

/**
 *
 * @author Bahaa
 */
public class DES_CLASS {

    
 

    public static String LeftRotate(char[] unOrderedArray, int orderToRotate) {
        String x = "";
        for (int i = 0; i < orderToRotate; i++) {
            x = LeftRotatebyOne(unOrderedArray);
        }
        //unOrderedArray = x.toCharArray(); 
        return x;
    }

    public static String LeftRotatebyOne(char[] unOrderedArray) {
        int i;
        char temp;
        temp = unOrderedArray[0];
        for (i = 0; i < unOrderedArray.length - 1; i++) {
            unOrderedArray[i] = unOrderedArray[i + 1];
        }
        unOrderedArray[i] = temp;
        return new String(unOrderedArray);
    }

    public String pc1(String res) {

        String v = "";
        char[] l = res.toCharArray();

        int[] pc1 = {
            57, 49, 41, 33, 25, 17, 9,
            1, 58, 50, 42, 34, 26, 18,
            10, 2, 59, 51, 43, 35, 27,
            19, 11, 3, 60, 52, 44, 36,
            63, 55, 47, 39, 31, 23, 15,
            7, 62, 54, 46, 38, 30, 22, 
            14, 6, 61, 53, 45, 37, 29,
            21, 13, 5, 28, 20, 12, 4};

        for (int i = 0; i < pc1.length; i++) {
            v += l[pc1[i] - 1];
        }
        return (v);

    }

    public String[] C_Generator(String C0) {
        // LEFT ROTATE 
        //1 1 2 2 2 2 2 2 1 2 2 2 2 2 2 1
        String Cs[] = new String[17];

        Cs[0]=C0;
        Cs[1] = LeftRotate(C0.toCharArray(), 1);
        Cs[2] = LeftRotate(Cs[1].toCharArray(), 1);
        Cs[3] = LeftRotate(Cs[2].toCharArray(), 2);
        Cs[4] = LeftRotate(Cs[3].toCharArray(), 2);
        Cs[5] = LeftRotate(Cs[4].toCharArray(), 2);
        Cs[6] = LeftRotate(Cs[5].toCharArray(), 2);
        Cs[7] = LeftRotate(Cs[6].toCharArray(), 2);
        Cs[8] = LeftRotate(Cs[7].toCharArray(), 2);
        Cs[9] = LeftRotate(Cs[8].toCharArray(), 1);
        Cs[10] = LeftRotate(Cs[9].toCharArray(), 2);
        Cs[11] = LeftRotate(Cs[10].toCharArray(), 2);
        Cs[12] = LeftRotate(Cs[11].toCharArray(), 2);
        Cs[13] = LeftRotate(Cs[12].toCharArray(), 2);
        Cs[14] = LeftRotate(Cs[13].toCharArray(), 2);
        Cs[15] = LeftRotate(Cs[14].toCharArray(), 2);
        Cs[16] = LeftRotate(Cs[15].toCharArray(), 1);

        return Cs;
    }

    public String[] D_Generator(String D0) {
        // LEFT ROTATE 
        //1 1 2 2 2 2 2 2 1 2 2 2 2 2 2 1
        String Ds[] = new String[17];

        Ds[0]=D0;
        Ds[1] = LeftRotate(D0.toCharArray(), 1);
        Ds[2] = LeftRotate(Ds[1].toCharArray(), 1);
        Ds[3] = LeftRotate(Ds[2].toCharArray(), 2);
        Ds[4] = LeftRotate(Ds[3].toCharArray(), 2);
        Ds[5] = LeftRotate(Ds[4].toCharArray(), 2);
        Ds[6] = LeftRotate(Ds[5].toCharArray(), 2);
        Ds[7] = LeftRotate(Ds[6].toCharArray(), 2);
        Ds[8] = LeftRotate(Ds[7].toCharArray(), 2);
        Ds[9] = LeftRotate(Ds[8].toCharArray(), 1);
        Ds[10] = LeftRotate(Ds[9].toCharArray(), 2);
        Ds[11] = LeftRotate(Ds[10].toCharArray(), 2);
        Ds[12] = LeftRotate(Ds[11].toCharArray(), 2);
        Ds[13] = LeftRotate(Ds[12].toCharArray(), 2);
        Ds[14] = LeftRotate(Ds[13].toCharArray(), 2);
        Ds[15] = LeftRotate(Ds[14].toCharArray(), 2);
        Ds[16] = LeftRotate(Ds[15].toCharArray(), 1);

        return Ds;

    }

    public String[] PC2(String Cs[], String Ds[]) {
        String CD[] = new String[17];
        for (int i = 0; i <=16; i++) {
            CD[i] = Cs[i].concat(Ds[i]);

        }
        System.out.println("=====================  CD Compination Array  ====================================");

        for (int i = 0; i <=16; i++) {
            System.out.println(CD[i]);

        }

        String[] PCC2 = new String[17];
        String[] Keys = new String[16];

        int[] pc2 = {
            14, 17, 11, 24, 1, 5,
            3, 28, 15, 6, 21, 10,
            23, 19, 12, 4, 26, 8,
            16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55,
            30, 40, 51, 45, 33, 48,
            44, 49, 39, 56, 34, 53,
            46, 42, 50, 36, 29, 32

        };

        for (int J = 0; J <=16; J++) {
            String v = "";

            for (int i = 0; i < pc2.length; i++) {
                char[] l = CD[J].toCharArray();

                v += l[pc2[i] - 1];

            }
            PCC2[J] = v;
            

        }
        for(int i=0;i<16;i++)
        {
            Keys[i]=PCC2[i+1];
        }
        System.out.println("=====================  KEYs Array  ====================================");

        return (Keys);

    }

    public String IP(String M) {

        String v = "";
        char[] l = M.toCharArray();

        int[] ip = {
            58, 50, 42, 34, 26, 18, 10, 2,
            60, 52, 44, 36, 28, 20, 12, 4,
            62, 54, 46, 38, 30, 22, 14, 6,
            64, 56, 48, 40, 32, 24, 16, 8,
            57, 49, 41, 33, 25, 17, 9, 1,
            59, 51, 43, 35, 27, 19, 11, 3,
            61, 53, 45, 37, 29, 21, 13, 5,
            63, 55, 47, 39, 31, 23, 15, 7

        };

        for (int i = 0; i < ip.length; i++) {
            v += l[ip[i] - 1];
        }
        return (v);

    }

    public String L_R_GENERATOR(String IP, String keys[]) {
        String L0 = "";
        String R0 = "";
        String[] Ls = new String[17];
        String[] Rs = new String[17];

        char[] pc1 = IP.toCharArray();
        //Splitting the keys
        for (int i = 0; i < 32; i++) {
            L0 += pc1[i];
        }
        for (int i = 32; i < 64; i++) {
            R0 += pc1[i];
        }

         //Ln = Rn-1
        //Rn = Ln-1 + f(Rn-1,Kn)
        Ls[0] = L0;
        Rs[0] = R0;
        Ls[1] = Rs[0];
            System.out.println("L(0) "+L0);
            System.out.println("R(0) "+R0);
            System.out.println("=============================================");

         //R1 = L0 + f(R0,K1)
        //F(R0,K1)=EBIT_SELECTION_TABLE(R0) XOR K1

        for (int i = 1; i <= 16; i++) {
            String xor_res = "";

            Ls[i] = Rs[i - 1];
            char r[] = EBIT_SELECTION_TABLE(Rs[i - 1]).toCharArray();
            System.out.println("LO : "+(i-1) +" = "+ Ls[i]);
            System.out.println("E (RO) : "+(i-1)+" = " + EBIT_SELECTION_TABLE(Rs[i - 1]));

            char k[] = keys[i-1].toCharArray();
            System.out.println("K(n+1) "+i+" = " + keys[i-1]);

            for (int j = 0; j < 48; j++) {
                int M;
                M = r[j] ^ k[j];
                xor_res += M;
            }

            System.out.println("xor " + xor_res);

            String[] xor_split = div(xor_res);
            int v1[] = string_to_binary(xor_split[0]);
            int v2[] = string_to_binary(xor_split[1]);
            int v3[] = string_to_binary(xor_split[2]);
            int v4[] = string_to_binary(xor_split[3]);
            int v5[] = string_to_binary(xor_split[4]);
            int v6[] = string_to_binary(xor_split[5]);
            int v7[] = string_to_binary(xor_split[6]);
            int v8[] = string_to_binary(xor_split[7]);
//                         System.out.println("Split"+xor_split[0]);
//                       
//            System.out.println("S1"+S1(v1));

            String r1 = (appendZeroes(Binary_to_string(S1(v1))));
            

            String r2 = appendZeroes(Binary_to_string(S2(v2)));
            String r3 = appendZeroes(Binary_to_string(S3(v3)));
            String r4 = appendZeroes(Binary_to_string(S4(v4)));
            String r5 = appendZeroes(Binary_to_string(S5(v5)));
            String r6 = appendZeroes(Binary_to_string(S6(v6)));
            String r7 = appendZeroes(Binary_to_string(S7(v7)));
            String r8 = appendZeroes(Binary_to_string(S8(v8)));
                        System.out.println(r1);
                        System.out.println(r2);
                        System.out.println(r3);
                        System.out.println(r4);
                        System.out.println(r5);
                        System.out.println(r6);
                        System.out.println(r7);
                        System.out.println(r8);
 String f = "" + r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8;

            f = PTable(f);

            System.out.println(" F : "+f);
            char fs[] = f.toCharArray();
           String Presult= PTable(f);
           System.out.println("P(F) "+Presult);

            char LS_CH[] = Ls[i - 1].toCharArray();

            String res = "";


            for (int j = 0; j < fs.length; j++) {

                int M;
                M = LS_CH[j] ^ fs[j];
                res += M;
            }
            Rs[i] = res;

                       System.out.println("F XOR L "+Rs[i]);
                                               System.out.println("RO : "+(i-1) +" = "+ Rs[i]);


            
           
            System.out.println("=========================================");

//
        }
        
           String L16=Ls[16];
           String R16=Rs[16];
            String LR=R16.concat(L16);
                              System.out.println("CON : "+LR);

                  String P4=P4(LR);
                  System.out.println("P4 : "+P4);
                                                                     
                                                                     
                                        
      //  System.out.println("Cipher    : "+String.format( "%21X", Long.parseLong(P4,2)) );

        //111011101111101001001100000100
        
        String p41 = P4.substring(0, 4);
        String p411 = P4.substring(4, 8);
        String p42 = P4.substring(8, 12);
        String p421 = P4.substring(12, 16);
        String p43 = P4.substring(16, 20);
        String p431 = P4.substring(20, 24);
        String p44 = P4.substring(24, 28);
        String p441 = P4.substring(28, 32);
        String p45 = P4.substring(32, 36);
        String p451 = P4.substring(36, 40);
        String p46 = P4.substring(40, 44);
        String p461 = P4.substring(44, 48);
        String p47 = P4.substring(48, 52);
        String p471 = P4.substring(52, 56);
        String p48 = P4.substring(56, 60);
        String p481 = P4.substring(60, 64);
        System.out.println("Cipher :");
        hex(p41);
        hex(p411);
        hex(p42);
        hex(p421);
        hex(p43);
        hex(p431);
        hex(p44);
        hex(p441);
        hex(p45);
        hex(p451);
        hex(p46);
        hex(p461);
        hex(p47);
        hex(p471);
        hex(p48);
        hex(p481);
        
          
//
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        String final_Str = Rs[15] + Ls[15];
        return final_Str;

    }

    public String EBIT_SELECTION_TABLE(String M) {

        String v = "";
        char[] l = M.toCharArray();

        int[] E = {
            32, 1, 2, 3, 4, 5,
            4, 5, 6, 7, 8, 9,
            8, 9, 10, 11, 12, 13,
            12, 13, 14, 15, 16, 17,
            16, 17, 18, 19, 20, 21,
            20, 21, 22, 23, 24, 25,
            24, 25, 26, 27, 28, 29,
            28, 29, 30, 31, 32, 1

        };

        for (int i = 0; i < E.length; i++) {
            v += l[E[i] - 1];
        }
        return (v);

    }

    public String S1(int y[]) {

        int[][] E = {
            {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
            {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
            {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
            {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}

        };

        String res = "" + E[y[0]][y[1]];
        return (res);

    }

    public String S2(int[] y) {

        int[][] E = {
            {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
            {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
            {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
            {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}

        };

        String res = "" + E[y[0]][y[1]];
        return (res);

    }

    public String S3(int[] y) {

        int[][] E = {
            {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
            {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
            {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
            {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}

        };

        String res = "" + E[y[0]][y[1]];
        return (res);

    }

    public String S4(int[] y) {

        int[][] E = {
            {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
            {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
            {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
            {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}

        };

        String res = "" + E[y[0]][y[1]];
        return (res);

    }

    public String S5(int[] y) {

        int[][] E = {
            {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
            {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
            {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
            {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}

        };

        String res = "" + E[y[0]][y[1]];
        return (res);

    }

    public String S6(int[] y) {

        int[][] E = {
            {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
            {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
            {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
            {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}

        };

        String res = "" + E[y[0]][y[1]];
        return (res);

    }

    public String S7(int[] y) {

        int[][] E = {
            {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
            {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
            {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
            {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}

        };

        String res = "" + E[y[0]][y[1]];
        return (res);

    }

    public String S8(int[] y) {

        int[][] E = {
            {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
            {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
            {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
            {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}

        };

        String res = "" + E[y[0]][y[1]];
        return (res);

    }

    public int[] string_to_binary(String n) {
        int[] o = new int[2];
        char l = n.charAt(n.length() - 1);
        char f = n.charAt(0);
        String row = "" + f + l;
        String column = n.substring(1, n.length() - 1);
        int r = Integer.parseInt(row, 2);
        int c = Integer.parseInt(column, 2);
       
        o[0] = r;
        o[1] = c;
        
        return o;

    }

    public String Binary_to_string(String m) {

        String i = Integer.toString(Integer.parseInt(m), 2);

        return i;

    }

    public String[] div(String n) {
        String res[] = new String[8];
        res[0] = n.substring(0, 6);
        res[1] = n.substring(6, 12);
        res[2] = n.substring(12, 18);
        res[3] = n.substring(18, 24);
        res[4] = n.substring(24, 30);
        res[5] = n.substring(30, 36);
        res[6] = n.substring(36, 42);
        res[7] = n.substring(42, 48);
        return res;

    }

    public String PTable(String n) {
        int E[] = {
            16, 7, 20, 21,
            29, 12, 28, 17,
            1, 15, 23, 26,
            5, 18, 31, 10,
            2, 8, 24, 14,
            32, 27, 3, 9, 19, 13, 30, 6,
            22, 11, 4, 25
        };

        String v = "";
        char[] l = n.toCharArray();

        for (int i = 0; i < E.length; i++) {
            v += l[E[i] - 1];
        }

        return (v);

    }

    public static String appendZeroes(String bits) {
        int rem = bits.length() % 4;
        if (rem == 0) {
            return bits;
        } else {
            int appendingZeroes = 4 - rem;
            String s = "";
            for (int i = 0; i < appendingZeroes; i++) {
                s += "0";
            }
            s = s + bits;
            return s;
        }
    }

    public String P4(String n) {
        int E[] = {
            40, 8, 48, 16, 56, 24, 64, 32,
            39, 7, 47, 15, 55, 23, 63, 31,
            38, 6, 46, 14, 54, 22, 62, 30,
            37, 5, 45, 13, 53, 21, 61, 29,
            36, 4, 44, 12, 52, 20, 60, 28,
            35, 3, 43, 11, 51, 19, 59, 27,
            34, 2, 42, 10, 50, 18, 58, 26,
            33, 1, 41, 9, 49, 17, 57, 25
        };

        String v = "";
        char[] l = n.toCharArray();

        for (int i = 0; i < E.length; i++) {
            v += l[E[i] - 1];
        }

        return (v);

    }
   
     public  String toBinary(String str, int bits) {
    String result = "";
    String tmpStr;
    int tmpInt;
    char[] messChar = str.toCharArray();

    for (int i = 0; i < messChar.length; i++) {
        tmpStr = Integer.toBinaryString(messChar[i]);
        tmpInt = tmpStr.length();
        if(tmpInt != bits) {
            tmpInt = bits - tmpInt;
            if (tmpInt == bits) {
                result += tmpStr;
            } else if (tmpInt > 0) {
                for (int j = 0; j < tmpInt; j++) {
                    result += "0";
                }
                result += tmpStr;
            } else {
                System.err.println("argument 'bits' is too small");
            }
        } else {
            result += tmpStr;
        }
        result += ""; // separator
    }

    return result;
}

}
