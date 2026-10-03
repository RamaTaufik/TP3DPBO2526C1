from Role import Role

class Ranger(Role):
  def __init__(self, i="", n="", h=0, s=0, d=0, m=0, rs=0):
    super().__init__(i, n, h, s, d, m)
    self.range_str = 0

    if rs:
      self.setRangeStr(rs)

  def setRangeStr(self, rs):
    if rs < 0:
      print("Stat ranged STR harus bilangan bulat positif!", end="")
      return -1

    self.range_str = rs
    return 0

  def getRangeStr(self):
    return self.range_str

  # Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Ranger ketika melakukan
  # serangan jarak jauh (ranged attack)
  def rangeAtk(self):
    return (max(0, self.getFinStr()) + (self.range_str * 4 // 3)) // 2