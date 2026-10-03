from Healer import Healer
from Ranger import Ranger

class Bard(Healer, Ranger):
  def __init__(self, i="", n="", h=0, s=0, d=0, m=0, hs=0, rs=0, bs=0):
    super().__init__(i, n, h, s, d, m, hs)
    self.range_str = 0
    self.buff_str = 0

    if rs:
      self.setRangeStr(rs)
    if bs:
      self.setBuffStr(bs)

  def setBuffStr(self, bs):
    if bs < 0:
      print("Stat buff STR harus bilangan bulat positif!", end="")
      return -1

    self.buff_str = bs
    return 0

  def getBuffStr(self):
    return self.buff_str

  # Fungsi untuk mendapat seberapa besar health yang disembuhkan oleh Bard ketika meng-invokasi
  # penyembuhan (cast heal). Perhitungan dibawah dimodifikasi dengan kondisi role Bard yang
  # perlu menyeimbangkan 3 stat kelas, beda dengan role Healer yang hanya memiliki stat kelas
  # heal_str
  def castHeal(self):
    return (max(0, self.getFinMgc()) + self.heal_str + self.buff_str) // 2

  # Sebagai sedikit balancing, advanced role Bard tidak bisa menyerang jarak jauh (range attack)
  def rangeAtk(self):
    return 0

  # Fungsi untuk mendapat seberapa besar tambahan serangan yang dapat diberikan Bard ketika meng-
  # invokasi buff (cast buff) kepada role lain
  def castBuff(self):
    return (max(0, self.getFinMgc()) + self.heal_str + self.buff_str) // 4