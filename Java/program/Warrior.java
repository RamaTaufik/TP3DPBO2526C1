import java.util.ArrayList;

public class Warrior extends Role {
  protected int melee_str;
  
  public Warrior() {
    equipments = new ArrayList<>();
  }
  public Warrior(String i, String n, int h, int s, int d, int m, int ms) {
    equipments = new ArrayList<>();
    setId(i);
    setName(n);
    setHealth(h);
    setBaseStr(s);
    setBaseDef(d);
    setBaseMgc(m);
    setMeleeStr(ms);
  }
  
  public int setMeleeStr(int ms) {
    if(ms < 0) {
      System.out.println("Stat melee STR harus bilangan bulat positif!");
      return -1;
    }

    melee_str = ms;
    return 0;
  }
  public int getMeleeStr() {
    return melee_str;
  }

  // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Warrior ketika melakukan
  // serangan jarak dekat (melee attack)
  public int meleeAtk() {
    return ((Math.max(0, getFinStr())) + (melee_str * 3 / 2)) / 2;
  }
}