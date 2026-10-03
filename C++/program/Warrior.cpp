#include "Role.cpp"

class Warrior: virtual public Role {
  protected:
    int melee_str;
  
  public:
    Warrior() {}
    Warrior(std::string i, std::string n, int h, int s, int d, int m, int ms) {
      setId(i);
      setName(n);
      setHealth(h);
      setBaseStr(s);
      setBaseDef(d);
      setBaseMgc(m);
      setMeleeStr(ms);
    }
  
    int setMeleeStr(int ms) {
      if(ms < 0) {
        std::cout << "Stat melee STR harus bilangan bulat positif!";
        return -1;
      }

      melee_str = ms;
      return 0;
    }
    int getMeleeStr() {
      return melee_str;
    }

    // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Warrior ketika melakukan
    // serangan jarak dekat (melee attack)
    virtual int meleeAtk() {
      return ((std::max(0, getFinStr())) + (melee_str * 3 / 2)) / 2;
    }

    virtual ~Warrior() {}
};