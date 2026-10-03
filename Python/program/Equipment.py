class Equipment:
  def __init__(self, n: str = "", s: int = 0, d: int = 0, m: int = 0):
    self.__name = ""
    self.__str = 0
    self.__def = 0
    self.__mgc = 0
    
    if n:
      self.setName(n)
    if s:
      self.setStr(s)
    if d:
      self.setDef(d)
    if m:
      self.setMgc(m)

  def setName(self, n: str) -> int:
    if not n or not n.strip():
      print("Nama tidak boleh kosong!")
      return -1
    
    self.__name = n
    return 0

  def getName(self) -> str:
    return self.__name

  def setStr(self, s: int) -> int:
    if s < 0:
      print("Stat STR harus bilangan bulat positif!")
      return -1

    self.__str = s
    return 0

  def getStr(self) -> int:
    return self.__str

  def setDef(self, d: int) -> int:
    if d < 0:
      print("Stat DEF harus bilangan bulat positif!")
      return -1

    self.__def = d
    return 0

  def getDef(self) -> int:
    return self.__def

  def setMgc(self, m: int) -> int:
    if m < 0:
      print("State MGC harus bilangan bulat positif!")
      return -1

    self.__mgc = m
    return 0

  def getMgc(self) -> int:
    return self.__mgc