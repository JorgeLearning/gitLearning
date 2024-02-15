import java.util.*;
import graphics.*;

public class Main {
    public static void main(String[] args) {
	Random random = new Random();
	int n = random.nextInt(20) + 1;
	VideoGame3 round1 = new VideoGame3(n, 10, 10);
	round1.menu();
    }
}
