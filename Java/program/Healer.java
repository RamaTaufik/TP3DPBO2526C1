import java.util.ArrayList;

public class Healer extends Role {
  protected int heal_str;
  
  public Healer() {
    equipments = new ArrayList<>();
  }
  public Healer(String i, String n, int h, int s, int d, int m, int hs) {
    equipments = new ArrayList<>();
    setId(i);
    setName(n);
    setHealth(h);
    setBaseStr(s);
    setBaseDef(d);
    setBaseMgc(m);
    setHealStr(hs);
  }
  
  public int setHealStr(int hs) {
    if(hs < 0) {
      System.out.println("Stat heal STR harus bilangan bulat positif!");
      return -1;
    }

    heal_str = hs;
    return 0;
  }
  public int getHealStr() {
    return heal_str;
  }

  // Fungsi untuk mendapat seberapa besar health yang disembuhkan oleh Healer ketika meng-invokasi
  // penyembuhan (cast heal)
  public int castHeal() {
    return ((Math.max(0, getFinMgc())) + (heal_str * 5 / 4)) / 2;
  }
}