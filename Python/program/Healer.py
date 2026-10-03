from Role import Role

class Healer(Role):
  def __init__(self, i="", n="", h=0, s=0, d=0, m=0, hs=0):
    super().__init__(i, n, h, s, d, m)
    self.heal_str = 0

    if hs:
      self.setHealStr(hs)

  def setHealStr(self, hs):
    if hs < 0:
      print("Stat heal STR harus bilangan bulat positif!", end="")
      return -1

    self.heal_str = hs
    return 0

  def getHealStr(self):
    return self.heal_str

  # Fungsi untuk mendapat seberapa besar health yang disembuhkan oleh Healer ketika meng-invokasi
  # penyembuhan (cast heal)
  def castHeal(self):
    return (max(0, self.getFinMgc()) + (self.heal_str * 5 // 4)) // 2