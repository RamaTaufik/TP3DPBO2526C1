#include "Healer.cpp"

class Ranger: virtual public Role {
  protected:
    int range_str;
  
  public:
    Ranger() {}
    Ranger(std::string i, std::string n, int h, int s, int d, int m, int rs) {
      setId(i);
      setName(n);
      setHealth(h);
      setBaseStr(s);
      setBaseDef(d);
      setBaseMgc(m);
      setRangeStr(rs);
    }
  
    int setRangeStr(int rs) {
      if(rs < 0) {
        std::cout << "Stat ranged STR harus bilangan bulat positif!";
        return -1;
      }

      range_str = rs;
      return 0;
    }
    int getRangeStr() {
      return range_str;
    }

    // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Ranger ketika melakukan
    // serangan jarak jauh (ranged attack)
    virtual int rangeAtk() {
      return ((std::max(0, getFinStr())) + (range_str * 4 / 3)) / 2;
    }

    virtual ~Ranger() {}
};