#include "Paladin.cpp"

class Bard: public Healer, public Ranger {
  private:
    int buff_str;
  
  public:
    Bard() {}
    Bard(std::string i, std::string n, int h, int s, int d, int m, int hs, int rs, int bs) {
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
  
    int setBuffStr(int bs) {
      if(bs < 0) {
        std::cout << "Stat buff STR harus bilangan bulat positif!";
        return -1;
      }

      buff_str = bs;
      return 0;
    }
    int getBuffStr() {
      return buff_str;
    }

    // Fungsi untuk mendapat seberapa besar health yang disembuhkan oleh Bard ketika meng-invokasi
    // penyembuhan (cast heal). Perhitungan dibawah dimodifikasi dengan kondisi role Bard yang
    // perlu menyeimbangkan 3 stat kelas, beda dengan role Healer yang hanya memiliki stat kelas
    // heal_str
    int castHeal() override {
      return ((std::max(0, getFinMgc())) + heal_str + buff_str) / 2;
    }

    // Sebagai sedikit balancing, advanced role Bard tidak bisa menyerang jarak jauh (range attack)
    int rangeAtk() override {
      return 0;
    }

    // Fungsi untuk mendapat seberapa besar tambahan serangan yang dapat diberikan Bard ketika meng-
    // invokasi buff (cast buff) kepada role lain
    int castBuff() {
      return ((std::max(0, getFinMgc())) + heal_str + buff_str) / 4;
    }

    virtual ~Bard() {}
};