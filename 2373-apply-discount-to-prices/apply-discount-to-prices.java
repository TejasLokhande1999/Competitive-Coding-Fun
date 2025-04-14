class Solution {


 public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (isValidPrice(word)) {
                double amount = Double.parseDouble(word.substring(1));
                double discounted = amount - (amount * discount / 100);
                result.append(String.format("$%.2f", discounted));
            } else {
                result.append(word);
            }
            result.append(" ");
        }

        return result.toString().trim(); // remove trailing space
    }

    private boolean isValidPrice(String word) {
        if (word.length() < 2 || word.charAt(0) != '$') return false;

        for (int i = 1; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i))) return false;
        }

        return true;
    }
   
   
}