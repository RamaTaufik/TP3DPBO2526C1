import java.util.ArrayList;

public class Role {
  private String id, name;
  private int health, base_str, base_def, base_mgc;
  protected ArrayList<Equipment> equipments;

  public Role() {
    equipments = new ArrayList<>();
  }
  public Role(String i, String n, int h, int s, int d, int m) {
    equipments = new ArrayList<>();
    setId(i);
    setName(n);
    setHealth(h);
    setBaseStr(s);
    setBaseDef(d);
    setBaseMgc(m);
  }

  public int setId(String i) {
    if(i == null || i.trim().isEmpty()) {
      System.out.println("ID tidak boleh kosong!");
      return -1;
    }

    id = i;
    return 0;
  }
  public String getId() {
    return id;
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

  public int setHealth(int h) {
    if(h < 0) {
      System.out.println("Health harus bilangan bulat positif!");
      return -1;
    }

    health = h;
    return 0;
  }
  public int getHealth() {
    return health;
  }

  public int setBaseStr(int s) {
    if(s < 0) {
      System.out.println("Stat STR harus bilangan bulat positif!");
      return -1;
    }

    base_str = s;
    return 0;
  }
  public int getBaseStr() {
    return base_str;
  }

  public int setBaseDef(int d) {
    if(d < 0) {
      System.out.println("Stat DEF harus bilangan bulat positif!");
      return -1;
    }

    base_def = d;
    return 0;
  }
  public int getBaseDef() {
    return base_def;
  }

  public int setBaseMgc(int m) {
    if(m < 0) {
      System.out.println("State MGC harus bilangan bulat positif!");
      return -1;
    }

    base_mgc = m;
    return 0;
  }
  public int getBaseMgc() {
    return base_mgc;
  }
  
  // Fungsi untuk mendapat stat STR yang sudah dimodifikasi dengan stat dari equipment
  public int getFinStr() {
    int str = base_str;

    for(Equipment e: equipments) {
      str += e.getStr();
    }

    return str;
  }
  
  // Fungsi untuk mendapat stat DEF yang sudah dimodifikasi dengan stat dari equipment
  public int getFinDef() {
    int def = base_def;

    for(Equipment e: equipments) {
      def += e.getDef();
    }

    return def;
  }
  
  // Fungsi untuk mendapat stat MGC yang sudah dimodifikasi dengan stat dari equipment
  public int getFinMgc() {
    int mgc = base_mgc;

    for(Equipment e: equipments) {
      mgc += e.getMgc();
    }

    return mgc;
  }

  public void addEquipment(Equipment e) {
    equipments.add(e);
  }
  public ArrayList<Equipment> getEquipments() {
    return equipments;
  }
}