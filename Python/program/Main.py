from Equipment import Equipment
from Role import Role
from Warrior import Warrior
from Healer import Healer
from Ranger import Ranger
from Paladin import Paladin
from Bard import Bard
from Mercenary import Mercenary

# Fungsi kustom untuk merubah string menjadi integer. Dibuat fungsi kustom ini, karena sekaligus digunakan sebagai 
# filter input yang benar-benar hanya menerima bilangan bulat positif
def cstrtoint(s):
  # isdigit() benar-benar hanya akan menerima digit 0 sampai 9 sehingga dipastikan hanya bilangan bulat positif yang
  # bisa dimasukkan
  if not s or not s.isdigit():
    return -1
  return int(s)


def printRoles(src):
  if not src:
    print("Belum ada data member!\n")
  else:
    for r in src:
      print(f"\nMember {r.getId()}", end="")
      print(f"\nNama         : {r.getName()}", end="")
      print("\nStat         :", end="")
      print(f"\n - Health      {r.getHealth()}", end="")
      print(f"\n - STR         {r.getBaseStr()} + {r.getFinStr() - r.getBaseStr()} (dari equipment)", end="")
      print(f"\n - DEF         {r.getBaseDef()} + {r.getFinDef() - r.getBaseDef()} (dari equipment)", end="")
      print(f"\n - MGC         {r.getBaseMgc()} + {r.getFinMgc() - r.getBaseMgc()} (dari equipment)", end="")

      if isinstance(r, Paladin):
        print(f"\n - Heal STR    {r.getHealStr()}", end="")
        print(f"\n - Melee STR   {r.getMeleeStr()}", end="")
        print(f"\n - Guard STR   {r.getGuardStr()}", end="")
      elif isinstance(r, Mercenary):
        print(f"\n - Melee STR   {r.getMeleeStr()}", end="")
        print(f"\n - Range STR   {r.getRangeStr()}", end="")
        print(f"\n - Stealth STR {r.getStealthStr()}", end="")
      elif isinstance(r, Bard):
        print(f"\n - Range STR   {r.getRangeStr()}", end="")
        print(f"\n - Heal STR    {r.getHealStr()}", end="")
        print(f"\n - Buff STR    {r.getBuffStr()}", end="")
      elif isinstance(r, Warrior):
        print(f"\n - Melee STR   {r.getMeleeStr()}", end="")
      elif isinstance(r, Ranger):
        print(f"\n - Range STR   {r.getRangeStr()}", end="")
      elif isinstance(r, Healer):
        print(f"\n - Heal STR    {r.getHealStr()}", end="")

      print("\nKemampuan    :", end="")
      if isinstance(r, Paladin):
        print(f"\n - Melee Attack ({r.meleeAtk()} damage)", end="")
        print(f"\n - Cast Guard ({r.castGuard()} damage mitigation)", end="")
      elif isinstance(r, Mercenary):
        print(f"\n - Ranged Attack ({r.rangeAtk()} damage)", end="")
        print(f"\n - Sneak Attack ({r.sneakAtk()} damage)", end="")
      elif isinstance(r, Bard):
        print(f"\n - Cast Heal ({r.castHeal()} health)", end="")
        print(f"\n - Cast Buff ({r.castBuff()} damage buff)", end="")
      elif isinstance(r, Warrior):
        print(f"\n - Melee Attack ({r.meleeAtk()} damage)", end="")
      elif isinstance(r, Ranger):
        print(f"\n - Ranged Attack ({r.rangeAtk()} damage)", end="")
      elif isinstance(r, Healer):
        print(f"\n - Cast Heal ({r.castHeal()} health)", end="")

      print("\nEquipment(s) :")
      for e in r.getEquipments():
        str_sign = "+" if e.getStr() >= 0 else ""
        def_sign = "+" if e.getDef() >= 0 else ""
        mgc_sign = "+" if e.getMgc() >= 0 else ""
        print(f" - {e.getName()} ({str_sign}{e.getStr()} STR, {def_sign}{e.getDef()} DEF, {mgc_sign}{e.getMgc()} MGC)")

    print("")


def main():
  members = []
  choice = "0"

  print("   _____   __ __  __   __  _____  __  __       _____   __ __  __  __    ____")
  print("  / // /  / // / /  |_/ / /  __/ / / / /      / ___/  / // / / / / /   / /| |")
  print(" / /_/ / / // / / /|_/ / /__  / / / / /_     / /_/ / / // / / / / /_  / /_/ /")
  print("/_____/ /____/ /_/  /_/ /____/ /_/ /___/    /_____/ /____/ /_/ /___/ /_____/")
  print("\n</> Serikat Petualang Bumi Siliwangi </>")

  while True:
    if 0 <= cstrtoint(choice) <= 2:
      print("1. Lihat data member guild")
      print("2. Tambah data dummy member guild")
      print("0. Keluar")

    print("\nPilih opsi: ", end="")
    choice = input().strip()

    if choice == "1":
      printRoles(members)
    elif choice == "2":
      temp_w = Warrior("WRR-001", "Guts", 1500, 100, 200, 0, 150)
      temp_w.addEquipment(Equipment("Dragon Slayer", 50, 0, 0))
      temp_w.addEquipment(Equipment("Berserker Armor", 0, 300, 0))
      members.append(temp_w)

      temp_m = Mercenary("MCN-001", "EMIYA", 620, 100, 100, 100, 75, 75, 75)
      temp_m.addEquipment(Equipment("Caladbolg", 50, 0, 0))
      temp_m.addEquipment(Equipment("Rho-Aias", 0, 450, 0))
      members.append(temp_m)

      temp_r = Ranger("RGR-001", "Clover", 200, 100, 50, 0, 150)
      temp_r.addEquipment(Equipment("Six Shooter", 50, 0, 0))
      temp_r.addEquipment(Equipment("Cowboy Hat", 0, 50, 0))
      members.append(temp_r)

      temp_h = Healer("HLR-001", "Hyacinthia", 2000, 20, 50, 100, 150)
      temp_h.addEquipment(Equipment("Little Ica", 0, 50, 0))
      temp_h.addEquipment(Equipment("Coreflame of the Sky", 0, 100, 50))
      members.append(temp_h)

      temp_p = Paladin("PLD-001", "Shu", 620, 100, 100, 200, 75, 75, 75)
      temp_p.addEquipment(Equipment("Tianshi Baton", 50, 50, 0))
      members.append(temp_p)

      temp_b = Bard("BRD-001", "Venti", 620, 100, 100, 100, 75, 75, 75)
      temp_b.addEquipment(Equipment("Holy Lyre der Himmel", 0, 0, 25))
      temp_b.addEquipment(Equipment("Anemo Gnosis", 0, 150, 25))
      members.append(temp_b)

      print("Berhasil menambahkan data dummy member guild!\n")
    elif choice == "0":
      break
    else:
      print(f"Tidak ada opsi '{choice}'!", end="")
      choice = "-1"


if __name__ == "__main__":
  main()