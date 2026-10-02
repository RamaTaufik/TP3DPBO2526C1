public class Equipment {
  private String name;
  private int str, def, mgc;

  public Equipment() {
    name = "";
    str = 0;
    def = 0;
    mgc = 0;
  }
  public Equipment(String n, int s, int d, int m) {
    setName(n);
    setStr(s);
    setDef(d);
    setMgc(m);
  }

  public int setName(String n) {
    if(n == null || n.trim().isEmpty()) {
      System.out.println("Nama tidak boleh kosong!");
      return -1;
    }

    name = n;
    return 0;
  }
  public String getName() {
    return name;
  }

  public void setStr(int s) {
    str = s;
  }
  public int getStr() {
    return str;
  }

  public void setDef(int d) {
    def = d;
  }
  public int getDef() {
    return def;
  }

  public void setMgc(int m) {
    mgc = m;
  }
  public int getMgc() {
    return mgc;
  }
}