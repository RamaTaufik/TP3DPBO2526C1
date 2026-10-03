#include <string>
#include <iostream>

class Equipment {
  private:
    std::string name;
    int str, def, mgc;

  public:
    Equipment() {}  
    Equipment(std::string n, int s, int d, int m) {
      setName(n);
      setStr(s);
      setDef(d);
      setMgc(m);
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

    int setStr(int s) {
      if(s < 0) {
        std::cout << "Stat STR harus bilangan bulat positif!\n";
        return -1;
      }

      str = s;
      return 0;
    }
    int getStr() {
      return str;
    }

    int setDef(int d) {
      if(d < 0) {
        std::cout << "Stat DEF harus bilangan bulat positif!\n";
        return -1;
      }

      def = d;
      return 0;
    }
    int getDef() {
      return def;
    }

    int setMgc(int m) {
      if(m < 0) {
        std::cout << "State MGC harus bilangan bulat positif!\n";
        return -1;
      }

      mgc = m;
      return 0;
    }
    int getMgc() {
      return mgc;
    }

    ~Equipment() {}
};