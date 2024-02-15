import java.util.*;

public class UseMaps {
    public static void main(String[] args) {
	/*Random random = new Random();
	Map<String, Soldier> names = new HashMap<>();
	Map<Integer, Soldier> troop = new HashMap<>();

	int n = random.nextInt(20) + 1;

	for(int i = 0; i < n; i++) {
	    Soldier x = new Soldier();
	    x.setPoints(random.nextInt(5) + 1);
	    x.setName("soldier" + i);
	    names.put(x.getName(), x);
	    troop.put(i, x);
	}

	// ordenacion ingeniada 
	long start = System.nanoTime();
	Map <Integer, Soldier> sort = new HashMap<>();
	int j = 0;
	while(names.size() != 0) {
	    int max = Integer.MIN_VALUE;
	    Soldier god = null;
	    for(String i : names.keySet()) {
		if(names.get(i).getPoints() > max) {
		    max = names.get(i).getPoints();
		    god = names.get(i);
		}
	    }
	    sort.put(j, god);
	    names.remove(god.getName());
	    j++;
	}
	long end = System.nanoTime();

	for(int i = 0; i < sort.size(); i++) {
	    System.out.println(i + ": " + sort.get(i).getPoints());
	}
	System.out.println("\nTiempo: " + (end - start) + "\n");
	
	// insertionSort
	start = System.nanoTime();
	int h; Soldier current;
	for(int i = 1; i < troop.size(); i++){
	    j = i - 1;
	    current = troop.get(i);
	    while(j >= 0 && troop.get(j).getPoints() < current.getPoints()){
		troop.put(j + 1, troop.get(j));
		j--;
	    }
	    troop.put(j + 1, current);
	}
	end = System.nanoTime();

	for(int i = 0; i < troop.size(); i++) {
	    System.out.println(i + ": " + troop.get(i).getPoints());
	}
	System.out.println("Tiempo: " + (end - start));*/ 
	
	Map<Integer, String> names = new HashMap<>();
	names.put(19, "Jorge");
	names.put(6, "Alvaro");
	names.put(2, "Adrian");
	names.put(16, "Ricardo");
	names.put(5, "Victor");
	names.put(3, "Gustavo");
	names.put(7, "Jhonatan");
	names.put(4, "Jhossep");
	names.put(8, "Deniss");
	names.put(11, "Pablo");
	names.put(9, "Jorgito");

	System.out.println(names.get("x") + "\n");
       
	for(Integer i : names.keySet())
	    System.out.println("clave: " + i + ", valor: " + names.get(i));
       
	System.out.println();
	for(String j : names.values())
	    System.out.println("valor: " + j);
       
	System.out.println();   
	Set<Map.Entry<Integer, String>> iterable = names.entrySet();

	for(Map.Entry<Integer, String> i : iterable)
	    System.out.println("Clave: " + i.getKey() + ", valor: " + i.getValue());

    }
}
