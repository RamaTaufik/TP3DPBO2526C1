import java.util.ArrayList;

public class Ranger extends Role {
  protected int range_str;
  
  public Ranger() {
    equipments = new ArrayList<>();
  }
  public Ranger(String i, String n, int h, int s, int d, int m, int rs) {
    equipments = new ArrayList<>();
    setId(i);
    setName(n);
    setHealth(h);
    setBaseStr(s);
    setBaseDef(d);
    setBaseMgc(m);
    setRangeStr(rs);
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

  // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Ranger ketika melakukan
  // serangan jarak jauh (ranged attack)
  public int rangeAtk() {
    return ((Math.max(0, getFinStr())) + (range_str * 4 / 3)) / 2;
  }
}