import java.util.Random;

public class Main {
	private static double testUF(UF uf,int m) {
		int size = uf.getSize();
		Random random = new Random();
		
		long startTime = System.nanoTime();
		
		for(int i=0;i<m;i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			uf.unionElements(a, b);
		}
		
		for(int i=0;i<m;i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			uf.isConnected(a, b);
		}
		
		
		long endTime = System.nanoTime();
		
		return (endTime-startTime)/1000000000.0;
	}
	
	public static void main(String[] args) {
		int size = 100000;
		int m = 100000; // 如果增大m，会发现UF2更耗时
		UnionFind1 uf1 = new UnionFind1(size);
		System.out.println("UnionFind1:" + testUF(uf1,m)+" s"); // 7.7569s
		
		UnionFind2 uf2 = new UnionFind2(size);
		System.out.println("UnionFind2:" + testUF(uf2,m)+" s"); // 12.568s
		
		UnionFind3 uf3 = new UnionFind3(size);
		System.out.println("UnionFind3:" + testUF(uf3,m)+" s"); // 0.0333s
		
		UnionFind4 uf4 = new UnionFind4(size);
		System.out.println("UnionFind4:" + testUF(uf4,m)+" s"); // 0.017s
	}
}
