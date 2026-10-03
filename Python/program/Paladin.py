from Warrior import Warrior
from Healer import Healer

class Paladin(Warrior, Healer):
  def __init__(self, i="", n="", h=0, s=0, d=0, m=0, ms=0, hs=0, gs=0):
    super().__init__(i, n, h, s, d, m, ms)
    self.heal_str = 0
    self.guard_str = 0

    if hs:
      self.setHealStr(hs)
    if gs:
      self.setGuardStr(gs)

  def setGuardStr(self, gs):
    if gs < 0:
      print("Stat guard STR harus bilangan bulat positif!", end="")
      return -1

    self.guard_str = gs
    return 0

  def getGuardStr(self):
    return self.guard_str

  # Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Paladin ketika melakukan
  # serangan jarak dekat (melee attack)
  def meleeAtk(self):
    return (max(0, self.getFinStr()) + self.melee_str + self.guard_str) // 2

  # Sebagai sedikit balancing, advanced role Paladin tidak bisa meng-invokasi penyembuhan (cast heal)
  def castHeal(self):
    return 0

  # Fungsi untuk mendapat seberapa besar kerusakan (damage) yang dapat dimitigasi oleh Paladin ketika
  # meng-invokasi perlindungan (cast guard)
  def castGuard(self):
    return (max(0, self.getFinDef()) + self.heal_str + (self.guard_str * 6 // 5)) // 3