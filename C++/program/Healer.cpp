#include "Warrior.cpp"

class Healer: virtual public Role {
  protected:
    int heal_str;
  
  public:
    Healer() {}
    Healer(std::string i, std::string n, int h, int s, int d, int m, int hs) {
      setId(i);
      setName(n);
      setHealth(h);
      setBaseStr(s);
      setBaseDef(d);
      setBaseMgc(m);
      setHealStr(hs);
    }
  
    int setHealStr(int hs) {
      if(hs < 0) {
        std::cout << "Stat heal STR harus bilangan bulat positif!";
        return -1;
      }

      heal_str = hs;
      return 0;
    }
    int getHealStr() {
      return heal_str;
    }

    // Fungsi untuk mendapat seberapa besar health yang disembuhkan oleh Healer ketika meng-invokasi
    // penyembuhan (cast heal)
    virtual int castHeal() {
      return ((std::max(0, getFinMgc())) + (heal_str * 5 / 4)) / 2;
    }

    virtual ~Healer() {}
};