#include "Ranger.cpp"

class Paladin: public Warrior, public Healer {
  protected:
    int guard_str;
  
  public:
    Paladin() {}
    Paladin(std::string i, std::string n, int h, int s, int d, int m, int ms, int hs, int gs) {
      setId(i);
      setName(n);
      setHealth(h);
      setBaseStr(s);
      setBaseDef(d);
      setBaseMgc(m);
      setMeleeStr(ms);
      setHealStr(hs);
      setGuardStr(gs);
    }
  
    int setGuardStr(int gs) {
      if(gs < 0) {
        std::cout << "Stat guard STR harus bilangan bulat positif!";
        return -1;
      }

      guard_str = gs;
      return 0;
    }
    int getGuardStr() {
      return guard_str;
    }

    // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Paladin ketika melakukan
    // serangan jarak dekat (melee attack)
    int meleeAtk() override {
      return ((std::max(0, getFinStr())) + melee_str + guard_str) / 2;
    }

    // Sebagai sedikit balancing, advanced role Paladin tidak bisa meng-invokasi penyembuhan (cast heal)
    int castHeal() override {
      return 0;
    }

    // Fungsi untuk mendapat seberapa besar kerusakan (damage) yang dapat dimitigasi oleh Paladin ketika
    // meng-invokasi perlindungan (cast guard)
    int castGuard() {
      return ((std::max(0, getFinDef())) + heal_str + (guard_str * 6 / 5)) / 3;
    }

    ~Paladin() {}
};