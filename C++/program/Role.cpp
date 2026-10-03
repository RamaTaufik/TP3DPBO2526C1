#include "Equipment.cpp"
#include <vector>
#include <algorithm>

class Role {
  private:
    std::string id, name;
    int health, base_str, base_def, base_mgc;
  
  protected:
    std::vector<Equipment> equipments;
  
  public:
    Role() {}
    Role(std::string i, std::string n, int h, int s, int d, int m) {
      setId(i);
      setName(n);
      setHealth(h);
      setBaseStr(s);
      setBaseDef(d);
      setBaseMgc(m);
    }

    int setId(const std::string& i) {
      if(i.empty() || i.find_first_not_of(" \t\n\r") == std::string::npos) {
        std::cout << "ID tidak boleh kosong!\n";
        return -1;
      }

      id = i;
      return 0;
    }
    std::string getId() {
      return id;
    }

    int setName(const std::string& n) {
      if(n.empty() || n.find_first_not_of(" \t\n\r") == std::string::npos) {
        std::cout << "Nama tidak boleh kosong!\n";
        return -1;
      }
      
      name = n;
      return 0;
    }
    std::string getName() {
      return name;
    }

    int setHealth(int h) {
      if(h < 0) {
        std::cout << "Health harus bilangan bulat positif!\n";
        return -1;
      }

      health = h;
      return 0;
    }
    int getHealth() {
      return health;
    }

    int setBaseStr(int s) {
      if(s < 0) {
        std::cout << "Stat STR harus bilangan bulat positif!\n";
        return -1;
      }

      base_str = s;
      return 0;
    }
    int getBaseStr() {
      return base_str;
    }

    int setBaseDef(int d) {
      if(d < 0) {
        std::cout << "Stat DEF harus bilangan bulat positif!\n";
        return -1;
      }

      base_def = d;
      return 0;
    }
    int getBaseDef() {
      return base_def;
    }

    int setBaseMgc(int m) {
      if(m < 0) {
        std::cout << "State MGC harus bilangan bulat positif!\n";
        return -1;
      }

      base_mgc = m;
      return 0;
    }
    int getBaseMgc() {
      return base_mgc;
    }

    int getFinStr() {
      int str = base_str;

      for(Equipment e : equipments) {
        str += e.getStr();
      }

      return str;
    }

    int getFinDef() {
      int def = base_def;

      for(Equipment e : equipments) {
        def += e.getDef();
      }

      return def;
    }

    int getFinMgc() {
      int mgc = base_mgc;

      for(Equipment e : equipments) {
        mgc += e.getMgc();
      }

      return mgc;
    }

    void addEquipment(const Equipment& e) {
      equipments.push_back(e);
    }

    std::vector<Equipment> getEquipments() {
      return equipments;
    }

    virtual ~Role() {}
};