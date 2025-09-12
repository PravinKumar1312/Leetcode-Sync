class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {
            int lineLen = words[i].length();
            int last = i + 1;
            while (last < n) {
                if (lineLen + 1 + words[last].length() > maxWidth) break;
                lineLen += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int numWords = last - i;
            if (last == n || numWords == 1) {
                for (int j = i; j < last; j++) {
                    sb.append(words[j]);
                    if (j < last - 1) sb.append(' ');
                }
                int remaining = maxWidth - sb.length();
                while (remaining-- > 0) sb.append(' ');
            } else {
                int totalSpaces = maxWidth - lineLen + (numWords - 1);
                int spaces = totalSpaces / (numWords - 1);
                int extra = totalSpaces % (numWords - 1);

                for (int j = i; j < last; j++) {
                    sb.append(words[j]);
                    if (j < last - 1) {
                        for (int s = 0; s < spaces + (j - i < extra ? 1 : 0); s++) {
                            sb.append(' ');
                        }
                    }
                }
            }
            res.add(sb.toString());
            i = last;
        }
        return res;
    }
}
