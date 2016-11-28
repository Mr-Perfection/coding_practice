// TODO: create the User class/object
// it must support rank, progress, and the incProgress(int rank) method
import java.lang.*;
import java.util.*;
import java.security.InvalidParameterException;
public class User {
    public int rank = -8;
    public int progress;

    public void incProgress(int rank) {
        if (rank < -8 || rank == 0 || rank > 8) {
            throw new InvalidParameterException();
        }

        int rankDiff = getInnerRank(rank) - getInnerRank(this.rank);
        if (rankDiff == 0) {
            progress += 3;
        } else if (rankDiff == -1) {
            progress += 1;
        } else if (rankDiff > 0) {
            progress += (10 * rankDiff * rankDiff);
        }
        if (progress > 100) {
            int rankBefore = this.rank;
            this.rank += progress / 100;
            progress %= 100;

            if (rankBefore < 0 && this.rank >= 0) {
                this.rank += 1;
            }
        }
        if (this.rank >= 8) {
            this.rank = 8;
            progress = 0;
        }
    }

    private int getInnerRank(int rank) {
        return rank > 0 ? rank - 1 : rank;
    }
}



//better solution.. Impressive
import java.util.Arrays;
public class User {
  private int[] ranks = {-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8};
  private int curRank = 0;
  public int progress = 0;
  public int rank = -8;
  public void incProgress(int kRank) {
    kRank = Arrays.binarySearch(ranks, kRank);
    if(kRank < 0) throw new RuntimeException("Invalid rank");
    if(ranks[curRank] == 8) return;
    if(kRank == curRank) progress += 3;
    else if(kRank == curRank - 1) progress++;
    else if(kRank > curRank) {
      int diff = kRank - curRank;
      progress += 10 * diff * diff;
    }
    while(progress >= 100) {
      curRank++;
      updateRank();
      progress -= 100;
      if(ranks[curRank] == 8) {
        progress = 0;
        return;
      }
    }
  }
  private void updateRank() {
    rank = ranks[curRank];
  }
}