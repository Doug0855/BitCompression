import java.io.*;
import java.util.*;


class compressionPair {
    private String line;
    private int frequency;

    public compressionPair(String line, int frequency) {
        this.line = line;
        this.frequency = frequency;
    }

    public String getLine() {return line;}
    public int getFrequency() {return frequency;}
    public void incrementFrequency() {frequency++;}
}

public class Compression {

    public static String dec_to_bin(int dec) {
        switch(dec) {
            case 0:
                return "0000";
            case 1:
                return "0001";
            case 2:
                return "0010";
            case 3:
                return "0011";
            case 4:
                return "0100";
            case 5:
                return "0101";
            case 6:
                return "0110";
            case 7:
                return "0111";
            case 8:
                return "1000";
            case 9:
                return "1001";
            case 10:
                return "1010";
            case 11:
                return "1011";
            case 12:
                return "1100";
            case 13:
                return "1101";
            case 14:
                return "1110";
            case 15:
                return "1111";
            default:
                System.out.println("Error converting dec to bin, tried to convert " + dec);
                return "";
        }
    }

    public static String dec_to_bin_5bit(int dec) {
        switch(dec) {
            case 0:
                return "00000";
            case 1:
                return "00001";
            case 2:
                return "00010";
            case 3:
                return "00011";
            case 4:
                return "00100";
            case 5:
                return "00101";
            case 6:
                return "00110";
            case 7:
                return "00111";
            case 8:
                return "01000";
            case 9:
                return "01001";
            case 10:
                return "01010";
            case 11:
                return "01011";
            case 12:
                return "01100";
            case 13:
                return "01101";
            case 14:
                return "01110";
            case 15:
                return "01111";
            case 16:
                return "10000";
            case 17:
                return "10001";
            case 18:
                return "10010";
            case 19:
                return "10011";
            case 20:
                return "10100";
            case 21:
                return "10101";
            case 22:
                return "10110";
            case 23:
                return "10111";
            case 24:
                return "11000";
            case 25:
                return "11001";
            case 26:
                return "11010";
            case 27:
                return "11011";
            case 28:
                return "11100";
            case 29:
                return "11101";
            case 30:
                return "11110";
            case 31:
                return "11111";
            default:
                System.out.println("Error converting dec to bin 5 bit, tried to convert " + dec);
                return "";
        }
    }

    public static String dec_to_bin_3bit(int dec) {
        switch (dec) {
            case 0:
                return "000";
            case 1:
                return "001";
            case 2:
                return "010";
            case 3:
                return "011";
            case 4:
                return "100";
            case 5:
                return "101";
            case 6:
                return "110";
            case 7:
                return "111";
            default:
                System.out.println("Invalid decimal " + dec + " when trying to convert to 3 bit binary");
                return "";
        }
    }

    public static int bin_to_dec_4bit(String bin) {
        switch(bin) {
            case "0000":
                return 0;
            case "0001":
                return 1;
            case "0010":
                return 2;
            case "0011":
                return 3;
            case "0100":
                return 4;
            case "0101":
                return 5;
            case "0110":
                return 6;
            case "0111":
                return 7;
            case "1000":
                return 8;
            case "1001":
                return 9;
            case "1010":
                return 10;
            case "1011":
                return 11;
            case "1100":
                return 12;
            case "1101":
                return 13;
            case "1110":
                return 14;
            case "1111":
                return 15;
            default:
                System.out.println("out of bounds error when trying to convert 4 bit bin to dec");
                return -1;
        }
    }

    public static int bin_to_dec_3bit(String bin) {
        switch (bin) {
            case "000":
                return 0;
            case "001":
                return 1;
            case "010":
                return 2;
            case "011":
                return 3;
            case "100":
                return 4;
            case "101":
                return 5;
            case "110":
                return 6;
            case "111":
                return 7;
            default:
                System.out.println("out of bounds error when trying to convert 3 bit bin to dec");
                return -1;
        }
    }

    public static int bin_to_dec_5bit(String bin) {
        switch (bin) {
            case "00000":
                return 0;
            case "00001":
                return 1;
            case "00010":
                return 2;
            case "00011":
                return 3;
            case "00100":
                return 4;
            case "00101":
                return 5;
            case "00110":
                return 6;
            case "00111":
                return 7;
            case "01000":
                return 8;
            case "01001":
                return 9;
            case "01010":
                return 10;
            case "01011":
                return 11;
            case "01100":
                return 12;
            case "01101":
                return 13;
            case "01110":
                return 14;
            case "01111":
                return 15;
            case "10000":
                return 16;
            case "10001":
                return 17;
            case "10010":
                return 18;
            case "10011":
                return 19;
            case "10100":
                return 20;
            case "10101":
                return 21;
            case "10110":
                return 22;
            case "10111":
                return 23;
            case "11000":
                return 24;
            case "11001":
                return 25;
            case "11010":
                return 26;
            case "11011":
                return 27;
            case "11100":
                return 28;
            case "11101":
                return 29;
            case "11110":
                return 30;
            case "11111":
                return 31;
            default:
                System.out.println("out of bounds error when trying to convert 4 bit bin to dec");
                return -1;
        }
    }

    private static ArrayList<String> input_parse(ArrayList<String> uncompressedContainer) throws IOException {
        ArrayList<String> out = new ArrayList<>(16);
        BufferedReader br = new BufferedReader(new FileReader("original.txt"));
        ArrayList<compressionPair> pears = new ArrayList<>();
        String in = br.readLine();

        while (in != null) {
            uncompressedContainer.add(in);
            boolean inList = false;
            for (compressionPair cp: pears) {
                if (cp.getLine().equals(in)) {
                    cp.incrementFrequency();
                    inList = true;
                    break;
                }
            }

            if (!inList) {
                pears.add(new compressionPair(in, 1));
            }

            in = br.readLine();
        }

        for (int i=0; i<16; i++) {
            int max = 0;
            for (int j=0; j<pears.size(); j++) {
                if (pears.get(j).getFrequency() > pears.get(max).getFrequency()) {
                    max = j;
                }
            }

            out.add(i, pears.get(max).getLine());
            //System.out.println("Adding " + pears.get(max).getLine() + " with frequency " + pears.get(max).getFrequency());
            pears.remove(max);
        }

        return out;
    }

    public static ArrayList<String> compress(ArrayList<String> uncompressed, ArrayList<String> dictionary) {
        ArrayList<String> compressed = new ArrayList<>();

        for (String s: uncompressed) {
            if (dictionary.contains(s)) {
                compressed.add("111" + dec_to_bin(dictionary.indexOf(s)));
            } else {
                String bitmasked = bitmaskCompression(s, dictionary);
                String mismatched = mismatchCompression(s, dictionary);

                if (mismatched.length() < bitmasked.length()) {
                    compressed.add(mismatched);
                    //System.out.println("Chose " + mismatched + " over " + bitmasked + " for binary " + s);
                } else {
                    compressed.add(bitmasked);
                }
            }
        }

        runLengthEncoding(compressed);
        return compressed;
    }

    public static int stringDiff(String a, String b) {
        int diff = 0;
        if (a.length() != b.length()) {
            System.out.println("stringDiff failed, strings are not the same length");
            return -1;
        }

        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff;
    }

    public static String mismatchCompression(String bin, ArrayList<String> dictionary) {
        int minDiff = stringDiff(dictionary.get(0), bin);
        int minIndex = 0;
        ArrayList<Integer> mismatches = new ArrayList<>();
        for (String s: dictionary) {
            int diff = stringDiff(bin, s);
            if (diff < minDiff) {
                minDiff = diff;
                minIndex = dictionary.indexOf(s);
            }
        }
        //System.out.println("Calculated " + minDiff + " differences between " + bin + " and " + dictionary.get(minIndex));
        String finalMin = dictionary.get(minIndex);
        for (int i=0; i<32; i++) {
            if (bin.charAt(i) != finalMin.charAt(i)) {
                mismatches.add(i);
            }
        }

        switch (mismatches.size()) {
            case 1:
                return "011" + dec_to_bin_5bit(mismatches.get(0)) + dec_to_bin(dictionary.indexOf(finalMin));
            case 2:
                if (mismatches.get(0) == (mismatches.get(1) - 1)) {
                    return "100" + dec_to_bin_5bit(mismatches.get(0)) + dec_to_bin(dictionary.indexOf(finalMin));
                } else {
                    //System.out.println("Flag");
                    return "110" + dec_to_bin_5bit(mismatches.get(0)) + dec_to_bin_5bit(mismatches.get(1)) + dec_to_bin(dictionary.indexOf(finalMin));
                }
            case 4:
                //System.out.println("Flag 1");
                if (mismatches.get(0) == mismatches.get(1)-1
                        && mismatches.get(0) == mismatches.get(2)-2
                        && mismatches.get(0) == mismatches.get(3)-3) {
                    return "101" + dec_to_bin_5bit(mismatches.get(0)) + dec_to_bin(dictionary.indexOf(finalMin));
                }
                break;
        }

        return "000" + bin;
    }

    public static String bitmaskCompression(String bin, ArrayList<String> dictionary) {
        int minDiff = stringDiff(dictionary.get(0), bin);
        int minIndex = 0;
        ArrayList<Integer> mismatches = new ArrayList<>();
        for (String s: dictionary) {
            int diff = stringDiff(bin, s);
            if (diff < 5 && diff > 1) {
                minDiff = diff;
                minIndex = dictionary.indexOf(s);

                for (int i=0; i<32; i++) {
                    if (bin.charAt(i) != s.charAt(i)) {
                        mismatches.add(i);
                    }
                }

                if (mismatches.get(mismatches.size()-1) - mismatches.get(0) <= 3) {
                    break;
                } else {
                    mismatches.clear();
                }
            }
        }
        //System.out.println("Calculated " + minDiff + " differences between " + bin + " and " + dictionary.get(minIndex));
        String finalMin = dictionary.get(minIndex);


        if (!mismatches.isEmpty() && mismatches.get(mismatches.size()-1) - mismatches.get(0) <= 3) {
            int a = Integer.parseInt(bin.substring(mismatches.get(0), mismatches.get(0)+4), 2);
            int b = Integer.parseInt(finalMin.substring(mismatches.get(0),mismatches.get(0)+4), 2);

            String bitmask = dec_to_bin(a^b);
            //System.out.println(a + " xor  " + b + " =  " + bitmask);
            return "010" + dec_to_bin_5bit(mismatches.get(0)) + bitmask + dec_to_bin(dictionary.indexOf(finalMin));
        } else {
            //System.out.println("Not doing bitmask on " + bin + " with distance " + (mismatches.get(mismatches.size()-1) - mismatches.get(0)));
            return "000" + bin;
        }
    }

    public static ArrayList<String> formatCompressedFile(ArrayList<String> compressed, ArrayList<String> dictionary) {
        int lineLength = 0;
        String currentLine = "";
        ArrayList<String> out = new ArrayList<>();

        for (int i=0; i<compressed.size(); i++) {
            String cur = compressed.get(i);
            if (lineLength + cur.length() <= 32) {
                currentLine += cur;
                lineLength += cur.length();
            } else if (lineLength == 32) {
                out.add(currentLine);
                i = i-1;
                currentLine = "";
                lineLength = 0;
            } else {
                int clip = 32 - lineLength;
                if (clip < 1) {

                }
                String firstHalf = cur.substring(0,clip);
                String secondHalf = cur.substring(clip);

                currentLine += firstHalf;

                out.add(currentLine);
                currentLine = secondHalf;
                lineLength = secondHalf.length();

                if (lineLength > 32) {
                    out.add(currentLine.substring(0,32));
                    currentLine = currentLine.substring(32);
                    lineLength = currentLine.length();
                }
            }
        }
        if (lineLength < 32) {
            for (int i=lineLength; i<32; i++) {
                currentLine += "0";
            }

            out.add(currentLine);
        }

        out.add("xxxx");

        for (String s: dictionary) {
            out.add(s);
        }

        return out;
    }

    public static void runLengthEncoding(ArrayList<String> compressed) {
        Stack<String> s = new Stack<>();
        int index = 0;

        while (!compressed.isEmpty()) {
            if (s.empty()) {
                s.push(compressed.get(0));
                compressed.remove(compressed.get(0));
            } else if (!s.peek().equals(compressed.get(0))) {
                s.push(compressed.get(0));
                compressed.remove(compressed.get(0));
            } else {
                int counter = 0;
                while (!compressed.isEmpty() && compressed.get(0).equals(s.peek()) && counter < 8) {
                    compressed.remove(0);
                    counter++;
                }
                s.push("001" + dec_to_bin_3bit(counter-1));
            }
        }

        Object[] objectArray = s.toArray();

        String[] stringArray = Arrays.copyOf(objectArray, objectArray.length, String[].class);

        for (String st: stringArray) {
            compressed.add(st);
        }
    }

    public static ArrayList<String> parseDecompressionInput() {
        ArrayList<String> out = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("compressed.txt"));

            String in = br.readLine();

            while (in != null) {
                out.add(in);
                in = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out;
    }

    public static ArrayList<String> decompress(ArrayList<String> compressed) {
        String megaBufferExtreme = "";
        ArrayList<String> decompressed = new ArrayList<>();
        ArrayList<String> dictionary = new ArrayList<>();
        boolean flag = false;
        for (String s: compressed) {
            if (s.equals("xxxx")) {
                flag = true;
                continue;
            }

            if (!flag) {
                megaBufferExtreme += s;
            } else {
                dictionary.add(s);
            }

        }

        lineDecompress(megaBufferExtreme, dictionary, decompressed, "");
        return decompressed;
    }

    private static String lineDecompress(String s, ArrayList<String> dictionary, ArrayList<String> decompressed, String lastInstruction) {
        if (s.length() < 3) {
            System.out.println("somethings weird");
            return "";
        }
        String compressionType = s.substring(0,3);
        String decompressedLine = "";
        String startingLoc = "";
        String dictionaryIndex = "";
        switch(compressionType) {
            case "000":
                if (s.length() < 35) {
                    break;
                }
                decompressedLine = s.substring(3,35);
                decompressed.add(decompressedLine);
                lastInstruction = decompressedLine;
                lineDecompress(s.substring(35), dictionary,  decompressed, lastInstruction);
                break;
            case "001":
                String repeating = s.substring(3,6);

                for (int i=0; i<bin_to_dec_3bit(repeating) + 1; i++) {
                    decompressed.add(lastInstruction);
                }

                lineDecompress(s.substring(6), dictionary, decompressed, lastInstruction);
                break;
            case "010":
                startingLoc = s.substring(3, 8);
                String bitMask = s.substring(8,12);
                dictionaryIndex = s.substring(12,16);

                decompressedLine = bitmaskDecompression(startingLoc, bitMask, dictionaryIndex, dictionary);
                decompressed.add(decompressedLine);
                lastInstruction = decompressedLine;

                lineDecompress(s.substring(16), dictionary, decompressed, lastInstruction);
                break;
            case "011":
                startingLoc = s.substring(3, 8);
                dictionaryIndex = s.substring(8,12);

                decompressedLine = bitMismatchDecompression(startingLoc, dictionaryIndex, dictionary);
                lastInstruction = decompressedLine;
                decompressed.add(decompressedLine);

                lineDecompress(s.substring(12), dictionary, decompressed, lastInstruction);
                break;
            case "100":
                startingLoc = s.substring(3,8);
                dictionaryIndex = s.substring(8,12);

                decompressedLine = twoBitMismatchDecompression(startingLoc, dictionaryIndex, dictionary);
                lastInstruction = decompressedLine;
                decompressed.add(decompressedLine);

                lineDecompress(s.substring(12), dictionary, decompressed, lastInstruction);
                break;
            case "101":
                startingLoc = s.substring(3,8);
                dictionaryIndex = s.substring(8,12);

                decompressedLine = fourBitMismatchDecompression(startingLoc, dictionaryIndex, dictionary);
                lastInstruction = decompressedLine;
                decompressed.add(decompressedLine);

                lineDecompress(s.substring(12), dictionary, decompressed, lastInstruction);
                break;
            case "110":
                startingLoc = s.substring(3,8);
                String startingLoc2 = s.substring(8,13);
                dictionaryIndex = s.substring(13,17);

                decompressedLine = twoBitMismatchesDecompression(startingLoc, startingLoc2, dictionaryIndex, dictionary);
                lastInstruction = decompressedLine;
                decompressed.add(decompressedLine);

                lineDecompress(s.substring(17), dictionary, decompressed, lastInstruction);
                break;
            case "111":
                dictionaryIndex = s.substring(3,7);

                decompressedLine = dictionary.get(bin_to_dec_4bit(dictionaryIndex));
                lastInstruction = decompressedLine;
                decompressed.add(decompressedLine);

                lineDecompress(s.substring(7), dictionary, decompressed, lastInstruction);
                break;
            default:
                System.out.println("Somethings messed up");
                return "";
            }

            return "";
        }

    private static String twoBitMismatchesDecompression(String startingLoc, String startingLoc2, String dictionaryIndex, ArrayList<String> dictionary) {
        String intermediate = bitMismatchDecompression(startingLoc, dictionaryIndex, dictionary);
        int startingIndex2 = bin_to_dec_5bit(startingLoc2);

        Character newChar;
        if (intermediate.charAt(startingIndex2) == '0') {
            newChar = '1';
        } else {
            newChar = '0';
        }

        return intermediate.substring(0,startingIndex2) + newChar + intermediate.substring(startingIndex2 + 1);
    }

    private static String fourBitMismatchDecompression(String startingLoc, String dictionaryIndex, ArrayList<String> dictionary) {
        int startingIndex = bin_to_dec_5bit(startingLoc);
        String dic = dictionary.get(bin_to_dec_4bit(dictionaryIndex));

        String update = "";

        for (int i=startingIndex; i<startingIndex+4; i++) {
            if (dic.charAt(i) == '0') {
                update += '1';
            } else {
                update += '0';
            }
        }

        return dic.substring(0,startingIndex) + update + dic.substring(startingIndex+4);
    }

    private static String twoBitMismatchDecompression(String startingLoc, String dictionaryIndex, ArrayList<String> dictionary) {
        int startingIndex = bin_to_dec_5bit(startingLoc);
        String dic = dictionary.get(bin_to_dec_4bit(dictionaryIndex));

        String update = "";

        for (int i=startingIndex; i<startingIndex+2; i++) {
            if (dic.charAt(i) == '0') {
                update += '1';
            } else {
                update += '0';
            }
        }

        return dic.substring(0,startingIndex) + update + dic.substring(startingIndex+2);

}

    private static String bitMismatchDecompression(String startingLoc, String dictionaryIndex, ArrayList<String> dictionary) {
        int startingIndex = bin_to_dec_5bit(startingLoc);
        String dic = dictionary.get(bin_to_dec_4bit(dictionaryIndex));

        Character newChar;
        if (dic.charAt(startingIndex) == '0') {
            newChar = '1';
        } else {
            newChar = '0';
        }

        return dic.substring(0,startingIndex) + newChar + dic.substring(startingIndex+1);
    }

    private static String bitmaskDecompression(String startingLoc, String bitMask, String dictionaryIndex, ArrayList<String> dictionary) {
        String dic = dictionary.get(bin_to_dec_4bit(dictionaryIndex));
        int startingIndex = bin_to_dec_5bit(startingLoc);

        String importantPart = dic.substring(startingIndex, startingIndex+4);

        int a = Integer.parseInt(importantPart, 2);
        int b = Integer.parseInt(bitMask , 2);

        int res = a ^ b;

        String result = dec_to_bin(res);

        return dic.substring(0,startingIndex) + result + dic.substring(startingIndex+4);

    }

    private static void writeCompressionFile(ArrayList<String> formatted) {
        try {
            PrintWriter p = new PrintWriter("cout.txt", "UTF-8");

            for (String s: formatted) {
                p.println(s);
            }

            p.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void writeDecompressionFile(ArrayList<String> decompressed) {
        try {
            PrintWriter p = new PrintWriter("dout.txt", "UTF-8");

            for (String s: decompressed) {
                p.println(s);
            }

            p.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("USAGE: java SIM 1 || java SIM 2");
            System.exit(0);
        }

        if (args[0].equals("1")) {
            ArrayList<String> uncompressed = new ArrayList<>();
            ArrayList<String> dictionary = input_parse(uncompressed);
            ArrayList<String> compressed = compress(uncompressed, dictionary);
            ArrayList<String> formatted = formatCompressedFile(compressed, dictionary);
            writeCompressionFile(formatted);
        } else if (args[0].equals("2")){
            ArrayList<String> decompressionInput = parseDecompressionInput();
            ArrayList<String> decompressed = decompress(decompressionInput);
            writeDecompressionFile(decompressed);
        } else {
            System.out.println("USAGE: java SIM 1 || java SIM 2");
            System.exit(0);
        }

    }
}
