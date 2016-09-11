package com.pavel.alex.lab.first.generator;


/**
 * Created by pyshankov on 07.09.2016.
 */
public interface Generator {

    long getFirstState();

    Object getCurrentState();

    long generateNext();


    class LFSR implements Generator {
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
