public class test66_plusone {
  public int[] plusOne(int[] digits) {
    List<Integer> ret = new ArrayList<>();

    int buff = 1;
    int remain = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      remain = (digits[i] + buff) % 10;
      buff = (digits[i] + buff) / 10;
      ret.add(0, remain);
    }
    if (buff > 0) {
      ret.add(0, buff);
    }

    int[] retInts = new int[ret.size()];
    for (int i = 0; i < ret.size(); i++) {
      retInts[i] = ret.get(i);
    }
    return retInts;
  }
}
