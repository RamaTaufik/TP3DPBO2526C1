#include "Bard.cpp"

class Mercenary: public Ranger, public Warrior {
  protected:
    int stealth_str;
  
  public:
    Mercenary() {}
    Mercenary(std::string i, std::string n, int h, int s, int d, int m, int rs, int ms, int ss) {
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
  
    int setStealthStr(int ss) {
      if(ss < 0) {
        std::cout << "Stat stealth STR harus bilangan bulat positif!";
        return -1;
      }

      stealth_str = ss;
      return 0;
    }
    int getStealthStr() {
      return stealth_str;
    }

    // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Mercenary ketika melakukan
    // serangan jarak jauh (ranged attack). Perhitungan dibawah dimodifikasi dengan kondisi role Mercenary yang
    // perlu menyeimbangkan 3 stat kelas, beda dengan role Ranger yang hanya memiliki stat kelas
    // range_str
    int rangeAtk() override {
      return ((std::max(0, getFinStr())) + range_str + stealth_str) / 2;
    }

    // Sebagai sedikit balancing, advanced role Mercenary tidak bisa menyerang jarak dekat (melee attack)
    int meleeAtk() override {
      return 0;
    }

    // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang dapat ditimbulkan oleh Mercenary ketika
    // menyerang dengan mengendap-endap (sneak attack)
    int sneakAtk() {
      return ((std::max(0, getFinStr())) + melee_str + range_str + (stealth_str * 6 / 5)) / 2;
    }

    virtual ~Mercenary() {}
};