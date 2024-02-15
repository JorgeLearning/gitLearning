import java.util.*;
import graphics.*;

public class VideoGame3 {
    private Map <Integer, Soldier> troop1;
    private Map <Integer, Soldier> troop2;
    private Picture[][] batteRoyale;

    public VideoGame3(int n, int r, int c) { 
	Random random = new Random();
	Map <Integer, Soldier> troop1 = new HashMap<>();
        Map <Integer, Soldier> troop2 = new HashMap<>();
	Picture[][] batteRoyale = new Picture[r][c];

	//create batteRoyale
	for (int i = 0; i < r; i++) {
	    for(int j = 0; j < c; j++){
		batteRoyale[i][j] = Picture.table();
	    }
	}

	int i = 0, a1 = 0, a2 = 0;
	do {
	    while( i < n ){
		int x = random.nextInt(10);
		int y = random.nextInt(10);

		if(compare(batteRoyale[x][y].getImg(), Picture.table().getImg())) { 
		    if (random.nextBoolean() & a1 < 10) {
			troop1.put(a1, new Soldier());
			troop1.get(a1).setName("Soldier" + i);
			troop1.get(a1).setPoints(random.nextInt(5) + 1);
			troop1.get(a1).setRow(x);
			troop1.get(a1).setColumn(y);
			troop1Points(batteRoyale, x, y, troop1.get(a1));
			a1++;
			i++;
		    } else {
			if (a2 < 10) {
			    troop2.put(a2, new Soldier());
			    troop2.get(a2).setName("Soldier" + i);
			    troop2.get(a2).setPoints(random.nextInt(5) + 1);
			    troop2.get(a2).setRow(x);
			    troop2.get(a2).setColumn(y);
			    troop2Points(batteRoyale, x, y, troop2.get(a2));
			    a2++;
			    i++;
			}
		    }
		}
	    }
        } while (troop1.isEmpty() || troop2.isEmpty());
	
	this.troop1 = troop1;
	this.troop2 = troop2;
	this.batteRoyale = batteRoyale;

	Graphics g = new Graphics(Picture.mergePicture(batteRoyale));
	g.print();
    }
	
    private boolean compare(String[] a, String[] b) {
	if(a.length != b.length)
	    return false;

	int i = 0;
	while(i < a.length) {
	    if(a[i].equals(b[i]))
		i++;
	    else
		return false;
	}
	return true;
    }

    private void troop1Points(Picture[][] batteRoyale, int x, int y, Soldier soldier) {
	    switch (soldier.getPoints()) {
	        case 1 :
		        batteRoyale[x][y] = Picture.soldier1().superponer(batteRoyale[x][y]); break;
	        case 2 :
		        batteRoyale[x][y] = Picture.soldier2().superponer(batteRoyale[x][y]); break;
	        case 3 :
		        batteRoyale[x][y] = Picture.soldier3().superponer(batteRoyale[x][y]); break;
	        case 4 :
		        batteRoyale[x][y] = Picture.soldier4().superponer(batteRoyale[x][y]); break;
	        default:
		        batteRoyale[x][y] = Picture.soldier5().superponer(batteRoyale[x][y]); break;
	    }
    }

    private void troop2Points(Picture[][] batteRoyale, int x, int y, Soldier soldier) {
	    switch (soldier.getPoints()) {
	        case 1 :
		        batteRoyale[x][y] = Picture.soldier1().invertir().superponer(batteRoyale[x][y]); break;
	        case 2 :
		        batteRoyale[x][y] = Picture.soldier2().invertir().superponer(batteRoyale[x][y]); break;
	        case 3 :
		        batteRoyale[x][y] = Picture.soldier3().invertir().superponer(batteRoyale[x][y]); break;
	        case 4 :
		        batteRoyale[x][y] = Picture.soldier4().invertir().superponer(batteRoyale[x][y]); break;
	        default:
		        batteRoyale[x][y] = Picture.soldier5().invertir().superponer(batteRoyale[x][y]); break;
	    }	
    }

    private Map <Integer, Soldier> ranking(Map <Integer, Soldier> troop) {
	    int j; Soldier current;
	    for(int i = 1; i < troop.size(); i++){
	        j = i - 1;
	        current = troop.get(i);
	        while(j >= 0 && troop.get(j).getPoints() < current.getPoints()){
		        troop.put(j + 1, troop.get(j));
		        j--;
	        }
	        troop.put(j + 1, current);
	    }
	    return troop;
    }

    private void information(Map <Integer, Soldier> troop) {
	    for(int i = 0; i < troop.size(); i++)
	        System.out.println(troop.get(i).toString()); 
    }

    private String soldierGod(Map <Integer, Soldier> troop) {
	    String soldier = troop.get(0).toString();
	    int point = troop.get(0).getPoints();
	    
        for(int i = 1; i < troop.size(); i++) {
	        if(troop.get(i).getPoints() > point) {
		        point = troop.get(i).getPoints();
		        soldier = troop.get(i).toString();
	        }
	    }
	    return soldier;
    }
    
    private int average(Map <Integer, Soldier> troop) {
	    int n = 0;
	    for(Soldier i : troop.values())
	        n += i.getPoints();

	    n = n / troop.size();
	    return n;
    }

    private String victory(Map <Integer, Soldier> troop1, Map <Integer, Soldier> troop2) {
	int p1 = 0, p2 = 0;
	for(Soldier i : troop1.values())
	    p1 += i.getPoints();
	for(Soldier i : troop2.values())
	    p2 += i.getPoints();

	if(p1 != p2) {
	    if(p1 > p2)
		return "\nEjército green, victoria! " + p1 + " de vida";
	    return "\nEjército orange, victoria! " + p2 + " de vida";
	} else {
	    if(troop1.size() == troop2.size())
		return "\nBrutal empate!";
	    if(troop1.size() > troop2.size())
		return "\nEjército green, victoría" + troop1.size() + " soldados";
	    return "\nEjército orange, victoría" + troop2.size() + " soldados";
	}

    }

    public void menu() {
	Scanner sc = new Scanner(System.in);
	String option;
	boolean w = true;
	while(w) {
	    System.out.println("\n=======Batte Royale========");
	    System.out.println("1. Soldados supremos");
	    System.out.println("2. Poder de los ejércitos");
	    System.out.println("3. Datos de los soldados");
	    System.out.println("4. Ranking power");
	    System.out.println("5. Ejército ganador");
	    System.out.println("6. Salir");
	    System.out.print("\nSeleccione una opción: ");
	    option = sc.nextLine();

	    switch(option) {
		case "1" :
		    System.out.println("\nEJÉRCITO GREEN:" + soldierGod(troop1));
		    System.out.println("\nEJÉRCITO ORANGE:" + soldierGod(troop2)); break;
		case "2" : 
		    System.out.println("\nEJÉRCITO GREEN: " + average(troop1));
		    System.out.println("\nEJÉRCITO ORANGE: " + average(troop2)); break;
		case "3" :
		    System.out.println("\nEJÉRCITO GREEN:");
		    information(troop1);
		    System.out.println("\nEJÉRCITO ORANGE:");
		    information(troop2); break;
		case "4" :
		    System.out.println("\nEJÉRCITO GREEN:");
		    information(ranking(troop1));
		    System.out.println("\nEJÉRCITO ORANGE:");
		    information(ranking(troop2)); break;
		case "5" :
		    System.out.println(victory(troop1, troop2)); break;
		case "6" :
		    System.out.println("Saliendo... Por favor, cierre el panel");
		    w = false; break;
		default :
		    System.out.println("Opción no válida");
	    } 
	}
    }
}
