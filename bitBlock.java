package com.java;


import java.util.Arrays;
import java.util.BitSet;

public class bitBlock {
    public BitSet fullBitBlock;
    public BitSet leftBitBlock;
    public BitSet rightBitBlock;

    public BitSet permedBitBlock;
    public BitSet permedLBitBlock;
    public BitSet permedRBitBlock;

    public void bitBlockSplit(boolean permed) {
        if (!(permed)) {
            leftBitBlock = fullBitBlock.get(0, 32);
            rightBitBlock = fullBitBlock.get(32, 64);
        } else {
            permedLBitBlock = permedBitBlock.get(0,28);
            permedRBitBlock = permedBitBlock.get(28,56);
        }
    }


    public bitBlock(boolean permed) {
        if (!(permed)) {
            fullBitBlock = new BitSet(64);
            leftBitBlock = new BitSet(32);
            rightBitBlock = new BitSet(32);
        } else {
            permedBitBlock = new BitSet(56);
            permedLBitBlock = new BitSet(28);
            permedRBitBlock = new BitSet(28);
        }
    }

}
