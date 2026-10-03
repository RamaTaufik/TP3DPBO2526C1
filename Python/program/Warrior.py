from Role import Role

class Warrior(Role):
  def __init__(self, i="", n="", h=0, s=0, d=0, m=0, ms=0):
    super().__init__(i, n, h, s, d, m)
    self.melee_str = 0

    if ms:
      self.setMeleeStr(ms)

  def setMeleeStr(self, ms):
    if ms < 0:
      print("Stat melee STR harus bilangan bulat positif!", end="")
      return -1

    self.melee_str = ms
    return 0

  def getMeleeStr(self):
    return self.melee_str

  # Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Warrior ketika melakukan
  # serangan jarak dekat (melee attack)
  def meleeAtk(self):
    return (max(0, self.getFinStr()) + (self.melee_str * 3 // 2)) // 2