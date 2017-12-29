/**
 * Created by a123 on 29/12/2017.
 */
//N皇后问题，是回溯算法的典型案例，在8*8格的国际象棋上摆放8个皇后，使其不能互相攻击，即任意两个皇后不能处在同一行
  //  同一列，或者同一斜线上
public class QueensProblem {
    int N;
    int[] a;
    int count = 0;
    //将要打印出来的数组
    char[] grid;


    public QueensProblem(int n){
        this.N = n;
        a = new int[n];
        grid = new char[n*n];

        for (int i=0; i < n; i++){
            a[i] = -1;
        }
    }



    public int soLution(){

        for(int j = 0; j < N; j++){
            //在第一行的某一列放置棋子是否是合法的
            if(place(0,j)){
                for(int ki = 0 ;ki < N; ki++){
                    System.out.print(a[ki]);
                }
                System.out.println();

            }
        }

        return count;
    }


    //将棋子放在第i行第列时，判断其是否是合法的
    public boolean place(int i,int j){
        if(i<0 || i > N - 1 || j < 0 || j > N - 1){
            return false;
        }
        a[i] = j;
        //验证是否是符合规则的
        for(int k =0;k < i; k++){
            if(a[k] != a[i]&& Math.abs(a[k] - a[i]) != Math.abs(k - i)) {
                continue;
            }
            return false;
        }

        if(i == N - 1){
            place(i,j+1);
            count++;
            for(int num = 0;num<N*N;num++){
                grid[num] = '+';
            }
            System.out.println("第" + count + "方案：");
            for(int num = 0;num<N;num++){
                grid[num*8 + a[num]] = 'O';
            }
            for(int num = 0;num<N*N;num++){
                System.out.print(grid[num] +" ");
                if((num +1)%8 == 0){
                    System.out.println();
                }
            }

            return true;
        }

         for(int l=0;l<N;l++){
             place(i + 1,l);

                }

        return false;
    }


    public static void main(String[] args){
        System.out.print(new QueensProblem(8).soLution());
    }
}

