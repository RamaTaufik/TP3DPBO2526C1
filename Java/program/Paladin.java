import java.util.ArrayList;

public class Paladin extends Healer implements IWarrior {
  private int melee_str, guard_str;
  
  public Paladin() {
    equipments = new ArrayList<>();
  }
  public Paladin(String i, String n, int h, int s, int d, int m, int ms, int hs, int gs) {
    equipments = new ArrayList<>();
    setId(i);
    setName(n);
    setHealth(h);
    setBaseStr(s);
    setBaseDef(d);
    setBaseMgc(m);
    setMeleeStr(ms);
    setHealStr(hs);
    setGuardStr(gs);
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
  
  public int setGuardStr(int gs) {
    if(gs < 0) {
      System.out.println("Stat melee STR harus bilangan bulat positif!");
      return -1;
    }

    guard_str = gs;
    return 0;
  }
  public int getGuardStr() {
    return guard_str;
  }

  // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Paladin ketika melakukan
  // serangan jarak dekat (melee attack)
  public int meleeAtk() {
    return ((Math.max(0, getFinStr())) + melee_str + guard_str) / 2;
  }

  // Sebagai sedikit balancing, advanced role Paladin tidak bisa meng-invokasi penyembuhan (cast heal)
  @Override public int castHeal() {
    return 0;
  }

  // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang dapat dimitigasi oleh Paladin ketika
  // meng-invokasi perlindungan (cast guard)
  public int castGuard() {
    return ((Math.max(0, getFinDef())) + heal_str + (guard_str * 6 / 5)) / 3;
  }
}