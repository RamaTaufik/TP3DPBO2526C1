import java.util.ArrayList;

public class Bard extends Ranger implements IHealer {
  private int heal_str, buff_str;
  
  public Bard() {
    equipments = new ArrayList<>();
  }
  public Bard(String i, String n, int h, int s, int d, int m, int hs, int rs, int bs) {
    equipments = new ArrayList<>();
    setId(i);
    setName(n);
    setHealth(h);
    setBaseStr(s);
    setBaseDef(d);
    setBaseMgc(m);
    setHealStr(hs);
    setRangeStr(rs);
    setBuffStr(bs);
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
  
  public int setBuffStr(int bs) {
    if(bs < 0) {
      System.out.println("Stat buff STR harus bilangan bulat positif!");
      return -1;
    }

    buff_str = bs;
    return 0;
  }
  public int getBuffStr() {
    return buff_str;
  }

  // Fungsi untuk mendapat seberapa besar health yang disembuhkan oleh Bard ketika meng-invokasi
  // penyembuhan (cast heal). Perhitungan dibawah dimodifikasi dengan kondisi role Bard yang
  // perlu menyeimbangkan 3 stat kelas, beda dengan role Healer yang hanya memiliki stat kelas
  // heal_str
  public int castHeal() {
    return ((Math.max(0, getFinMgc())) + heal_str + buff_str) / 2;
  }

  // Sebagai sedikit balancing, advanced role Bard tidak bisa menyerang jarak jauh (range attack)
  @Override public int rangeAtk() {
    return 0;
  }

  // Fungsi untuk mendapat seberapa besar tambahan serangan yang dapat diberikan Bard ketika meng-
  // invokasi buff (cast buff) kepada role lain
  public int castBuff() {
    return ((Math.max(0, getFinMgc())) + heal_str + buff_str) / 4;
  }
}