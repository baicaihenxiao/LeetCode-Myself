package club.cser.leetcode;

class NimGame {
    public boolean canWinNim(int n) {
        if (n % 4 == 0)
            return false;
        else
            return true;
    }
}