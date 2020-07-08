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
		int size = 10000000;
		int m = 10000000;

		UnionFind3 uf3 = new UnionFind3(size);
		System.out.println("UnionFind3:" + testUF(uf3,m)+" s"); // 7.1665s
		
		UnionFind4 uf4 = new UnionFind4(size);
		System.out.println("UnionFind4:" + testUF(uf4,m)+" s"); // 7.8199s
		
		UnionFind5 uf5 = new UnionFind5(size);
		System.out.println("UnionFind5:" + testUF(uf5,m)+" s"); // 5.5789s
		
		UnionFind6 uf6 = new UnionFind6(size);
		System.out.println("UnionFind6:" + testUF(uf6,m)+" s"); // 5.9180s
	}
}
