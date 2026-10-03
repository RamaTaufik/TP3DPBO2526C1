from Ranger import Ranger
from Warrior import Warrior

class Mercenary(Ranger, Warrior):
  def __init__(self, i="", n="", h=0, s=0, d=0, m=0, rs=0, ms=0, ss=0):
    super().__init__(i, n, h, s, d, m, rs)
    self.melee_str = 0
    self.stealth_str = 0

    if ms:
      self.setMeleeStr(ms)
    if ss:
      self.setStealthStr(ss)

  def setStealthStr(self, ss):
    if ss < 0:
      print("Stat stealth STR harus bilangan bulat positif!", end="")
      return -1

    self.stealth_str = ss
    return 0

  def getStealthStr(self):
    return self.stealth_str

  # Fungsi untuk mendapat seberapa besar kerusakan (damage) yang ditimbulkan Mercenary ketika melakukan
  # serangan jarak jauh (ranged attack). Perhitungan dibawah dimodifikasi dengan kondisi role Mercenary yang
  # perlu menyeimbangkan 3 stat kelas, beda dengan role Ranger yang hanya memiliki stat kelas
  # range_str
  def rangeAtk(self):
    return (max(0, self.getFinStr()) + self.range_str + self.stealth_str) // 2

  # Sebagai sedikit balancing, advanced role Mercenary tidak bisa menyerang jarak dekat (melee attack)
  def meleeAtk(self):
    return 0

  # Fungsi untuk mendapat seberapa besar kerusakan (damage) yang dapat ditimbulkan oleh Mercenary ketika
  # menyerang dengan mengendap-endap (sneak attack)
  def sneakAtk(self):
    return (max(0, self.getFinStr()) + self.melee_str + self.range_str + (self.stealth_str * 6 // 5)) // 2