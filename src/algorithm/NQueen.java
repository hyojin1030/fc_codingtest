package algorithm;

import java.util.ArrayList;

public class NQueen {
    public void dfs(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {
        if (currentRow == N) {
            System.out.println(currentCandidate);
            return;
        }

        for (int index = 0; index < N; index++) {
            if (this.isAvailable(currentCandidate, index) == true) {
                currentCandidate.add(index);
                this.dfs(N, currentRow + 1, currentCandidate);
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    private boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {
        Integer currentRow = candidate.size();

        for (int index = 0; index < currentRow; index++) {
            if ((candidate.get(index) == currentCol) || (Math.abs(candidate.get(index) - currentCol) == currentRow - index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.dfs(4, 0, new ArrayList<Integer>());
    }
}
