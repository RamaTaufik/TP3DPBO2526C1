import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  // Fungsi kustom untuk merubah string menjadi integer. Dibuat fungsi kustom ini, karena sekaligus digunakan sebagai 
  // filter input yang benar-benar hanya menerima bilangan bulat positif
  public static int cstrtoint(String str) {
    int num = 0;

    for(int i = 0; i < str.length(); i++) {
      if(str.charAt(i) < '0' || str.charAt(i) > '9') {
        // Karena semua atribut integer dipastikan hanya bilangan bulat positif, maka hanya digit berupa angka 0 sampai 9
        // yang akan diterima
        return -1;
      } else {
        num = (num * 10) + (str.charAt(i) - '0');
      }
    }

    return num;
  }

  // Prosedur untuk meng-print data member guild ke bentuk list
  public static void printRoles(ArrayList<Role> src) {
    if(src.size() == 0) {
      System.out.print("Belum ada data member!\n");
    } else {
      for(Role r: src) {
        System.out.print("\nMember " + r.getId());
        System.out.print("\nNama         : " + r.getName());
        System.out.print("\nStat         :\n");
        System.out.print(" - Health      " + r.getHealth());
        System.out.print("\n - STR         " + r.getBaseStr() + " + " + (r.getFinStr() - r.getBaseStr()) + " (dari equipment)");
        System.out.print("\n - DEF         " + r.getBaseDef() + " + " + (r.getFinDef() - r.getBaseDef()) + " (dari equipment)");
        System.out.print("\n - MGC         " + r.getBaseMgc() + " + " + (r.getFinMgc() - r.getBaseMgc()) + " (dari equipment)");
        if(r instanceof Warrior || r instanceof Mercenary) {
          System.out.print("\n - Melee STR   " + ((Warrior)r).getMeleeStr());
        }
        if(r instanceof Ranger || r instanceof Bard) {
          System.out.print("\n - Range STR   " + ((Ranger)r).getRangeStr());
        }
        if(r instanceof Healer || r instanceof Paladin) {
          System.out.print("\n - Heal STR    " + ((Healer)r).getHealStr());
        }
        if(r instanceof Paladin) {
          System.out.print("\n - Melee STR   " + ((Paladin)r).getMeleeStr());
          System.out.print("\n - Guard STR   " + ((Paladin)r).getGuardStr());
        }
        if(r instanceof Mercenary) {
          System.out.print("\n - Range STR   " + ((Mercenary)r).getRangeStr());
          System.out.print("\n - Stealth STR " + ((Mercenary)r).getStealthStr());
        }
        if(r instanceof Bard) {
          System.out.print("\n - Heal STR    " + ((Bard)r).getHealStr());
          System.out.print("\n - Buff STR    " + ((Bard)r).getBuffStr());
        }
        System.out.print("\nKemampuan    :");
        if(r instanceof Warrior && !(r instanceof Mercenary)) {
          System.out.print("\n - Melee Attack (" + ((Warrior)r).meleeAtk() + " damage)");
        }
        if(r instanceof Ranger && !(r instanceof Bard)) {
          System.out.print("\n - Ranged Attack (" + ((Ranger)r).rangeAtk() + " damage)");
        }
        if(r instanceof Healer && !(r instanceof Paladin)) {
          System.out.print("\n - Cast Heal (" + ((Healer)r).castHeal() + " health)");
        }
        if(r instanceof Paladin) {
          System.out.print("\n - Melee Attack (" + ((Paladin)r).meleeAtk() + " damage)");
          System.out.print("\n - Cast Guard (" + ((Paladin)r).castGuard() + " damage mitigation)");
        }
        if(r instanceof Mercenary) {
          System.out.print("\n - Ranged Attack (" + ((Mercenary)r).rangeAtk() + " damage)");
          System.out.print("\n - Sneak Attack (" + ((Mercenary)r).sneakAtk() + " damage)");
        }
        if(r instanceof Bard) {
          System.out.print("\n - Cast Heal (" + ((Bard)r).castHeal() + " health)");
          System.out.print("\n - Cast Buff (" + ((Bard)r).castBuff() + " damage buff)");
        }
        System.out.print("\nEquipment(s) :\n");
        for(Equipment e: r.getEquipments()) {
          System.out.print(
            " - " + e.getName() + " (" + (e.getStr() >= 0? "+": "") + e.getStr() + " STR, " + 
            (e.getDef() >= 0? "+": "") + e.getDef() + " DEF, " + 
            (e.getMgc() >= 0? "+": "") + e.getMgc() + " MGC)\n"
          );
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Role> members = new ArrayList<>(); // ArrayList data member guild
    String choice = "0"; // Variabel untuk input opsi

    System.out.print("   _____   __ __  __   __  _____  __  __       _____   __ __  __  __    ____\n");
    System.out.print("  / // /  / // / /  |_/ / /  __/ / / / /      / ___/  / // / / / / /   / /| |\n");
    System.out.print(" / /_/ / / // / / /|_/ / /__  / / / / /_     / /_/ / / // / / / / /_  / /_/ /\n");
    System.out.print("/_____/ /____/ /_/  /_/ /____/ /_/ /___/    /_____/ /____/ /_/ /___/ /_____/\n");
    System.out.print("\n</> Serikat Petualang Bumi Siliwangi </>");

    // Loop utama
    do {
      // Jika terjadi kesalahan dalam input opsi, tidak perlu print ulang pilihan opsi agar tidak memenuhi layar
      if(cstrtoint(choice) >= 0 && cstrtoint(choice) <= 2) {
        System.out.print("\n1. Lihat data member guild\n");
        System.out.print("2. Tambah data dummy member guild\n");
        System.out.print("0. Keluar\n");
      }
      System.out.print("\nPilih opsi: ");

      choice = scanner.nextLine().trim();

      if(choice.equals("1")) {
        // Lihat semua data
        printRoles(members);
      } else if(choice.equals("2")) {
        // Tambah data dummy statis
        // Warrior temp_w = new Warrior("WRR-001", "Guts", 1500, 100, 200, 0, 150);
        // temp_w.addEquipment(new Equipment("Dragon Slayer", 200, 0, 0));
        // temp_w.addEquipment(new Equipment("Berserker Armor", 50, 300, 0));
        // members.add(temp_w);

        // Mercenary temp_m = new Mercenary("MCN-001", "EMIYA", 620, 50, 100, 100, 200, 150, 150);
        // temp_m.addEquipment(new Equipment("Caladbolg", 150, 0, 0));
        // temp_m.addEquipment(new Equipment("Rho-Aias", 0, 450, 0));
        // members.add(temp_m);
        
        // Healer temp_h = new Healer("HLR-001", "Hyacinthia", 2000, 20, 50, 100, 200);
        // temp_h.addEquipment(new Equipment("Little Ica", 100, 50, 100));
        // temp_h.addEquipment(new Equipment("Coreflame of the Sky", 0, 100, 20));
        // members.add(temp_h);
        Warrior temp_w = new Warrior("WRR-001", "Guts", 1500, 100, 200, 0, 150);
        temp_w.addEquipment(new Equipment("Dragon Slayer", 50, 0, 0));
        temp_w.addEquipment(new Equipment("Berserker Armor", 0, 300, 0));
        members.add(temp_w);

        Mercenary temp_m = new Mercenary("MCN-001", "EMIYA", 620, 100, 100, 100, 75, 75, 75);
        temp_m.addEquipment(new Equipment("Caladbolg", 50, 0, 0));
        temp_m.addEquipment(new Equipment("Rho-Aias", 0, 450, 0));
        members.add(temp_m);

        Ranger temp_r = new Ranger("RGR-001", "Clover", 200, 100, 50, 0, 150);
        temp_r.addEquipment(new Equipment("Six Shooter", 50, 0, 0));
        temp_r.addEquipment(new Equipment("Cowboy Hat", 0, 50, 0));
        members.add(temp_r);
        
        Healer temp_h = new Healer("HLR-001", "Hyacinthia", 2000, 20, 50, 100, 150);
        temp_h.addEquipment(new Equipment("Little Ica", 0, 50, 0));
        temp_h.addEquipment(new Equipment("Coreflame of the Sky", 0, 100, 50));
        members.add(temp_h);

        Paladin temp_p = new Paladin("PLD-001", "Shu", 620, 100, 100, 200, 75, 75, 75);
        temp_p.addEquipment(new Equipment("Tianshi Baton", 50, 50, 0));
        members.add(temp_p);

        Bard temp_b = new Bard("BRD-001", "Venti", 620, 100, 100, 100, 75, 75, 75);
        temp_b.addEquipment(new Equipment("Holy Lyre der Himmel", 0, 0, 25));
        temp_b.addEquipment(new Equipment("Anemo Gnosis", 0, 150, 25));
        members.add(temp_b);

        System.out.print("Berhasil menambahkan data dummy member guild!\n");
      } else if(!choice.equals("0")) {
        System.out.print("Tidak ada opsi '" + choice + "'!");
        choice = "-1";
      }
    } while(!choice.equals("0"));

    scanner.close();
  }
}