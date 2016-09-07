package com.pavel.alex.lab.first.generator;

/**
 * Created by pyshankov on 08.09.2016.
 */
public class GeffeGen implements Generator {

    private Generator l1;
    private Generator l2;
    private Generator l3;
    public GeffeGen(Generator l1, Generator l2, Generator l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    @Override
    public long getFirstState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getCurrentState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long generateNext() {
        long x = l1.generateNext();
        long y = l2.generateNext();
        long s = l3.generateNext();
        return (s & x) ^ (s ^ 1) & y ;
    }

    public static class LFSR implements Generator {
        private final long characteristicPolynon;

        private final long firstState;

        //defines current state of register
        private long currentState;

        //defines a function for generating elements
        private final long multiplicativeMask;

        //defines a length of register;
        private final int registerLength;

        public LFSR(long characteristicPolynon,long firstState){
            this.characteristicPolynon=characteristicPolynon;
            int n = Long.numberOfLeadingZeros(this.characteristicPolynon) + 1;
            long identityMask = (0xFFFF_FFFF >>> n);
            this.registerLength = 64 - n ;
            this.multiplicativeMask = characteristicPolynon & identityMask;
            this.firstState= firstState & identityMask;
            this.currentState = this.firstState;
        }

        public void reset(){
            currentState = firstState;
        }

        public long generateNext(){
            long outputBit = currentState & 1;
            long nextBit = Long.bitCount(currentState & multiplicativeMask) & 1 ;
            currentState = ( currentState >>> 1 ) | (nextBit << (registerLength - 1));
            return outputBit;
        }

        public long getFirstState(){
            return firstState;
        }

        public Object getCurrentState() {
            String binary = Long.toBinaryString(currentState & (0xFFFF_FFFF >>> (64 - registerLength)));
            int needZeros = registerLength - binary.length();
            StringBuilder builder = new StringBuilder(registerLength);
            while (needZeros-- > 0) {
                builder.append("0");
            }
            builder.append(binary);
            return builder.toString();
        }

    }
}
