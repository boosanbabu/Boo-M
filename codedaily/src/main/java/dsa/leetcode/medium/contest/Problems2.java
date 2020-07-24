package dsa.leetcode.medium.contest;

import java.util.*;

public class Problems2 {
    public static void main(final String[] args)

    {
        final Problems2 p = new Problems2();
        // final String[][] k = { { "David", "3", "Ceviche" }, { "Corina", "10", "Beef
        // Burrito" },
        // { "David", "3", "Fried Chicken" }, { "Carla", "5", "Water" }, { "Carla", "5",
        // "Ceviche" },
        // { "Rous", "3", "Ceviche" } };

        // final List<List<String>> inp = new ArrayList<>();
        // for (final String[] a : k) {
        // inp.add(Arrays.asList(a));
        // }
        // p.displayTable(inp);
        int r = p.minNumberOfFrogs("corak");
        System.out.println(r);

    }

    public List<List<String>> displayTable(final List<List<String>> orders) {
        final List<List<String>> result = new ArrayList<>();
        final Map<String, Integer> map = new HashMap<>();
        final Set<String> allItems = new TreeSet<>();
        final Set<Integer> allTables = new TreeSet<>();
        for (final List<String> l : orders) {
            allTables.add(Integer.valueOf(l.get(1)));
            allItems.add(l.get(2));
            final String k = l.get(1) + "-" + l.get(2);
            final int val = map.getOrDefault(k, 0);
            map.put(k, val + 1);
        }
        final List<String> header = new ArrayList<>();
        header.add("Table");
        for (final String item : allItems) {
            header.add(item);
        }
        result.add(header);
        for (final Integer t : allTables) {
            final List<String> rec = new ArrayList<>();
            final String table = Integer.toString(t);
            rec.add(table);
            for (final String item : allItems) {
                final int count = map.getOrDefault(table + "-" + item, 0);
                rec.add(Integer.toString(count));
            }
            result.add(rec);
        }
        return result;
    }

    public String reformat(final String s) {
        if (s.length() == 0)
            return "";
        final Queue<Character> digits = new LinkedList<>();
        final Queue<Character> alp = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digits.add(s.charAt(i));
            } else {
                alp.add(s.charAt(i));
            }
        }
        final int d = digits.size(), c = alp.size();
        if (Math.abs(d - c) > 1)
            return "";
        final StringBuffer sb = new StringBuffer();

        if (c > d) {
            sb.append(alp.remove());
            while (!alp.isEmpty()) {
                sb.append(digits.remove());
                sb.append(alp.remove());
            }
        } else if (c < d) {
            sb.append(digits.remove());
            while (!alp.isEmpty()) {
                sb.append(alp.remove());
                sb.append(digits.remove());
            }
        } else {
            while (!alp.isEmpty()) {
                sb.append(alp.remove());
                sb.append(digits.remove());
            }
        }
        return sb.toString();
    }

    public int minNumberOfFrogs(final String croakOfFrogs) {
        final String croak = "croak";
        final int[] arr = new int[croak.length()];
        Arrays.fill(arr, 0);
        int completed = 0;
        for (final Character c : croakOfFrogs.toCharArray()) {
            if (validChar(c, arr, croak)) {
                completed += addCharToArr(c, arr, croak, completed);
            }
        }
        if (!identicalelements(arr))
            return -1;
        return arr[0];
    }

    private boolean identicalelements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1])
                return false;
        }
        return true;
    }

    private int addCharToArr(final Character c, final int[] arr, final String croak, final int completed) {
        int idx = croak.indexOf(c);
        if (idx == 0 && arr[idx] > 0 && completed > 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i]--;
            }
        }

        arr[idx]++;
        if (idx == arr.length - 1)
            return 1;
        return 0;
    }

    private boolean validChar(final Character c, final int[] arr, final String croak) {
        int idx = croak.indexOf(c);
        if (idx == 0)
            return true;
        return arr[idx - 1] >= arr[idx] + 1;
    }
}