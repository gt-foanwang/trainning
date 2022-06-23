package codility;

import java.util.HashSet;
import java.util.Set;

public class codility {
    public int Iterations(int N) {
        int max = 0;
        int temp = 0;
        int index = 0;
        String binary = Integer.toBinaryString(N);
        while (index < binary.length()) {
            if (binary.charAt(index) == '1') {
                index++;
                temp = 0;
                while (index < binary.length() && binary.charAt(index) == '0') {
                    temp++;
                    index++;
                }
                if (index >= binary.length()) {
                    temp = 0;
                }
            } else {
                index++;
            }
            max = Math.max(max, temp);
        }

        return max;
    }

    public int[] CyclicRotation(int[] A, int K) {
        if (A.length == 0 || A.length == 1 || A.length == K) {
            return A;
        }
        K = K % A.length;
        int[] reply = new int[A.length];

        for (int i = 0; i < A.length - K; i++) {
            reply[i + K] = A[i];
        }
        for (int j = 0; j < K; j++) {
            reply[j] = A[A.length - K + j];
        }

        return reply;
    }

    public int OddOccurrencesInArray(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        int reply = 0;
        for (int i = 0; i < A.length; i++) {
            reply ^= A[i];
            System.out.println(reply);
        }


        return reply;
    }

    public int OddOccurrencesInArray2(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        HashSet<Integer> dups = new HashSet<Integer>();
        int elem = -1;
        for (int i = 0; i < A.length; i++) {
            if (dups.add(A[i])) {
                elem = A[i];
                System.out.println("elem[i]:" + elem);
            }
//			  for(Integer element : dups) {
//			        System.out.println("dup[j]:"+element);
//			    }
        }
        return elem;
    }

    public int PermMissingElem(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int arraysum = 0;
        int count = (1 + A.length + 1) * (A.length + 1) / 2;
        for (int i = 0; i < A.length; i++) {
            arraysum += A[i];
        }
        return count - arraysum;
    }

    public int FrogJmp(int X, int Y, int D) {
        int step = 0;
        if (Y <= 0) {
            return step;
        }
        if (X >= Y) {
            return step;
        }
        int diff = Y - X;
        if (diff % D == 0)
            return diff / D;
        else
            return diff / D + 1;

    }

    public int TapeEquilibrium(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int reply = Integer.MAX_VALUE;
        int prev = 0;
        int next = sum;

        for (int p = 1; p < A.length; p++) {
            prev += A[p - 1];
            next = sum - prev;
            reply = Math.min(reply, Math.abs(prev - next));
        }

        return reply;
    }

    public int PermCheck(int[] A) {
        int sum = (1 + A.length) * A.length / 2;
        int listsum = 0;
        Set<Integer> temp = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            temp.add(A[i]);
            listsum += A[i];
        }
        if (temp.size() != A.length) {
            return 0;
        }
        if (sum == listsum) {
            return 1;
        } else {
            return 0;
        }
    }

    public int FrogRiverOne(int X, int[] A) {
        Set<Integer> temp = new HashSet<Integer>();
        for (int i = 1; i <= X; i++) {
            temp.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            temp.remove(A[i]);
            if (temp.size() == 0) {
                return i;
            }
        }
        return -1;
    }

    public int[] MaxCounters(int N, int[] A) {
        int[] reply = new int[N];
        for (int i = 0; i < N; i++) {
            reply[i] = 0;
        }
        int max = 0;
        int lastmax = 0;
        for (int i = 0; i < A.length; i++) {
            if (1 <= A[i] && A[i] <= N) {
                reply[A[i] - 1] = Math.max(reply[A[i] - 1], lastmax);
                reply[A[i] - 1] += 1;
                max = Math.max(max, reply[A[i] - 1]);
            } else if (A[i] == N + 1) {
                lastmax = max;
            }
        }
        for (int i = 0; i < reply.length; i++) {
            reply[i] = Math.max(reply[i], lastmax);
        }
        return reply;
    }

    public int MissingInteger(int[] A) {

        Set<Integer> temp = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            temp.add(A[i]);
        }

        for (int i = 0; i < A.length; i++) {
            if (temp.contains(i + 1) != true) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    public int PassingCars(int[] A) {

        return 1;
    }

    public int[] GenomicRangeQuery(String S, int[] P, int[] Q) {
        int M = 0;
        if (P.length != Q.length) {
            return null;
        }

        M = P.length;
        int[] reply = new int[M];
        for (int i = 0; i < M; i++) {
            reply[i] = checkRange(S.substring(P[i], Q[i] + 1));
//			System.out.print("reply["+i+"]: " +checkRange(temp));
        }
//		for(int i =0; i < reply.length;i++) {
//			System.out.print("reply["+i+"]: " +reply[i]+" ");
//		}
        return reply;
    }

    public int checkRange(String Str) {
        Set<Character> check = new HashSet<Character>();
        for (int i = 0; i < Str.length(); i++) {
            check.add(Str.charAt(i));
        }
//		for(Character temp : check) {
//			System.out.println("char:"+temp);
//		}
        if (check.contains('A')) {
            return 1;
        } else if (check.contains('C')) {
            return 2;
        } else if (check.contains('G')) {
            return 3;
        } else {
            return 4;
        }
    }


    public static void main(String[] args) {
        codility temp = new codility();
        System.out.println("reply:" + temp.GenomicRangeQuery("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }
}