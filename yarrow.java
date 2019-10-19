package com.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;
import java.lang.Math;
import com.java.bitBlock;

public class yarrow {
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();

        for(byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        //Define digest for the one-way hash function
        MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
        //Define the scanner used to take in the plain text to generate from.
        Scanner plainTextScan = new Scanner(System.in);
        //PlainText String
        String plainText;
        BitSet inputBits = new BitSet();
        //ArrayList of byte arrays holding each individual 64bit block of data
        ArrayList<bitBlock> blockList = new ArrayList<>();
        ArrayList<bitBlock> permBlockList = new ArrayList<>();
        ArrayList<Integer> PC1 = new ArrayList<>(Arrays.asList(57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,
                59,51,43,35,27,19,11,3,60,52,44,36,62,55,47,39,31,23,15,7,62,54,46,
                38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4));

        System.out.println(PC1.size());
        //The minimum amount of blocks required to hold the data
        Integer minBlocks = 0;
        byte[] inputBytes;
        byte[] plainBytes = new byte[8];
        byte[] leftPlain = new byte[4];
        byte[] rightPlain = new byte[4];
//        BitSet tESTBITSET = new BitSet(64);
//        tESTBITSET.clear();
//        System.out.println(tESTBITSET.get(50));

        //Set plainText to the user input
        plainText = plainTextScan.nextLine();
        //Get the byte content of the string
        inputBytes = plainText.getBytes();
        inputBits = BitSet.valueOf(inputBytes);

        if(inputBits.length() % 64 != 0) {
            minBlocks = (inputBytes.length / 8) + 1;
        } else {
            minBlocks = inputBytes.length / 8;
        }

        for(int i = 0; i < minBlocks; i++) {
            blockList.add(new bitBlock(false));
            permBlockList.add(new bitBlock(true));
        }

        for(int i = 0; i < minBlocks; i++) {
            blockList.get(i).fullBitBlock = inputBits.get((i*64),(i*64)+64);
            blockList.get(i).bitBlockSplit(false);
        }

        for(int i = 0; i < blockList.size(); i++) {
            for(int x = 0; x < PC1.size(); x++) {
               //Need to permute the bitBlocks via PC1.
            }
            permBlockList.get(i).bitBlockSplit(true);
        }

        System.out.println("No errors? :DDDDDD");

    }
}
