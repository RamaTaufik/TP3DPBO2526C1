import java.util.ArrayList;

public class Mercenary extends Warrior implements IRanger {
  private int range_str, stealth_str;
  
  public Mercenary() {
    equipments = new ArrayList<>();
  }
  public Mercenary(String i, String n, int h, int s, int d, int m, int rs, int ms, int ss) {
    equipments = new ArrayList<>();
    setId(i);
    setName(n);
    setHealth(h);
    setBaseStr(s);
    setBaseDef(d);
    setBaseMgc(m);
    setRangeStr(rs);
    setMeleeStr(ms);
    setStealthStr(ss);
  }
  
  public int setRangeStr(int rs) {
    if(rs < 0) {
      System.out.println("Stat ranged STR harus bilangan bulat positif!");
      return -1;
    }

    range_str = rs;
    return 0;
  }
  public int getRangeStr() {
    return range_str;
  }
  
  public int setStealthStr(int ss) {
    if(ss < 0) {
      System.out.println("Stat stealth STR harus bilangan bulat positif!");
      return -1;
    }

    stealth_str = ss;
    return 0;
  }
  public int getStealthStr() {
    return stealth_str;
  }

  // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Mercenary ketika melakukan
  // serangan jarak jauh (ranged attack)
  public int rangeAtk() {
    return ((Math.max(0, getFinStr())) + range_str + stealth_str) / 2;
  }

  // Sebagai sedikit balancing, advanced role Mercenary tidak bisa menyerang jarak dekat (melee attack)
  @Override public int meleeAtk() {
    return 0;
  }

  // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang dapat ditimbulkan oleh Mercenary ketika
  // menyerang dengan mengendap-endap (sneak attack)
  public int sneakAtk() {
    return ((Math.max(0, getFinStr())) + melee_str + range_str + (stealth_str * 6 / 5)) / 2;
  }
}