#include "Mercenary.cpp"
#include <typeinfo>
#include <memory>

// Fungsi untuk menghapus whitespace dari ujung awal dan akhir string
std::string trim(const std::string& str) {
  size_t first = str.find_first_not_of(" \t\n\r");
  if(first == std::string::npos) return "";
  size_t last = str.find_last_not_of(" \t\n\r");
  return str.substr(first, (last - first + 1));
}

// Fungsi kustom untuk merubah string menjadi integer. Dibuat fungsi kustom ini, karena sekaligus digunakan sebagai 
// filter input yang benar-benar hanya menerima bilangan bulat positif
int cstrtoint(std::string str) {
  int num = 0;

  for(int i = 0; i < str.size(); i++) {
    if(str[i] < '0' || str[i] > '9') {
      // Karena semua atribut integer dipastikan hanya bilangan bulat positif, maka hanya digit berupa angka 0 sampai 9
      // yang akan diterima
      return -1;
    } else {
      num = (num * 10) + (str[i] - '0');
    }
  }

  return num;
}

void printRoles(std::vector<std::shared_ptr<Role>>& src) {
  if(src.empty()) {
    std::cout << "Belum ada data member!\n";
  } else {
    for(auto& r: src) {
      std::cout << "\nMember " << r->getId();
      std::cout << "\nNama         : " << r->getName();
      std::cout << "\nStat         :\n";
      std::cout << " - Health      " << r->getHealth();
      std::cout << "\n - STR         " << r->getBaseStr() << " + " << (r->getFinStr() - r->getBaseStr()) << " (dari equipment)";
      std::cout << "\n - DEF         " << r->getBaseDef() << " + " << (r->getFinDef() - r->getBaseDef()) << " (dari equipment)";
      std::cout << "\n - MGC         " << r->getBaseMgc() << " + " << (r->getFinMgc() - r->getBaseMgc()) << " (dari equipment)";
      
      // Dynamic casting untuk mempermudah pengecekkan role dari member
      auto w  = dynamic_cast<Warrior*>(r.get());
      auto m  = dynamic_cast<Mercenary*>(r.get());
      auto rg = dynamic_cast<Ranger*>(r.get());
      auto b  = dynamic_cast<Bard*>(r.get());
      auto h  = dynamic_cast<Healer*>(r.get());
      auto p  = dynamic_cast<Paladin*>(r.get());

      if(p) {
        std::cout << "\n - Heal STR    " << p->getHealStr();
        std::cout << "\n - Melee STR   " << p->getMeleeStr();
        std::cout << "\n - Guard STR   " << p->getGuardStr();
      } else if(m) {
        std::cout << "\n - Melee STR   " << m->getMeleeStr();
        std::cout << "\n - Range STR   " << m->getRangeStr();
        std::cout << "\n - Stealth STR " << m->getStealthStr();
      } else if(b) {
        std::cout << "\n - Range STR   " << b->getRangeStr();
        std::cout << "\n - Heal STR    " << b->getHealStr();
        std::cout << "\n - Buff STR    " << b->getBuffStr();
      } else if(w) {
        std::cout << "\n - Melee STR   " << w->getMeleeStr();
      } else if(rg) {
        std::cout << "\n - Range STR   " << rg->getRangeStr();
      } else if(h) {
        std::cout << "\n - Heal STR    " << h->getHealStr();
      }

      std::cout << "\nKemampuan    :";
      if(p) {
        std::cout << "\n - Melee Attack (" << p->meleeAtk() << " damage)";
        std::cout << "\n - Cast Guard (" << p->castGuard() << " damage mitigation)";
      } else if(m) {
        std::cout << "\n - Ranged Attack (" << m->rangeAtk() << " damage)";
        std::cout << "\n - Sneak Attack (" << m->sneakAtk() << " damage)";
      } else if(b) {
        std::cout << "\n - Cast Heal (" << b->castHeal() << " health)";
        std::cout << "\n - Cast Buff (" << b->castBuff() << " damage buff)";
      } else if(w) {
        std::cout << "\n - Melee Attack (" << w->meleeAtk() << " damage)";
      } else if(rg) {
        std::cout << "\n - Ranged Attack (" << rg->rangeAtk() << " damage)";
      } else if(h) {
        std::cout << "\n - Cast Heal (" << h->castHeal() << " health)";
      }

      std::cout << "\nEquipment(s) :\n";
      for(Equipment e: r->getEquipments()) {
        std::cout << " - " << e.getName() << " (" 
          << (e.getStr() >= 0? "+": "") << e.getStr() << " STR, "
          << (e.getDef() >= 0? "+": "") << e.getDef() << " DEF, " 
          << (e.getMgc() >= 0? "+": "") << e.getMgc() << " MGC)\n";
      }
    }
  }
}

int main() {
  std::vector<std::shared_ptr<Role>> members;
  std::string choice = "0";

  std::cout << "   _____   __ __  __   __  _____  __  __       _____   __ __  __  __    ____\n";
  std::cout << "  / // /  / // / /  |_/ / /  __/ / / / /      / ___/  / // / / / / /   / /| |\n";
  std::cout << " / /_/ / / // / / /|_/ / /__  / / / / /_     / /_/ / / // / / / / /_  / /_/ /\n";
  std::cout << "/_____/ /____/ /_/  /_/ /____/ /_/ /___/    /_____/ /____/ /_/ /___/ /_____/\n";
  std::cout << "\n</> Serikat Petualang Bumi Siliwangi </>";

  do {
    if(cstrtoint(choice) >= 0 && cstrtoint(choice) <= 2) {
      std::cout << "\n1. Lihat data member guild\n";
      std::cout << "2. Tambah data dummy member guild\n";
      std::cout << "0. Keluar\n";
    }

    std::cout << "\nPilih opsi: ";
    std::getline(std::cin, choice);
    choice = trim(choice);

    if(choice == "1") {
      printRoles(members);
    } else if(choice == "2") {
      auto temp_w = std::make_shared<Warrior>("WRR-001", "Guts", 1500, 100, 200, 0, 150);
      temp_w->addEquipment(Equipment("Dragon Slayer", 50, 0, 0));
      temp_w->addEquipment(Equipment("Berserker Armor", 0, 300, 0));
      members.push_back(temp_w);

      auto temp_m = std::make_shared<Mercenary>("MCN-001", "EMIYA", 620, 100, 100, 100, 75, 75, 75);
      temp_m->addEquipment(Equipment("Caladbolg", 50, 0, 0));
      temp_m->addEquipment(Equipment("Rho-Aias", 0, 450, 0));
      members.push_back(temp_m);

      auto temp_r = std::make_shared<Ranger>("RGR-001", "Clover", 200, 100, 50, 0, 150);
      temp_r->addEquipment(Equipment("Six Shooter", 50, 0, 0));
      temp_r->addEquipment(Equipment("Cowboy Hat", 0, 50, 0));
      members.push_back(temp_r);

      auto temp_h = std::make_shared<Healer>("HLR-001", "Hyacinthia", 2000, 20, 50, 100, 150);
      temp_h->addEquipment(Equipment("Little Ica", 0, 50, 0));
      temp_h->addEquipment(Equipment("Coreflame of the Sky", 0, 100, 50));
      members.push_back(temp_h);

      auto temp_p = std::make_shared<Paladin>("PLD-001", "Shu", 620, 100, 100, 200, 75, 75, 75);
      temp_p->addEquipment(Equipment("Tianshi Baton", 50, 50, 0));
      members.push_back(temp_p);

      auto temp_b = std::make_shared<Bard>("BRD-001", "Venti", 620, 100, 100, 100, 75, 75, 75);
      temp_b->addEquipment(Equipment("Holy Lyre der Himmel", 0, 0, 25));
      temp_b->addEquipment(Equipment("Anemo Gnosis", 0, 150, 25));
      members.push_back(temp_b);

      std::cout << "Berhasil menambahkan data dummy member guild!\n";
    } else if(choice != "0") {
      std::cout << "Tidak ada opsi '" << choice << "'!";
      choice = "-1";
    }
  } while(choice != "0");

  return 0;
}