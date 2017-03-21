import java.util.Scanner;

/*
A function is defined as follows :
GF(A,B,0)=A
GF(A,B,1)=B
GF(A,B,N)= GF(A,B,N-1)+GF(A,B,N-2) where N>1
Given 3 non negative numbers A B N returns remainder from division by 1000000007
For example given A =3 B=4 n =5 the function should return 29 BECAUSE
GF(3,4,0)= 3 mod 1000000007 = 3
GF(3,4,1)= 4 mod 1000000007 = 4
GF(3,4,2)= (GF(3,4,0)+GF(3,4,1)) mod 1000000007 =7
GF(3,4,3)= (GF(3,4,1)+GF(3,4,2)) mod 1000000007 =11
GF(3,4,4)= (GF(3,4,2)+GF(3,4,3)) mod 1000000007 =18
GF(3,4,5)= (GF(3,4,3)+GF(3,4,4)) mod 1000000007 =29
Can anyone solve this question in
time complexity: O(logN)
space complexity: O(1)

Solution:
G(a, b, 0) =  a
G(a, b, 1) =  b
G(a, b, 2) =  a +  b
G(a, b, 3) =  a + 2b
G(a, b, 4) = 2a + 3b
G(a, b, 5) = 3a + 5b
G(a, b, 6) = 5a + 8b
G(a, b, 7) = 8a + 13b

G(A, B, N)  = A                      for N = 0
            = F(N-1)*A + F(N)*B      for all N > 0 */

public class Fibonacci_number {
	static final int MOD = 1000000007;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a: ");
		int a = sc.nextInt();
		System.out.println("Input b: ");
		int b = sc.nextInt();
		System.out.println("Input n: ");
		int n = sc.nextInt();
		
		System.out.println(fib(a,b,n));
	}
	
	public static int fib(int a, int b, int n){
		long[][] F = new long[][]{{1,1},{1,0}};
		if(n==0){
			return a % MOD;
		} else {
			helpFib(F, n-1);
			System.out.println(F[0][0] + " " + F[0][1] + " " + F[1][0] + " " + F[1][1]);
			return (int)((a%MOD)*(F[1][1]%MOD) + (b%MOD)*(F[0][1]%MOD))%MOD;
		}
	}
	
	public static void helpFib(long[][] F, int n){
		int[][] M = new int[][]{{1,1},{1,0}};
		for(int i = 0; i < n; ++i){
			System.out.println("Inhelp: " + F[0][0] + " " + F[0][1] + " " + F[1][0] + " " + F[1][1]);
			MatrixMultiply(F,M);
		}
	}
	
	public static void MatrixMultiply(long[][] F, int[][] M){
		long f00 = (F[0][0]*M[0][0] + F[0][1]*M[1][0]) % MOD;
		long f01 = (F[0][0]*M[0][1] + F[0][1]*M[1][1]) % MOD;
		long f10 = (F[1][0]*M[0][0] + F[1][1]*M[1][0]) % MOD;
		long f11 = (F[1][0]*M[0][1] + F[1][1]*M[1][1]) % MOD;
		
		F[0][0] = f00;
		F[0][1] = f01;
		F[1][0] = f10;
		F[1][1] = f11;
	}
}
