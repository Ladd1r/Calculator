class Roman {
    public static String[] numbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static boolean check(String[] blocks) {
        boolean flag = false;
        for (int i = 0; i < Roman.numbers.length; i++) {
            if (Roman.numbers[i].equals(blocks[0]) || Roman.numbers[i].equals(blocks[1]))
                flag = true;
        }
        return flag;
    }

    public static int toNumber(String block){
        switch (block){
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
            default: return 0;
        }
    }

    public static String toRoman(int number){
        String[] rDigits = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] aDigits = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String finalResult = "";
        if (number < 1)
            throw new IllegalArgumentException("В римской системе нет 0 и отрицательных чисел");
        int i = 0;
        while (number > 0) {
            while (aDigits[i] > number)
                i++;
            finalResult += rDigits[i];
            number -= aDigits[i];
        }
        return finalResult;
    }
}
